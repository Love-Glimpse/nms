package com.kuaidu.nms.bizandpush.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/** 
 * @Title CustomMsgNews.java 
 * @description 图文客服消息
 * @time 2018年11月2日 上午9:52:31 
 * @author victor 
 * @version 1.0 
**/
@Controller
@RequestMapping("/customMsgNews")
public class CustomMsgNewsController {
	@RequestMapping("/customMsgNewsIndex")
	public ModelAndView customMsgNewsIndex(HttpSession session){
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("bizAndPush/sendGroupMsg"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
}
