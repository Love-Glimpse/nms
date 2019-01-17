package com.kuaidu.nms.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserReadLog {
	private Integer id;
	private Integer user_id;
	private Integer type_id;
	private Integer book_id;
	private String book_name;
	private Integer chapter_id;
	private String chapter_name;
	
	private Integer chapter_num;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date create_time;
	private String nick_name;
	private String picture;
	
	private Integer type;
	private Integer read_time;
	
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
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public Integer getChapter_id() {
		return chapter_id;
	}
	public void setChapter_id(Integer chapter_id) {
		this.chapter_id = chapter_id;
	}
	public String getChapter_name() {
		return chapter_name;
	}
	public void setChapter_name(String chapter_name) {
		this.chapter_name = chapter_name;
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
	
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	
	
	
	public Integer getChapter_num() {
		return chapter_num;
	}
	public void setChapter_num(Integer chapter_num) {
		this.chapter_num = chapter_num;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getRead_time() {
		return read_time;
	}
	public void setRead_time(Integer read_time) {
		this.read_time = read_time;
	}
	public UserReadLog(Integer id, Integer user_id, Integer type_id, Integer book_id, String book_name,
			Integer chapter_id, String chapter_name, Date create_time, String nick_name, Integer start_rows,
			Integer end_rows) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.type_id = type_id;
		this.book_id = book_id;
		this.book_name = book_name;
		this.chapter_id = chapter_id;
		this.chapter_name = chapter_name;
		this.create_time = create_time;
		this.nick_name = nick_name;
		this.start_rows = start_rows;
		this.end_rows = end_rows;
	}
	public UserReadLog() {
		super();
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
}


