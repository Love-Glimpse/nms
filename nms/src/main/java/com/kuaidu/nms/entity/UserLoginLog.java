package com.kuaidu.nms.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserLoginLog {

	private Integer id;

	private Integer user_id;

	private String mail;

	private String ip;

	private String modle;// 手机型号

	private String browser;// 浏览器

	private String os_name; // 操作系统

	private String region;

	private String city;

	private Integer online_time;;

	private Integer read_time;

	private String login_time;

	private String picture;

	private Date create_time;

	private Integer start_rows; // 起始行
	private Integer end_rows; // 末尾行

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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getModle() {
		return modle;
	}

	public void setModle(String modle) {
		this.modle = modle;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getOs_name() {
		return os_name;
	}

	public void setOs_name(String os_name) {
		this.os_name = os_name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getOnline_time() {
		return online_time;
	}

	public void setOnline_time(Integer online_time) {
		this.online_time = online_time;
	}

	public Integer getRead_time() {
		return read_time;
	}

	public void setRead_time(Integer read_time) {
		this.read_time = read_time;
	}

	public String getLogin_time() {
		return login_time;
	}

	public void setLogin_time(String login_time) {
		this.login_time = login_time;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
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

	@Override
	public String toString() {
		return "UserLoginLog [id=" + id + ", user_id=" + user_id + ", mail=" + mail + ", ip=" + ip + ", modle=" + modle
				+ ", browser=" + browser + ", os_name=" + os_name + ", region=" + region + ", city=" + city
				+ ", online_time=" + online_time + ", read_time=" + read_time + ", login_time=" + login_time
				+ ", picture=" + picture + ", create_time=" + create_time + ", start_rows=" + start_rows + ", end_rows="
				+ end_rows + "]";
	}

	
}