package com.kuaidu.nms.partner.datastat.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaidu.nms.entity.PartnerPushUrl;
import com.kuaidu.nms.entity.UserOrder;
import com.kuaidu.nms.partner.datastat.mapper.PartnerUserOrderMapper;
/*
 * 接口实现类
 * */
@Service
@Transactional 
public class PartnerUserOrderMapperImpl {
	@Resource
	private PartnerUserOrderMapper pMapper;
	
	//查询书籍
	public List<UserOrder> getAllRecords(UserOrder userOrder) {
		return pMapper.getAllRecords(userOrder);
	}
	//获取书籍记录总行数
	public int getCount(UserOrder userOrder) {
		return pMapper.getCount(userOrder);
	}
	public List<PartnerPushUrl> getPushUrlsByPartnerId(int partner_id) {
		// TODO Auto-generated method stub
		return pMapper.getPushUrlsByPartnerId(partner_id);
	}

}
