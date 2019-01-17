package com.kuaidu.nms.queryManage.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kuaidu.nms.entity.SpiderConfig;
import com.kuaidu.nms.query.serviceImpl.SpiderConfigMapperImpl;
import com.kuaidu.nms.utils.ResultData;

import net.sf.json.JSONObject;

//spiderConfig/spiderConfigIndex
@Controller
@RequestMapping("/spiderConfig")
public class SpiderConfigManage {
	@Autowired
	private SpiderConfigMapperImpl sImpl;
	
	public SpiderConfigMapperImpl getsImpl() {
		return sImpl;
	}
	public void setsImpl(SpiderConfigMapperImpl sImpl) {
		this.sImpl = sImpl;
	}
	@RequestMapping("/spiderConfigIndex")
	public ModelAndView authorsQueryManageIndex(HttpSession session){
		
			ModelAndView mv = new ModelAndView();
			
		try {
			mv.setViewName("Query/spiderConfig"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	/*
	 * datagrid使用了分页的话，其框架自身会向后台传递page、rows这个两个属性值。
	 * 分别表示当前页和当前页显示的记录行数。
	 * 可以在action中定义好这两个属性，并同样设置getter和setter方法，就可以接受到这些参数了。
	 * */
	//查
	@ResponseBody
	@RequestMapping("/getAllConfigs")
	public String getAll(HttpServletRequest request,SpiderConfig spiderConfig){	
		Integer page = Integer.parseInt(request.getParameter("page"));
		Integer rows = Integer.parseInt(request.getParameter("rows"));
		
		Integer start_rows = (page-1)*rows;
		spiderConfig.setStart_rows(start_rows);
		spiderConfig.setRows(rows);
		List<SpiderConfig> list = sImpl.getAllConfigs(spiderConfig);
		int total = sImpl.getCount();
		//list.size()=10
		return ResultData.toJsonString(total, list);
	}
	/*
	 * 新增
	 */
	@ResponseBody
	@RequestMapping("/add_sConfig")
	public String add_sConfig(HttpServletRequest request,SpiderConfig spiderConfig){
		JSONObject json = new JSONObject();
		try {
			sImpl.add_sConfig(spiderConfig);
			json.put("result", "0");
		} catch (Exception e) {
			json.put("result", "1");
			e.printStackTrace();
		}
		return json.toString();
	}
	
	/*
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/del_sConfig")
	public String del_sConfig(HttpServletRequest request,SpiderConfig spiderConfig){
		JSONObject json = new JSONObject();
		try {
			sImpl.del_sConfig(spiderConfig);
			json.put("result", "0");
		} catch (Exception e) {
			json.put("result", "1");
			e.printStackTrace();
		}
		return json.toString();
	}
	/*
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update_sConfig")
	public String update_sConfig(HttpServletRequest request,SpiderConfig spiderConfig){
		JSONObject json = new JSONObject();
		try {
			sImpl.update_sConfig(spiderConfig);
			json.put("result", "0");
		} catch (Exception e) {
			json.put("result", "1");
			e.printStackTrace();
		}
		return json.toString();
	}
}
