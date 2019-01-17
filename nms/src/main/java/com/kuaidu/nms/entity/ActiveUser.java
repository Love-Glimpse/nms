package com.kuaidu.nms.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/** 
 * @Title 活跃用户
 * @description TODO 
 * @time 2018年11月26日 上午9:44:12 
 * @author victor 
 * @version 1.0 
**/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActiveUser {
    private	String active_date;
    private	String create_date;
    private	int parent_id;
    private	int partner_id;
    private	int push_id;
    private int user_id;
    private	String partner_name;
    private	String nick_name;
    private	String push_name;
    private	String picture;
    private int active_count;
	public String getActive_date() {
		return active_date;
	}
	public void setActive_date(String active_date) {
		this.active_date = active_date;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public int getPartner_id() {
		return partner_id;
	}
	public void setPartner_id(int partner_id) {
		this.partner_id = partner_id;
	}
	public int getPush_id() {
		return push_id;
	}
	public void setPush_id(int push_id) {
		this.push_id = push_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getPartner_name() {
		return partner_name;
	}
	public void setPartner_name(String partner_name) {
		this.partner_name = partner_name;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getPush_name() {
		return push_name;
	}
	public void setPush_name(String push_name) {
		this.push_name = push_name;
	}
	public int getActive_count() {
		return active_count;
	}
	public void setActive_count(int active_count) {
		this.active_count = active_count;
	}
	public ActiveUser(String active_date, String create_date, int parent_id, int partner_id, int push_id, int user_id,
			String partner_name, String nick_name, String push_name, int active_count) {
		super();
		this.active_date = active_date;
		this.create_date = create_date;
		this.parent_id = parent_id;
		this.partner_id = partner_id;
		this.push_id = push_id;
		this.user_id = user_id;
		this.partner_name = partner_name;
		this.nick_name = nick_name;
		this.push_name = push_name;
		this.active_count = active_count;
	}
	public ActiveUser() {
		super();
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
    
}
