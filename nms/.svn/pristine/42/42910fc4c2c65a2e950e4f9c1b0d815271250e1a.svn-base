package com.kuaidu.nms.loginManage.controller;

import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.login.serviceImpl.loginMapperImpl;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("partner/userlogin")
public class PartnerLoginManage {
	@Autowired
	private loginMapperImpl lImpl;

	public loginMapperImpl getlImpl() {
		return lImpl;
	}

	public void setlImpl(loginMapperImpl lImpl) {
		this.lImpl = lImpl;
	}
	
	/*
	 * 渠道登录
	 */
	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping("/login")
	public String partnerLogin(HttpServletRequest request,HttpSession session) throws UnknownHostException{
		    JSONObject json = new JSONObject();

		try {
			String node = request.getParameter("node");
			JSONObject js = JSONObject.fromObject(node);
			PartnerInfo partnerInfo = new PartnerInfo();
			partnerInfo.setLogin_name(js.getString("user_name"));
			partnerInfo.setPassword(js.getString("password"));
			partnerInfo = lImpl.partnerLogin(partnerInfo);
			if (partnerInfo==null||partnerInfo.getPartner_id()<=0) {
				json.put("result", "1");//账号密码错误
			}else if (partnerInfo!=null&&partnerInfo.getPartner_id()!=0){
				lImpl.updatePaLastLoginTime(partnerInfo);//修改登录时间
				json.put("result", "0");
				session.setAttribute("login_flag", "partner");
				session.setAttribute("partner_user", partnerInfo);
			}else if (partnerInfo.getStatus()==0) {
				json.put("result", "3");//账号不可用
			}else {
				json.put("result", "4");//其他错误
			}
		} catch (Exception e) {
			e.printStackTrace();
			json.put("result", "2");
		}finally{
			return json.toString();
		}
		
	}
	
}
