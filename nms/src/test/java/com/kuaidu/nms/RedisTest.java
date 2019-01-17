package com.kuaidu.nms;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.Charsets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.VoidMethodStubbable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kuaidu.nms.partner.financial.serviceImpl.PartnerBillServiceImpl;
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:config/spring-common.xml","classpath:config/spring-redis.xml"}) 
public class RedisTest {
	

	@Autowired
	PartnerBillServiceImpl partnerBillService;
	
	
	@Test
	public void sds() throws Exception {
		  String url = "http://45.78.43.207/group2/M00/00/10/aJlkh1vJkuiIBB7TAAAJVHIjc6EAAAGhAAbGBEAAAls85.jpeg";
	}
		
	
	public static List<String> getContentByUrl(String fileUrl) throws Exception {
		List<String> list = new ArrayList<>();
		URL url = new URL(fileUrl);
		InputStream inputStream = url.openStream();
		ZipInputStream zipInputStream = new ZipInputStream(inputStream);
		ZipEntry zipEntry = null;
		StringBuffer sb = new StringBuffer();
		while ((zipEntry = zipInputStream.getNextEntry()) != null) {
			InputStreamReader inputStreamReader = new InputStreamReader(zipInputStream, Charsets.toCharset("UTF-8"));
			BufferedReader reader = toBufferedReader(inputStreamReader);
			String line = reader.readLine();
			while (line != null && !line.equalsIgnoreCase("null")) {
				if (line.length() > 1) {
					list.add(line);
				}
				line = reader.readLine();
			}
		}
		return list;
	}

	public static BufferedReader toBufferedReader(Reader reader) {
		return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
	}
	
	
	@Test
	public void efwef() {
		partnerBillService.sdfsdf();
	}
	
	
	

}
		