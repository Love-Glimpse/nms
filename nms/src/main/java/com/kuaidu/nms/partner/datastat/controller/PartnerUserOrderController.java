package com.kuaidu.nms.partner.datastat.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.entity.PartnerPushUrl;
import com.kuaidu.nms.entity.UserOrder;
import com.kuaidu.nms.partner.datastat.serviceImpl.PartnerUserOrderMapperImpl;
import com.kuaidu.nms.partner.proxy.serviceImpl.PartnerProxyMapperImpl;
import com.kuaidu.nms.utils.EasyUIReturn;
import com.kuaidu.nms.utils.ResultData;
import com.kuaidu.nms.utils.Utils;


@Controller
@RequestMapping("/partnerUserOrder")
public class PartnerUserOrderController {
	@Autowired
	private PartnerUserOrderMapperImpl pImpl;
	@Autowired 
	PartnerProxyMapperImpl proxyImpl;
	@RequestMapping("/partnerUserOrderIndex")
	public ModelAndView partnerUserOrderIndex(HttpSession session){
		ModelAndView mv = new ModelAndView();
		try {
			PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
			if (partnerInfo==null) {
				return mv;
			}
			PartnerInfo partnerInfo2 = new PartnerInfo();
			partnerInfo2.setPartner_id(partnerInfo.getPartner_id());
			List<PartnerInfo> proxys = proxyImpl.getProxy(partnerInfo2);
			proxys.add(partnerInfo);
			mv.addObject("proxy", proxys);
			mv.setViewName("partner/dataStat/partnerUserOrder");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	@RequestMapping("/partnerUserOrderDetailIndex")
	public ModelAndView partnerUserOrderDetailIndex(HttpSession session,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		try {
			String push_id = request.getParameter("push_id")+"";
			mv.addObject("push_id", push_id);
			mv.setViewName("partner/dataStat/partnerUserOrderDetail");
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
	@RequestMapping("/getOrders")
	public EasyUIReturn getAll(HttpServletRequest request,HttpSession session,UserOrder userOrder){	
		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		if (partnerInfo==null) {
			return null;
		}else {
			if (partnerInfo.getPartner_gradation()>1) {//代理渠道登录
				userOrder.setParent_id(partnerInfo.getParent_id());
				userOrder.setPartner_id(partnerInfo.getPartner_id());
			}else if (partnerInfo.getPartner_gradation() == 1) {
				if (userOrder.getPartner_id()!=null&&userOrder.getPartner_id()>0) {//查询代理渠道订单
					//userOrder.setParent_id(partnerInfo.getParent_id());
					//userOrder.setPartner_id(userOrder.getPartner_id());
				}else if (userOrder.getPartner_id()==null||userOrder.getPartner_id()==0) {//所有订单
					userOrder.setParent_id(partnerInfo.getParent_id());
					userOrder.setPartner_id(partnerInfo.getPartner_id());
				}
			}else {
				return null;
			}

		}
		String page= request.getParameter("page");	
		String rows= request.getParameter("rows");
		Integer start_rows = Integer.parseInt(page)*Integer.parseInt(rows)-Integer.parseInt(rows);
		userOrder.setStart_rows(start_rows);
		userOrder.setEnd_rows(Integer.parseInt(rows));
		List<UserOrder> list = pImpl.getAllRecords(userOrder);
		int total = pImpl.getCount(userOrder);
		//return ResultData.toJsonString(total, list);
		return new  EasyUIReturn(total,list);
	}
	@ResponseBody
	@RequestMapping("/getPushUrlsByPartnerId")
	public String getPushUrlsByPartnerId(HttpSession session,int partner_id){
		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		if (partnerInfo==null) {
			return "";
		}
		List<PartnerPushUrl> partnerPushUrls = pImpl.getPushUrlsByPartnerId(partner_id);
		return ResultData.toJsonString2(partnerPushUrls);
	}
	
}
