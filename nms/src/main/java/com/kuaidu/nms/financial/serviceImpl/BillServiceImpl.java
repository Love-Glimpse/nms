package com.kuaidu.nms.financial.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuaidu.nms.entity.PartnerBill;
import com.kuaidu.nms.financial.mapper.BillMapper;

@Service
public class BillServiceImpl {

	@Autowired
	BillMapper billMapper;
	
	
	public Object getBill(PartnerBill partnerBill) {
		
		List<PartnerBill> list = billMapper.getBill(partnerBill);
		return null;
	}

}
