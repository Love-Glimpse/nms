package com.kuaidu.nms.systemManage.controller;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kuaidu.nms.entity.GroupModule;
import com.kuaidu.nms.entity.Sys_group;
import com.kuaidu.nms.entity.Sys_module;
import com.kuaidu.nms.system.serviceImpl.SystemGroupMapperImpl;
import com.kuaidu.nms.utils.ResultData;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/group")
public class SystemGroupManage {
	
	@Resource
	SystemGroupMapperImpl sImpl;
	@RequestMapping("/groupIndex")
	public ModelAndView foreignAllManageIndex(HttpSession session){
		
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("System/group"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	@ResponseBody
	@RequestMapping("/getAll")
	public String getAll(HttpServletRequest request){
		List<Sys_group> list = sImpl.getAll();
		return ResultData.toJsonString(list.size(), list);
	}
	/*
	 * 新增用户,编辑用户
	 */
	@ResponseBody
	@RequestMapping("/save_group")
	public String save_user(Sys_group sys_group){
		JSONObject json = new JSONObject();
		try{
			if(sys_group.getGroup_id()<=0){

				sImpl.save_group(sys_group);
			}else{
				sImpl.edit_group(sys_group);
			}
			//成功
			json.put("result", "0");
		} catch (Exception e) {
			json.put("result", "1");
			e.printStackTrace();
		}
		return json.toString();
	}
	@ResponseBody
	@RequestMapping("/del_group")
	public String del_user(HttpServletRequest request){
		String node =request.getParameter("node");
		JSONObject jsonObject = new JSONObject();
		try {
			JSONArray jsonArray = JSONArray.fromObject(node);  
	        List<Object> list= new ArrayList<Object>();
	        for(int i=0;i<jsonArray.size();i++){
	            list.add(jsonArray.get(i));
	        }
	        sImpl.del_group(list);
	        jsonObject.put("result", "0");
	        
		} catch (Exception e) {
			 jsonObject.put("result", "1");
			e.printStackTrace();
			
			// TODO: handle exception
		}
		return jsonObject.toString();
	}
	/*
	 * 树形菜单
	 */
	@ResponseBody
	@RequestMapping("/getAllTree")
	public String getAllTree(HttpServletRequest request) throws UnknownHostException{
		JSONObject json1 = new JSONObject();
		JSONObject json2 = new JSONObject();
		JSONArray jArray1 = new JSONArray();
		JSONArray jArray2 = new JSONArray();
		
		String group_id = request.getParameter("group_id");
         List<Sys_module> list = sImpl.getAllTree(Integer.parseInt(group_id));
         json1.put("id", "0");
         json1.put("text", "根节点");

         for (Sys_module sys_module : list) {
        	 if(sys_module.getParent_id()==0){//模块根节点
				 json2.put("id", sys_module.getModule_id());
				 json2.put("text", sys_module.getModule_name());
				 
				 JSONArray jArray3 = new JSONArray();
				 for (Sys_module module : list) {
					if(module.getParent_id()==sys_module.getModule_id()&&module.getParent_id()!=0){
						JSONObject json3 = new JSONObject();
						json3.put("id", module.getModule_id());
						json3.put("text", module.getModule_name());
						if(module.getFlag()!=null&&module.getFlag()>0){
							json3.put("checked", "true");
						}
						jArray3.add(json3);
					}
				}
				 json2.put("children", jArray3);
				 jArray2.add(json2);
        	 }
		}
         json1.put("children", jArray2);
         jArray1.add(json1.toString());
         return jArray1.toString();
	}
	/*
	 * 修改分组权限
	 */
	@ResponseBody
	@RequestMapping("/save_authority")
	public String save_authority(HttpServletRequest request,HttpSession session){
		Integer group_id = Integer.parseInt(request.getParameter("group_id"));
		String node = request.getParameter("node");
		JSONObject jsonObject = new JSONObject();
		try {
			System.out.println(group_id);
			sImpl.del_group_module(group_id);
			JSONArray jsonArray = JSONArray.fromObject(node);
			List<GroupModule> gModules = new ArrayList<GroupModule>();
	        for(int i=0;i<jsonArray.size();i++){
	        	GroupModule gModule = new GroupModule();
	        	gModule.setGroup_id(group_id);
	        	gModule.setModule_id(jsonArray.getInt(i));
	        	gModules.add(gModule);
	        }
	        sImpl.save_authority(gModules);
	        jsonObject.put("result", "0");
	        
		} catch (Exception e) {
			jsonObject.put("result", "1");
			e.printStackTrace();
			
		}
		return jsonObject.toString();
	}
}
