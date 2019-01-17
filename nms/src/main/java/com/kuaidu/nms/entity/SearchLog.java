package com.kuaidu.nms.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchLog {

	private Integer id;

	private String book_name;
	
	private Integer user_id;
	
	private String nick_name;
	
	private String picture;
	


	private Integer start_rows; // 起始行
	
	private Integer count;
	private Integer end_rows;

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date create_date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getBook_name() {
		return book_name;
	}
	
	

	

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}


	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
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

	

	

	

	

	

	
	
}
