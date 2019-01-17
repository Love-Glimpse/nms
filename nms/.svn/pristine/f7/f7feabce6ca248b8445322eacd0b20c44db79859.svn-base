package com.kuaidu.nms.pushchannel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kuaidu.nms.entity.Sys_module;
import com.kuaidu.nms.pushchannel.serviceImpl.PartnerModuleMapperImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/partnerModule")
public class PartnerModuleManage {
	@Autowired
	private PartnerModuleMapperImpl mImpl;
	
	public PartnerModuleMapperImpl getmImpl() {
		return mImpl;
	}

	public void setmImpl(PartnerModuleMapperImpl mImpl) {
		this.mImpl = mImpl;
	}

	@RequestMapping("/partnerModuleIndex")
	public ModelAndView foreignAllManageIndex(HttpSession session){
		
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("PushChannel/partnerModule"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	/*
	 * 树形网格
	 */
	@ResponseBody
	@RequestMapping("/treeGrid")
	public String treeGrid(){
		List<Sys_module> list =mImpl.getAll_module();
		JSONObject json1 = new JSONObject();
		JSONObject json2 = new JSONObject();
		JSONArray jArray1 = new JSONArray();
		JSONArray jArray2 = new JSONArray();
        json1.put("id", "0");
        json1.put("module_name", "根节点");
        json1.put("parent_id", "");
        json1.put("module_url", "");
        for (Sys_module sys_module : list) {
       	 if(sys_module.getParent_id()==0){
				 json2.put("id", sys_module.getModule_id());
				 json2.put("module_name", sys_module.getModule_name());
				 json2.put("parent_id", sys_module.getParent_id());
				 json2.put("module_url", sys_module.getModule_url());
				 json2.put("show_order", sys_module.getShow_order());
				 JSONObject json3 = new JSONObject();
				 JSONArray jArray3 = new JSONArray();
				 for (Sys_module module : list) {
					if(module.getParent_id()==sys_module.getModule_id()){
						json3.put("id", module.getModule_id());
						json3.put("module_name", module.getModule_name());
						json3.put("parent_id", module.getParent_id());
						json3.put("module_url", module.getModule_url());
						json3.put("show_order", module.getShow_order());
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
	 * 树形菜单
	 */
	@ResponseBody
	@RequestMapping("/getAllTree")
	public String getAll_module(){
		List<Sys_module> list =mImpl.getAll_module();
		JSONObject json1 = new JSONObject();
		JSONObject json2 = new JSONObject();
		JSONArray jArray1 = new JSONArray();
		JSONArray jArray2 = new JSONArray();
        json1.put("id", "0");
        json1.put("text", "根节点");
        for (Sys_module sys_module : list) {
       	 if(sys_module.getParent_id()==0){
				 json2.put("id", sys_module.getModule_id());
				 json2.put("text", sys_module.getModule_name());
				 JSONObject json3 = new JSONObject();
				 JSONArray jArray3 = new JSONArray();
				 for (Sys_module module : list) {
					if(module.getParent_id()==sys_module.getModule_id()){
						json3.put("id", module.getParent_id());
						json3.put("text", module.getModule_name());

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
	 * 新增系统模块
	 */
	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping("/save")
	public String save(HttpServletRequest request){
		String node = request.getParameter("node");
		JSONObject jObject = JSONObject.fromObject(node);
		JSONObject js = new JSONObject();
		try {

			Sys_module sModule = new Sys_module();
			sModule.setModule_name(jObject.getString("module_name"));
			sModule.setParent_id(Integer.parseInt(jObject.getString("parent_id")));
			sModule.setShow_order(Integer.parseInt(jObject.getString("show_order")));
			sModule.setModule_url(jObject.getString("module_url"));
			if (!jObject.getString("module_id").equals("")) {
				sModule.setModule_id(Integer.parseInt(jObject.getString("module_id")));
			}
			
			if(jObject.getString("type").equals("add")){
				mImpl.save(sModule);
			}else {
				mImpl.update_module(sModule);
			}
			
			js.put("result", "0");
		} catch (Exception e) {
			js.put("result", "1");
			e.printStackTrace();
		}finally{
			return js.toString();
		}
	}
	/*
	 * 删除
	 */
	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping("/del_module")
	public String del_module(HttpServletRequest request){
		JSONObject js = new JSONObject();
		try {
			String node = request.getParameter("node");
			JSONObject jObject = JSONObject.fromObject(node);
			mImpl.del_module(Integer.parseInt(jObject.getString("module_id")));
			mImpl.delson_module(Integer.parseInt(jObject.getString("module_id")));//删除父节点的同时删除子节点
			js.put("result", "0");
		} catch (Exception e) {
			js.put("result", "1");
			e.printStackTrace();
		}finally{
			return js.toString();
		}

	}
}
