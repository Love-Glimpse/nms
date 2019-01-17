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
import com.kuaidu.nms.datastaticstics.serviceImpl.StatUserStayMapperImpl;
import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.entity.StatUserStayByDay;

/** 
 * @Title 
 * 用户留存统计
 * @description TODO 
 * @time 2018年9月10日 下午5:37:50 
 * @author victor 
 * @version 1.0 
**/
@Controller
@RequestMapping("userStay")
public class StatUserStayController {
	
	@Autowired
	StatOrderPushMapperImpl sImpl;
	@Autowired
	StatUserStayMapperImpl sUserStay;
	
	@RequestMapping("userStayIndex")
	public ModelAndView userStayIndex(HttpSession session){
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("PushChannel/statUserStay"); 
			List<PartnerInfo> list = sImpl.getAllPartnerId();
			mv.addObject("partnerInfos", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	@RequestMapping("/getUserStayDetailIndex")
	public ModelAndView getUserStayIndexDetailIndex(HttpSession session,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		try {
			mv.addObject("parentId", request.getParameter("parent_id"));
			mv.addObject("subDate", request.getParameter("sub_date"));
			mv.addObject("pushId", request.getParameter("push_id"));
			mv.addObject("days", request.getParameter("days"));
			mv.setViewName("PushChannel/statUserStayDetail"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	@ResponseBody
	@RequestMapping("/getStatUserStays")
	public String getStatUserStays(HttpSession session,StatUserStayByDay statUserStayByDay){
		return sUserStay.getStatUserStays(statUserStayByDay);
	}
	
	
	@ResponseBody
	@RequestMapping("getUserStayDetail")
	public String getUserStayDetail(@RequestParam("parent_id")Integer parentId,@RequestParam("sub_date")String sub_date,
			@RequestParam("push_id")Integer pushId,@RequestParam("days")int days,@RequestParam("page")int page,@RequestParam("rows")int rows) {
		return sUserStay.getUserStayDetail(parentId,pushId,sub_date,days-1,page,rows);
	}
	@ResponseBody
	@RequestMapping("getUserStayDetailByUserId")
	public String getUserStayDetailByUserId(@RequestParam("user_id")int user_id) {
		return sUserStay.getUserStayDetailByUserId(user_id);
	}
}
