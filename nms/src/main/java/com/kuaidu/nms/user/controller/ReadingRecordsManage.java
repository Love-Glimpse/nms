package com.kuaidu.nms.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kuaidu.nms.entity.UserReadLog;
import com.kuaidu.nms.user.serviceImpl.ReadingRecordsMapperImpl;
import com.kuaidu.nms.utils.EasyUIReturn;


@Controller
@RequestMapping("/readingRecords")
public class ReadingRecordsManage {
	@Autowired
	private ReadingRecordsMapperImpl rImpl;
	@RequestMapping("/readingRecordsIndex")
	public ModelAndView readingRecordsManageIndex(HttpSession session){
			
			ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("user/readingRecords");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	/*
	 * 使用了分页的话，其框架自身会向后台传递page、rows这个两个属性值。
	 * 分别表示当前页和当前页显示的记录行数。
	 * 可以在action中定义好这两个属性，并同样设置getter和setter方法，就可以接受到这些参数了。
	 * */
	//查
	@ResponseBody
	@RequestMapping("/getAll")
	public EasyUIReturn getAll(HttpServletRequest request,UserReadLog rList,@RequestParam(defaultValue="1")Integer isGroup){	
		String page= request.getParameter("page");	
		String rows= request.getParameter("rows");
		Integer start_rows = Integer.parseInt(page)*Integer.parseInt(rows)-Integer.parseInt(rows);
		rList.setStart_rows(start_rows);
		rList.setEnd_rows(Integer.parseInt(rows));
		List<UserReadLog> list = rImpl.getAllRecords(rList,isGroup);
		int total = rImpl.getCount(rList,isGroup);
		//return ResultData.toJsonString(total, list);
		return new EasyUIReturn(total, list);
	}
	
	@ResponseBody
	@RequestMapping("groupByUserId")
	public EasyUIReturn getGroupByUserIdReadLog(UserReadLog rList,HttpServletRequest request) {
		String page= request.getParameter("page");	
		String rows= request.getParameter("rows");
		Integer start_rows = Integer.parseInt(page)*Integer.parseInt(rows)-Integer.parseInt(rows);
		rList.setStart_rows(start_rows);
		rList.setEnd_rows(Integer.parseInt(rows));
		List<UserReadLog> list = rImpl.getGroupByUserIdReadLog(rList);
		int total = rImpl.getGroupByUserIdReadLogCount();
		//return ResultData.toJsonString(total, list);
		return new EasyUIReturn(total, list);
		
	}
}
