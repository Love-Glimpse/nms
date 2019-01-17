package com.kuaidu.nms.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.kuaidu.nms.message.serviceImpl.CustomMsgImpl;
import com.kuaidu.nms.user.serviceImpl.UserManagementMapperImpl;
import com.kuaidu.nms.utils.fastdfs.FastDFSTemplate;

/** 
 * @Title RedisListener.java 
 * @description TODO 
 * @time 2018年10月18日 上午9:21:30 
 * @author victor 
 * @version 1.0 
**/
/**
 * redis 订阅
 * */
public class RedisListener {
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	@Autowired
	FastDFSTemplate fastDFSTemplate;
	private static String ip = Utils.getLocalHostIp();
	@Autowired
	UserManagementMapperImpl userImpl;
	@Autowired
	CustomMsgImpl cImpl ;
	//订阅渠道提交的群发消息
/*	public void partnerCustomGroupMsg1(String jsonMsg, String channel){
		if (ip.matches("69\\.171\\.67\\.171")){
			JSONObject jsonObject = JSONObject.fromObject(jsonMsg);
			PartnerCustomMsg partnerCustomMsg = (PartnerCustomMsg) JSONObject.toBean(jsonObject,PartnerCustomMsg.class);
			
			Integer partner_id = partnerCustomMsg.getPartner_id();
			if (partner_id>0) {
				List<WxCustomMsg> wxCustomMsgs = new ArrayList<WxCustomMsg>();
				Set<String> keys = redisTemplate.keys( "ActivityUser-ParentId:"+partner_id+"userId:*");
				for (String key : keys) {
					String user = (String) redisTemplate.opsForValue().get(key);
					if (user==null) {
						continue;
					}
					JSONObject json = JSONObject.fromObject(user);
					int user_id = json.getInt("userId");
					UserInfo userInfo = userImpl.getUserInfoByUserId(user_id);
					if (partnerCustomMsg.getSex()!=2&&userInfo.getSex()!=partnerCustomMsg.getSex()) {
							continue;
					}
					if (partnerCustomMsg.getVip_type()==0) {// 未充值
						if (userInfo.getVip_type()>0) {
							continue;
						}
					}else if(partnerCustomMsg.getVip_type()==1) {//已充值
						if (userInfo.getVip_type()==0) {
							continue;
						}
					}
					WxCustomMsg wxCustomMsg = new WxCustomMsg();
					wxCustomMsg.setPartner_id(partner_id);
					wxCustomMsg.setUser_id(json.getInt("userId"));
					wxCustomMsg.setBook_id(0);
					wxCustomMsg.setTo_user(json.getString("openid"));
					wxCustomMsg.setType("group");//渠道群发
					wxCustomMsg.setMsg_type(partnerCustomMsg.getMsg_type());
					wxCustomMsg.setP_msg_id(partnerCustomMsg.getP_msg_id());
					wxCustomMsg.setTitle(partnerCustomMsg.getTitle());
					wxCustomMsg.setDescription(partnerCustomMsg.getDescription());
					wxCustomMsg.setUrl(partnerCustomMsg.getUrl());
					wxCustomMsg.setPic_url(partnerCustomMsg.getPic_url());
					wxCustomMsg.setSend_time(partnerCustomMsg.getSend_time());
					wxCustomMsgs.add(wxCustomMsg);
				}
				//save 客服消息
				cImpl.batchInsert(wxCustomMsgs,5000);
			}
		}
	}*/
	@SuppressWarnings("unchecked")
	public void clearBook(String key, String channel){
		if (ip.matches("69\\.171\\.67\\.171")&&redisTemplate.hasKey(key)){
		/*if (ip.matches("69\\.171\\.67\\.171")&&redisTemplate.hasKey(key)) {*/
			Log4jUtil.getBusinessLogger().info(key);
			Object object = redisTemplate.opsForValue().get(key);
			if (object instanceof List<?>) {
				Log4jUtil.getBusinessLogger().info(object);
				List<Object> urls =  (List<Object>) object;
				for (Object url : urls) {
					try {
						fastDFSTemplate.deleteFile(url.toString());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						Log4jUtil.getBusinessLogger().info("清空书籍，删除失败=="+url);
					}
				}
			}else if (object instanceof String) {
				try {
					fastDFSTemplate.deleteFile(object.toString());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					Log4jUtil.getBusinessLogger().info("清空书籍，删除失败=="+object);
				}
			}
			redisTemplate.delete(key);
		}
	}
	

	public void c(String json, String channel){
		System.out.println(json);
	}
}
