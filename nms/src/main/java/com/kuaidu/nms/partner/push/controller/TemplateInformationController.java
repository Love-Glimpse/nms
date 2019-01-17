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

import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.entity.PartnerTemplateMsg;
import com.kuaidu.nms.entity.RestReturn;
import com.kuaidu.nms.partner.push.serviceImpl.TemplateInformationServiceImpl;
import com.kuaidu.nms.utils.ResultData;
import com.kuaidu.nms.utils.Utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/** 
 * @Title KeywordReplyController.java 
 * @description 模板消息
 * @time 2018年11月7日 下午2:23:41 
 * @author victor 
 * @version 1.0 
**/
@Controller
@RequestMapping("templateInformation")
public class TemplateInformationController {
	@Autowired
	TemplateInformationServiceImpl tImpl;
	
	@RequestMapping("/templateInformationIndex")
	public ModelAndView templateInformationIndex(HttpSession session){
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("partner/PushChannel/templateInformation"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	@ResponseBody
	@RequestMapping("/getTemplateInformation")
	public String getTemplateInformation(HttpSession session,HttpServletRequest request){
		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		if (partnerInfo==null) {
			return null;
		}
		Integer page= Integer.parseInt(request.getParameter("page"));	
		Integer rows= Integer.parseInt(request.getParameter("rows"));
		Integer start_rows = (page-1)*rows;
		List<PartnerTemplateMsg> templateInfos = tImpl.getTemplateInformation(start_rows,rows,partnerInfo.getPartner_id());
		int total = tImpl.getTemplateInformationCount();
		return ResultData.toJsonString(total, templateInfos);
	}
	
	
		@ResponseBody
		@RequestMapping("/addTemplateInformation")
		public JSONObject addKeyword(HttpSession session,PartnerTemplateMsg partnerTemplateMsg){
			JSONObject retJson = new JSONObject();
			int ret=0;
			PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
			if (partnerInfo==null) {
				retJson.put("result", 3);
				return retJson;
			}
			partnerTemplateMsg.setPartner_id(partnerInfo.getPartner_id());

			
			ret = tImpl.addTemplateMsg(partnerTemplateMsg);
			retJson.put("result", ret);
			return retJson;
		
		}
		
		@ResponseBody
		@RequestMapping("deleteTemplateInformation")
		public Object deletePartnerTemplateMsg(String node) {
			JSONObject jsonObject = new JSONObject();
			JSONArray jArray = new JSONArray();
			try {
				JSONArray jsonArray = JSONArray.fromObject(node);  
		        List<Object> list= new ArrayList<Object>();
		        for(int i=0;i<jsonArray.size();i++){
		            list.add(jsonArray.get(i));
		        }
		        System.out.println(list);
		        tImpl.deletePartnerTemplateMsg(list);
		        jsonObject.put("result", "0");
		        
			} catch (Exception e) {
				 jsonObject.put("result", "1");
				e.printStackTrace();
				
			}finally {
				jArray.add(jsonObject.toString());
				return jArray.toString();
			}
		}
		
		@ResponseBody
		@RequestMapping("testSend")
		public Object testSendTemplageMsg(Integer userId,HttpSession session,String data,String url,String template_id) {
			PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
			if (partnerInfo==null) {
				return RestReturn.fail();
			}
			return tImpl.testSendTemplageMsg(userId,data,partnerInfo.getParent_id(),url,template_id);
		}
		
		
		

		@ResponseBody
		@RequestMapping("wxTemplateMsg")
		public RestReturn getWxTemplateMsg(HttpSession session) {
			PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
			if (partnerInfo==null || partnerInfo.getGroup_id() != 1) {
				return RestReturn.fail();
			}
			return  tImpl.getWxTemplateMsg(partnerInfo.getPartner_id());
			
			
		}

}
