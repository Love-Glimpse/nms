package com.kuaidu.nms.entity;

/** 
 * @Title WxTemplateMsg.java 
 * @description TODO 
 * @time 2018年11月1日 下午5:17:21 
 * @author victor 
 * @version 1.0 
**/
public class WxTemplateMsg {
	private int id;
	private int user_id;
	private int parent_id;
	private String to_user;
	private String template_id;
	private String url;
	private String data;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getTo_user() {
		return to_user;
	}
	public void setTo_user(String to_user) {
		this.to_user = to_user;
	}
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public WxTemplateMsg(int id, int user_id, int parent_id, String to_user, String template_id, String url,
			String data) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.parent_id = parent_id;
		this.to_user = to_user;
		this.template_id = template_id;
		this.url = url;
		this.data = data;
	}
	public WxTemplateMsg() {
		super();
	}
	@Override
	public String toString() {
		return "WxTemplateMsg [id=" + id + ", user_id=" + user_id + ", parent_id=" + parent_id + ", to_user=" + to_user
				+ ", template_id=" + template_id + ", url=" + url + ", data=" + data + "]";
	}
	
}
