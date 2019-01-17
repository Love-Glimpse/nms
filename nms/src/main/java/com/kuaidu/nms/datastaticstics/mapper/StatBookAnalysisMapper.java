package com.kuaidu.nms.datastaticstics.mapper;

import java.util.List;
import com.kuaidu.nms.entity.StatBookAnalysis;

public interface StatBookAnalysisMapper {
	
	List<StatBookAnalysis> getBookAnalysis(StatBookAnalysis statBookAnalysis);

	int getBookAnalysisCount(StatBookAnalysis statBookAnalysis);
}
