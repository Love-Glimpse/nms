package com.kuaidu.nms.spider.down;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kuaidu.nms.query.serviceImpl.BooksQueryMapperImpl;
import com.kuaidu.nms.spider.controller.serviceImpl.WebSpiderImpl;
import com.kuaidu.nms.utils.Utils;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

@Component
public class INovelGetBookIdSpider implements PageProcessor {
	
	public static WebSpiderImpl wImpl;
	
	public WebSpiderImpl getwImpl() {
		return wImpl;
	}
	@Autowired
	public void setwImpl(WebSpiderImpl wImpl) {
		INovelGetBookIdSpider.wImpl = wImpl;
	}
	
	public static BooksQueryMapperImpl bImpl;
	
	public BooksQueryMapperImpl getbImpl() {
		return bImpl;
	}
	@Autowired
	public void setbImpl(BooksQueryMapperImpl bImpl) {
		INovelGetBookIdSpider.bImpl = bImpl;
	}
	public INovelGetBookIdSpider(String ua,String cookie) {
		super();
	}

	public INovelGetBookIdSpider() {
		// TODO Auto-generated constructor stub
	}

	private  static Map<String, String> cookieMap = new HashMap<String, String>();
	private Site site ;

	private volatile static Spider spider;

	public static Spider getSpider() {
		 synchronized (INovelGetBookIdSpider.class) {  
			 if (spider == null) {  
				 spider = new Spider(new INovelGetBookIdSpider());  
			 }   
		}  
		return spider;
	}
/*	private Site putSite() {
		// TODO Auto-generated method stub
	}*/
	@Override
	public void process(Page page) {
		String sType = Utils.getParamsFromUrl(page.getUrl().toString(), "stype");
		if (sType!=null) {
			List<String> bookNames = page.getHtml().xpath("//div[@class='col-xs-12']/table/tbody/tr/td/a/text()").all();
			List<String> bookUrls = page.getHtml().xpath("//div[@class='col-xs-12']/table/tbody/tr/td/a").links().all();

			List<String> bookNameList = new ArrayList<String>();
			List<String> bookUrlList = new ArrayList<String>();

			for (int i = 0; i < bookNames.size(); i++) {
				if (i%2==0) {
					bookNameList.add(bookNames.get(i));
					bookUrlList.add(bookUrls.get(i));
				}
			}
			List<String> nextPageUrl =  page.getHtml()
					.xpath("//div[@class='col-xs-12']/div/ul/li[@class='next page']/a").links().all();
			
			for (int i = 0; i < bookUrlList.size(); i++) {
				String bookUrl = bookUrlList.get(i);
				String zBookID = bookUrl.substring(bookUrl.lastIndexOf("/")+1);
				Integer book_id = bImpl.getbookIdByBookname(bookNameList.get(i));
				wImpl.savezBookId(zBookID,book_id);
			}
			//下一页
			if (nextPageUrl.size()>=1) {
				page.addTargetRequest(nextPageUrl.get(0));
			}
		}
	}

	@Override
	public Site getSite() {
		// TODO Auto-generated method stub
		cookieMap = Utils.getCookies();
		site = Site.me().setRetryTimes(0).setTimeOut(10000).setSleepTime(2)
				.addCookie("_uab_collina", "153110622447253170998979").addCookie("last_read_notice_id_12561", "147")
				.addCookie("aliyungf_tc", cookieMap.get("aliyungf_tc"))
				.addCookie(" user_token", cookieMap.get(" user_token"))
				.addHeader("User-Agent",
						"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36")
				.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
				.addHeader("Accept-Encoding", "gzip, deflate, sdch").addHeader("Accept-Language", "zh-CN,zh;q=0.8")
				.addHeader("Connection", "keep-alive").addHeader("Host", "inovel.818tu.com");
		return site;
	}
	public void BeginSpider(String urls) {
		spider = getSpider();
		if(spider.getStatus().equals(Spider.Status.Stopped)) {
/*			if (spider!=null) {
				spider.stop();
				spider=null;
			}
			Utils.threadSleep(1000);
			spider = getSpider();*/
		}else if (spider.getStatus().equals(Spider.Status.Running)) {
		}
		spider.addUrl(urls);
		spider.thread(1);
		spider.setEmptySleepTime(1000);
		spider.run();

	}
	public int getNumfromString(String str) {
		str = str.substring(str.indexOf("共"), str.indexOf("章"));
		String regEx="[^0-9]";   
		Pattern p = Pattern.compile(regEx);   
		Matcher m = p.matcher(str);   
		String retNum = m.replaceAll("").trim();
		if (retNum.length()>0) {
			return Integer.parseInt(retNum);
		}else {
			return 0;
		}
	}
}
