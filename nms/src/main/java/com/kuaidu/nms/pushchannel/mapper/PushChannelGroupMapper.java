package com.kuaidu.nms.pushchannel.mapper;

import java.util.List;

import com.kuaidu.nms.entity.GroupModule;
import com.kuaidu.nms.entity.PartnerGroup;
import com.kuaidu.nms.entity.Sys_module;

public interface PushChannelGroupMapper {

	List<PartnerGroup> getAllChannelGroup(PartnerGroup partnerGroup);

	void updateChannelGroup(PartnerGroup partnerGroup);

	void addChannelGroup(PartnerGroup partnerGroup);

	void delChannelGroup(PartnerGroup partnerGroup);

	List<Sys_module> getAllTree(Integer group_id);

	void del_group_module(Integer group_id);

	void save_authority(List<GroupModule> gModules);

}
