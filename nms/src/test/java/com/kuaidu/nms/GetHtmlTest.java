package com.kuaidu.nms;

public class GetHtmlTest {
	public static void main(String[] args) {
		String maxPartnerId ="1";
		int length = maxPartnerId.length();
		if (length<4) {
			for (int i = 4; i > length; i--) {
				maxPartnerId = "0"+maxPartnerId;
			}
		}
		System.out.println(maxPartnerId);
	}
}
