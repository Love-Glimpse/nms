package com.kuaidu.nms.pushchannel.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaidu.nms.entity.Sys_module;
import com.kuaidu.nms.pushchannel.mapper.PartnerModuleMapper;

@Service
@Transactional 
public class PartnerModuleMapperImpl {
	@Resource
	private PartnerModuleMapper mapper;

	public PartnerModuleMapper getMapper() {
		return mapper;
	}

	public void setMapper(PartnerModuleMapper mapper) {
		this.mapper = mapper;
	}

	public List<Sys_module> getAll_module() {
		return mapper.getAll_module();
	}

	public void save(Sys_module sModule) {
		mapper.save(sModule);
	}

	public void del_module(Integer module_id) {
		mapper.del_module(module_id);
	}

	public void update_module(Sys_module sModule) {
		mapper.update_module(sModule);
	}

	public void delson_module(Integer parent_id) {
		mapper.delson_module(parent_id);
	}
	
	
}
