package com.kuaidu.nms.datastaticstics.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kuaidu.nms.datastaticstics.serviceImpl.StatOrderPushMapperImpl;
import com.kuaidu.nms.datastaticstics.serviceImpl.UserOrderStatMapperImpl;
import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.entity.RestReturn;
import com.kuaidu.nms.entity.StatUserOrder;
import com.kuaidu.nms.entity.Sys_user;
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
@RequestMapping("/dataStaticstics")
public class UserOrderStatController {
	
	@Autowired
	UserOrderStatMapperImpl uImpl;
	
	@Autowired
	StatOrderPushMapperImpl sImpl;
	

	@RequestMapping("/dataOverviewIndex")
	public ModelAndView homepageIndex(HttpSession session){
		ModelAndView mv = new ModelAndView();
		try {
			List<PartnerInfo> list = sImpl.getAllPartnerId();
			mv.addObject("partnerInfos", list);
			mv.setViewName("PushChannel/dataOverview"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	//单个渠道统计
	@RequestMapping("/partnerOrderIndex")
	public ModelAndView partnerOrderIndex(HttpSession session){
		ModelAndView mv = new ModelAndView();
		try {
			
			mv.setViewName("PushChannel/dataOverviewPartner"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	//单个代理统计
	@RequestMapping("/proxyOrderIndex")
	public ModelAndView proxyOrderIndex(HttpSession session){
		ModelAndView mv = new ModelAndView();
		try {
			
			mv.setViewName("PushChannel/dataOverviewProxy"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 获取今日数据
	 * */
	@ResponseBody
	@RequestMapping("/getStatsToday")
	public StatUserOrder getStatsToday(HttpSession session,StatUserOrder statUserOrder) {
		int partnerId = getPartnerId(session);
		if (partnerId<0||statUserOrder.getPartner_id()==null||statUserOrder.getPartner_id()<0) {//未登录
			return null;
		}
		statUserOrder = uImpl.getStatsToday(statUserOrder);
		return statUserOrder;
	}
	/**
	 * 获取昨日数据
	 * */
	@ResponseBody
	@RequestMapping("/getStatsYesterDay")
	public StatUserOrder getStatsYesterDay(HttpSession session,StatUserOrder statUserOrder) {
		int partnerId = getPartnerId(session);
		if (partnerId<0||statUserOrder.getPartner_id()==null||statUserOrder.getPartner_id()<0) {//未登录
			return null;
		}
		statUserOrder = uImpl.getStatsYesterDay(statUserOrder);
		return statUserOrder;
	}
	/**
	 * 获取本月数据
	 * */
	@ResponseBody
	@RequestMapping("/getStatsMonthAll")
	public StatUserOrder getStatsMonthAll(HttpSession session,StatUserOrder statUserOrder) {
		int partnerId = getPartnerId(session);
		if (partnerId<0||statUserOrder.getPartner_id()==null||statUserOrder.getPartner_id()<0) {//未登录
			return null;
		}
		statUserOrder  = uImpl.getStatsMonthAll(statUserOrder);
		return statUserOrder;
	}
	/**
	 * 获取所有数据
	 * */
	@ResponseBody
	@RequestMapping("/getStatsAll")
	public StatUserOrder getStatsAll(HttpSession session,StatUserOrder statUserOrder) {
		int partnerId = getPartnerId(session);
		if (partnerId<0||statUserOrder.getPartner_id()==null||statUserOrder.getPartner_id()<0) {//未登录
			return null;
		}/*else {
			statUserOrder.setPartner_id(partnerId);
		}*/
		statUserOrder  = uImpl.getStatsAll(statUserOrder);
		return statUserOrder;
	}
	/**
	 * 获取列表数据
	 * */
	@ResponseBody
	@RequestMapping("/getStatsList")
	public RestReturn getStatsList(HttpSession session,StatUserOrder statUserOrder) {
		JSONObject jsonRet = new JSONObject();
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String day  = df.format(date);
		if (statUserOrder.getOrder_time()==null) {
			statUserOrder.setOrder_time(day);
		}
		int partnerId = getPartnerId(session);
		if (partnerId<0||statUserOrder.getPartner_id()==null||statUserOrder.getPartner_id()<0) {//未登录
			return null;
		}
		List<Object> statUserOrders = uImpl.getStatsList(statUserOrder);
		if (statUserOrders.size()==0) {
			return RestReturn.success(day, statUserOrders);
		}else {
			return RestReturn.success(((StatUserOrder) statUserOrders.get(statUserOrders.size()-1)).getOrder_time(), statUserOrders);
		}
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
	
	
	/**
	 * 获取列表数据
	 * */
	@ResponseBody
	@RequestMapping("/getYesterdayStatList")
	public JSONObject getYestDayStatsList(HttpSession session,StatUserOrder statUserOrder,String startDate,String endDate) {
		JSONObject jsonRet = new JSONObject();
		int partnerId = getPartnerId(session);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (startDate==null||startDate.equalsIgnoreCase("")) {
			startDate =sdf.format(Utils.getDateByDays(-10));
		}
		if (endDate==null||endDate.equalsIgnoreCase("")) {
			endDate =sdf.format(Utils.getDateByDays(-1));
		}
		if (partnerId<0||statUserOrder.getParent_id()==null||statUserOrder.getParent_id()<0) {//未登录
			return null;
		}
		List<Object> statUserOrders = uImpl.getYestDayStatsList(statUserOrder,startDate,endDate);
		jsonRet.put("rows", statUserOrders);
		return jsonRet;
	}
	
	/**
	 * 获取列表数据
	 * */
	@ResponseBody
	@RequestMapping("/getYestDayStatsListDetail")
	public JSONObject getYestDayStatsListDetail(HttpSession session,StatUserOrder statUserOrder) {
		JSONObject jsonRet = new JSONObject();
		int partnerId = getPartnerId(session);
		if (partnerId<0||statUserOrder.getPartner_id()==null||statUserOrder.getPartner_id()<0) {//未登录
			return null;
		}
		List<Object> statUserOrders = uImpl.getYestDayStatsListDetail(statUserOrder);
		jsonRet.put("rows", statUserOrders);
		return jsonRet;
	}
}
