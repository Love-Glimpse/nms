package com.kuaidu.nms.entity;

/** 
 * @Title PartnerKeyword.java 
 * @description TODO 
 * @time 2018年11月7日 下午3:02:22 
 * @author victor 
 * @version 1.0 
**/
public class PartnerKeyword {
	private Integer id;
	private Integer partner_id;
	private String key_word;
	private Integer status;
	private Integer reply_type;
	private String url;
	private String create_time;
	private String title;
	private String description;
	private String pic_url;
	private String msg_type;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPartner_id() {
		return partner_id;
	}
	public void setPartner_id(Integer partner_id) {
		this.partner_id = partner_id;
	}
	public String getKey_word() {
		return key_word;
	}
	public void setKey_word(String key_word) {
		this.key_word = key_word;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getReply_type() {
		return reply_type;
	}
	public void setReply_type(Integer reply_type) {
		this.reply_type = reply_type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPic_url() {
		return pic_url;
	}
	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}
	public String getMsg_type() {
		return msg_type;
	}
	public void setMsg_type(String msg_type) {
		this.msg_type = msg_type;
	}
	public PartnerKeyword(Integer id, Integer partner_id, String key_word, Integer status, Integer reply_type,
			String url, String create_time, String title, String description, String pic_url, String msg_type) {
		super();
		this.id = id;
		this.partner_id = partner_id;
		this.key_word = key_word;
		this.status = status;
		this.reply_type = reply_type;
		this.url = url;
		this.create_time = create_time;
		this.title = title;
		this.description = description;
		this.pic_url = pic_url;
		this.msg_type = msg_type;
	}
	public PartnerKeyword() {
		super();
	}
	@Override
	public String toString() {
		return "PartnerKeyword [id=" + id + ", partner_id=" + partner_id + ", key_word=" + key_word + ", status="
				+ status + ", reply_type=" + reply_type + ", url=" + url + ", create_time=" + create_time + ", title="
				+ title + ", description=" + description + ", pic_url=" + pic_url + ", msg_type=" + msg_type + "]";
	}

}
