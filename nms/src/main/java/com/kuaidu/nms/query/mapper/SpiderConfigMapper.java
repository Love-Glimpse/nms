package com.kuaidu.nms.query.mapper;

import java.util.List;

import com.kuaidu.nms.entity.SpiderConfig;

public interface SpiderConfigMapper {

	List<SpiderConfig> getAllConfigs(SpiderConfig spiderConfig);

	int getCount();

	void update_sConfig(SpiderConfig spiderConfig);

	void del_sConfig(SpiderConfig spiderConfig);

	void add_sConfig(SpiderConfig spiderConfig);
	
}
