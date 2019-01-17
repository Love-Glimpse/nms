package com.kuaidu.nms.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kuaidu.nms.entity.RestReturn;
import com.kuaidu.nms.entity.SearchLog;
import com.kuaidu.nms.entity.Sys_user;
import com.kuaidu.nms.entity.UserInfo;
import com.kuaidu.nms.user.serviceImpl.SearchLogServiceImpl;
import com.kuaidu.nms.utils.EasyUIReturn;
import com.kuaidu.nms.utils.HttpUtil;
import com.kuaidu.nms.utils.MyWxUtils;

@Controller
@RequestMapping("searchLog")
public class SearchLogController {
	@Autowired
	SearchLogServiceImpl searchLogService;
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	
	
	
	@RequestMapping("index")
	public String searchLogPage() {
		
		
		return "user/searchLog";
	}
	
	@ResponseBody
	@RequestMapping("getAll")
	public Object getSearchLog(HttpServletRequest request,SearchLog searchLog,@RequestParam(defaultValue="0")Integer sort) {
		
		String page= request.getParameter("page");	
		String rows= request.getParameter("rows");
		Integer start_rows = Integer.parseInt(page)*Integer.parseInt(rows)-Integer.parseInt(rows);
		searchLog.setStart_rows(start_rows);
		searchLog.setEnd_rows(Integer.parseInt(rows));
		if (sort == 0) {
			List<SearchLog> list = searchLogService.getAllRecords(searchLog);
			int total = searchLogService.getCount(searchLog);
			return new EasyUIReturn(total, list);
		}else {
			
			List<SearchLog> list = searchLogService.getSortAllRecords(searchLog);
			int total = searchLogService.getSortCount();
			return new EasyUIReturn(total, list);
		}
	}
	
	
	@ResponseBody
	@DeleteMapping("")
	public Object deleteSearchLog(@RequestParam()String ids) {
		
		return searchLogService.deleteSearchLog(ids);
		
		
	}
	
	@ResponseBody
	@PostMapping("replay")
	public Object replay(String msg,Integer userId,Integer id,HttpSession session) {
		UserInfo userInfo = searchLogService.getParentIdAndOpenidByUserId(userId);
		String content = "{\"touser\":\""+userInfo.getOpenid()+"\",\"msgtype\":\"text\",\"text\":{\"content\":\""+msg+"\"}}";
		String accessToken = MyWxUtils.getAccessToken(userInfo.getParent_id());
		String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+accessToken;
		String postWithJson = HttpUtil.postWithJson(url, content, 10000, 10000);
		if (!postWithJson.equals("")) {
			
			JSONObject parseObject = JSON.parseObject(postWithJson);
			Integer integer = parseObject.getInteger("errcode");
			if (integer != null && integer == 0) {
				Sys_user sys_user = (Sys_user) session.getAttribute("user");
				searchLogService.saveReplayMsg(id,msg,sys_user.getShow_name());
				return RestReturn.success();
			}
		}
		
		return RestReturn.fail("发送失败");
	}

}
