package com.kuaidu.nms.user.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaidu.nms.entity.UserReadLog;
import com.kuaidu.nms.user.mapper.ReadingRecordsMapper;
/*
 * 接口实现类
 * */
@Service
@Transactional 
public class ReadingRecordsMapperImpl {
	@Resource
	private ReadingRecordsMapper rMapper;

	public ReadingRecordsMapper getrMapper() {
		return rMapper;
	}

	public void setrMapper(ReadingRecordsMapper rMapper) {
		this.rMapper = rMapper;
	}
	
	public List<UserReadLog> getAllRecords(UserReadLog rList, Integer isGroup) {
		if (isGroup == 1) {
			
			return rMapper.getAllRecords(rList);
		}else {
			return rMapper.getGroupUser_id(rList);
		}
	}
	//获取书籍记录总行数
	public int getCount(UserReadLog rList, Integer isGroup) {
		if(isGroup == 1) {
			
			return rMapper.getCount(rList);
		}else {
			return rMapper.getGroupByUserIdReadLogCount();
		}
	}

	public List<UserReadLog> getGroupByUserIdReadLog(UserReadLog rList) {
		return rMapper.getGroupUser_id(rList);
	}

	public int getGroupByUserIdReadLogCount() {
		return rMapper.getGroupByUserIdReadLogCount();
	}

}
