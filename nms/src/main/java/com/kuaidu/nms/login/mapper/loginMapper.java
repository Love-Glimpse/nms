package com.kuaidu.nms.login.mapper;

import org.apache.ibatis.annotations.Param;

import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.entity.Sys_user;
public interface loginMapper {
	   public Sys_user login(Sys_user user);
	   public void edit_last_time(@Param("user_id")Integer user_id);
	   public void edit_status(@Param("status")Integer status,@Param("user_id")Integer user_id);
	   public PartnerInfo partnerLogin(PartnerInfo partnerInfo);
	   public void updateUserStatus(Sys_user user);
	   public void updatePaLastLoginTime(PartnerInfo partnerInfo);
}
