package com.kuaidu.nms.pushchannel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuaidu.nms.entity.Sys_module;

public interface PartnerModuleMapper {
      public List<Sys_module> getAll_module();
      public void save(Sys_module sModule);
      public void del_module(@Param("module_id")Integer module_id);
      public void delson_module(@Param("parent_id")Integer parent_id); 
      public void update_module(Sys_module sModule);
}
