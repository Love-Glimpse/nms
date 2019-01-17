package com.kuaidu.nms;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
/*
 * @RunWith(SpringJUnit4ClassRunner.class)
 * 
 * @ContextConfiguration(locations = { "classpath:config/spring-common.xml",
 * "classpath:config/spring-redis.xml"})
 */


public class AppTest {

	@Test
	public void wewe() throws IOException {

		Document doc = Jsoup.connect("https://www.luochen.com/kw/婚来孕转：冷少的心尖宠").userAgent(
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.84 Safari/537.36")
				// .cookie("auth", "token")
				.timeout(3000).get();
		Elements select = doc.select("img[alt=婚来孕转：冷少的心尖宠]");
		if (select != null) {
			String attr = select.attr("src");
			System.err.println(attr);
		} else {
			System.err.println("没有找到");
		}
	}

	
	@Test
	public void swee() throws IOException {
		String name = "冷面娘亲萌宝贝";
		Document doc = Jsoup.connect("http://wenxue.iqiyi.com/book/search-"+name+"-1.html").userAgent(
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.84 Safari/537.36")
				// .cookie("auth", "token")
				.timeout(3000).get();
		Elements select = doc.select("img[alt="+name+"]");
		if (select != null) {
			String attr = select.attr("src");
			System.err.println(attr);
		} else {
			System.err.println("没有:"+name);
		}
	}
}
