package com.kuaidu.nms.config;

import java.util.HashMap;
import java.util.List;

public class LayuiResult {
	
	
	
	public static HashMap<String, Object> success(Integer count,String msg,List<?> data){
		HashMap<String, Object> map = new HashMap<>();
		map.put("code", 0);
		map.put("count", count);
		map.put("msg", msg);
		map.put("data", data);
		return map;
		
	}
	
	public static HashMap<String, ?> success(Integer count,List<?> data){
		HashMap<String, Object> map = new HashMap<>();
		map.put("code", 0);
		map.put("count", count);
		map.put("msg", "");
		map.put("data", data);
		return map;
		
	}
	
	public static HashMap<String, Object> fail(){
		HashMap<String, Object> map = new HashMap<>();
		map.put("code", 1);
		map.put("count", 0);
		map.put("msg", "");
		map.put("data", null);
		return map;
		
	}
	
	
	
	public static HashMap<String, Object> fail(Integer count,String msg){
		HashMap<String, Object> map = new HashMap<>();
		map.put("code", 1);
		map.put("count", count);
		map.put("msg", msg);
		map.put("data", null);
		return map;
		
	}

}
