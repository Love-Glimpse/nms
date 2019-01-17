package com.kuaidu.nms.partner.push.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.kuaidu.nms.entity.PartnerCustomMsg;
import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.entity.WxCustomMsg;
import com.kuaidu.nms.message.mapper.CustomMsgMapper;
import com.kuaidu.nms.partner.push.mapper.CustomerServiceInfoMapper;
import com.kuaidu.nms.utils.Log4jUtil;
import com.kuaidu.nms.utils.MyWxUtils;

import net.sf.json.JSONObject;

/** 
 * @Title CustomerServiceInfoServiceImpl.java 
 * @time 2018年11月7日 下午2:25:02 
 * @author victor 
 * @version 1.0 
**/
@Service
public class CustomerServiceInfoServiceImpl {
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	@Autowired
	CustomerServiceInfoMapper cMapper;
	@Autowired
	CustomMsgMapper cMsgMapper;
	public List<PartnerCustomMsg> getCustomerServiceInfo(Integer start_rows, Integer rows, int partner_id) {
		return cMapper.getCustomerServiceInfo(start_rows,rows,partner_id);
	}

	public int getCustomerServiceInfoCount() {
		return cMapper.getCustomerServiceInfoCount();
	}
	 /*删除*/
	public void delCustomerServiceInfo(List<Object> list){
		cMapper.delCustomerServiceInfo(list);
	}
	/*添加渠道客服消息*/
	public int addCustomerServiceInfo(PartnerCustomMsg partner_custom_msg) {
		int ret = 0;
		try {
			cMapper.addCustomerServiceInfo(partner_custom_msg);
			//添加完毕 发送redis订阅消息
			//redisTemplate.convertAndSend("partnerCustomGroupMsg1", JSONObject.fromObject(partner_custom_msg).toString());
			ret = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public int sendTestWxCustomMsg(WxCustomMsg wxCustomMsg, PartnerInfo partnerInfo) {
		// TODO Auto-generated method stub
		int ret = 99;
		String key = "ActivityUser-ParentId:"+partnerInfo.getPartner_id()+"userId:"+wxCustomMsg.getUser_id();
		String userInfo = (String) redisTemplate.opsForValue().get(key);
		if (userInfo==null) {
			return 4; //不是活跃用户
		}
		JSONObject json = JSONObject.fromObject(userInfo);
		if (json==null) {
			return 4; //不是活跃用户
		}
		String openId = json.optString("openid");
		wxCustomMsg.setTo_user(openId);
		wxCustomMsg.setType("test");
		wxCustomMsg.setPartner_id(partnerInfo.getPartner_id());
		
		String retStr = MyWxUtils.sendCustomMsg(wxCustomMsg);
		JSONObject jsonRet = JSONObject.fromObject(retStr);
		Log4jUtil.getBusinessLogger().info(jsonRet);
		ret = jsonRet.optInt("errcode", 11);
		if (ret == 0) {
			ret = 2;
		}
		wxCustomMsg.setSend_status(ret);
		try {
			cMsgMapper.saveCustomMsg(wxCustomMsg);
			ret = 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
}
