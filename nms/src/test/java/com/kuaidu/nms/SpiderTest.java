package com.kuaidu.nms;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.ZipInputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.xml.DOMConfigurator;

import com.kuaidu.nms.spider.down.INovelSpider;



public class SpiderTest {
	public static void main(String[] args) throws Exception {
		DOMConfigurator.configure("E:/dubbo/myeclipse2017/novels/src/main/resources/config/log4j.xml");
		INovelSpider iSpider = new INovelSpider();
		String url = "https://inovel.818tu.com/backend/novels/index?order_by=rank+desc&stype=1&ct="+System.currentTimeMillis();
		iSpider.BeginSpider(url);
	}
	
	/**读取zip内容*/
	public static String readZipFile(String filename) throws Exception {
		StringBuffer sb = new StringBuffer();
		try {
			ZipInputStream zin = new ZipInputStream(new FileInputStream(filename));
			// 输入源zip路径
			BufferedInputStream bin = new BufferedInputStream(zin);
			
			java.util.zip.ZipEntry entry;
			try {
				while ((entry = zin.getNextEntry()) != null && !entry.isDirectory()) {
					System.out.println(entry.getName());
					BufferedReader reader = new BufferedReader(new InputStreamReader(bin,"UTF-8"));
					try {
						String s = reader.readLine();
						while (s != null) {
							s = StringUtils.trimToEmpty(s);
							if (s.length()>0) {
								s=System.getProperty("line.separator")+"    "
										+s+System.getProperty("line.separator");
								//s = s.replaceAll("<\\s*/?[p|P][^>]*>", System.getProperty("line.separator")); 
								sb.append(s);
							}
							s = reader.readLine();
						}
						System.out.println(sb.toString());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				bin.close();
				zin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "    "+sb.toString().trim();
	}

}
