package com.kuaidu.nms.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kuaidu.nms.partner.financial.serviceImpl.PartnerBillServiceImpl;
import com.kuaidu.nms.utils.Utils;

@Component
public class BillJob {
	
	@Autowired
	PartnerBillServiceImpl partnerBillServices;
	
	
	@Scheduled(cron = "1 30 0 * * ?")
	public void statisticalBill () {
		String ip = Utils.getLocalHostIp();
		if (ip.equals("69.171.67.171")) {
			partnerBillServices.statisticalBill();
		}
	}

}
