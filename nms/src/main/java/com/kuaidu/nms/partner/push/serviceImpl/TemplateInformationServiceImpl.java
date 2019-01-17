package com.kuaidu.nms.partner.push.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kuaidu.nms.entity.PartnerTemplateMsg;
import com.kuaidu.nms.entity.RestReturn;
import com.kuaidu.nms.partner.push.mapper.TemplateInformationMapper;
import com.kuaidu.nms.utils.HttpUtil;
import com.kuaidu.nms.utils.MyWxUtils;

/** 
 * @Title KeywordReplyServiceImpl.java 
 * @time 2018年11月7日 下午2:25:02 
 * @author victor 
 * @version 1.0 
**/
@Service
public class TemplateInformationServiceImpl {
	@Autowired
	TemplateInformationMapper tMapper;

	public List<PartnerTemplateMsg> getTemplateInformation(Integer start_rows, Integer rows, int partner_id) {
		return tMapper.getTemplateInformation(start_rows,rows,partner_id);
	}

	public int getTemplateInformationCount() {
		return tMapper.getTemplateInformationCount();
	}

	
	public int addTemplateMsg(PartnerTemplateMsg partnerTemplateMsg) {
		int ret = 0;
		try {
			//tMapper.addTemplateMsg(partnerTemplateMsg);
			tMapper.insertSelective(partnerTemplateMsg);
			ret = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	

	public RestReturn getWxTemplateMsg(int partner_id) {
		String accessToken = MyWxUtils.getAccessToken(partner_id);
		String url = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token="+accessToken;
		System.err.println(url);
		String string = HttpUtil.get(url, null, 10000, 10000, "utf-8");
		if(string != null) {
			JSONObject parseObject = JSON.parseObject(string);
			JSONArray jsonArray = parseObject.getJSONArray("template_list");
			//JSONArray parseArray = parseObject.parseArray("template_list");
			if (jsonArray == null || jsonArray.size() == 0) {
				return RestReturn.fail();
			}
			
			return RestReturn.success(jsonArray);
		}
		return RestReturn.fail();
	}

	public void deletePartnerTemplateMsg(List<Object> list) {
		tMapper.deletePartnerTemplateMsg(list);
		
	}

	public Object testSendTemplageMsg(Integer userId, String data, int parentId, String url, String template_id) {
		
		Map<String, Object> map = tMapper.getUserOpenidAndNiceName(userId);
		if(map.size() == 0) {
			return RestReturn.fail("没有这个用户");
		}
		String openid = (String) map.get("openid");
		if (data.contains("{wename}")) {
			String nickName = (String) map.get("nick_name");
			//data = data.replaceAll("{wename}", nickName);
			System.err.println(data);
			data = StringUtils.replaceAll(data, "\\{wename\\}", nickName);
		}
		
		
		tMapper.testSendTemplageMsg(userId,parentId,openid,data,url,template_id);
		
		
		return RestReturn.success();
	}
}
