package com.kuaidu.nms.partner.push.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuaidu.nms.entity.PartnerCustomMsg;

public interface CustomerServiceInfoMapper{
	List<PartnerCustomMsg> getCustomerServiceInfo(@Param("start_rows")Integer start_rows, @Param("rows")Integer rows,@Param("partner_id") int partner_id);
	/*获取记录数，分页*/
	int getCustomerServiceInfoCount();

	public void delCustomerServiceInfo(List<Object> list);

	void addCustomerServiceInfo(PartnerCustomMsg partner_custom_msg);
	
}
