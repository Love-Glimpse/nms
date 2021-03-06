package com.kuaidu.nms.entity;

public class ExternalPushPonfig {

	private Integer id;
	private Integer push_id;
	private Integer partner_id;
	private String head_pic_url;
	private String reply_keyword;
	private String foot_pic_url;
	private String redirect_url;
	private String status;
	private String create_time;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPush_id() {
		return push_id;
	}
	public void setPush_id(Integer push_id) {
		this.push_id = push_id;
	}
	public Integer getPartner_id() {
		return partner_id;
	}
	public void setPartner_id(Integer partner_id) {
		this.partner_id = partner_id;
	}
	public String getHead_pic_url() {
		return head_pic_url;
	}
	public void setHead_pic_url(String head_pic_url) {
		this.head_pic_url = head_pic_url;
	}
	public String getReply_keyword() {
		return reply_keyword;
	}
	public void setReply_keyword(String reply_keyword) {
		this.reply_keyword = reply_keyword;
	}
	public String getFoot_pic_url() {
		return foot_pic_url;
	}
	public void setFoot_pic_url(String foot_pic_url) {
		this.foot_pic_url = foot_pic_url;
	}
	public String getRedirect_url() {
		return redirect_url;
	}
	public void setRedirect_url(String redirect_url) {
		this.redirect_url = redirect_url;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public ExternalPushPonfig(Integer id, Integer push_id, Integer partner_id, String head_pic_url,
			String reply_keyword, String foot_pic_url, String redirect_url, String status, String create_time) {
		super();
		this.id = id;
		this.push_id = push_id;
		this.partner_id = partner_id;
		this.head_pic_url = head_pic_url;
		this.reply_keyword = reply_keyword;
		this.foot_pic_url = foot_pic_url;
		this.redirect_url = redirect_url;
		this.status = status;
		this.create_time = create_time;
	}
	public ExternalPushPonfig() {
		super();
	}
	@Override
	public String toString() {
		return "external_push_config [id=" + id + ", push_id=" + push_id + ", partner_id=" + partner_id
				+ ", head_pic_url=" + head_pic_url + ", reply_keyword=" + reply_keyword + ", foot_pic_url="
				+ foot_pic_url + ", redirect_url=" + redirect_url + ", status=" + status + ", create_time="
				+ create_time + "]";
	}
	
	
}
