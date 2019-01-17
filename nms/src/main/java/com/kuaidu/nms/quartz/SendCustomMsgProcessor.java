package com.kuaidu.nms.quartz;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Component;

import com.kuaidu.nms.entity.MessageLog;
import com.kuaidu.nms.entity.WxCustomMsg;
import com.kuaidu.nms.message.serviceImpl.CustomMsgImpl;
import com.kuaidu.nms.partner.config.serviceImpl.PartnerwxCfgMapperImpl;
import com.kuaidu.nms.user.mapper.UserManagementMapper;
import com.kuaidu.nms.utils.Log4jUtil;
import com.kuaidu.nms.utils.MyWxUtils;
import com.kuaidu.nms.utils.QueueManager;
import com.kuaidu.nms.utils.SpringApplicationContextHolder;
import com.kuaidu.nms.utils.Utils;

import net.sf.json.JSONObject;

/** 
 * @Title SendCustomMsgProcessor.java 
 * @description TODO 
 * @time 2018年10月30日 下午4:39:22 
 * @author victor 
 * @version 1.0 
**/
@Component
public class SendCustomMsgProcessor extends Thread{

	private boolean startFlag = false;

	@Override
	public void run() {
		String ip = Utils.getLocalHostIp();
		Log4jUtil.getBusinessLogger().info(ip+" send msg=="+System.currentTimeMillis());
		if (ip.equals("69.171.67.171")) {
			while (startFlag) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO: handle exception
					startFlag = false;
				}
				WxCustomMsg customMsg = getWxCustomMsg();
				if (customMsg == null) {
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO: handle exception
						startFlag = false;
					}
				} else {
					String ret = MyWxUtils.sendCustomMsg(customMsg);
					/*{ "errcode": 0, "errmsg": "ok" }*/
					JSONObject jsonRet;
					try {
						jsonRet = JSONObject.fromObject(ret);
						Log4jUtil.getBusinessLogger().info(jsonRet);
						int status = jsonRet.optInt("errcode", 103);
						if (status == 40001||status == 41001) {//access_token 错误 重新发送
							customMsg.setSend_status(0);
							continue;
						}else if (status == 48004) {//接口被屏蔽,将所有该partner的消息处理掉
							PartnerwxCfgMapperImpl pImpl = (PartnerwxCfgMapperImpl) SpringApplicationContextHolder.getBean("partnerwxCfgMapperImpl");
							if (pImpl==null) {
								continue;
							}
							pImpl.updatePartnerWxStatus(customMsg.getPartner_id(),-1);
						}else if (status == 0) {//发送成功
							status = 2;
							UserManagementMapper uMapper = (UserManagementMapper) SpringApplicationContextHolder.getBean("userManagementMapper");
							if (uMapper==null) {
								continue;
							}
							try {
								MessageLog messageLog = new MessageLog();
								messageLog.setContent(customMsg.getTitle()+customMsg.getDescription());
								messageLog.setFlag(2);//发送消息
								messageLog.setMsg_type(customMsg.getMsg_type());
								messageLog.setPic_url(customMsg.getPic_url());
								messageLog.setUser_id(customMsg.getUser_id());
								messageLog.setCreate_time(Utils.getNowDate());
								
								QueueManager.getInstance().addMessageLog(messageLog);
								//uMapper.saveMessageLog(messageLog);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								Log4jUtil.getSimpleErrorLogger().error("save message log error", e);
							}
						}
						customMsg.setSend_status(status);
						CustomMsgImpl cImpl = (CustomMsgImpl) SpringApplicationContextHolder.getApplicationContext().getBean("customMsgImpl");
						if (cImpl==null) {
							continue;
						}
						if (customMsg.getIs_last()==1) {
							cImpl.updatePartnerCustomMsgStatusByMsgId(customMsg.getP_msg_id(),2);
						}
						cImpl.updateMsgStatus(customMsg);
						cImpl.updateSendMsgCount(customMsg);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} 
		}
	}
	private static synchronized  WxCustomMsg getWxCustomMsg() {
		ConcurrentLinkedQueue<WxCustomMsg> wxCustomMsgs = QueueManager.getInstance().getWxCustomMsgs();
		int size = wxCustomMsgs.size();
		Log4jUtil.getBusinessLogger().info("wx_custom_msg queue size===" + size);
		if (size <= 0) {
			return null;
		}
		WxCustomMsg customMsg = wxCustomMsgs.poll();
		if (customMsg!=null) {
			return customMsg;
		}else {
			return null;
		}
	}
	public boolean isStartFlag() {
		return startFlag;
	}
	public void setStartFlag(boolean startFlag) {
		this.startFlag = startFlag;
	}

}
