package com.kuaidu.nms.datastaticstics.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kuaidu.nms.datastaticstics.serviceImpl.StatOrderPushMapperImpl;
import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.entity.StatOrderPushByDay;

/** 
 * @Title 
 * 推广统计分析
 * @description TODO 
 * @time 2018年9月10日 下午5:37:50 
 * @author victor 
 * @version 1.0 
**/
@Controller
@RequestMapping("/statOrderPush")
public class StatOrderPushController {
	
	@Autowired
	StatOrderPushMapperImpl sImpl;
	
	@RequestMapping("/statOrderPushIndex")
	public ModelAndView statOrderPushIndex(HttpSession session){
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("PushChannel/statOrderPush"); 
			List<PartnerInfo> list = sImpl.getAllPartnerId();
			mv.addObject("partnerInfos", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	@RequestMapping("/getSubDateDetailIndex")
	public ModelAndView getSubDateDetailIndex(HttpSession session,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		try {
			mv.addObject("parentId", request.getParameter("parent_id"));
			mv.addObject("subDate", request.getParameter("sub_date"));
			mv.addObject("pushId", request.getParameter("push_id"));
			mv.setViewName("PushChannel/statOrderPushDetail"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	@ResponseBody
	@RequestMapping("/getStatOrders")
	public String getStatOrders(HttpSession session,StatOrderPushByDay statOrderPush){
		return sImpl.getStatOrders(statOrderPush);
	}
	
	
	@ResponseBody
	@RequestMapping("pushIds")
	public Object getPushIdByPartnerId(Integer partnerId) {
		return sImpl.getPushIdByPartnerId(partnerId);
	}
	
	@ResponseBody
	@RequestMapping("getSubDateDetail")
	public String getSubDateDetail(@RequestParam("parent_id")Integer parentId,@RequestParam("sub_date")String sub_date,@RequestParam("push_id")Integer pushId) {
		return sImpl.getSubDateDetail(parentId,pushId,sub_date);
	}
	
}
