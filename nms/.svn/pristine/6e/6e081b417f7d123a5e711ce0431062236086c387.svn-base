package com.kuaidu.nms.bizandpush.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kuaidu.nms.bizandpush.serviceImpl.PushUrlServiceImpl;
import com.kuaidu.nms.entity.PartnerPushUrl;
import com.kuaidu.nms.entity.Sys_user;
import com.kuaidu.nms.utils.ResultData;
import com.kuaidu.nms.utils.Utils;

/** 
 * @Title SalesPromotion.java 
 * @description 促销活动
 * @time 2018年11月2日 上午10:31:56 
 * @author victor 
 * @version 1.0 
**/
@Controller
@RequestMapping("/pushUrl")
public class PushUrlController {
	@Autowired
	PushUrlServiceImpl pImpl;
	
	@RequestMapping("/pushUrlIndex")
	public ModelAndView pushUrlIndex(HttpSession session){
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("bizAndPush/pushUrl"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 渠道推广链接表数据
	 * */
	
	@ResponseBody
	@RequestMapping("/getPushUrl")
	public String getAll(HttpServletRequest request,HttpSession session,PartnerPushUrl partnerPushUrl){	
		String offset= request.getParameter("offset");	
		String rows= request.getParameter("limit");
		/* pList = new PartnerPushUrl();*/
		partnerPushUrl.setStart_rows(Integer.parseInt(offset));
		partnerPushUrl.setEnd_rows(Integer.parseInt(rows));
		
		Sys_user  sUser = Utils.getSysUserFromSession(session);
		
		if (sUser!=null) {
			/*获取记录*/
			List<PartnerPushUrl> list =  pImpl.getAllPushUrl(partnerPushUrl);
			System.out.println(list);
			/*获取记录数*/
			int total = pImpl.getCount(partnerPushUrl);
			return ResultData.toJsonString(total, list);
		}else {
			return null;
		}
	}
}
