package com.kuaidu.nms.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

public class RedisKey {

	
	/**
	 *   用户登陆凭证Key
	 */
	public static String userToken(String cookieValue) {
		return "User:"+cookieValue;
		
	}
	
	/**
	 *  记录登陆前的url
	 */
	public static String urlRecord(String url){
		return "URL:"+url;
	}
	
	
	
	/**
	 *   每日访问量统计key n为前后多少天
	 * @return 0:今天,1明天,-1昨天......
	 */
	public static String visits(int n) {
		Date backupTime=DateUtils.addDays(new Date(),n);
		String format = new SimpleDateFormat("yyyy-MM-dd").format(backupTime);
		return "Visits--Time:"+format;
	}
	
	

	/**
	 *  统计无需登陆章节阅读量的key
	 * @return
	 */
	public static String noLoginReadCount(int n){
		Date backupTime=DateUtils.addDays(new Date(),n);
		String format = new SimpleDateFormat("yyyy-MM-dd").format(backupTime);
		return "NoLoginReadCount:"+format;
	}
	
	
	/**
	 *  记录章节放问的ip
	 * @param ip
	 * @return
	 */
	public static String chapterIp(String ip){
		return "Chapter:"+ip;
	}
	
	/**
	 *  章节黑名单ip
	 * @param ip
	 * @return
	 */
	public static String blackChapter(String ip){
		return "Black:"+ip;
	}
	
	
	


	/**
	 * 
	 * @param mail
	 * @return 记录用户登陆失败次数的key
	 */
	public static String loginFail(String mail) {
		return "LoginFail--Mail:"+mail.toLowerCase();
	}
	
	/**
	 * 
	 * @return 记录每日活跃用户数的KEY
	 */
	public static String activeUser() {
		SimpleDateFormat simpleDateFormat = new  SimpleDateFormat("yyyy-MM-dd");
		String format = simpleDateFormat.format(new Date());
		return "Active--Time:"+format;
	}
	
	/**
	 *   统计用户每日阅读时间Key
	 *   0:今天,1明天,-1昨天......
	 * @return
	 */
	public static String readTime(int n) {
		Date addDays = DateUtils.addDays(new Date(), n);
		SimpleDateFormat simpleDateFormat = new  SimpleDateFormat("yyyy-MM-dd");
		String format = simpleDateFormat.format(addDays);
		return "Read--Time:"+format;
	}
	
	/**
	 *  统计在线时常每次请求的key
	 * @param userId
	 * @return
	 */
	public static String requestReadTime(Integer userId) {
		return "RequestRead--ID:"+userId;
	}
	
	
	
	
	/**
	 *  统计阅读时常每次请求的key
	 * @param userId
	 * @return
	 */
	public static String requestOnlineTime(Integer userId) {
		return "RequestOnline--ID:"+userId;
	}
	
	/**
	 *    统计用户每日在线时间Key
	 * @param n
	 * @return
	 */
	public static String onlineTime(int n) {
		Date addDays = DateUtils.addDays(new Date(), n);
		SimpleDateFormat simpleDateFormat = new  SimpleDateFormat("yyyy-MM-dd");
		String format = simpleDateFormat.format(addDays);
		return "Online--Time:"+format;
	}
	
	
	
	
	
	
	/**
	 * 用户登陆日志
	 *  0:今天,1明天,-1昨天......
	 * @return  LoginLog--加上日期
	 */			
	public static String loginLog(int n) {
		Date addDays = DateUtils.addDays(new Date(), n);
		SimpleDateFormat simpleDateFormat = new  SimpleDateFormat("yyyy-MM-dd");
		String format = simpleDateFormat.format(addDays);
		return "LoginLog--Time:"+format;
	}
	
	/**
	 *  7折购买token
	 * @param userId
	 * @param bookId
	 * @return
	 */
	public static String percentOff(int userId,int bookId){
		return "PercentOffToken:"+userId+"-"+bookId;
	}
	
	/**
	 *  推广链接的点击量过滤
	 * @return
	 */
	public static String pushIdHits(int pushId,String ip){
		
		return "PushUrl:"+pushId+":"+ip;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * @param mail
	 * @return 注册验证码KEY
	 */
	public static String registCode(String mail) {
		return "RegistCode--Mial:"+mail.toLowerCase();
	}
	
	/**
	 * 
	 * @return 重置密码KEY
	 */
	public static String forgetPwdCode(String mail) {
		return "ForgetPwdCode--Mail:"+mail.toLowerCase();
	}
	
	/**
	 *  每日用户签到key
	 * @return
	 */
	public static String UserSingIn(int n) {
		Date addDays = DateUtils.addDays(new Date(), n);
		SimpleDateFormat simpleDateFormat = new  SimpleDateFormat("yyyy-MM-dd");
		String format = simpleDateFormat.format(addDays);
		return "UserSignIn:"+format;
	}

	public static String searchLog(int n) {
		Date addDays = DateUtils.addDays(new Date(), n);
		SimpleDateFormat simpleDateFormat = new  SimpleDateFormat("yyyy-MM-dd");
		String format = simpleDateFormat.format(addDays);
		return "SearchLog:"+format;
	}


	
}
