package com.kuaidu.nms.financial.mapper;

import java.util.List;

import com.kuaidu.nms.entity.PartnerBill;

public interface BillMapper {

	List<PartnerBill> getBill(PartnerBill partnerBill);

	void updateBillPay(Integer id);

}
