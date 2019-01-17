package com.kuaidu.nms.partner.proxy.mapper;

import java.util.List;

import com.kuaidu.nms.entity.PartnerInfo;

public interface PartnerProxyMapper {

	List<PartnerInfo> getProxy(PartnerInfo partnerInfo);

	void updateProxy(PartnerInfo partnerInfo);

	void addProxy(PartnerInfo partnerInfo);

	void addPartnerScale(int partner_id);

	
}
