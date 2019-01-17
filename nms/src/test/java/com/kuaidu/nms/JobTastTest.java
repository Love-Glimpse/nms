package com.kuaidu.nms;

import com.kuaidu.nms.utils.PageEncoding;

import sun.misc.BASE64Encoder;

public class JobTastTest {

	public static void main(String[] args) {
		//System.out.println(encryptBASE64("aaa"));
		System.out.println(PageEncoding.getEncodingByContentStream("https://www.235zw.com/book/1894/"));
	}
    public static String encryptBASE64(String key) {
        byte[] bt = key.getBytes();
        return (new BASE64Encoder()).encodeBuffer(bt);
    }
}
