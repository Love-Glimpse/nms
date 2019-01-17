package com.kuaidu.nms.pay.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuaidu.nms.entity.UserOrder;
import com.kuaidu.nms.pay.mapper.UserOrderMapper;

@Service
public class UserOrderServiceImpl {
	@Autowired
	UserOrderMapper userOrderMapper;

	public List<UserOrder> getUserOrder(Integer orderId, String mail) {
		if(orderId != null) {
			UserOrder user_order =  userOrderMapper.getUserOrderByOrderId(orderId);
			List<UserOrder> list = new ArrayList<>();
			list.add(user_order);
			return list;
		}
		if (mail != null) {
			return userOrderMapper.getUserOrderByMail(mail);
		}
		return new ArrayList<UserOrder>();
	}

}
