package com.kuaidu.nms.bizandpush.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuaidu.nms.bizandpush.mapper.WxExternalUrlMapper;
import com.kuaidu.nms.entity.WxJumpLog;

/** 
 * @Title CustomMsgNewsServiceImpl.java 
 * @description TODO 
 * @time 2018年11月2日 上午10:30:14 
 * @author victor 
 * @version 1.0 
**/
@Service
public class WxExternalUrlServiceImpl {
	@Autowired
	WxExternalUrlMapper wxMapper;
	public void saveWxJumpLog(WxJumpLog wxJumpLog) {
		// TODO Auto-generated method stub
		wxMapper.saveWxJumpLog(wxJumpLog);
	}
	public String getWxRedirectUrlByPushId(Integer pushId) {
		// TODO Auto-generated method stub
		return wxMapper.getWxRedirectUrlByPushId(pushId);
	}
	
}
