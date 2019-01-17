package com.kuaidu.nms.pay.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuaidu.nms.entity.PayChannel;
import com.kuaidu.nms.entity.RestReturn;
import com.kuaidu.nms.pay.serviceImpl.PayChannelServiceImpl;

@Controller
public class PayChannelController {
	
	
	@Autowired
	PayChannelServiceImpl payChannelService;
	
	
	@RequestMapping("payChannel/index")
	public String toPayChannelPage() {
		return "pay/payChannel";
		
	}
	
	
	@ResponseBody
	@RequestMapping("payChannels")
	public String getAllPayChannel(HttpServletRequest request,PayChannel payChannel) {
		Integer start_rows = (payChannel.getPage()-1)*payChannel.getRows();
		payChannel.setStart_rows(start_rows);
		String  json = payChannelService.getAllPayChannel(payChannel);
		return json;
	}
	
	@ResponseBody
	@PutMapping("payChannel/{channelId}")
	public RestReturn updateEveryDayStatus(@PathVariable()Integer channelId,@RequestParam(required=false)Integer status
			,@RequestParam(required=false)Integer everydayStatus) {
		
		return payChannelService.updateEveryDayStatus(channelId,status,everydayStatus);
	}
	
	
}
