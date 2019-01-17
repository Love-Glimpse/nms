package com.kuaidu.nms.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuaidu.nms.entity.GroupModule;
import com.kuaidu.nms.entity.Sys_group;
import com.kuaidu.nms.entity.Sys_module;
/*
 * 定义一个管理接口
 * */
public interface SystemGroupMapper {
     public List<Sys_group> getAll();
     
     //删除	del_user
     public void del_group(List<Object> list);
     //增	save_user
     public void save_group(Sys_group sGroup);
     //改	edit_user
     public void edit_group(Sys_group sGroup);
     //获得所有树getAllTree
     public List<Sys_module> getAllTree(@Param("group_id")Integer group_id);
    
     
     public void del_group_module(@Param("group_id")Integer group_id);
     //保存
	public void save_authority(List<GroupModule> gModules);
}
