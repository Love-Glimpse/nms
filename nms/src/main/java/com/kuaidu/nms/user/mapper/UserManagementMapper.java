package com.kuaidu.nms.user.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.kuaidu.nms.entity.MessageLog;
import com.kuaidu.nms.entity.PartnerPmConfig;
import com.kuaidu.nms.entity.UserInfo;
import com.kuaidu.nms.entity.UserPointRecord;

public interface UserManagementMapper {
	 //历史记录表查询
	 public List<UserInfo> getAllRecords(UserInfo rList);
	 //记录数，用于分页
	 public int getCount(UserInfo rList);
	 //给反馈用户增加50积分
	 public void addUserPoint50(@Param("user_id")Integer user_id);
	 
	 public List<UserInfo> getActiveUsersByPartnerId(@Param("partner_id")Integer partner_id);
	 	
	 public UserInfo getUserInfoByUserId(@Param("user_id")Integer user_id);
	 
	public List<UserInfo> getUserInfosByIds(@Param("ids")List<Integer> ids, @Param("userInfo")UserInfo userInfo);
	
	public Integer getOnlineCountUserInfosByIds(@Param("ids")List<Integer> ids,@Param("userInfo")UserInfo userInfo);
	
	public void clearUsers(List<Object> list);
	
	List<UserInfo> getUnSubScuribeOpenIdAndParentId(String[] userIds);
	
	public void addUsersPoint50(Set<Integer> userIds);
	
	public List<UserPointRecord> getUserPointRecord(UserPointRecord userPointRecord);
	
	public int getUserPointRecordCount(UserPointRecord userPointRecord);
	
	public List<MessageLog> getUserMessageLog(MessageLog messageLog);
	
	public void saveMessageLog(MessageLog messageLog);
	
	public String getUserPic(Integer user_id);
	
	public List<PartnerPmConfig> getGhPic(Integer parent_id);
	
	public void saveMessageLogs(List<MessageLog> messageLogs);
	 
}
