package com.kuaidu.nms.homepage.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaidu.nms.entity.Sys_module;
import com.kuaidu.nms.homepage.mapper.HomepageMapper;

@Service
@Transactional 
public class HomepageMapperImpl {
	@Resource
	private HomepageMapper hMapper;

	public HomepageMapper gethMapper() {
		return hMapper;
	}

	public void sethMapper(HomepageMapper hMapper) {
		this.hMapper = hMapper;
	}

	public List<Sys_module> getAll(Integer group_id) {
		return hMapper.getAll(group_id);
	}

	public List<Sys_module> getPartnerMenu(int group_id) {
		// TODO Auto-generated method stub
		return hMapper.getPartnerMenu(group_id);
	}
	
}
