package com.kuaidu.nms.bizandpush.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuaidu.nms.bizandpush.serviceImpl.WxExternalUrlServiceImpl;
import com.kuaidu.nms.entity.WxJumpLog;
import com.kuaidu.nms.utils.Utils;

import cz.mallat.uasparser.OnlineUpdater;
import cz.mallat.uasparser.UASparser;
import cz.mallat.uasparser.UserAgentInfo;

/** 
 * @Title ExternalUrlController.java 
 * @description 微信跳转统计
 * @time 2018年11月19日 上午11:55:37 
 * @author victor 
 * @version 1.0 
**/

@Controller
@RequestMapping("/externalUrl")
public class WxExternalUrlController {
	@Autowired
	WxExternalUrlServiceImpl wxImpl;
	@ResponseBody
	@RequestMapping("wx/{pushId}")
	public void WxJump(HttpServletRequest request,HttpServletResponse response
			,@PathVariable Integer pushId) {
		try {
			// 处理统计
			String userAgent = request.getHeader("user-agent");
			String model = getMobileModel(userAgent);
			UASparser uasParser = null;
			uasParser = new UASparser(OnlineUpdater.getVendoredInputStream());
			String ip = Utils.getClientIP(request);
			UserAgentInfo userAgentInfo = uasParser.parse(userAgent);

			WxJumpLog wxJumpLog = new WxJumpLog();
			wxJumpLog.setModle(model);
			wxJumpLog.setPush_id(pushId);
			wxJumpLog.setIp(ip);
			wxJumpLog.setBrowser(userAgentInfo.getUaName());
			wxJumpLog.setOs_name(userAgentInfo.getOsName());
			wxImpl.saveWxJumpLog(wxJumpLog);
			
			String redirectUrl = wxImpl.getWxRedirectUrlByPushId(pushId);
			if (redirectUrl == null) {
				response.setStatus(404);
				return;
			}
			response.sendRedirect(redirectUrl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getMobileModel(String userAgent) {
		// 获取手机型号开始**************************************************************************
		// 获取Android手机型号
		String mobileModel = "unknown";
		try {
			Pattern pattern = Pattern.compile(";\\s?(\\S*?\\s?\\S*?)\\s?(Build)?/");
			Matcher matcher = pattern.matcher(userAgent);
			if (matcher.find()) {
				String sub = StringUtils.substringBetween(userAgent, "(", ")");
				String[] split = StringUtils.split(sub, ";");
				sub = split[split.length - 2] + split[split.length - 1];
				mobileModel = StringUtils.replaceOnce(sub, "Build", "").trim();
			}
			// 判断iphone和ipad
			if (userAgent.toLowerCase().indexOf("iphone") > 0) {
				mobileModel = "iPhone";
			}
			if (userAgent.toLowerCase().indexOf("ipad") > 0) {
				mobileModel = "iPad";
			}
		} catch (Exception e) {
		}
		// 获取手机型号结束**************************************************************************
		return mobileModel;
	}
}
