package com.kuaidu.nms.partner.push.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.entity.Product;
import com.kuaidu.nms.entity.PromotionActive;
import com.kuaidu.nms.partner.push.serviceImpl.PartnerSalesPromotionImpl;
import com.kuaidu.nms.utils.ResultData;
import com.kuaidu.nms.utils.Utils;

import net.sf.json.JSONObject;

/** 
 * @Title SalesPromotion.java 
 * @description 促销活动
 * @time 2018年11月2日 上午10:31:56 
 * @author victor 
 * @version 1.0 
**/
@Controller
@RequestMapping("/partnerSalesPromotion")
public class PartnerSalesPromotionController {
	@Autowired
	PartnerSalesPromotionImpl sImpl;
	
	@RequestMapping("/partnerSalesPromotionIndex")
	public ModelAndView customMsgNewsIndex(HttpSession session){
		ModelAndView mv = new ModelAndView();
		try {
			List<Product> products = sImpl.getPromotionProducts();
			mv.addObject("product", products);
			mv.setViewName("partner/PushChannel/partnerSalesPromotion"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 获取平台活动列表
	 * */
	
	@ResponseBody
	@RequestMapping("/getPromotionActiveList")
	public String getAll(HttpServletRequest request,HttpSession session,PromotionActive promotionActive){	
		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		if (partnerInfo!=null) {
			String offset= request.getParameter("offset");	
			String rows= request.getParameter("limit");
			promotionActive.setStart_rows(Integer.parseInt(offset));
			promotionActive.setEnd_rows(Integer.parseInt(rows));
			promotionActive.setFlag(0);
			List<PromotionActive> list =  sImpl.getPromotionActiveList(promotionActive);
			for (PromotionActive pActive : list) {
				pActive.setActive_url(pActive.getActive_url().replace("####", partnerInfo.getPartner_id()+"")+pActive.getActive_id());
			}
			int total = sImpl.getPromotionProductsCount(promotionActive);
			return ResultData.toJsonString(total, list);
		}else {
			return null;
		}
	}
	
	
	/**
	 * 获取渠道自己的活动列表
	 * */
	@ResponseBody
	@RequestMapping("/getPartnerPromotionActiveList")
	public String getPartnerPromotionActiveList(HttpServletRequest request,HttpSession session,PromotionActive promotionActive) {

		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		
		if (partnerInfo!=null) {
			String offset= request.getParameter("offset");	
			String rows= request.getParameter("limit");
			promotionActive.setStart_rows(Integer.parseInt(offset));
			promotionActive.setEnd_rows(Integer.parseInt(rows));
			promotionActive.setFlag(1);
			promotionActive.setPartner_id(partnerInfo.getPartner_id());
			List<PromotionActive> list =  sImpl.getPromotionActiveList(promotionActive);
			for (PromotionActive pActive : list) {
				pActive.setActive_url(pActive.getActive_url()+pActive.getActive_id());
			}
			int total = sImpl.getPromotionProductsCount(promotionActive);
			return ResultData.toJsonString(total, list);
		}else {
			return null;
		}
	}
	
	/**
	 * 1：成功
	 * 2：结束日期不正确
	 * 3：需要重新登录
	 * 4：创建次数超过限制
	 * 渠道添加活动
	 * */
	@ResponseBody
	@RequestMapping("/createActive")
	public JSONObject addPlatActive(HttpServletRequest request,HttpSession session,PromotionActive promotionActive,String product_list) {
		JSONObject retJson = new JSONObject();
		int ret=0;
		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		if (partnerInfo==null) {
			retJson.put("result", 3);//需要重新登录
			return retJson;
		}
		promotionActive.setPartner_id(partnerInfo.getPartner_id());
		int count = sImpl.getActiveCount(promotionActive);
		if (count>=4) {
			retJson.put("result", 4);//活动次数超过4次
			return retJson;
		}
		ret = sImpl.createActive(promotionActive,product_list);
	
		retJson.put("result", ret);
		return retJson;
	}
	/**
	 * 渠道删除活动
	 * */
	@ResponseBody
	@RequestMapping("/removeActive")
	public JSONObject removeActive(HttpServletRequest request,HttpSession session,Integer active_id) {
		JSONObject retJson = new JSONObject();
		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		if (partnerInfo==null) {
			retJson.put("result", 1);
			return retJson;
		}else {
	        sImpl.removeActive(partnerInfo.getPartner_id(),active_id);
			retJson.put("result", 1);
			return retJson;
		}
	}
	
}
