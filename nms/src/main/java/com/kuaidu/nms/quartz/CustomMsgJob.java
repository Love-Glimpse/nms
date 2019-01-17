package com.kuaidu.nms.quartz;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.quartz.DisallowConcurrentExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kuaidu.nms.entity.MessageLog;
import com.kuaidu.nms.entity.WxCustomMsg;
import com.kuaidu.nms.message.serviceImpl.CustomMsgImpl;
import com.kuaidu.nms.user.mapper.UserManagementMapper;
import com.kuaidu.nms.utils.Log4jUtil;
import com.kuaidu.nms.utils.QueueManager;
import com.kuaidu.nms.utils.SpringApplicationContextHolder;
import com.kuaidu.nms.utils.Utils;


/**
 * 客服消息处理
 * */
@Component
@DisallowConcurrentExecution
public class CustomMsgJob {
	@Autowired
	CustomMsgImpl cImpl ;
	 
	
	/**
	 * 每5分钟执行一次
	 * 1、关注后半小时首单福利（默认开启,停止了）
	 * 2、关注用户图文推送（关注6小时后）（默认开启--不需要了)
	 * 3、签到用户（默认关闭）（签到12小时后）
	 * 4、订单待支付提醒（默认关闭）（半小时后）
	 * 5、继续阅读提醒 （8小时未阅读） 
	 * 以上不需要去查询活跃用户
	 * */
	@Scheduled(cron="0 0/5 * * * ?")
	public void createCustomMsg() {
		String ip = Utils.getLocalHostIp();
		if (ip.equals("69.171.67.171")) {
			cImpl.createCustomMsg();
		}
	}
	/**
	 * 6、 智能托管
	 * 每天下午18:00发送
	 * */
/*	@Scheduled(cron="0 0 18 * * ?")
	public void createAutoSendCustomMsg() {
		String ip = Utils.getLocalHostIp();
		if (ip.equals("69.171.67.171")) {
			cImpl.createDailyCustomMsg();
		}
	}*/
	/**
	 * 载入客服消息
	 * 每10秒执行一次
	 * */
	@Scheduled(cron="0/10 * * * * ?")
	public void loadCustomMsg() {
		String ip = Utils.getLocalHostIp();
		if (ip.equals("69.171.67.171")) {
			List<WxCustomMsg> wxCustomMsgs = cImpl.loadCustomMsg();
			if (wxCustomMsgs.size()>0) {
				QueueManager.getInstance().addWxCustomMsg(wxCustomMsgs);
				cImpl.updateCustomMsg(wxCustomMsgs);
			}
		}
	}
	/**
	 * 生成手动群发的客服消息
	 * 每10秒执行一次
	 * */
	@Scheduled(cron="0/10 * * * * ?")
	public void createGroupCustomMsg() {
		String ip = Utils.getLocalHostIp();
		if (ip.equals("69.171.67.171")) {
			cImpl.createGroupCustomMsg();
		}
	}
	/**
	 * 验证公众号接口
	 * 每2小说验证一次
	 * */
	@Scheduled(cron="0 0 */2 * * ?")
	public void validatePartnerApi() {
		String ip = Utils.getLocalHostIp();
		if (ip.equals("69.171.67.171")) {
			Log4jUtil.getBusinessLogger().info("validatePartnerApi begin!");
			cImpl.validatePartnerApi();
		}
	}
	
	@Scheduled(cron="0/5 * * * * ?")
	public void saveMessageLog() {
		String ip = Utils.getLocalHostIp();
		if (ip.equals("69.171.67.171")) {
			ConcurrentLinkedQueue<MessageLog> concurrentLinkedQueueMessageLogs = QueueManager.getInstance().getMessageLogs();
			int size = concurrentLinkedQueueMessageLogs.size()>300?300:concurrentLinkedQueueMessageLogs.size();
			if (size>0) {
				List<MessageLog> messageLogs = new ArrayList<MessageLog>();
				for (int i = 0; i < size; i++) {
					MessageLog messageLog = concurrentLinkedQueueMessageLogs.poll();
					
					if (messageLog!=null&&messageLog.getUser_id()!=null) {
						messageLogs.add(messageLog);
					}else{
						Log4jUtil.getSimpleErrorLogger().error("message user_id null!");
						continue;
					}
				}
				if (messageLogs.size()>0) {
					UserManagementMapper uMapper = (UserManagementMapper) SpringApplicationContextHolder.getBean("userManagementMapper");
					try {
						uMapper.saveMessageLogs(messageLogs);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						Log4jUtil.getSimpleErrorLogger().error("save messages error", e);
					}
				}
			}
		}
	}
	
}
