package com.kuaidu.nms.financial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kuaidu.nms.financial.serviceImpl.BillServiceImpl;

@Controller
@RequestMapping("bill")
public class BillController {
	
	@Autowired
	BillServiceImpl billService;
	
	
	@GetMapping("index")
	public String billIndex() {
		
		
		return "financial/bill";
	}
	
	
	

}
