package com.kuaidu.nms.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/** 
 * @Title StatUserInfo.java 
 * @description TODO 
 * @time 2018年9月21日 下午5:37:22 
 * @author victor 
 * @version 1.0 
**/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatUserInfo {
	private int id;
	private String day_time;
	private Integer parent_id;
	private Integer partner_id;
	private String  partner_name;
	private int push_id;
	//女
	private int wm_new;
	private int wm_charged;
	private int wm_active;
	private int wm_sub;
	private int wm_unsub;
	//男
	private int m_new;
	private int m_charged;
	private int m_active;
	private int m_sub;
	private int m_unsub;
	//未知
	private int wz_new;
	private int wz_charged;
	private int wz_active;
	private int wz_sub;
	private int wz_unsub;
	
	private String start_date;
	private String end_date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDay_time() {
		return day_time;
	}
	public void setDay_time(String day_time) {
		this.day_time = day_time;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	public Integer getPartner_id() {
		return partner_id;
	}
	public void setPartner_id(Integer partner_id) {
		this.partner_id = partner_id;
	}
	public int getPush_id() {
		return push_id;
	}
	public void setPush_id(int push_id) {
		this.push_id = push_id;
	}
	public int getWm_new() {
		return wm_new;
	}
	public void setWm_new(int wm_new) {
		this.wm_new = wm_new;
	}
	public int getWm_charged() {
		return wm_charged;
	}
	public void setWm_charged(int wm_charged) {
		this.wm_charged = wm_charged;
	}
	public int getWm_active() {
		return wm_active;
	}
	public void setWm_active(int wm_active) {
		this.wm_active = wm_active;
	}
	public int getWm_sub() {
		return wm_sub;
	}
	public void setWm_sub(int wm_sub) {
		this.wm_sub = wm_sub;
	}
	public int getWm_unsub() {
		return wm_unsub;
	}
	public void setWm_unsub(int wm_unsub) {
		this.wm_unsub = wm_unsub;
	}
	public int getM_new() {
		return m_new;
	}
	public void setM_new(int m_new) {
		this.m_new = m_new;
	}
	public int getM_charged() {
		return m_charged;
	}
	public void setM_charged(int m_charged) {
		this.m_charged = m_charged;
	}
	public int getM_active() {
		return m_active;
	}
	public void setM_active(int m_active) {
		this.m_active = m_active;
	}
	public int getM_sub() {
		return m_sub;
	}
	public void setM_sub(int m_sub) {
		this.m_sub = m_sub;
	}
	public int getM_unsub() {
		return m_unsub;
	}
	public void setM_unsub(int m_unsub) {
		this.m_unsub = m_unsub;
	}
	public int getWz_new() {
		return wz_new;
	}
	public void setWz_new(int wz_new) {
		this.wz_new = wz_new;
	}
	public int getWz_charged() {
		return wz_charged;
	}
	public void setWz_charged(int wz_charged) {
		this.wz_charged = wz_charged;
	}
	public int getWz_active() {
		return wz_active;
	}
	public void setWz_active(int wz_active) {
		this.wz_active = wz_active;
	}
	public int getWz_sub() {
		return wz_sub;
	}
	public void setWz_sub(int wz_sub) {
		this.wz_sub = wz_sub;
	}
	public int getWz_unsub() {
		return wz_unsub;
	}
	public void setWz_unsub(int wz_unsub) {
		this.wz_unsub = wz_unsub;
	}
	
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public StatUserInfo(int id, String day_time, Integer parent_id, Integer partner_id, int push_id, int wm_new,
			int wm_charged, int wm_active, int wm_sub, int wm_unsub, int m_new, int m_charged, int m_active, int m_sub,
			int m_unsub, int wz_new, int wz_charged, int wz_active, int wz_sub, int wz_unsub) {
		super();
		this.id = id;
		this.day_time = day_time;
		this.parent_id = parent_id;
		this.partner_id = partner_id;
		this.push_id = push_id;
		this.wm_new = wm_new;
		this.wm_charged = wm_charged;
		this.wm_active = wm_active;
		this.wm_sub = wm_sub;
		this.wm_unsub = wm_unsub;
		this.m_new = m_new;
		this.m_charged = m_charged;
		this.m_active = m_active;
		this.m_sub = m_sub;
		this.m_unsub = m_unsub;
		this.wz_new = wz_new;
		this.wz_charged = wz_charged;
		this.wz_active = wz_active;
		this.wz_sub = wz_sub;
		this.wz_unsub = wz_unsub;
	}
	public StatUserInfo() {
		super();
	}
	@Override
	public String toString() {
		return "StatUserInfo [id=" + id + ", day_time=" + day_time + ", parent_id=" + parent_id + ", partner_id="
				+ partner_id + ", push_id=" + push_id + ", wm_new=" + wm_new + ", wm_charged=" + wm_charged
				+ ", wm_active=" + wm_active + ", wm_sub=" + wm_sub + ", wm_unsub=" + wm_unsub + ", m_new=" + m_new
				+ ", m_charged=" + m_charged + ", m_active=" + m_active + ", m_sub=" + m_sub + ", m_unsub=" + m_unsub
				+ ", wz_new=" + wz_new + ", wz_charged=" + wz_charged + ", wz_active=" + wz_active + ", wz_sub="
				+ wz_sub + ", wz_unsub=" + wz_unsub + "]";
	}
	public String getPartner_name() {
		return partner_name;
	}
	public void setPartner_name(String partner_name) {
		this.partner_name = partner_name;
	}
	
	
	
}