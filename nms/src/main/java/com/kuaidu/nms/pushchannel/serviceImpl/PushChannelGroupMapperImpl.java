package com.kuaidu.nms.pushchannel.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kuaidu.nms.entity.GroupModule;
import com.kuaidu.nms.entity.PartnerGroup;
import com.kuaidu.nms.entity.Sys_module;
import com.kuaidu.nms.pushchannel.mapper.PushChannelGroupMapper;

@Service
public class PushChannelGroupMapperImpl {
	@Resource
	PushChannelGroupMapper pcgMapper;

	public List<PartnerGroup> getAllChannelGroup(PartnerGroup partnerGroup) {
		// TODO Auto-generated method stub
		return pcgMapper.getAllChannelGroup(partnerGroup);
	}

	public void updateChannelGroup(PartnerGroup partnerGroup) {
		// TODO Auto-generated method stub
		pcgMapper.updateChannelGroup(partnerGroup);
	}

	public void addChannelGroup(PartnerGroup partnerGroup) {
		// TODO Auto-generated method stub
		pcgMapper.addChannelGroup(partnerGroup);
	}

	public void delChannelGroup(PartnerGroup partnerGroup) {
		// TODO Auto-generated method stub
		pcgMapper.delChannelGroup(partnerGroup);
	}

	public List<Sys_module> getAllTree(Integer group_id) {
		// TODO Auto-generated method stub
		return pcgMapper.getAllTree(group_id);
	}

	public void del_group_module(Integer group_id) {
		// TODO Auto-generated method stub
		pcgMapper.del_group_module(group_id);
	}

	public void save_authority(List<GroupModule> gModules) {
		// TODO Auto-generated method stub
		pcgMapper.save_authority(gModules);
	}

}
