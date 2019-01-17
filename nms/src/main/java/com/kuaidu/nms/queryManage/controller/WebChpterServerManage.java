package com.kuaidu.nms.queryManage.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kuaidu.nms.query.serviceImpl.ChpterServerImpl;


@Controller
@RequestMapping("/webchapterEdit")
public class WebChpterServerManage {
	@Autowired
	private ChpterServerImpl cImpl;
	//private BooksQueryMapperImpl bImpl;
	@Autowired
	ChpterServerImpl chpterServerImpl;
	
	@RequestMapping("/webchapterEditIndex")
	public ModelAndView booksQueryManageIndex(HttpSession session){
			
			ModelAndView mv = new ModelAndView();
		try {
			//List<Novel_type> novel_types = cImpl.getAllnovel_type();
			//mv.addObject("novel_types", novel_types);
			mv.setViewName("Query/webchapterList"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
}
