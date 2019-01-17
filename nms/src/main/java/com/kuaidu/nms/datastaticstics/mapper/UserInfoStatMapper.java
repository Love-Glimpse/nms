package com.kuaidu.nms.datastaticstics.mapper;

import java.util.List;

import com.kuaidu.nms.entity.StatUserInfo;

public interface UserInfoStatMapper {
	public List<java.util.Map<String, Object>> getStatsToday(StatUserInfo statUserInfo);

	public StatUserInfo getStatsYesterDay(StatUserInfo statUserInfo);

	public StatUserInfo getStatsMonthAll(StatUserInfo statUserInfo);

	public StatUserInfo getStatsAll(StatUserInfo statUserInfo);

	public List<Object> getStatsList(StatUserInfo statUserInfo);

	public List<Object> getStatsListGroup(StatUserInfo statUserInfo);
}
