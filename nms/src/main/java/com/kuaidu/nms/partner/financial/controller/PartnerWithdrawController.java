package com.kuaidu.nms.partner.financial.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.entity.PartnerWithdraw;
import com.kuaidu.nms.entity.RestReturn;
import com.kuaidu.nms.partner.financial.serviceImpl.PartnerWithdrawServiceImpl;
import com.kuaidu.nms.utils.Utils;

/**
 *  提现模块 
 * @author bkk
 *
 */
@Controller
@RequestMapping("partner/withdraw")
public class PartnerWithdrawController {
	
	@Autowired
	PartnerWithdrawServiceImpl partnerWithdrawService;
	
	
	
	
	
	/*
	@GetMapping("withdraw/index")
	public String withDrawPage() {
		
		
		return "partner/financial/withdraw";
		
	}*/
	
	//@ResponseBody
	@RequestMapping("index")
	public String getPartnerWithdraw(String start,String end,HttpSession session,HttpServletRequest request) {
		String login_flag = (String) session.getAttribute("login_flag");
		if (login_flag == null||!login_flag.equalsIgnoreCase("partner")) {
			return null;
		}
		PartnerInfo pInfo = Utils.getPartnerFromSession(session);
		if (pInfo==null) {
			return null;
		}
		 partnerWithdrawService.getPartnerWithdraw(pInfo,start,end,request);
		 return "partner/financial/withdraw";
	}
	
	
	
	@GetMapping("{id}")
	public String getPartnerWithdraw(@PathVariable()Integer id,HttpSession session,HttpServletRequest request) {
		String login_flag = (String) session.getAttribute("login_flag");
		if (login_flag == null||!login_flag.equalsIgnoreCase("partner")) {
			return null;
		}
		PartnerInfo pInfo = Utils.getPartnerFromSession(session);
		if (pInfo==null) {
			return null;
		}
		int group_id = pInfo.getGroup_id();
		PartnerWithdraw partnerWithdraw = new PartnerWithdraw();
		if (group_id == 1) {
			 partnerWithdraw = partnerWithdrawService.getParentWithdrawById(id);
		}else {
			 partnerWithdraw = partnerWithdrawService.getPartnerWithdrawById(id);
		}
		request.setAttribute("partnerWithdraw", partnerWithdraw);
		return "partner/financial/cashWithdrawalInfo";
	}
	
	
	
	
	
	/**
	 * 申请提现
	 * @return
	 */
	@ResponseBody
	@GetMapping("request")
	public RestReturn withdrawRequest(HttpSession session) {
		String login_flag = (String) session.getAttribute("login_flag");
		if (login_flag == null||!login_flag.equalsIgnoreCase("partner")) {
			return null;
		}
		PartnerInfo pInfo = Utils.getPartnerFromSession(session);
		if (pInfo==null) {
			return null;
		}
		
		return partnerWithdrawService.withdrawRequest(pInfo);
	}

}
