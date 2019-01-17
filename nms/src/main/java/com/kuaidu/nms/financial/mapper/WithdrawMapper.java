package com.kuaidu.nms.financial.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuaidu.nms.entity.PartnerAccount;
import com.kuaidu.nms.entity.PartnerWithdraw;

import tk.mybatis.mapper.common.Mapper;

public interface WithdrawMapper extends Mapper<PartnerWithdraw>{

	int getCount(PartnerWithdraw partnerWithdraw);

	List<PartnerWithdraw> getWithdraw(@Param("partnerWithdraw")PartnerWithdraw partnerWithdraw,@Param("start") int start, @Param("end")int end);

	Integer getWithdrawStatusById(Integer id);

	PartnerAccount getPartnerAccountByPartnerId(int partnerId);

}
