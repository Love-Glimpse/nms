package com.kuaidu.nms.user.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuaidu.nms.entity.RestReturn;
import com.kuaidu.nms.entity.SearchLog;
import com.kuaidu.nms.entity.UserInfo;
import com.kuaidu.nms.user.mapper.SearchLogMapper;

@Service
public class SearchLogServiceImpl {
	
	
	@Autowired
	SearchLogMapper searchLogMapper;
	

	

	public List<SearchLog> getAllRecords(SearchLog searchLog) {
		return searchLogMapper.getAllRecords(searchLog);
	}


	public int getCount(SearchLog searchLog) {
		return searchLogMapper.getCount(searchLog);
	}


	public Object deleteSearchLog(String ids) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		String[] split = StringUtils.split(ids, "-");
		for (String string : split) {
			int parseInt = Integer.parseInt(string);
			arrayList.add(parseInt);
			
		}
		int num = searchLogMapper.deleteSearchLog(arrayList);
		if (num >=1) {
			return RestReturn.success();
		}
		
		
		
		return RestReturn.fail();
	}


	public List<SearchLog> getSortAllRecords(SearchLog searchLog) {
		
		return searchLogMapper.getSortAllRecords(searchLog);
	}


	public int getSortCount() {
		
		return searchLogMapper.getSortCount(null);
	}


	


	public UserInfo getParentIdAndOpenidByUserId(Integer userId) {
		return searchLogMapper.getParentIdAndOpenidByUserId(userId);
	}


	public void saveReplayMsg(Integer id, String msg, String show_name) {
		searchLogMapper.saveReplayMsg( id,  msg,  show_name) ;
		
	}
	
	
	

}
