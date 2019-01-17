package com.kuaidu.nms.datastaticstics.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuaidu.nms.entity.StatUserOrder;
public interface UserOrderStatMapper {
	   public List<Object> getStatsToday(StatUserOrder statUserOrder);

	   public StatUserOrder getStatsYesterDay(StatUserOrder statUserOrder);

	   public StatUserOrder getStatsMonthAll(StatUserOrder statUserOrder);

	   public StatUserOrder getStatsAll(StatUserOrder statUserOrder);

	   public List<Object> getStatsList(StatUserOrder statUserOrder);

	   public List<Object> getYestDayStatsList(@Param("parent_id")Integer parent_id, 
			   @Param("startDate")String startDate, @Param("endDate")String endDate);

	public List<Object> getYestDayStatsListDetail(StatUserOrder statUserOrder);
}
