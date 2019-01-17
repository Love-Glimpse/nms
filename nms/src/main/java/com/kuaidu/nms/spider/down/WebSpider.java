package com.kuaidu.nms.spider.down;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.kuaidu.nms.config.Config;
import com.kuaidu.nms.entity.ChapterList;
import com.kuaidu.nms.entity.ReplaceConfig;
import com.kuaidu.nms.entity.SpiderConfig;
import com.kuaidu.nms.spider.controller.serviceImpl.WebSpiderImpl;
import com.kuaidu.nms.utils.Log4jUtil;
import com.kuaidu.nms.utils.Utils;
import com.kuaidu.nms.utils.spider.SpiderStart;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.Spider.Status;
import us.codecraft.webmagic.processor.PageProcessor;

@Component
public class WebSpider implements PageProcessor {

	public static WebSpiderImpl wImpl;
	
	public WebSpiderImpl getwImpl() {
		return wImpl;
	}
	@Autowired
	public void setwImpl(WebSpiderImpl wImpl) {
		this.wImpl = wImpl;
	}
	private Site site =Site.me().setRetryTimes(1).setTimeOut(10000).setSleepTime(2)
			.setAcceptStatCode(SpiderStart.AcceptStatCode)
			//.addCookie("Hm_lpvt_5eb81c3b57ea700d51556a83f9cebcfe", System.currentTimeMillis()+"")
			//.addCookie("Hm_lvt_5eb81c3b57ea700d51556a83f9cebcfe", "1531206622")
			//添加请求头，有些网站会根据请求头判断该请求是由浏览器发起还是由爬虫发起的
			.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36")
			.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
			//.addHeader("Accept-Encoding", "gzip, deflate, br")
			.addHeader("Accept-Language", "zh-CN,zh;q=0.8")
			.addHeader("Connection", "keep-alive").addHeader("Upgrade-Insecure-Requests", "1");
			
	private static SpiderConfig spiderConfig;
	private static List<ReplaceConfig> replaces;
	private volatile static Spider spider;
	public static Spider getSpider() {
		 synchronized (WebSpider.class) {  
			 if (spider == null) {  
				 System.out.println("new");
				 spider = new Spider(new WebSpider());  
			 }   
		}  
		return spider;
	}
	private static JSONObject ret = null;
	@Override
	public void process(Page page) {
		int statusCode = page.getStatusCode();
		ret.put("statusCode", statusCode);
		if (String.valueOf(statusCode).startsWith("2")||String.valueOf(statusCode).startsWith("3")) {
			Map<String, Object> extras = page.getRequest().getExtras();
			String type = (String) extras.get("type");
			ret.put("status", "22");//网页获取成功，但没有章节信息
			if (type.equalsIgnoreCase("1")) {//解析章节信息
				Integer book_id =Integer.parseInt(extras.get("book_id")+"");
				String pageUrl = page.getUrl().toString();
				
				Set<String> set = new HashSet<String>();
				int d_chapter_count = wImpl.getDownChapterCount(book_id);
				ret.put("downloaded_chapter_count", d_chapter_count);
				//获取章节名称
				List<String> chapterNames = page.getHtml().xpath(spiderConfig.getChapter_reg()).all();
				//获取章节连接
				List<String> chapterUrls = page.getHtml().xpath(spiderConfig.getChapter_url_reg()).links().all();
				Log4jUtil.getBusinessLogger().info(chapterNames);
				Log4jUtil.getBusinessLogger().info(chapterUrls);
				List<ChapterList> chapterLists = new ArrayList<ChapterList>();
				List<ChapterList> cLists = wImpl.getAllChapterList(book_id,1);
				Map<String, Integer> map = new HashMap<String, Integer>();
				if (chapterNames.size() > 0) {
					ret.put("status", "23");//网页获取成功，有章节信息
					for (ChapterList cList : cLists) {//数据库已有的章节信息
						map.put(cList.getChapter_name_old().trim().replaceAll(Config.CHAPTER_FILTER_REGEX, ""), cList.getContent_upload_flag());
					}
				}
				boolean find = false ;
				String subUrl = "";
				if (pageUrl.contains("rzlib.net")) {
					String rzbookId;
					String rzChapterId;
					try {
						rzbookId = pageUrl.split("/")[4];
						rzChapterId = pageUrl.split("/")[5];
					} catch (Exception e) {
						// TODO Auto-generated catch block
						return ;
						
					}
					String js = Utils.getHtmlcodeWithoutHeader("https://www.rzlib.net/public/read.js", "gbk");
					if (js==null) {
						Log4jUtil.getSimpleErrorLogger().error("https://www.rzlib.net/public/read.js down error!!");
						ret.put("status", "22");//网页获取成功，但没有章节信息
						return;
					}
					String regex = "var url_get_data=.*";
					Pattern pattern = Pattern.compile(regex);
					Matcher matcher = pattern.matcher(js);


					while (matcher.find()) {
						subUrl = matcher.group().replace("'+article_id +'/'+chapter_id +'.html';", "").replace("var url_get_data='", "")
								.replace("article_id ", rzbookId).replace("chapter_id", rzChapterId);
						find = true;
						break;
					}
					if (!find) {
						Log4jUtil.getSimpleErrorLogger().error("https://www.rzlib.net chapter url not found !!");
						ret.put("status", "22");//网页获取成功，但没有章节信息
						return;
					}
				}
				int size = chapterNames.size();
				if (spiderConfig.getOrderby() == 0) {
					for (int i = spiderConfig.getBefore_count(); i < size - spiderConfig.getAfter_count(); i++) {
						if (!set.add(chapterNames.get(i).trim())) {// 用set去重
							continue;
						}
						if (!map.containsKey(chapterNames.get(i).trim().replaceAll(Config.CHAPTER_FILTER_REGEX, ""))) {
							ChapterList chapterList = new ChapterList();
							chapterList.setChapter_name(chapterNames.get(i).trim());
							chapterList.setChapter_num(i + 1);
							String chapter_url = chapterUrls.get(i);
							if (chapterUrls.get(i).contains("kayege")) {//kayege https报错
								chapter_url = chapter_url.replace("https", "http");
							} 
							if (chapterUrls.get(i).contains("rzlib.net")) {
								if (find) {
									chapter_url = chapter_url.replaceAll("/b/\\d+/", subUrl);
								} else {
									Log4jUtil.getSimpleErrorLogger()
											.error("https://www.rzlib.net chapter url not found !!");
									return;
								} 
							}
							chapterList.setChapter_url(chapter_url);
							chapterLists.add(chapterList);
							if (chapterLists.size() >= 200) {
								break;
							}
						}
					}
				} else if (spiderConfig.getOrderby() == 1) {
					for (int i = size - spiderConfig.getAfter_count() - 1; i >= spiderConfig.getBefore_count(); i--) {
						if (!set.add(chapterNames.get(i).trim())) {// 用set去重
							continue;
						}
						if (!map.containsKey(chapterNames.get(i).trim().replaceAll(Config.CHAPTER_FILTER_REGEX, ""))) {
							ChapterList chapterList = new ChapterList();
							chapterList.setChapter_name(chapterNames.get(i).trim());
							chapterList.setChapter_num(i + 1);
							String chapter_url = chapterUrls.get(i);
							if (chapterUrls.get(i).contains("kayege")) {
								chapter_url = chapter_url.replace("https", "http");
							}
							chapterList.setChapter_url(chapter_url);
							chapterLists.add(chapterList);
							if (chapterLists.size() >= 200) {
								break;
							}
						}
					}

				}
				for (int i = 0; i < chapterLists.size(); i++) {
					chapterLists.get(i).setChapter_num(d_chapter_count + i + 1);
				}
				ret.put("total", chapterLists.size());
				ret.put("rows", chapterLists);
			} else {//解析内容
				
				String url = page.getUrl().toString();
				
				Integer book_id =Integer.parseInt(extras.get("book_id")+"");
				String chapter_name = (String) extras.get("chapter_name");
				String pre_url = url.substring(0,url.lastIndexOf('/')+1);
				StringBuilder chapterContent = new StringBuilder(500);
				List<String> chapterContents = page.getHtml().xpath(spiderConfig.getContent_reg()).all();
				if (chapterContents.size() > 0) {
					ret.put("status", "24");//网页获取成功，有内容信息
					try {
						replaces = wImpl.getReplaces(book_id);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						replaces = null;
					}
					chapterContent.append(Utils.replace(chapterContents.get(0), replaces).trim());
				}
				if (spiderConfig.getHave_next_content()==1&&null != spiderConfig.getContent_next_page_name_reg()
						&& null != spiderConfig.getContent_next_page_reg() && null != spiderConfig.getChapter_name()
						&& !spiderConfig.getContent_next_page_name_reg().equals("")
						&& !spiderConfig.getContent_next_page_reg().equals("")
						&& !spiderConfig.getChapter_name().equals("")) {
					List<String> next_page_name = page.getHtml().xpath(spiderConfig.getContent_next_page_name_reg())
							.all();
					List<String> next_page_url = page.getHtml().xpath(spiderConfig.getContent_next_page_reg()).links()
							.all();
					List<String> chapter_names = page.getHtml().xpath(spiderConfig.getChapter_name()).all();
					System.out.println(next_page_name);
					System.out.println(next_page_url);
					System.out.println(chapter_names);
					if (next_page_name.size() <= 0 || next_page_url.size() <= 0 || chapter_names.size() <= 0) {
						ret.put("status", "25");//下一页配置规则不正确
					} else {
						String nextChapterContent = Utils.getNextPageContent(next_page_url, next_page_name, spiderConfig, replaces,
								chapter_name,pre_url);
						if (nextChapterContent==null) {
							ret.put("status", "20");//有有一个下一页加载失败
							//清空每一页内容
							chapterContent.delete( 0, chapterContent.length() );
						}else {
							chapterContent.append(nextChapterContent);
						}
					}
				}
				ret.put("content", Utils.replace(chapterContent.toString(), replaces));
			} 
		}
	}

	private String getValueWithKey(String url,String key) {
		// TODO Auto-generated method stub
		String value  = Utils.getParamsFromUrl(url, key);
		if (value==null) {
			value = site.getHeaders().get(key);
		}
		return value;
	}
	@Override
	public Site getSite() {
		return site;
	}
	public JSONObject BeginSpider(String url) {
		ret = new JSONObject();
		spiderConfig = wImpl.getSpiderConfig(url);
		if (spiderConfig==null) {
			ret.put("status", "11");//没有配置
		}else {
			Log4jUtil.getBusinessLogger().info(url);
			Map<String, Object> extras = Utils.URLRequest2(url);
			if (!extras.containsKey("book_id")||!extras.containsKey("type")) {
				ret.put("status", "13");//链接参数错误
				return ret;
			}
			ret.put("status", "21");//有配置，但网页下载不成功
			ret.put("statusCode", 0);
			
			spider = getSpider();
			Status status = spider.getStatus();
			System.out.println(status);
			if(spider.getStatus().equals(Spider.Status.Init)||spider.getStatus().equals(Spider.Status.Stopped)) {
				Request request = Utils.createRequest(extras,url, spiderConfig.getMethod()+"");
				request.setRemoverDuplicate(false);
				spider.addRequest(request);
				spider.getSite().addHeader("Content-Length","0");
				
				if (spiderConfig.getSpider_user_charset()==1) {
					spider.getSite().setCharset(spiderConfig.getCharset());
				}else {
					spider.getSite().setCharset(null);
				}
				
				spider.setExitWhenComplete(true);
				spider.setEmptySleepTime(1000);
				spider.run();
				
			}else if (spider.getStatus().equals(Spider.Status.Running)) {
				ret.put("status", "12");//spider正忙，请稍后再试
				return ret;
			}
		}
		return ret;
	}
}
