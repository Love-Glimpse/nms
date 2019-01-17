package com.kuaidu.nms.query.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaidu.nms.entity.SpiderConfig;
import com.kuaidu.nms.query.mapper.SpiderConfigMapper;
/*
 * 接口实现类
 * */
@Service
@Transactional 
public class SpiderConfigMapperImpl {
	@Resource
	private SpiderConfigMapper sMapper;

	public List<SpiderConfig> getAllConfigs(SpiderConfig spiderConfig) {
		// TODO Auto-generated method stub
		return sMapper.getAllConfigs(spiderConfig);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return sMapper.getCount();
	}

	public void update_sConfig(SpiderConfig spiderConfig) {
		// TODO Auto-generated method stub
		sMapper.update_sConfig(spiderConfig);
	}

	public void del_sConfig(SpiderConfig spiderConfig) {
		// TODO Auto-generated method stub
		sMapper.del_sConfig(spiderConfig);
	}

	public void add_sConfig(SpiderConfig spiderConfig) {
		// TODO Auto-generated method stub
		sMapper.add_sConfig(spiderConfig);
	}
}
