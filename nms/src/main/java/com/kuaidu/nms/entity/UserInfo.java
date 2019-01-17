package com.kuaidu.nms.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfo {
	private Integer user_id;
	private String login_name;
	private String password;
	private Integer login_type;
	private Integer sex;
	private String nick_name;
	private String mail;
	private String mobile;
	private Integer group_id;
	private Integer vip_type;
	private String vip_start_date;
	private String vip_end_date;
	private Integer user_status;
	private Integer user_point;
	private String promoters_name;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date created_time;
	private String last_login_time;
	private Integer push_id;
	private String picture;
	private Integer partner_id;
	private Integer parent_id;
	private String partner_name;
	private String parent_name;
	private Integer online;
	private String openid;
	private String unionid;
	private Integer subscribe;
	private String push_name;
	private String book_name;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date subscribe_time;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date unsubscribe_time;
	private Integer charge_point;
	private String total_recharge_amount;
	private Integer start_rows;  //起始行
	private Integer end_rows;	//末尾行
	private String start_time;
	private String end_time;
	
	private Integer kl_flag;

	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getLogin_type() {
		return login_type;
	}
	public void setLogin_type(Integer login_type) {
		this.login_type = login_type;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getGroup_id() {
		return group_id;
	}
	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}
	public Integer getVip_type() {
		return vip_type;
	}
	public void setVip_type(Integer vip_type) {
		this.vip_type = vip_type;
	}
	public String getVip_start_date() {
		return vip_start_date;
	}
	public void setVip_start_date(String vip_start_date) {
		this.vip_start_date = vip_start_date;
	}
	public String getVip_end_date() {
		return vip_end_date;
	}
	public void setVip_end_date(String vip_end_date) {
		this.vip_end_date = vip_end_date;
	}
	public Integer getUser_status() {
		return user_status;
	}
	public void setUser_status(Integer user_status) {
		this.user_status = user_status;
	}
	public Integer getUser_point() {
		return user_point;
	}
	public void setUser_point(Integer user_point) {
		this.user_point = user_point;
	}
	public String getPromoters_name() {
		return promoters_name;
	}
	public void setPromoters_name(String promoters_name) {
		this.promoters_name = promoters_name;
	}
	
	public Date getCreated_time() {
		return created_time;
	}
	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}
	public String getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(String last_login_time) {
		this.last_login_time = last_login_time;
	}
	public Integer getPush_id() {
		return push_id;
	}
	public void setPush_id(Integer push_id) {
		this.push_id = push_id;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getPartner_name() {
		return partner_name;
	}
	public void setPartner_name(String partner_name) {
		this.partner_name = partner_name;
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
	
	
	
	public Integer getOnline() {
		return online;
	}
	public void setOnline(Integer online) {
		this.online = online;
	}
	
	
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public Integer getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(Integer subscribe) {
		this.subscribe = subscribe;
	}

	public String getPush_name() {
		return push_name;
	}
	public void setPush_name(String push_name) {
		this.push_name = push_name;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public UserInfo() {
		super();
	}
	public String getParent_name() {
		return parent_name;
	}
	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}
	
	
	
	public Date getSubscribe_time() {
		return subscribe_time;
	}
	public void setSubscribe_time(Date subscribe_time) {
		this.subscribe_time = subscribe_time;
	}
	public Integer getCharge_point() {
		return charge_point;
	}
	public void setCharge_point(Integer charge_point) {
		this.charge_point = charge_point;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	public Integer getPartner_id() {
		return partner_id;
	}
	public void setPartner_id(Integer partner_id) {
		this.partner_id = partner_id;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	
	
	public Integer getKl_flag() {
		return kl_flag;
	}
	public void setKl_flag(Integer kl_flag) {
		this.kl_flag = kl_flag;
	}
	public UserInfo(Integer user_id, String login_name, String password, Integer login_type, Integer sex,
			String nick_name, String mail, String mobile, Integer group_id, Integer vip_type, String vip_start_date,
			String vip_end_date, Integer user_status, Integer user_point, String promoters_name, Date created_time,
			String last_login_time, Integer push_id, String picture, Integer partner_id, Integer parent_id,
			String partner_name, String parent_name, Integer online, String openid, String unionid, Integer subscribe,
			String push_name, String book_name, String subscribe_time, Integer charge_point, Integer start_rows,
			Integer end_rows) {
		super();
		this.user_id = user_id;
		this.login_name = login_name;
		this.password = password;
		this.login_type = login_type;
		this.sex = sex;
		this.nick_name = nick_name;
		this.mail = mail;
		this.mobile = mobile;
		this.group_id = group_id;
		this.vip_type = vip_type;
		this.vip_start_date = vip_start_date;
		this.vip_end_date = vip_end_date;
		this.user_status = user_status;
		this.user_point = user_point;
		this.promoters_name = promoters_name;
		this.created_time = created_time;
		this.last_login_time = last_login_time;
		this.push_id = push_id;
		this.picture = picture;
		this.partner_id = partner_id;
		this.parent_id = parent_id;
		this.partner_name = partner_name;
		this.parent_name = parent_name;
		this.online = online;
		this.openid = openid;
		this.unionid = unionid;
		this.subscribe = subscribe;
		this.push_name = push_name;
		this.book_name = book_name;
		this.charge_point = charge_point;
		this.start_rows = start_rows;
		this.end_rows = end_rows;
	}
	
	public Date getUnsubscribe_time() {
		return unsubscribe_time;
	}
	public void setUnsubscribe_time(Date unsubscribe_time) {
		this.unsubscribe_time = unsubscribe_time;
	}
	public String getTotal_recharge_amount() {
		return total_recharge_amount;
	}
	public void setTotal_recharge_amount(String total_recharge_amount) {
		this.total_recharge_amount = total_recharge_amount;
	}
	
}