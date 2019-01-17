package com.kuaidu.nms.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuaidu.nms.entity.UserProposal;

public interface UserFeedBackMapper {
	 //历史记录表查询
	 public List<UserProposal> getAllRecords(UserProposal rList);
	 //记录数，用于分页
	 public int getCount(UserProposal rList);
	public void ignore(@Param("list")List<Integer> ids,@Param("status")int status);
	 
}
