package com.kuaidu.nms.entity;

public class PartnerGroup {
	private Integer group_id;
	private String group_name;
	private String privilege;
	private String group_desc;
	private String created_time;
	private Integer page;
	private Integer rows;
	public Integer getGroup_id() {
		return group_id;
	}
	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
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
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "PartnerGroup [group_id=" + group_id + ", group_name=" + group_name + ", privilege=" + privilege
				+ ", group_desc=" + group_desc + ", created_time=" + created_time + ", page=" + page + ", rows=" + rows
				+ "]";
	}

	public PartnerGroup(Integer group_id, String group_name, String privilege, String group_desc, String created_time,
			Integer page, Integer rows) {
		super();
		this.group_id = group_id;
		this.group_name = group_name;
		this.privilege = privilege;
		this.group_desc = group_desc;
		this.created_time = created_time;
		this.page = page;
		this.rows = rows;
	}
	public PartnerGroup() {
		super();
	}

}
