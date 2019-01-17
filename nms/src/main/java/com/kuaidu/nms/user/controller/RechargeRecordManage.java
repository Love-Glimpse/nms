package com.kuaidu.nms.user.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.entity.PayChannel;
import com.kuaidu.nms.entity.UserOrder;
import com.kuaidu.nms.user.serviceImpl.RechargeRecordMapperImpl;
import com.kuaidu.nms.utils.EasyUIReturn;
import com.kuaidu.nms.utils.Utils;


@Controller
@RequestMapping("/rechargeRecord")
public class RechargeRecordManage {
	@Autowired
	private RechargeRecordMapperImpl rImpl;
	
	@RequestMapping("/rechargeRecordIndex")
	public ModelAndView readingRecordsManageIndex(HttpSession session){
		ModelAndView mv = new ModelAndView();
		try {
			List<PayChannel> pay_channels = rImpl.getAllPayChannel();
			List<PartnerInfo> partnerInfos = rImpl.getWxAuthPartners();
			mv.addObject("pay_channels", pay_channels);
			mv.addObject("partnerInfos",partnerInfos);
			mv.setViewName("user/rechargeRecord");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	/*
	 * 使用了分页的话，其框架自身会向后台传递page、rows这个两个属性值。
	 * 分别表示当前页和当前页显示的记录行数。
	 * 可以在action中定义好这两个属性，并同样设置getter和setter方法，就可以接受到这些参数了。
	 * */
	//查
	@ResponseBody
	@RequestMapping("/getAll")
	public EasyUIReturn getAll(HttpServletRequest request,UserOrder userOrder,Integer timeFlag){
		
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		
		if (timeFlag==null||timeFlag==0) {
			userOrder.setStart_time("");
			userOrder.setEnd_time("");
		}else {
			if (userOrder.getStart_time()==null|| userOrder.getStart_time().equalsIgnoreCase("")) {
				userOrder.setStart_time(sdf.format(Utils.getDateByDays(-7)));
			}
			if (userOrder.getEnd_time()==null|| userOrder.getEnd_time().equalsIgnoreCase("")) {
				userOrder.setEnd_time(sdf.format(new Date()));
			}
		}
		String page= request.getParameter("page");	
		String rows= request.getParameter("rows");
		Integer start_rows = Integer.parseInt(page)*Integer.parseInt(rows)-Integer.parseInt(rows);
		userOrder.setStart_rows(start_rows);
		userOrder.setEnd_rows(Integer.parseInt(rows));
		List<UserOrder> list = rImpl.getAllRecords(userOrder);
		int total = rImpl.getCount(userOrder);
		//return ResultData.toJsonString(total, list);
		return new EasyUIReturn(total, list);
	}
}
