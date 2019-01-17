package com.kuaidu.nms.pay.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuaidu.nms.entity.PayChannel;
import com.kuaidu.nms.entity.RestReturn;
import com.kuaidu.nms.pay.mapper.PayChannelMapper;
import com.kuaidu.nms.utils.ResultData;

@Service
public class PayChannelServiceImpl {

	@Autowired
	PayChannelMapper payChannelMapper;

	public String getAllPayChannel(PayChannel payChannel) {
		int count = payChannelMapper.getCount(payChannel);
		List<PayChannel> list = payChannelMapper.getAllPayChannel(payChannel);
		return ResultData.toJsonString(count, list);

	}

	public RestReturn updateEveryDayStatus(Integer channelId, Integer status, Integer everydayStatus) {
		if (status  != null) {
			if (status == 0) {
				status = 1;
			}else {
				status = 0;
			}
		}
		if (everydayStatus != null) {
			if (everydayStatus == 0) {
				everydayStatus = 1;
			}else {
				everydayStatus = 0;
			}
		}
		
		Integer num = payChannelMapper.updateEveryDayStatus(channelId,status,everydayStatus);
		if (num > 0) {
			return RestReturn.success();
		}
		return RestReturn.fail();
	}

}
