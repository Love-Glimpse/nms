package com.kuaidu.nms.partner.financial.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuaidu.nms.entity.PartnerBill;
import com.kuaidu.nms.entity.PartnerWithdraw;

import tk.mybatis.mapper.common.Mapper;

public interface PartnerWithdrawMapper extends Mapper<PartnerWithdraw>{

	void savePartnerWithAndBill(@Param("id")Integer id,@Param("list") List<PartnerBill> list);

	List<PartnerWithdraw> getPartnerWithdrawByPartnerId(@Param("partnerId")int partner_id,@Param("start") String start,@Param("end") String end);

	List<PartnerWithdraw> getparentWithdrawByPartnerId(@Param("partnerId")int partner_id,@Param("start") String start,@Param("end") String end);

	PartnerWithdraw getPartnerWithAccountByPartnerId(int partner_id);

	PartnerWithdraw getPartnerWithdrawById(Integer id);

	PartnerWithdraw getParentWithdrawById(Integer id);
	
	

}
