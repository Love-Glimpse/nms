package com.kuaidu.nms.user.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.kuaidu.nms.entity.UserLoginLog;
import com.kuaidu.nms.user.serviceImpl.UserLoginLogServiceImpl;
import com.kuaidu.nms.utils.ResultData;


@Controller
@RequestMapping("userLoginLog")
public class UserLoginLogController {
	
	
	@Autowired
	UserLoginLogServiceImpl userLoginLogService;
	
	
	
	@GetMapping("index")
	public String aaa() {
		
		return "user/loginLog";
	}

	
	
	@ResponseBody
	@RequestMapping("getAll")
	public Object getUserLoginLog(UserLoginLog userLoginLog,HttpServletRequest request
			,@RequestParam(required=false)String start_time,@RequestParam(required=false)String end_time) {
		
		int page= Integer.parseInt(request.getParameter("page"));	
		int rows= Integer.parseInt(request.getParameter("rows"));
		Integer start_rows = page*rows-rows;
		/*rList.setUser_id();*/
		userLoginLog.setStart_rows(start_rows);
		userLoginLog.setEnd_rows(rows);
		List<UserLoginLog> list = userLoginLogService.getAllRecords(userLoginLog,start_time,end_time);
		int total = userLoginLogService.getCount(userLoginLog,start_time,end_time);
		return ResultData.toJsonString(total, list);
		
	}
	
	@ResponseBody
	@RequestMapping("userRegion")
	public Object userRegion() {
		List<Map<String,Long>> dd = userLoginLogService.userRegion();
		Long max = dd.get(0).get("value");
		Long min = dd.get(dd.size()-1).get("value");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", dd);
		jsonObject.put("max",max);
		jsonObject.put("min", min);
		return jsonObject;
	}
	
	
	
}
