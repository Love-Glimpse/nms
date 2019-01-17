package com.kuaidu.nms.datastaticstics.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuaidu.nms.datastaticstics.mapper.StatBookAnalysisMapper;
import com.kuaidu.nms.entity.StatBookAnalysis;
import com.kuaidu.nms.utils.ResultData;

/**
 * @description TODO
 * @time 2018年9月11日 下午2:01:37
 * @author victor
 * @version 1.0
 **/
@Service
public class StatBookAnalysisMapperImpl {
	@Autowired
	StatBookAnalysisMapper sMapper;


	public String getBookAnalysis(StatBookAnalysis statBookAnalysis) {
		// TODO Auto-generated method stub
		int count =  sMapper.getBookAnalysisCount(statBookAnalysis);
		return ResultData.toJsonString(count, sMapper.getBookAnalysis(statBookAnalysis));
	}

}
