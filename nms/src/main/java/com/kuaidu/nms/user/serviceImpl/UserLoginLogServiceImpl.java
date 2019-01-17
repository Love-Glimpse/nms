package com.kuaidu.nms.user.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.kuaidu.nms.entity.UserLoginLog;
import com.kuaidu.nms.user.mapper.UserLoginLogMapper;

@Service
public class UserLoginLogServiceImpl {
	
	
	@Autowired
	UserLoginLogMapper userLoginLogMapper;
	
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	
	


	public List<UserLoginLog> getAllRecords(UserLoginLog userLoginLog,String start_time,String end_time) {
		return userLoginLogMapper.getAllRecords(userLoginLog,start_time,end_time);
	}



	public int getCount(UserLoginLog userLoginLog, String start_time, String end_time) {
		// TODO Auto-generated method stub
		return userLoginLogMapper.getCount(userLoginLog, start_time,end_time);
	}



	public List<Map<String, Long>> userRegion() {
		// TODO Auto-generated method stub
		return userLoginLogMapper.userRegion();
	}

}
