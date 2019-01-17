package com.kuaidu.nms.datastaticstics.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kuaidu.nms.datastaticstics.serviceImpl.StatBookAnalysisMapperImpl;
import com.kuaidu.nms.datastaticstics.serviceImpl.StatOrderPushMapperImpl;
import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.entity.StatBookAnalysis;
import com.kuaidu.nms.entity.Sys_user;
import com.kuaidu.nms.utils.Utils;

/** 
 * @Title 
 * 书本统计分析
 * @description TODO 
 * @time 2018年9月10日 下午5:37:50 
 * @author victor 
 * @version 1.0 
**/
@Controller
@RequestMapping("/bookAnalysis")
public class StatBookAnalysisController {
	@Autowired
	StatOrderPushMapperImpl sImpl;
	@Autowired
	StatBookAnalysisMapperImpl bImpl;
	
	@RequestMapping("/bookAnalysisIndex")
	public ModelAndView statOrderPushIndex(HttpSession session){
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("PushChannel/bookAnalysis"); 
			List<PartnerInfo> list = sImpl.getAllPartnerId();
			mv.addObject("partnerInfos", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	@ResponseBody
	@RequestMapping("/getBookAnalysis")
	public String getBookAnalysis(HttpSession session,StatBookAnalysis statBookAnalysis){
		Sys_user sys_user = Utils.getSysUserFromSession(session);
		if (sys_user==null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (statBookAnalysis.getStart_date()==null||statBookAnalysis.getStart_date().equalsIgnoreCase("")) {
			statBookAnalysis.setStart_date(sdf.format(Utils.getDateByDays(-1)));
		}
		if (statBookAnalysis.getEnd_date()==null||statBookAnalysis.getEnd_date().equalsIgnoreCase("")) {
			statBookAnalysis.setEnd_date(sdf.format(Utils.getDateByDays(-1)));
		}
		statBookAnalysis.setStart_rows((statBookAnalysis.getPage()-1)*statBookAnalysis.getRows());

		return bImpl.getBookAnalysis(statBookAnalysis);		
	}

	
}
