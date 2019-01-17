package com.kuaidu.nms.partner.config.controller;

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
@RequestMapping("/partnerwxCfg")
public class PartnerwxCfgController {
	@Autowired
	PartnerwxCfgMapperImpl pImpl;
	
	@RequestMapping("/partnerwxCfgIndex")
	public ModelAndView partnerwxCfgIndex(HttpSession session,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
			if (partnerInfo!=null) {
				PartnerPmConfig pmConfig = pImpl.getPmConfig(partnerInfo.getPartner_id());
				mv.addObject("pmConfig", pmConfig);
				mv.setViewName("partner/config/partnerwxCfg"); 
			}else {
				response.sendRedirect("/nms/partner/index.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	@ResponseBody
	@RequestMapping("/save")
	public JSONObject save(HttpSession session,PartnerPmConfig pmConfig){
		JSONObject retJson = new JSONObject();
		int ret=0;
		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		if (partnerInfo!=null) {
			pmConfig.setPartner_id(partnerInfo.getPartner_id());
			ret = pImpl.save(pmConfig);
		}else {
			ret = 0;
		}
		retJson.put("result", ret);
		return retJson;
	}
	
	@ResponseBody
	@RequestMapping("/doMenu")
	public JSONObject doMenu(HttpSession session,int flag,int menu_id){
		JSONObject retJson = new JSONObject();
		int ret=0;
		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		if (partnerInfo!=null) {
			ret = pImpl.doMenu(partnerInfo,flag,menu_id);
		}else {
			ret = 0;
		}
		retJson.put("result", ret);
		return retJson;
	}
	
}
