package com.kuaidu.nms.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuaidu.nms.entity.Sys_group;
import com.kuaidu.nms.entity.Sys_module;
import com.kuaidu.nms.entity.Sys_user;
/*
 * 定义一个用户管理接口
 * */
public interface UserMapper {
	 //查询	getAll()
     public List<Sys_user> getAll(@Param("user_name")String user_name);
     
     //删除	del_user
     public void del_user(List<Object> list);
     //增	save_user
     public void save_user(Sys_user sUser);
     //改	edit_user
     public void edit_user(Sys_user sUser);
     //获得所有树getAllTree
     public List<Sys_module> getAllTree(@Param("user_id")Integer user_id);
     //保存
     public void save_authority(@Param("user_id")Integer user_id , @Param("module_id")Integer module_id);
     
     public void del_user_module(@Param("user_id")Integer user_id);

	public List<Sys_group> getSysGroups();

	public void changeStatus(Sys_user user);

	public int checkSysUser(@Param("user_id")int id, @Param("md5_pwd")String s_pwd);

	public void changeSysPwd(@Param("user_id")int id,  @Param("md5_pwd")String n_pwd,  @Param("s_pwd")String s_pwd);

}
