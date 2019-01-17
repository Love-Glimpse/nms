package com.kuaidu.nms.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserProposal {
	private Integer id;
	private Integer user_id;
	private String content;
	private Integer status;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date create_time;
	private String nick_name;
	private String book_name;
	private String chapter_name;
	private String picture;
	private Integer start_rows;  //起始行
	private Integer end_rows;	//末尾行
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
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


	public UserProposal(Integer id, Integer user_id, String content, Integer status, Date create_time,
			String nick_name, String book_name, String chapter_name, Integer start_rows, Integer end_rows) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.content = content;
		this.status = status;
		this.create_time = create_time;
		this.nick_name = nick_name;
		this.book_name = book_name;
		this.chapter_name = chapter_name;
		this.start_rows = start_rows;
		this.end_rows = end_rows;
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
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getChapter_name() {
		return chapter_name;
	}
	public void setChapter_name(String chapter_name) {
		this.chapter_name = chapter_name;
	}
	public UserProposal() {
		super();
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
	
}