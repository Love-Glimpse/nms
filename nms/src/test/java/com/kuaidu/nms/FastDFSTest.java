package com.kuaidu.nms;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import com.kuaidu.nms.utils.Utils;
import com.kuaidu.nms.utils.fastdfs.FastDFSException;
import com.kuaidu.nms.utils.fastdfs.FastDFSTemplate;
import com.kuaidu.nms.utils.fastdfs.FastDfsInfo;

public class FastDFSTest {
	//public static String LOCATION = "E:/dubbo/myeclipse2017/nms/src/main/resources/config/log4j.xml";

	@Test
	public void testFastDFS() throws FastDFSException{
		//DOMConfigurator.configure(LOCATION);
		String filePath = "D:/app/jdk-8u121-linux-x64.tar.gz";
	    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/spring-common.xml");
	    FastDFSTemplate fastDFSTemplate = (FastDFSTemplate) applicationContext.getBean("fastDFSTemplate");
	    for (int i = 0; i < 1; i++) {
	    	 
	    	byte[] bytes = fileToBetyArray(filePath);
	    	if (bytes!=null) {
		        FastDfsInfo fastDfsInfo = fastDFSTemplate.upload(bytes, "zip");
		        System.out.println(fastDfsInfo.getFileAbsolutePath());
		        System.out.println(fastDfsInfo.getGroup());
		        System.out.println(fastDfsInfo.getPath());
		        fastDFSTemplate.deleteFile(fastDfsInfo.getGroup(), fastDfsInfo.getPath());;
			}
		}
		Map<String, String> map = Utils.getGroupIdAndPath("http://192.168.1.131:80/group1/M00/00/00/wKgBg1rzBIOIN04eAAAAqJVvbrUAAAAAQHH-lAAAADA064.zip?token=a8e9d10d4d70937be273255d370ad0b4&ts=1529052285");

	}
	
	@Test
	public void sdfs() {
		  ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/spring-redis.xml");
		    RedisTemplate<String, Object> redisTemplate = (RedisTemplate<String, Object>) applicationContext.getBean("redisTemplate");
		    Object object = redisTemplate.opsForHash().get("LoginLog--Time:2018-09-20", 5);
		    System.out.println(object);
		    
	}
	
	
	
	
    public static byte[] fileToBetyArray(String filePath)  
    {  
        FileInputStream fileInputStream = null;  
        File file = new File(filePath); 
        if (!file.exists()) {  
            return null;  
        }  
        byte[] bFile = null;  
        try {  
            bFile = new byte[(int) file.length()];  
            fileInputStream = new FileInputStream(file);  
            fileInputStream.read(bFile);  
            fileInputStream.close();  
            //for (int i = 0; i < bFile.length; i++) {  
              //  System.out.print((char) bFile[i]);  
            //}  
            System.out.println("Done");  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                fileInputStream.close();  
                bFile.clone();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return bFile;  
    } 
}
