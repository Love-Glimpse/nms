package com.kuaidu.nms.user.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kuaidu.nms.entity.UserLoginLog;

public interface UserLoginLogMapper {


	int getCount(@Param("userLoginLog")UserLoginLog userLoginLog, @Param("start_time")String start_time, @Param("end_time")String end_time);



	List<UserLoginLog> getAllRecords(@Param("userLoginLog")UserLoginLog userLoginLog,@Param("start_time") String start_time,@Param("end_time") String end_time);



	List<Map<String, Long>> userRegion();

}
