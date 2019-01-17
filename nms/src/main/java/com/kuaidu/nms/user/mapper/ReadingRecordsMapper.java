package com.kuaidu.nms.user.mapper;

import java.util.List;

import com.kuaidu.nms.entity.UserReadLog;

public interface ReadingRecordsMapper {
	 //历史记录表查询
	 List<UserReadLog> getAllRecords(UserReadLog rList);
	 //记录数，用于分页
	 int getCount(UserReadLog rList);
	 
	 List<UserReadLog> getGroupUser_id(UserReadLog rList);
	 
	int getGroupByUserIdReadLogCount();
	 
}
