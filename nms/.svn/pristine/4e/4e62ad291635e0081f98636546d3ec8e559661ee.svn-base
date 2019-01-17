package com.kuaidu.nms.partner.config.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.entity.PartnerPmConfig;
import com.kuaidu.nms.partner.config.serviceImpl.PartnerwxCfgMapperImpl;
import com.kuaidu.nms.utils.Utils;

import net.sf.json.JSONObject;


@Controller
@RequestMapping("/partnerChargeCfg")
public class ChargeProductController {
	@Autowired
	PartnerwxCfgMapperImpl pImpl;
	
	@RequestMapping("/chargeCfgIndex")
	public ModelAndView chargeCfgIndex(HttpSession session,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
			if (partnerInfo!=null) {
				PartnerPmConfig pmConfig = pImpl.getPmConfig(partnerInfo.getPartner_id());
				List<Integer> charge_temp_ids = pImpl.getChargeTempIds();
				mv.addObject("pmConfig", pmConfig);
				mv.addObject("charge_temp_ids", charge_temp_ids);
				mv.setViewName("partner/config/partnerchargeCfg"); 
			}else {
				response.sendRedirect("/nms/partner/index.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	@ResponseBody
	@RequestMapping("/updateChargeTemplate")
	public JSONObject updateChargeTemplate(HttpSession session,Integer chargeTempId,Integer vip_flag){
		JSONObject retJson = new JSONObject();
		int ret=0;
		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		if (partnerInfo!=null) {
			ret = pImpl.updateChargeTemplate(partnerInfo.getPartner_id(),chargeTempId,vip_flag);
			
		}else {
			ret = 0;
		}
		retJson.put("result", ret);
		return retJson;
	}
}
