package com.kuaidu.nms.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuaidu.nms.entity.SearchLog;
import com.kuaidu.nms.entity.UserInfo;

public interface SearchLogMapper {

	List<SearchLog> getAllRecords(SearchLog searchLog);

	int deleteSearchLog(List<Integer> split);

	int getCount(SearchLog searchLog);

	List<SearchLog> getSortAllRecords(SearchLog searchLog);
	
	int getSortCount(SearchLog searchLog);

	String getOpenidByUserId(Integer userId);

	UserInfo getParentIdAndOpenidByUserId(Integer userId);

	void saveReplayMsg(@Param("id")Integer id,@Param("msg") String msg, @Param("showName")String show_name);

}
