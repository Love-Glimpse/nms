package com.kuaidu.nms.partner.push.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kuaidu.nms.entity.PartnerCustomMsg;
import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.entity.WxCustomMsg;
import com.kuaidu.nms.partner.push.serviceImpl.CustomerServiceInfoServiceImpl;
import com.kuaidu.nms.utils.EasyUIReturn;
import com.kuaidu.nms.utils.Utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/** 
 * @Title CustomerServiceInfoController.java 
 * @description 客服消息配置
 * @time 2018年11月7日 下午2:23:41 
 * @author dky 
 * @version 1.0 
**/
@Controller
@RequestMapping("partnerCustomerServiceInfo")
public class CustomerServiceInfoController {
	@Autowired
	CustomerServiceInfoServiceImpl cImpl;
	
	@RequestMapping("/customerServiceInfoIndex")
	public ModelAndView customerServiceInfoIndex(HttpSession session){
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("partner/PushChannel/CustomerServiceInfo"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	@ResponseBody
	@RequestMapping("/getCustomerServiceInfo")
	public EasyUIReturn getCustomerServiceInfo(HttpSession session,HttpServletRequest request){
		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		if (partnerInfo==null) {
			return null;
		}
		Integer page= Integer.parseInt(request.getParameter("page"));	
		Integer rows= Integer.parseInt(request.getParameter("rows"));
		Integer start_rows = (page-1)*rows;
		List<PartnerCustomMsg> pKeywords = cImpl.getCustomerServiceInfo(start_rows,rows,partnerInfo.getPartner_id());
		int total = cImpl.getCustomerServiceInfoCount();
		return new EasyUIReturn(total, pKeywords);
	}
	
	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping("/delCustomerServiceInfo")
	public String delCustomerServiceInfo(HttpSession session,HttpServletRequest request){
		String node =request.getParameter("node");
		JSONObject jsonObject = new JSONObject();
		JSONArray jArray = new JSONArray();
		try {
			JSONArray jsonArray = JSONArray.fromObject(node);  
	        List<Object> list= new ArrayList<Object>();
	        for(int i=0;i<jsonArray.size();i++){
	            list.add(jsonArray.get(i));
	        }
	        cImpl.delCustomerServiceInfo(list);
	        jsonObject.put("result", "0");
	        
		} catch (Exception e) {
			 jsonObject.put("result", "1");
			e.printStackTrace();
			
		}finally {
			jArray.add(jsonObject.toString());
			return jArray.toString();
		}
	}
	
	
	
		/**
		 * 添加群发客服消息
		 * */
		@ResponseBody
		@RequestMapping("/addCustomerServiceInfo")
		public JSONObject addCustomerServiceInfo(HttpSession session,PartnerCustomMsg partner_custom_msg){
			JSONObject retJson = new JSONObject();
			int ret=0;
			PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
			if (partnerInfo==null) {
				retJson.put("result", 3);
				return retJson;
			}
			partner_custom_msg.setPartner_id(partnerInfo.getPartner_id());
			ret = cImpl.addCustomerServiceInfo(partner_custom_msg);
			retJson.put("result", ret);
			return retJson;
		
	}
		/**
		 * 测试粉丝
		 * */
		@ResponseBody
		@RequestMapping("/addTestWxCustomMsg")
		public JSONObject addTestWxCustomMsg(HttpSession session,WxCustomMsg wxCustomMsg,HttpServletRequest request){
			JSONObject retJson = new JSONObject();
			PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
			if (partnerInfo==null) {
				retJson.put("result", 3);
				return retJson;
			}
			int ret = cImpl.sendTestWxCustomMsg(wxCustomMsg,partnerInfo);
			retJson.put("result", ret);
			return retJson;
			
		}
		
}
