package com.kuaidu.nms.system.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaidu.nms.entity.Sys_group;
import com.kuaidu.nms.entity.Sys_module;
import com.kuaidu.nms.entity.Sys_user;
import com.kuaidu.nms.system.mapper.UserMapper;

@Service
@Transactional 
public class UserMapperImpl {
	@Resource
	private UserMapper uMapper;

	public UserMapper getuMapper() {
		return uMapper;
	}

	public void setuMapper(UserMapper uMapper) {
		this.uMapper = uMapper;
	}

	public List<Sys_user> getAll(String user_name) {
		return uMapper.getAll(user_name);
	}

	public void del_user(List<Object> list) {
		uMapper.del_user(list);
	}

	public void save_user(Sys_user sUser) {
		uMapper.save_user(sUser);
	}

	public void edit_user(Sys_user sUser) {
		uMapper.edit_user(sUser);
	}

	public List<Sys_module> getAllTree(Integer user_id) {
		return uMapper.getAllTree(user_id);
	}

	public void save_authority(Integer user_id, Integer module_id) {
		uMapper.save_authority(user_id, module_id);
	}

	public void del_user_module(Integer user_id) {
		uMapper.del_user_module(user_id);
	}

	public List<Sys_group> getSysGroups() {
		// TODO Auto-generated method stub
		return uMapper.getSysGroups();
	}

	public int changeStatus(Sys_user user) {
		// TODO Auto-generated method stub
		int ret = 1;
		try {
			uMapper.changeStatus(user);
			ret = 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ret;
	}

	public int checkSysUser(int id, String s_pwd) {
		// TODO Auto-generated method stub
		return uMapper.checkSysUser(id,s_pwd);
	}
	/**
	 * @return  0:sql异常
	 * 			20：执行成功
	 * */
	public int changeSysPwd(int id, String n_pwd, String s_pwd) {
		int ret = 0;
		try {
			uMapper.changeSysPwd(id,n_pwd,s_pwd);
			ret = 20;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ret;
	}


	
}
