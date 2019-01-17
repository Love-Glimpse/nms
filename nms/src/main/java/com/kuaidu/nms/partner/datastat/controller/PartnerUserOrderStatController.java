package com.kuaidu.nms.partner.datastat.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.entity.RestReturn;
import com.kuaidu.nms.entity.StatUserOrder;
import com.kuaidu.nms.partner.datastat.serviceImpl.PartnerUserOrderStatMapperImpl;
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
@RequestMapping("/partnerDataStaticstics")
public class PartnerUserOrderStatController {
	
	@Autowired
	PartnerUserOrderStatMapperImpl uImpl;
	
	@RequestMapping("/partnerDataOverviewIndex")
	public ModelAndView partnerDataOverviewIndex(HttpSession session){
		ModelAndView mv = new ModelAndView();
		try {
			PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
			if (partnerInfo==null||partnerInfo.getPartner_id()<=0) {//未登录
				return null;
			}else {
				//传入登陆的partner_id
				mv.addObject("partner_id", partnerInfo.getPartner_id());
			}
			mv.setViewName("partner/dataStat/dataOverview"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	@RequestMapping("/proxyDataOverviewIndex")
	public ModelAndView proxyDataOverviewIndex(HttpSession session,@RequestParam(required=true)int partner_id){
		ModelAndView mv = new ModelAndView();
		try {
			PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
			if (partnerInfo==null||partnerInfo.getPartner_id()<=0) {//未登录
				return null;
			}else {
				mv.addObject("partner_id", partner_id);
			}
			mv.setViewName("partner/dataStat/dataOverview"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 获取今日数据
	 * */
	@ResponseBody
	@RequestMapping("/getPartnerStatsToday")
	/**
	 * flag = 1 查询登录的partner
	 * */
	public StatUserOrder getStatsToday(HttpSession session,StatUserOrder statUserOrder) {
		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		if (partnerInfo==null||partnerInfo.getPartner_id()<=0) {//未登录
			return null;
		}else {
			statUserOrder.setParent_id(partnerInfo.getParent_id());
		}
		statUserOrder = uImpl.getStatsToday(statUserOrder);
		return statUserOrder;
	}
	/**
	 * 获取昨日数据
	 * */
	@ResponseBody
	@RequestMapping("/getPartnerStatsYesterDay")
	public StatUserOrder getStatsYesterDay(HttpSession session,StatUserOrder statUserOrder) {
		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		if (partnerInfo==null||partnerInfo.getPartner_id()<=0) {//未登录
			return null;
		}else {
			statUserOrder.setParent_id(partnerInfo.getParent_id());
		}
		statUserOrder = uImpl.getStatsYesterDay(statUserOrder);
		return statUserOrder;
	}
	/**
	 * 获取本月数据
	 * */
	@ResponseBody
	@RequestMapping("/getPartnerStatsMonthAll")
	public StatUserOrder getStatsMonthAll(HttpSession session,StatUserOrder statUserOrder) {
		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		if (partnerInfo==null||partnerInfo.getPartner_id()<=0) {//未登录
			return null;
		}else {
			statUserOrder.setParent_id(partnerInfo.getParent_id());
		}
		statUserOrder  = uImpl.getStatsMonthAll(statUserOrder);
		return statUserOrder;
	}
	/**
	 * 获取所有数据
	 * */
	@ResponseBody
	@RequestMapping("/getPartnerStatsAll")
	public StatUserOrder getStatsAll(HttpSession session,StatUserOrder statUserOrder) {
		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		if (partnerInfo==null||partnerInfo.getPartner_id()<=0) {//未登录
			return null;
		}else {
			statUserOrder.setParent_id(partnerInfo.getParent_id());
		}
		statUserOrder  = uImpl.getStatsAll(statUserOrder);
		return statUserOrder;
	}
	/**
	 * 获取列表数据
	 * */
	@ResponseBody
	@RequestMapping("/getPartnerStatsList")
	public RestReturn getStatsList(HttpSession session,StatUserOrder statUserOrder) {
		JSONObject jsonRet = new JSONObject();
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String day  = df.format(date);
		if (statUserOrder.getOrder_time()==null) {
			statUserOrder.setOrder_time(day);
		}
		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		if (partnerInfo==null||partnerInfo.getPartner_id()<=0) {//未登录
			return null;
		}else {
			statUserOrder.setParent_id(partnerInfo.getParent_id());
		}
		List<Object> statUserOrders = uImpl.getStatsList(statUserOrder);
		if (statUserOrders.size()==0) {
			return RestReturn.success(day, statUserOrders);
		}else {
			return RestReturn.success(((StatUserOrder) statUserOrders.get(statUserOrders.size()-1)).getOrder_time(), statUserOrders);
		}
	}
	
}
