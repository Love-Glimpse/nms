package com.kuaidu.nms.partner.financial.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuaidu.nms.entity.PartnerBill;
import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.partner.financial.serviceImpl.PartnerBillServiceImpl;
import com.kuaidu.nms.utils.Utils;

/**
 * 账单模块
 * @author bkk
 *
 */
@Controller
@RequestMapping("partner/bill")
public class PartnerBillController {
	
	@Autowired
	PartnerBillServiceImpl partnerBillServices;
	
	
	@GetMapping("index")
	public String billPage(HttpSession session,HttpServletRequest request) {
		String login_flag = (String) session.getAttribute("login_flag");
		if (login_flag == null||!login_flag.equalsIgnoreCase("partner")) {
			return null;
		}
		PartnerInfo pInfo = Utils.getPartnerFromSession(session);
		if (pInfo==null) {
			return null;
		}
		partnerBillServices.getPartnerBill(pInfo,request);
		return "partner/financial/bill";
	}
	
	
	@GetMapping("{id}")
	public String getPartnerBill(@PathVariable()Integer id,HttpSession session,HttpServletRequest request) {
		String login_flag = (String) session.getAttribute("login_flag");
		if (login_flag == null||!login_flag.equalsIgnoreCase("partner")) {
			return null;
		}
		PartnerInfo pInfo = Utils.getPartnerFromSession(session);
		if (pInfo==null) {
			return null;
		}
		PartnerBill partnerBill = new PartnerBill();
		System.err.println(id+"----------------------------");
		if (pInfo.getGroup_id() == 1) {
			
			partnerBill = partnerBillServices.getParentBillById(id);
		}/*else {
			partnerBill = partnerBillServices.getPartnerBillById(id);
		}*/
		request.setAttribute("partnerBill", partnerBill);
		return "partner/financial/cashWithdrawalInfo";
	}
	
	
	@ResponseBody
	@GetMapping("everyDay")
	public Object everyDayBill(HttpSession session,Integer status,Integer pn) {
		String login_flag = (String) session.getAttribute("login_flag");
		if (login_flag == null||!login_flag.equalsIgnoreCase("partner")) {
			return null;
		}
		PartnerInfo pInfo = Utils.getPartnerFromSession(session);
		if (pInfo==null) {
			return null;
		}
		
		return partnerBillServices.everyDayBill(pInfo,status,pn);
	}
	
	
	

}
