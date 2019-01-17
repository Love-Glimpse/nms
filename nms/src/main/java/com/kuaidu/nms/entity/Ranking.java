package com.kuaidu.nms.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ranking {

	private Integer id;

	private String book_name;

	private String small_pic;

	private Integer book_id;

	private Integer type;

	
	private Integer words;
	

	private Integer hits;
	
	private String create_time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getSmall_pic() {
		return small_pic;
	}

	public void setSmall_pic(String small_pic) {
		this.small_pic = small_pic;
	}

	public Integer getBook_id() {
		return book_id;
	}

	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getWords() {
		return words;
	}

	public void setWords(Integer words) {
		this.words = words;
	}

	public Integer getHits() {
		return hits;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	@Override
	public String toString() {
		return "Ranking [id=" + id + ", book_name=" + book_name + ", small_pic=" + small_pic + ", book_id=" + book_id
				+ ", type=" + type + ", words=" + words + ", hits=" + hits + ", create_time=" + create_time + "]";
	}
	
	
	

	

	
	
	

	
}
