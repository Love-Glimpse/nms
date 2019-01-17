package com.kuaidu.nms.spider.down;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kuaidu.nms.entity.Book_list;
import com.kuaidu.nms.query.serviceImpl.BooksQueryMapperImpl;
import com.kuaidu.nms.spider.controller.serviceImpl.WebSpiderImpl;
import com.kuaidu.nms.utils.Log4jUtil;
import com.kuaidu.nms.utils.Utils;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

@Component
public class INovelSpider implements PageProcessor {
	
	public static WebSpiderImpl wImpl;
	
	public WebSpiderImpl getwImpl() {
		return wImpl;
	}
	@Autowired
	public void setwImpl(WebSpiderImpl wImpl) {
		INovelSpider.wImpl = wImpl;
	}
	public static BooksQueryMapperImpl bImpl;
	
	public BooksQueryMapperImpl getbImpl() {
		return bImpl;
	}
	@Autowired
	public void setbImpl(BooksQueryMapperImpl bImpl) {
		INovelSpider.bImpl = bImpl;
	}
	public INovelSpider(String ua,String cookie) {
		super();
	}

	public INovelSpider() {
		// TODO Auto-generated constructor stub
	}

	private  static Map<String, String> cookieMap = new HashMap<String, String>();
	private Site site ;

	private volatile static Spider spider;

	public static Spider getSpider() {
		 synchronized (INovelSpider.class) {  
			 if (spider == null) {  
				 spider = new Spider(new INovelSpider());  
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

			List<String> bookPicUrls = page.getHtml().xpath("//div[@class='col-xs-12']/table/tbody/tr/td")
					.css("img", "src").all();
			List<String> totalChapterCounts = page.getHtml()
					.xpath("//div[@class='col-xs-12']/table/tbody/tr/td/div[@class='text-muted']/text()").all();
			List<String> wanjies = page.getHtml().xpath("//div[@class='col-xs-12']/table/tbody/tr/td/span[@style='font-size:13px']/text()")
					.all();
			List<String> sexes = page.getHtml()
					.xpath("//div[@class='col-xs-12']/table/tbody/tr/td[@class='text-center']/text()").all();
			List<String> bookUrlsBak = new ArrayList<String>();
			List<String> bookNameList = new ArrayList<String>();
			List<String> bookUrlList = new ArrayList<String>();
			String regex ="https://inovel\\.818tu\\.com/backend/novels/view/\\d+";
			for (int i = 0; i < bookNames.size(); i++) {
				if (bookUrls.get(i).matches(regex)) {
					bookNameList.add(bookNames.get(i));
					bookUrlList.add(bookUrls.get(i));
				}
			}
			List<String> nextPageUrl =  page.getHtml()
					.xpath("//div[@class='col-xs-12']/div/ul/li[@class='next page']/a").links().all();
			for (int i = 0; i < bookUrlList.size(); i++) {
				//书籍信息没有保存在数据库则，存入数据库，已存在的直接过滤，根据书名查找
				if (bookNameList.get(i).split(" ").length>=2) {
					String bookUrl = bookUrlList.get(i);
					String zBookID = bookUrl.substring(bookUrl.lastIndexOf("/")+1);

					String typeName = bookNameList.get(i).split(" ")[0].replace("[", "").replace("]", "");
					String bookName = bookNameList.get(i).split(" ")[1];
					Book_list book_list = new Book_list();
					//书名
					book_list.setBook_name(bookName);
					book_list.setBook_pic_url(bookPicUrls.get(i));
					//总章节数
					book_list.setTotal_chapter_count(getNumfromString(totalChapterCounts.get(i)));
					Log4jUtil.getBusinessLogger().info(bookName+"==="+wanjies.get(i));
					//连载
					if (wanjies.get(i).indexOf("连载")>0) {
						book_list.setIsserial(0);
					}else if(wanjies.get(i).indexOf("完结")>0) {
						book_list.setIsserial(1);
					}else {
						book_list.setIsserial(0);
					}
					//男女频
					if (sexes.get(i*5+1).trim().equalsIgnoreCase("男频")) {
						book_list.setSex(1);
					}else if (sexes.get(i*5+1).trim().equalsIgnoreCase("女频")) {
						book_list.setSex(0);
					}else {
						book_list.setSex(2);
					}
					//派单指数
					book_list.setHot_value(Integer.parseInt(sexes.get(i*5+2).trim()));
					
					Book_list book_lib = wImpl.getBookList(book_list);

					if (book_lib==null) {//库里面没有的书
						if (book_lib==null||book_lib.getBook_url()==null||book_lib.getBook_url().equalsIgnoreCase("")) {
							if (zBookID!=null && zBookID.length()>0) {
								String book_url = BooksQueryMapperImpl.getUrlFromRzlibStr(bookName);
								if (book_url==null||book_url.equalsIgnoreCase("")) {
									book_url = "https://c49683.818tu.com/m/novels/"+zBookID+"/chapters";
								}
								book_list.setBook_url(book_url);
							}
						}
						try {
							if (!wImpl.novelTypeExist(typeName)) {//小说类型不存在
								wImpl.saveNovel(typeName);
							}
							int type_id = wImpl.getTypeId(typeName);
							book_list.setType_id(type_id);
							wImpl.saveBookInfo(book_list);
							bookUrlsBak.add(bookUrlList.get(i));
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//bookUrlsBak.add(bookUrls.get(i));
					}else{//库里面存在，更新派单指数，总章节数等信息（没审核的）
/*						if (book_lib.getDescription()==null) {
							bookUrlsBak.add(bookUrlList.get(i));
						}*/
						if (book_lib.getIs_fixed()==0) {
							if (!StringUtils.equals(book_lib.getBook_pic_url(), book_list.getBook_pic_url())) {
								Log4jUtil.getBusinessLogger().info(book_lib.getBook_pic_url()+"==="+book_list.getBook_pic_url());
								book_list.setBook_pic_changed(1);
							} else {
								book_list.setBook_pic_changed(null);
							}

							wImpl.updateBook(book_list);
						}
					}
					Integer book_id = bImpl.getbookIdByBookname(bookName);
					wImpl.savezBookId(zBookID,book_id);
					//bookUrlsBak.add(bookUrlList.get(i));
				}
			}
			page.addTargetRequests(bookUrlsBak);
			//下一页
			if (nextPageUrl.size()>=1) {
				page.addTargetRequest(nextPageUrl.get(0));
			}
		}else {
			List<String> bookNames = page.getHtml().xpath("//div[@class='col-sm-3']/h4/text()").all();
			List<String> descriptions =  page.getHtml().xpath("//div[@class='col-sm-3']/div[@class='text-muted']/text()").all();
			List<String> free_chapter_nums =  page.getHtml().xpath("//div[@class='col-sm-9']/ul/li/a/text()").all();
			List<String> chapterLists =  page.getHtml().xpath("//div[@class='col-sm-9']/ul/li/a[@class='chapter-title']/text()").all();
			List<String> readOriginalAndSubChapterLists =  page.getHtml().xpath("//div[@class='col-sm-9']/ul/li[@class='chapter-item']").all();
			int read_original_chapter_num = 0,sub_chapter_num=0;
			for (int i=0;i<readOriginalAndSubChapterLists.size();i++) {
				String [] cStrings= readOriginalAndSubChapterLists.get(i).replaceAll("\\<.*?>",",").split(",");
				for (int j = 0; j < cStrings.length; j++) {
					if (cStrings[j].equalsIgnoreCase("推荐关注章节")) {
						sub_chapter_num=i+1;
					}else if (cStrings[j].equalsIgnoreCase("推荐阅读原文章节")) {
						read_original_chapter_num=i+1;
					}
				}
				
			}
			Log4jUtil.getBusinessLogger().info(read_original_chapter_num+"==="+sub_chapter_num);
			
			Book_list book_list = new Book_list();
			String book_name = bookNames.get(0).trim();
			book_list.setBook_name(book_name);
			book_list.setDescription(descriptions.get(1));
			int free_chapter_num = free_chapter_nums.size();
			free_chapter_num = free_chapter_num>5?free_chapter_num:5;
			book_list.setFree_chapter_num(free_chapter_num);
			book_list.setRead_original_chapter_num(read_original_chapter_num);
			book_list.setNewest_chapter(chapterLists.get(0));
			wImpl.updateBook(book_list);
			bImpl.editSubscribeChapterByBookName(0, book_name, sub_chapter_num);
		}
		Utils.threadSleep(5000);
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
