package com.kuaidu.nms.spider.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kuaidu.nms.config.Config;
import com.kuaidu.nms.entity.ChapterList;
import com.kuaidu.nms.spider.controller.serviceImpl.WebSpiderImpl;
import com.kuaidu.nms.spider.down.WebSpider;
import com.kuaidu.nms.utils.PageEncoding;
import com.kuaidu.nms.utils.Utils;

@Controller
@RequestMapping("/spider")
public class SpiderResource {
	@Autowired
	public WebSpiderImpl wImpl;
	public static void main(String[] args) {


	}
	/**根据链接获取章节**/
	@SuppressWarnings("deprecation")
	@ResponseBody
	@RequestMapping("/getChapterListFromUrl")
	public JSONObject getChapterList(@RequestParam("book_url")String book_url,@RequestParam("book_id")Integer book_id) {
		JSONObject ret = new JSONObject();
		book_url = URLDecoder.decode(book_url);
		if (book_url.contains("c49683.818tu.com")) {
			ret = getChapterListFromUrl(book_url,book_id);
		}else {
			WebSpider webSpider = new WebSpider();
			ret = webSpider.BeginSpider(book_url.trim()+"?type=1&book_id="+book_id+"&ct="+System.currentTimeMillis());
		}
		System.out.println(ret);
		return ret;
	}
 
	private JSONObject getChapterListFromUrl(String book_url, Integer book_id) {
		// TODO Auto-generated method stub
		JSONObject ret = new JSONObject();
		Set<String> set = new HashSet<String>();
		String[] pas = book_url.split("/");
		ret.put("status", 22);
		ret.put("statusCode", 0);
		if (pas.length>=2) {
			List<ChapterList> chapterLists = new ArrayList<ChapterList>();
			String url = "https://c49683.818tu.com/v1/novels/"+pas[pas.length-2]+"/catalog";
			JSONObject jsonObject = JSONObject.parseObject(Utils.getHtmlcodeWithoutHeader(url, "utf-8"));
			JSONArray jArray = jsonObject.getJSONArray("data");
			for (int i = 0; i < jArray.size(); i++) {
				JSONObject json = JSONObject.parseObject(jArray.get(i).toString()); 
				List<ChapterList> cLists = wImpl.getAllChapterList(book_id,1);
				Map<String, Integer> map = new HashMap<String, Integer>();
				for (ChapterList cList : cLists) {//数据库已有的章节信息
					map.put(cList.getChapter_name_old().replaceAll(Config.CHAPTER_FILTER_REGEX, ""), cList.getChapter_id());
				}
				String chapterName = json.getString("title");
				if (set.add(chapterName)&&!map.containsKey(chapterName.trim().replaceAll(Config.CHAPTER_FILTER_REGEX, ""))) {
					ChapterList chapterList = new ChapterList();
					chapterList.setChapter_name(chapterName);
					chapterList.setChapter_num(i+1);
					chapterList.setChapter_url("https://c49683.818tu.com/v1/read/"+json.getString("id"));
					chapterLists.add(chapterList);
				}
			}
			ret.put("statusCode", 200);
			ret.put("status", 23);
			ret.put("total", chapterLists.size());
			ret.put("rows", chapterLists);
		}
		return ret;
	}
	/**根据章节
	 * result
	 * status:11 没有配置信息
	 * status:12 spider忙，稍后再试
	 * status:20 有配置，网页下载成功,下一页不成功
	 * status:21 有配置，网页下载不成功
	 * status:22 网页下载成功，没爬取到信息
	 * status:23网页下载成功，有章节信息
	 * status:24网页下载成功，有内容信息
	 * 
	 * 获取内容**/
	@SuppressWarnings("deprecation")
	@ResponseBody
	@RequestMapping("/getChapterContentFromUrl")
	public JSONObject getChapterContent(@RequestParam("chapter_url")String chapter_url,Integer book_id,String chapter_name) {
		WebSpider webSpider = new WebSpider();
		chapter_url = URLDecoder.decode(chapter_url).trim()+"?book_id="+book_id+"&chapter_name="+URLEncoder.encode(chapter_name);

		System.out.println(chapter_url);
		//去掉链接里面的换行
		chapter_url = chapter_url.replaceAll(Config.CHAPTER_FILTER_REGEX, "");
		JSONObject ret = new JSONObject();
		if (chapter_url.contains("c49683.818tu.com")) {
			ret.put("status", 22);
			JSONObject jsonContent;
			try {
				JSONObject jsonObject = JSONObject.parseObject(Utils.getHtmlcodeWithoutHeader(chapter_url, "utf-8"));
				jsonContent = JSONObject.parseObject(jsonObject.getString("data"));
				String content = jsonContent.getString("content");
				ret.put("status", 24);
				ret.put("content", content);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				ret.put("content", "");
				e.printStackTrace();
			}
		}else {
			chapter_url = chapter_url+"&type=2&ct="+System.currentTimeMillis();
			System.out.println(chapter_url);
			ret = webSpider.BeginSpider(chapter_url);
		}
		return ret;
	}
	@ResponseBody
	@RequestMapping("/test")
	public JSONObject test(HttpServletRequest request,@RequestHeader("User-Agent") String userAgent) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("ua", userAgent);
		System.out.println(jsonObject.toString());
		return jsonObject;
	}
	@ResponseBody
	@RequestMapping("/getCharset")
	public JSONObject getCharset(@RequestParam("url")String url) {
		JSONObject jsonObject = new JSONObject();
		String charset = PageEncoding.getEncodingByContentStream(url);
		if (charset.toLowerCase().startsWith("gb")) {
			charset="gbk";
		}
		jsonObject.put("charset", charset);
		return jsonObject;
	}
}
