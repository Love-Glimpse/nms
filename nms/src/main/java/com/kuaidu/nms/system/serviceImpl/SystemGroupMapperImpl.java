package com.kuaidu.nms.system.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaidu.nms.entity.GroupModule;
import com.kuaidu.nms.entity.Sys_group;
import com.kuaidu.nms.entity.Sys_module;
import com.kuaidu.nms.system.mapper.SystemGroupMapper;

@Service
@Transactional 
public class SystemGroupMapperImpl {
	@Resource
	private SystemGroupMapper sMapper;


	public SystemGroupMapperImpl(SystemGroupMapper sMapper) {
		super();
		this.sMapper = sMapper;
	}

	public List<Sys_group> getAll() {
		return sMapper.getAll();
	}

	public void del_group(List<Object> list) {
		sMapper.del_group(list);
	}

	public void save_group(Sys_group sGroup) {
		sMapper.save_group(sGroup);
	}

	public void edit_group(Sys_group sGroup) {
		sMapper.edit_group(sGroup);
	}

	public List<Sys_module> getAllTree(Integer group_id) {
		return sMapper.getAllTree(group_id);
	}

	public void save_authority(List<GroupModule> gModules) {
		sMapper.save_authority(gModules);
	}

	public void del_group_module(Integer group_id) {
		sMapper.del_group_module(group_id);
	}
	
}
