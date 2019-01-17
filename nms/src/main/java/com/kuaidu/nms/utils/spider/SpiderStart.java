package com.kuaidu.nms.utils.spider;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.httpclient.HttpStatus;

import com.kuaidu.nms.utils.Utils;

import us.codecraft.webmagic.Spider;

public class SpiderStart {
	public static Set<Integer> AcceptStatCode = new HashSet<>();
	static{
		AcceptStatCode.add(HttpStatus.SC_OK);
		AcceptStatCode.add(HttpStatus.SC_CREATED);
		AcceptStatCode.add(HttpStatus.SC_ACCEPTED);
		AcceptStatCode.add(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
		AcceptStatCode.add(HttpStatus.SC_NO_CONTENT);
		AcceptStatCode.add(HttpStatus.SC_RESET_CONTENT);
		AcceptStatCode.add(HttpStatus.SC_PARTIAL_CONTENT);
		AcceptStatCode.add(HttpStatus.SC_MULTI_STATUS);
		
		AcceptStatCode.add(HttpStatus.SC_MULTIPLE_CHOICES);
		AcceptStatCode.add(HttpStatus.SC_MOVED_PERMANENTLY);
		AcceptStatCode.add(HttpStatus.SC_MOVED_TEMPORARILY);
		AcceptStatCode.add(HttpStatus.SC_SEE_OTHER);
		AcceptStatCode.add(HttpStatus.SC_NOT_MODIFIED);
		AcceptStatCode.add(HttpStatus.SC_USE_PROXY);
		AcceptStatCode.add(HttpStatus.SC_TEMPORARY_REDIRECT);
		
		AcceptStatCode.add(HttpStatus.SC_BAD_REQUEST);
		AcceptStatCode.add(HttpStatus.SC_UNAUTHORIZED);
		AcceptStatCode.add(HttpStatus.SC_PAYMENT_REQUIRED);
		AcceptStatCode.add(HttpStatus.SC_FORBIDDEN);
		AcceptStatCode.add(HttpStatus.SC_SEE_OTHER);
		AcceptStatCode.add(HttpStatus.SC_NOT_FOUND);
		AcceptStatCode.add(HttpStatus.SC_METHOD_NOT_ALLOWED);
		AcceptStatCode.add(HttpStatus.SC_NOT_ACCEPTABLE);
		AcceptStatCode.add(HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED);
		AcceptStatCode.add(HttpStatus.SC_REQUEST_TIMEOUT);
		AcceptStatCode.add(HttpStatus.SC_CONFLICT);
		AcceptStatCode.add(HttpStatus.SC_GONE);
		AcceptStatCode.add(HttpStatus.SC_LENGTH_REQUIRED);
		AcceptStatCode.add(HttpStatus.SC_PRECONDITION_FAILED);
		AcceptStatCode.add(HttpStatus.SC_REQUEST_URI_TOO_LONG);
		AcceptStatCode.add(HttpStatus.SC_REQUEST_URI_TOO_LONG);
		AcceptStatCode.add(HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE);
		AcceptStatCode.add(HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE);
		AcceptStatCode.add(HttpStatus.SC_EXPECTATION_FAILED);
		
		AcceptStatCode.add(HttpStatus.SC_INTERNAL_SERVER_ERROR);
		AcceptStatCode.add(HttpStatus.SC_NOT_IMPLEMENTED);
		AcceptStatCode.add(HttpStatus.SC_BAD_GATEWAY);
		AcceptStatCode.add(HttpStatus.SC_SERVICE_UNAVAILABLE);
		AcceptStatCode.add(HttpStatus.SC_GATEWAY_TIMEOUT);
		AcceptStatCode.add(HttpStatus.SC_HTTP_VERSION_NOT_SUPPORTED);
		AcceptStatCode.add(HttpStatus.SC_INSUFFICIENT_STORAGE);
	}

	/**
	 * 获取Spider 任务活动线程数
	 * 
	 * @param spider
	 * @param second
	 *            二次确认间隔秒数 返回0 说明任务已完成 等待接收新的taskUrl
	 */
	public static int getSpiderThreadAlived(Spider spider, int second) {
		int count = spider.getThreadAlive();
		if (count == 0) {
			Utils.threadSleep(second*1000);
			// 二次确认
			count = spider.getThreadAlive();
		}
		return count;
	}
}
