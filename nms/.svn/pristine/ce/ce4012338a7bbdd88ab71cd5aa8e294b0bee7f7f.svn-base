package com.kuaidu.nms.datastaticstics.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.entity.PartnerPushUrl;
import com.kuaidu.nms.entity.StatOrderPush;

public interface StatOrderPushMapper {

	List<StatOrderPush> getStatOrders(StatOrderPush statOrderPush);

	List<PartnerPushUrl> getAllPush(int partnerId);

	List<PartnerInfo> getAllPartnerId();

	void statTodayOrders();

	List<StatOrderPush> getSubDateDetail(@Param("parent_id")Integer parentId, @Param("push_id")Integer pushId,@Param("sub_date")String sub_date);


}
