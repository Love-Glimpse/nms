package com.kuaidu.nms.pay.mapper;

import java.util.List;

import com.kuaidu.nms.entity.UserOrder;

public interface UserOrderMapper {

	UserOrder getUserOrderByOrderId(Integer orderId);

	List<UserOrder> getUserOrderByMail(String mail);

}
