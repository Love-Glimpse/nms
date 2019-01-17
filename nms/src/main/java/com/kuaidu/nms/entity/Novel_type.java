package com.kuaidu.nms.entity;

public class Novel_type {
	private Integer type_id;
	private String type_desc;
	private String type_url;
	private String created_time;
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public String getType_desc() {
		return type_desc;
	}
	public void setType_desc(String type_desc) {
		this.type_desc = type_desc;
	}
	public String getType_url() {
		return type_url;
	}
	public void setType_url(String type_url) {
		this.type_url = type_url;
	}
	public String getCreated_time() {
		return created_time;
	}
	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}
	public Novel_type(Integer type_id, String type_desc, String type_url, String created_time) {
		super();
		this.type_id = type_id;
		this.type_desc = type_desc;
		this.type_url = type_url;
		this.created_time = created_time;
	}
	public Novel_type() {
		super();
	}
	
	
	
}
