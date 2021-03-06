package com.kuaidu.nms.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import com.kuaidu.nms.quartz.GetBookUpdateJob;
import com.kuaidu.nms.quartz.SendCustomMsgProcessor;

public class Log4jConfigListener implements ServletContextListener{
	public static final String CONFIG_LOCATION_PARAM = "log4jConfigLocation";
	public static final String XML_FILE_EXTENSION = ".xml";
	 private SendCustomMsgProcessor[] sendProcessors = null;
	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		String location = event.getServletContext().getInitParameter(
				CONFIG_LOCATION_PARAM);
		if (location != null) {

			if (!location.startsWith("/")) {

				location = "/" + location;
			}
			location = event.getServletContext().getRealPath(location);

			// 如果是xml结尾就用DOM解析，否则就用properties解析
			if (location.toLowerCase().endsWith(XML_FILE_EXTENSION)) {
				DOMConfigurator.configure(location);
			} else {
				PropertyConfigurator.configure(location);
			}
		}
		Log4jUtil.getBusinessLogger().info("log4j 初始化完成");
		sendProcessors = new SendCustomMsgProcessor[5];
        for(int i=0; i < 5; i++){
        	sendProcessors[i] = new SendCustomMsgProcessor();
        	sendProcessors[i].setStartFlag(true);
        	sendProcessors[i].start();
        }
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		Log4jUtil.getBusinessLogger().info("contextDestroyed");
		if (sendProcessors!=null) {
	        for(int i=0; i < 5; i++){
	        	sendProcessors[i].setStartFlag(false);
	        	sendProcessors[i].interrupt();
	        }
		}
		//更新书状态
		GetBookUpdateJob g = new GetBookUpdateJob();
		g.updateBookStatusWhenDestroyed();
		LogManager.shutdown();
	}

}
