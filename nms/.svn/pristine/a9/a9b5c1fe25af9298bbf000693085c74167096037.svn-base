package com.kuaidu.nms.bizandpush.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuaidu.nms.bizandpush.mapper.PushUrlMapper;
import com.kuaidu.nms.entity.PartnerPushUrl;

@Service
public class PushUrlServiceImpl {
	@Autowired
	PushUrlMapper pMapper;

	public List<PartnerPushUrl> getAllPushUrl(PartnerPushUrl pList) {
		return pMapper.getAllPushUrl(pList);
	}
	//查询count
	public int getCount(PartnerPushUrl pList) {
			return pMapper.getCount(pList);
	}
}
