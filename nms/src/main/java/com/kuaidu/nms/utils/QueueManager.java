package com.kuaidu.nms.utils;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.kuaidu.nms.entity.ChapterList;
import com.kuaidu.nms.entity.MessageLog;
import com.kuaidu.nms.entity.WxCustomMsg;

public class QueueManager {
	/**
	 * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例 没有绑定关系，而且只有被调用到才会装载，从而实现了延迟加载
	 */
	private static class SingletonHolder {
		/**
		 * 静态初始化器，由JVM来保证线程安全
		 */
		private static QueueManager instance = new QueueManager(); 
		private static ConcurrentLinkedQueue<ChapterList> chapterLists = new ConcurrentLinkedQueue<ChapterList>();
		private static ConcurrentLinkedQueue<WxCustomMsg> customMsgs = new ConcurrentLinkedQueue<WxCustomMsg>();
		private static ConcurrentLinkedQueue<MessageLog> messageLogs = new ConcurrentLinkedQueue<MessageLog>();

}

	/**
	 * 私有化构造方法
	 */
	private QueueManager() {
	}
	
	public static QueueManager getInstance() {
		return SingletonHolder.instance;
	}
	public ConcurrentLinkedQueue<ChapterList> getChapterLists() {
		return SingletonHolder.chapterLists;
	}
	public boolean addChapterLists(List<ChapterList> chapterLists) {
		return SingletonHolder.chapterLists.addAll(chapterLists);
	}
	
	public ConcurrentLinkedQueue<WxCustomMsg> getWxCustomMsgs() {
		return SingletonHolder.customMsgs;
	}
	public boolean addWxCustomMsg(List<WxCustomMsg> wxCustomMsgs) {
		return SingletonHolder.customMsgs.addAll(wxCustomMsgs);
	}
	public ConcurrentLinkedQueue<MessageLog> getMessageLogs() {
		return SingletonHolder.messageLogs;
	}
	public boolean addMessageLog(MessageLog messageLog) {
		return SingletonHolder.messageLogs.add(messageLog);
	}
}
