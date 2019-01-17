package com.kuaidu.nms.partner.datastat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuaidu.nms.entity.PartnerPushUrl;
import com.kuaidu.nms.entity.UserOrder;

public interface PartnerUserOrderMapper {
	 //历史记录表查询
	 public List<UserOrder> getAllRecords(UserOrder rList);
	 //记录数，用于分页
	 public int getCount(UserOrder rList);
	public List<PartnerPushUrl> getPushUrlsByPartnerId(@Param("partner_id")int partner_id);
	 
}
