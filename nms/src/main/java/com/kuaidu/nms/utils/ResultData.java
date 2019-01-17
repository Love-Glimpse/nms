package com.kuaidu.nms.utils;

import java.util.Collection;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ResultData {

	   public static String toJsonString(int totalCount, List<?> list) {  
		   	//如果数据集对象为null做个特殊处理
	        if(null == list) {  
	            JSONObject jsonResult = new JSONObject();  
	            jsonResult.put("total", totalCount);  
	            jsonResult.put("rows", new JSONArray());  
	            return jsonResult.toString();  
	        }  
	        if(!Collection.class.isAssignableFrom(list.getClass())) {  
	            JSONObject jsonResult = new JSONObject();  
	            jsonResult.put("total", totalCount);  
	            jsonResult.put("rows", list);  
	            return jsonResult.toString();  
	        }  
	      
	        JSONObject jsonResult = new JSONObject();  
	        jsonResult.put("total", totalCount);  
	        jsonResult.put("rows", list);  
	        JSONObject json=JSONObject.fromObject(jsonResult);
	        return json.toString();  
	    }
	   public static String toJsonString2(List<?> list) {  
		   //如果数据集对象为null做个特殊处理
		   if(null == list) {  
			   JSONObject jsonResult = new JSONObject();  
			   jsonResult.put("rows", new JSONArray());  
			   return jsonResult.toString();  
		   }  
		   if(!Collection.class.isAssignableFrom(list.getClass())) {  
			   JSONObject jsonResult = new JSONObject();  
			   jsonResult.put("rows", list);  
			   return jsonResult.toString();  
		   }  
		   
		   JSONObject jsonResult = new JSONObject();  
		   jsonResult.put("rows", list);  
		   JSONObject json=JSONObject.fromObject(jsonResult);
		   return json.toString();  
	   }
}
