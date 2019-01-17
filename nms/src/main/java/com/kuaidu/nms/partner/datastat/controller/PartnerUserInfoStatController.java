package com.kuaidu.nms.partner.datastat.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.entity.StatUserInfo;
import com.kuaidu.nms.partner.datastat.serviceImpl.PartnerUserInfoStatMapperImpl;
import com.kuaidu.nms.utils.Utils;

import net.sf.json.JSONObject;

/** 
 * @Title UserOrderStatController.java 
 * 订单充值
 * @description TODO 
 * @time 2018年9月10日 下午5:37:50 
 * @author victor 
 * @version 1.0 
**/
@Controller
@RequestMapping("/partnerUserStaticstics")
public class PartnerUserInfoStatController {
	
	@Autowired
	PartnerUserInfoStatMapperImpl uImpl;
	/**
	 * 获取今日数据
	 * */
	@ResponseBody
	@RequestMapping("/getPartnerStatsToday")
	public StatUserInfo getStatsToday(HttpSession session,StatUserInfo statUserInfo) {
		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		if (partnerInfo==null||partnerInfo.getPartner_id()<=0) {//未登录
			return null;
		}else {
			statUserInfo.setParent_id(partnerInfo.getParent_id());
		}
		statUserInfo = uImpl.getStatsToday(statUserInfo);
		return statUserInfo;
	}
	/**
	 * 获取昨日数据
	 * */
	@ResponseBody
	@RequestMapping("/getPartnerStatsYesterDay")
	public StatUserInfo getStatsYesterDay(HttpSession session,StatUserInfo statUserInfo) {
		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		if (partnerInfo==null||partnerInfo.getPartner_id()<=0) {//未登录
			return null;
		}else {
			statUserInfo.setParent_id(partnerInfo.getParent_id());
		}
		statUserInfo = uImpl.getStatsYesterDay(statUserInfo);
		return statUserInfo;
	}
	/**
	 * 获取本月数据
	 * */
	@ResponseBody
	@RequestMapping("/getPartnerStatsMonthAll")
	public StatUserInfo getStatsMonthAll(HttpSession session,StatUserInfo statUserInfo) {
		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		if (partnerInfo==null||partnerInfo.getPartner_id()<=0) {//未登录
			return null;
		}else {
			statUserInfo.setParent_id(partnerInfo.getParent_id());
		}
		statUserInfo  = uImpl.getStatsMonthAll(statUserInfo);
		return statUserInfo;
	}
	/**
	 * 获取所有数据
	 * */
	@ResponseBody
	@RequestMapping("/getPartnerStatsAll")
	public StatUserInfo getStatsAll(HttpSession session,StatUserInfo statUserInfo) {
		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		if (partnerInfo==null||partnerInfo.getPartner_id()<=0) {//未登录
			return null;
		}else {
			statUserInfo.setParent_id(partnerInfo.getParent_id());
		}
		statUserInfo  = uImpl.getStatsAll(statUserInfo);
		return statUserInfo;
	}
	/**
	 * 获取列表数据
	 * */
	@ResponseBody
	@RequestMapping("/getPartnerStatsList")
	public JSONObject getStatsList(HttpSession session,StatUserInfo statUserInfo) {
		JSONObject jsonRet = new JSONObject();
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String day  = df.format(date);
		if (statUserInfo.getDay_time()==null) {
			statUserInfo.setDay_time(day);
		}
		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		if (partnerInfo==null||partnerInfo.getPartner_id()<=0) {//未登录
			return null;
		}else {
			statUserInfo.setParent_id(partnerInfo.getParent_id());
		}
		List<Object> statUserInfos = uImpl.getStatsList(statUserInfo);
		if (statUserInfos.size()==0) {
			jsonRet.put("last_day_time",day);
		}else {
			jsonRet.put("last_day_time", ((StatUserInfo) statUserInfos.get(statUserInfos.size()-1)).getDay_time());
		}
		jsonRet.put("rows", statUserInfos);
		return jsonRet;
	}
	
}
