package com.kuaidu.nms.systemManage.controller;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kuaidu.nms.entity.Sys_group;
import com.kuaidu.nms.entity.Sys_module;
import com.kuaidu.nms.entity.Sys_user;
import com.kuaidu.nms.system.serviceImpl.UserMapperImpl;
import com.kuaidu.nms.utils.ResultData;
import com.kuaidu.nms.utils.Utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
//表明该类是一个controller。
@Controller
@RequestMapping("/user")
public class UserManage {
	@Autowired
	private	 UserMapperImpl uImpl;
	
	
	public UserMapperImpl getuImpl() {
		return uImpl;
	}

	public void setuImpl(UserMapperImpl uImpl) {
		this.uImpl = uImpl;
	}

	@RequestMapping("/userIndex")
	public ModelAndView foreignAllManageIndex(HttpSession session){
		ModelAndView mv = new ModelAndView();
		try {
			List<Sys_group> sys_groups = uImpl.getSysGroups();
			mv.addObject("groups", sys_groups);
			mv.setViewName("System/user"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/getAll")
	public String getAll(HttpServletRequest request) throws UnknownHostException{
		String user_name = request.getParameter("user_name");
		List<Sys_user> list = uImpl.getAll(user_name);
		return ResultData.toJsonString(list.size(), list);
	}
	/*
	 * 删除用户
	 */
	//suppresswarnings：抑制finally警告
	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping("/del_user")
	public String del_user(HttpServletRequest request) throws UnknownHostException{
		String node =request.getParameter("node");
		JSONObject jsonObject = new JSONObject();
		JSONArray jArray = new JSONArray();
		try {
			JSONArray jsonArray = JSONArray.fromObject(node);  
	        List<Object> list= new ArrayList<Object>();
	        for(int i=0;i<jsonArray.size();i++){
	            list.add(jsonArray.get(i));
	        }
	        uImpl.del_user(list);
	        jsonObject.put("result", "0");
	        
		} catch (Exception e) {
			 jsonObject.put("result", "1");
			e.printStackTrace();
			
			// TODO: handle exception
		}finally {
			jArray.add(jsonObject.toString());
			return jArray.toString();
		}
	}
	/*
	 * 新增用户,编辑用户
	 */
	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping("/save_user")
	public String save_user(Sys_user sys_user) throws UnknownHostException{
		JSONObject json = new JSONObject();
		try {
			if(sys_user.getUser_id()==null || "".equals(sys_user.getUser_id())){

				uImpl.save_user(sys_user);
			}else{
				uImpl.edit_user(sys_user);
			}
			//成功
			json.put("result", "0");
		} catch (Exception e) {
			json.put("result", "1");
			e.printStackTrace();
		}finally{
			return json.toString();
		}
	}
	
	/*
	 * 树形菜单
	 */

	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping("/getAllTree")
	public String getAllTree(HttpServletRequest request) throws UnknownHostException{
		JSONObject json1 = new JSONObject();
		JSONObject json2 = new JSONObject();
		JSONArray jArray1 = new JSONArray();
		JSONArray jArray2 = new JSONArray();
		
		String user_id = request.getParameter("user_id");
         List<Sys_module> list = uImpl.getAllTree(Integer.parseInt(user_id));
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
						json3.put("id", module.getModule_id());
						json3.put("text", module.getModule_name());
						if(module.getFlag()!=null){
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
	 * 修改用户权限
	 */
	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping("/save_authority")
	public String save_authority(HttpServletRequest request,HttpSession session){
		Integer user_id = Integer.parseInt(request.getParameter("user_id"));
		String node = request.getParameter("node");
		JSONObject jsonObject = new JSONObject();
		JSONArray jArray = new JSONArray();
		try {
			uImpl.del_user_module(user_id);
			JSONArray jsonArray = JSONArray.fromObject(node);
			String module_id="";
	        for(int i=0;i<jsonArray.size();i++){
	        	
	        	 module_id = jsonArray.get(i).toString();
	        	 if(!module_id.equals("0")){
	        	   uImpl.save_authority(user_id, Integer.parseInt(module_id));
	        	 }

	          jsonObject.put("result", "0");
	        }
	        
		} catch (Exception e) {
			jsonObject.put("result", "1");
			e.printStackTrace();
			
		}finally{
			jArray.add(jsonObject);
			return jArray.toString();
		}
	}
	/*
	 * 修改用户权限
	 */
	@ResponseBody
	@RequestMapping("changeStatus")
	public JSONObject changeStatus(HttpServletRequest request,HttpSession session,Sys_user user){
		JSONObject jsonRet = new JSONObject();
		int ret =  uImpl.changeStatus(user);
		jsonRet.put("result", ret);
		return jsonRet;
	}
	/**
	 * @return
	 * 0:内部错误
	 * 10 ：用户ID错误
	 * 11：密码验证错误
	 * 12:登录错误
	 * 14：其他错误
	 * 13:权限不够
	 * 20：成功
	 * 修改用户密码
	* */
	@ResponseBody
	@RequestMapping("changePwd")
	public JSONObject changePwd(HttpSession session,@RequestParam("s_pwd")String s_pwd,
			@RequestParam("n_pwd") String n_pwd,@RequestParam("flag") int flag,@RequestParam("id") int id){
		JSONObject jsonRet = new JSONObject();
		int ret = 1;
		String login_flag = (String) session.getAttribute("login_flag");
		if (null==login_flag||!login_flag.equalsIgnoreCase("system")) {
			jsonRet.put("result", 12);//
		}else if (login_flag.equalsIgnoreCase("system")&&flag == 1) {//系统登录,修改自己密码
			Sys_user sUser = Utils.getSysUserFromSession(session);
			if (sUser!=null&&sUser.getUser_id()==id) {
				//验证原密码
				if (uImpl.checkSysUser(id,s_pwd)>0) {
					//开始修改
					ret = uImpl.changeSysPwd(id,n_pwd,s_pwd);
					jsonRet.put("result", ret);//修改成功
					session.removeAttribute("login_flag");
					session.removeAttribute("user");
				}else {
					jsonRet.put("result", 11);//密码验证 错误
				}
			}else {
				jsonRet.put("result", 10);//user_id 错误
			}
		}else if (login_flag.equalsIgnoreCase("system")&&flag == 2) {//系统登录,管理员修改密码
			Sys_user sUser = Utils.getSysUserFromSession(session);
			if (sUser!=null&&sUser.getGroup_id()==1){
				//开始修改
				ret = uImpl.changeSysPwd(id,n_pwd,s_pwd);
				jsonRet.put("result", ret);//修改成功
			}else {
				jsonRet.put("result", 13);//权限不够
			}
		}else {
			jsonRet.put("result", 14);//其他错误
		}
		return jsonRet;
	}
	
}
