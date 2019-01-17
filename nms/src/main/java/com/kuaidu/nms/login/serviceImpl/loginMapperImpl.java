package com.kuaidu.nms.login.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.entity.Sys_user;
import com.kuaidu.nms.login.mapper.loginMapper;

@Service
@Transactional 
public class loginMapperImpl {

	@Resource
	private loginMapper lMapper;

	public loginMapper getlMapper() {
		return lMapper;
	}

	public void setlMapper(loginMapper lMapper) {
		this.lMapper = lMapper;
	}
	
	public Sys_user login(Sys_user user) {
		return lMapper.login(user);
	}

	public PartnerInfo partnerLogin(PartnerInfo partnerInfo) {
		// TODO Auto-generated method stub
		return lMapper.partnerLogin(partnerInfo);
	}

	public void updatePaLastLoginTime(PartnerInfo partnerInfo) {
		// TODO Auto-generated method stub
		lMapper.updatePaLastLoginTime(partnerInfo);
	}

	public void updateUserStatus(Sys_user user) {
		// TODO Auto-generated method stub
		lMapper.updateUserStatus(user);
	}


	
}
