package com.kuaidu.nms.entity;

public class RecTitle {

	
	private Integer id;
	
	private String title;
	
	private Integer status;
	
	private String title_type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTitle_type() {
		return title_type;
	}

	public void setTitle_type(String title_type) {
		this.title_type = title_type;
	}

	public RecTitle(Integer id, String title, Integer status, String title_type) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
		this.title_type = title_type;
	}

	public RecTitle() {
		super();
	}

	@Override
	public String toString() {
		return "RecTitle [id=" + id + ", title=" + title + ", status=" + status + ", title_type=" + title_type + "]";
	}

	
}
