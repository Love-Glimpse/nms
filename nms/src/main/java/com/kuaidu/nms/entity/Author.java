package com.kuaidu.nms.entity;

public class Author {
	private Integer author_id;
	private String author_name;
	private String penname;
	private Integer group_type;
	private Integer start_rows;  //起始行
	private Integer end_rows;	//末尾行
	
	public Integer getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(Integer author_id) {
		this.author_id = author_id;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public String getPenname() {
		return penname;
	}
	public void setPenname(String penname) {
		this.penname = penname;
	}
	public Integer getGroup_type() {
		return group_type;
	}
	public void setGroup_type(Integer group_type) {
		this.group_type = group_type;
	}
	
	public Integer getStart_rows() {
		return start_rows;
	}
	public void setStart_rows(Integer start_rows) {
		this.start_rows = start_rows;
	}
	public Integer getEnd_rows() {
		return end_rows;
	}
	public void setEnd_rows(Integer end_rows) {
		this.end_rows = end_rows;
	}
	
	public Author(Integer author_id, String author_name, String penname, Integer group_type, Integer start_rows,
			Integer end_rows) {
		super();
		this.author_id = author_id;
		this.author_name = author_name;
		this.penname = penname;
		this.group_type = group_type;
		this.start_rows = start_rows;
		this.end_rows = end_rows;
	}
	public Author() {
		super();
	}
	
}
