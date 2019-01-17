package com.kuaidu.nms.partner.qrUrl.controller;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuaidu.nms.utils.MyWxUtils;

import net.sf.json.JSONObject;

/** 
 * @author victor 
 * @version 1.0 
**/
@Controller
@RequestMapping("partner/qrUrl")
public class QrUrl {
	@Autowired 
	RedisTemplate<String, Object> redisTemplate;
	public static int MAX_SECOND = 2592000;
	@ResponseBody
	@RequestMapping("/getTempQrUrl")
	/**
	 * 获取二维码图片
	 * */
	public String getTempQrUrl(HttpSession session,int pushId,int chapterId){
		String url = "";
		String key = "QrCode:temp:"+pushId+"-"+chapterId;
		if (redisTemplate.hasKey(key)) {
			url = (String) redisTemplate.opsForValue().get(key);
		}else {
			url = MyWxUtils.getTempQr(session, MAX_SECOND, pushId, chapterId);
			redisTemplate.opsForValue().set(key, url);
			redisTemplate.expire(key, MAX_SECOND-100, TimeUnit.SECONDS);
		}
		return url;
	}
	@ResponseBody
	@RequestMapping("/getTempQrUrlStr")
	/**
	 * 获取二维码链接信息
	 * */
	public String getTempQrUrlStr(HttpSession session,@Param("pushId")Integer pushId,@Param("chapterId")Integer chapterId){
		String ret = "";
		String key = "QrCodeInfo:temp:"+pushId+"-"+chapterId;
		if (redisTemplate.hasKey(key)) {
			ret = (String) redisTemplate.opsForValue().get(key);
		}else {
			ret = MyWxUtils.getTempQrStr(session, MAX_SECOND, pushId, chapterId);
			if (ret!=null&&ret!="") {
				JSONObject retJson = JSONObject.fromObject(ret);
				if (retJson.containsKey("url")) {
					Integer expire_seconds = retJson.optInt("expire_seconds", 0);
					redisTemplate.opsForValue().set(key, ret);
					redisTemplate.expire(key, expire_seconds-10, TimeUnit.SECONDS);
				}
			}
		}
		return ret;
	}
	@ResponseBody
	@RequestMapping("/getPermanentQrUrl")
	public String getPermanentQrUrl(HttpSession session,int pushId,int chapterId){
		String url = "";
		String key = "QrCode:temp:"+pushId+"-"+chapterId;
		if (redisTemplate.hasKey(key)) {
			url = (String) redisTemplate.opsForValue().get(key);
		}else {
			url = MyWxUtils.getPermanentQr(session, MAX_SECOND, pushId, chapterId);
			redisTemplate.opsForValue().set(key, url);
			redisTemplate.expire(key, MAX_SECOND-100, TimeUnit.SECONDS);
		}
		return url;
	}
}
