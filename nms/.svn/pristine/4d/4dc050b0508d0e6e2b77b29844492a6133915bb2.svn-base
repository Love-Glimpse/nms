package com.kuaidu.nms.quartz;


import java.net.URLEncoder;

import org.springframework.scheduling.annotation.Scheduled;



/*@Component
@DisallowConcurrentExecution*/
public class TestJob {
	@Scheduled(cron="0/1 * * * * ?")
	public void test() {
		String cron = "0 0/11 * * * ?";
		System.out.println(URLEncoder.encode(cron));
	}
}
