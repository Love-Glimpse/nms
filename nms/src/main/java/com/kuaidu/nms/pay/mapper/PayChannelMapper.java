package com.kuaidu.nms.pay.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuaidu.nms.entity.PayChannel;

public interface PayChannelMapper {

	int getCount(PayChannel payChannel);

	List<PayChannel> getAllPayChannel(PayChannel payChannel);

	Integer updateEveryDayStatus(@Param("channelId")Integer channelId,@Param("status")Integer status,@Param("everydayStatus") Integer everydayStatus);

}
