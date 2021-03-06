package com.kuaidu.nms.loginManage.controller;

import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuaidu.nms.entity.Sys_user;
import com.kuaidu.nms.login.serviceImpl.loginMapperImpl;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/userlogin")
public class LoginManage {
	@Autowired
	private loginMapperImpl lImpl;

	public loginMapperImpl getlImpl() {
		return lImpl;
	}

	public void setlImpl(loginMapperImpl lImpl) {
		this.lImpl = lImpl;
	}
	
	/*
	 * 系统用户登录
	 */
	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping("/login")
	public String login(HttpServletRequest request,HttpSession session) throws UnknownHostException{
		    JSONObject json = new JSONObject();

		try {
			String node = request.getParameter("node");
			JSONObject js = JSONObject.fromObject(node);
			Sys_user user = new Sys_user();
			user.setUser_name(js.getString("user_name"));
			user.setMd5_pwd(js.getString("password"));
			user = lImpl.login(user);
			if (user==null||user.getUser_id()==null) {
				json.put("result", "1");//用户名或密码不存在
			}else if (user.getStatus()==0) {
				json.put("result", "3");//账号不可用
			}else {
				user.setLogin_status(1);
				lImpl.updateUserStatus(user);//修改登录状态
				session.setAttribute("login_flag", "system");
				session.setAttribute("user", user);
				json.put("result", "0");//登录成功
			}
		} catch (Exception e) {
			e.printStackTrace();
			json.put("result", "2");//请求失败
		}finally{
			return json.toString();
		}
		
	}

}
