package com.kuaidu.nms.datastaticstics.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuaidu.nms.datastaticstics.serviceImpl.UserInfoStatMapperImpl;
import com.kuaidu.nms.entity.RestReturn;
import com.kuaidu.nms.entity.StatUserInfo;
import com.kuaidu.nms.entity.Sys_user;
import com.kuaidu.nms.utils.EasyUIReturn;
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
@RequestMapping("/userStaticstics")
public class UserInfoStatController {
	
	@Autowired
	UserInfoStatMapperImpl uImpl;
	/**
	 * 获取今日数据
	 * */
	@ResponseBody
	@RequestMapping("/getStatsToday")
	public StatUserInfo getStatsToday(HttpSession session,StatUserInfo statUserInfo) {
		int partnerId = getPartnerId(session);
		if (partnerId<0||statUserInfo.getPartner_id()==null||statUserInfo.getPartner_id()<0) {//未登录
			return null;
		}
		statUserInfo = uImpl.getStatsToday(statUserInfo);
		return statUserInfo;
	}
	/**
	 * 获取昨日数据
	 * */
	@ResponseBody
	@RequestMapping("/getStatsYesterDay")
	public StatUserInfo getStatsYesterDay(HttpSession session,StatUserInfo statUserInfo) {
		int partnerId = getPartnerId(session);
		if (partnerId<0||statUserInfo.getPartner_id()==null||statUserInfo.getPartner_id()<0) {//未登录
			return null;
		}
		statUserInfo = uImpl.getStatsYesterDay(statUserInfo);
		return statUserInfo;
	}
	/**
	 * 获取本月数据
	 * */
	@ResponseBody
	@RequestMapping("/getStatsMonthAll")
	public StatUserInfo getStatsMonthAll(HttpSession session,StatUserInfo statUserInfo) {
		int partnerId = getPartnerId(session);
		if (partnerId<0||statUserInfo.getPartner_id()==null||statUserInfo.getPartner_id()<0) {//未登录
			return null;
		}
		statUserInfo  = uImpl.getStatsMonthAll(statUserInfo);
		return statUserInfo;
	}
	/**
	 * 获取所有数据
	 * */
	@ResponseBody
	@RequestMapping("/getStatsAll")
	public StatUserInfo getStatsAll(HttpSession session,StatUserInfo statUserInfo) {
		int partnerId = getPartnerId(session);
		if (partnerId<0||statUserInfo.getPartner_id()==null||statUserInfo.getPartner_id()<0) {//未登录
			return null;
		}
		statUserInfo  = uImpl.getStatsAll(statUserInfo);
		return statUserInfo;
	}
	/**
	 * 获取列表数据
	 * */
	@ResponseBody
	@RequestMapping("/getStatsList")
	public EasyUIReturn getStatsList(HttpSession session,StatUserInfo statUserInfo,@RequestParam(defaultValue="1")Integer group_by_parent) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if (statUserInfo.getStart_date()==null||statUserInfo.getStart_date().equalsIgnoreCase("")) {
			statUserInfo.setStart_date(df.format(Utils.getDateByDays(-1)));
		}
		if (statUserInfo.getEnd_date()==null||statUserInfo.getEnd_date().equalsIgnoreCase("")) {
			statUserInfo.setEnd_date(df.format(Utils.getDateByDays(-1)));
		}
		
		int partnerId = getPartnerId(session);
		if (partnerId<0||statUserInfo.getPartner_id()==null||statUserInfo.getPartner_id()<0) {//未登录
			return null;
		}
		
		List<Object> statUserInfos = uImpl.getStatsList(statUserInfo,group_by_parent);
		return new EasyUIReturn(statUserInfos.size(), statUserInfos);
	}
	/**
	 * 0:系统登录
	 * >0 partner 登录
	 * -1：未登录
	 * */
	public static int getPartnerId(HttpSession session) {
		String login_flag = (String) session.getAttribute("login_flag");
		if (login_flag==null) {
			return -1;
		}else if (login_flag.equalsIgnoreCase("system")) {
			Sys_user sys_user = (Sys_user) session.getAttribute("user");
			if (sys_user==null) {
				return -1;
			}else {
				return 0;
			}
		}else {
			return -1;
		}
	}
	
}
