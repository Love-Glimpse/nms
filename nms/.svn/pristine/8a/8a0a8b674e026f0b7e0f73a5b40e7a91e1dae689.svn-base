package com.kuaidu.nms;

import java.io.File;

import org.jsoup.nodes.Document;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

/**
 * Hello world!
 *
 */
public class App implements PageProcessor{

	    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

	    @Override
	    public void process(Page page) {
	    	Html html = page.getHtml();
	    	Document document = html.getDocument();
	    	System.out.println(html.toString());
	        //page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
	      //  page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
	        //page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
	      /*  if (page.getResultItems().get("name")==null){
	            //skip this page
	            page.setSkip(true);
	        }*/
	       // page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
	       
	    }

	    @Override
	    public Site getSite() {
	        return site;
	    }

	    public static void main(String[] args) {
	       // Spider.create(new App()).addUrl("https://www.rzlib.net/b/2/2493/").thread(3).run();
	    	File file = new File("D://aa.zip");
	    	
	    }
	
}
