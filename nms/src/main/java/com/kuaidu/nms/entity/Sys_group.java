package com.kuaidu.nms.entity;

public class Sys_group {
	private int group_id;
	private String group_name;
	private String group_desc;
	private String created_time;
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getGroup_desc() {
		return group_desc;
	}
	public void setGroup_desc(String group_desc) {
		this.group_desc = group_desc;
	}
	public String getCreated_time() {
		return created_time;
	}
	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}
	public Sys_group(int group_id, String group_name, String group_desc, String created_time) {
		super();
		this.group_id = group_id;
		this.group_name = group_name;
		this.group_desc = group_desc;
		this.created_time = created_time;
	}
	@Override
	public String toString() {
		return "Sys_group [group_id=" + group_id + ", group_name=" + group_name + ", group_desc=" + group_desc
				+ ", created_time=" + created_time + "]";
	}
	public Sys_group() {
		super();
	}
	
}
