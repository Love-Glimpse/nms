package com.kuaidu.nms.user.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.entity.PayChannel;
import com.kuaidu.nms.entity.UserOrder;
import com.kuaidu.nms.pay.mapper.PayChannelMapper;
import com.kuaidu.nms.pushchannel.mapper.PartnerInfoMapper;
import com.kuaidu.nms.user.mapper.RechargeRecordMapper;
/*
 * 接口实现类
 * */
@Service
@Transactional 
public class RechargeRecordMapperImpl {
	@Resource
	private RechargeRecordMapper rMapper;
	@Resource
	private PayChannelMapper pMapper;
	
	@Resource PartnerInfoMapper piMapper;
	public RechargeRecordMapper getrMapper() {
		return rMapper;
	}

	public void setrMapper(RechargeRecordMapper rMapper) {
		this.rMapper = rMapper;
	}
	//查询书籍
	public List<UserOrder> getAllRecords(UserOrder rList) {
		return rMapper.getAllRecords(rList);
	}
	//获取书籍记录总行数
	public int getCount(UserOrder rList) {
		return rMapper.getCount(rList);
	}

	public List<PayChannel> getAllPayChannel() {
		// TODO Auto-generated method stub
		return pMapper.getAllPayChannel(null);
	}
	/**
	 * 获取认证服务号的渠道
	 * */
	public List<PartnerInfo> getWxAuthPartners() {
		// TODO Auto-generated method stub
		return piMapper.getWxAuthPartner();
	}

}
