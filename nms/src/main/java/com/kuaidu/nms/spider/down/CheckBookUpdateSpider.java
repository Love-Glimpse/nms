package com.kuaidu.nms.spider.down;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kuaidu.nms.config.Config;
import com.kuaidu.nms.spider.controller.serviceImpl.WebSpiderImpl;
import com.kuaidu.nms.utils.Log4jUtil;
import com.kuaidu.nms.utils.Utils;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

@Component
public class CheckBookUpdateSpider implements PageProcessor {

	public static WebSpiderImpl wImpl;
	
	public WebSpiderImpl getwImpl() {
		return wImpl;
	}
	@Autowired
	public void setwImpl(WebSpiderImpl wImpl) {
		CheckBookUpdateSpider.wImpl = wImpl;
	}
	private Site site = Site.me().setRetryTimes(0).setTimeOut(3000).setSleepTime(2)
			.setUserAgent(Config.USER_AGENT);
	private volatile static Spider spider;
	private static HashMap<Integer, Integer> chapterCounts = new HashMap<Integer, Integer>();
	private static Set<String>  set = new HashSet<String>();
	public static Spider getSpider() {
		 synchronized (CheckBookUpdateSpider.class) {  
			 if (spider == null) {  
				 spider = new Spider(new CheckBookUpdateSpider());  
			 }   
		}  
		return spider;
	}
	@Override
	public void process(Page page) {
		String reg = Utils.getParamsFromUrl(page.getUrl().toString(), "reg");
		String book_id = Utils.getParamsFromUrl(page.getUrl().toString(), "book_id");
		System.out.println(page.getUrl());
		//获取章节名称
		List<String> chapterNames = page.getHtml().xpath("//div[@class='book_list']/dl/dd/a/text()").all();
		//List<String> nextPageUrls = page.getHtml().xpath(reg).links().all();
		System.out.println(chapterNames);
		System.out.println(chapterNames.size());
		for (int i = 0; i < chapterNames.size(); i++) {
			if (!set.add(chapterNames.get(i).trim())) {// 用set去重
				continue;
			}else {
				addBookChapterCount(Integer.parseInt(book_id));
			}
		}
			
/*		if (nextPageUrls!=null&&nextPageUrls.size()>0) {
			page.addTargetRequests(nextPageUrls);
		}*/
	}

	private static void addBookChapterCount(Integer book_id) {
		// TODO Auto-generated method stub
		try {
			Integer count = 0;
			if (chapterCounts.containsKey(book_id)) {
				count = chapterCounts.get(book_id);
			}else {
				count = 0;
			}
			chapterCounts.put(book_id, count+1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Site getSite() {
		return site;
	}
	/**
	 * @param urls带参数（正则表达式规则）
	 * @return 
	 * */
	public HashMap<Integer, Integer> BeginSpider(String... urls) throws InterruptedException {
		spider = getSpider();
		System.out.println(spider.getStatus());
		if(spider.getStatus().equals(Spider.Status.Stopped)) {
			if (spider!=null) {
				spider.stop();
				spider=null;
			}
			Thread.sleep(500);
			spider = getSpider();
		}else if (spider.getStatus().equals(Spider.Status.Running)) {
			Log4jUtil.getBusinessLogger().info("spider正忙，请稍后再试");
			return null;
		}
		spider.addUrl(urls);
		spider.setExitWhenComplete(true).thread(3);
		spider.setEmptySleepTime(5000);
		// 启动爬虫
		spider.run();
		return chapterCounts;
	}
}
