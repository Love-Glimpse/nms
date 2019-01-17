package com.kuaidu.nms.entity;

/** 
 * @Title CustomMsg.java 
 * @description TODO 
 * @time 2018年10月30日 下午4:26:04 
 * @author victor 
 * @version 1.0 
**/
public class WxCustomMsg {
	private int id;
	private int partner_id;
	private int p_msg_id;
	private int user_id;
	private int book_id;
	private String to_user;
	private String type;
	private String msg_type;
	private String title;
	private String description;
	private String url;
	private String pic_url;
	private int send_status;
	private String create_time;
	private String send_time;
	private int is_last;//是否是最后一个 0 不是 1是
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPartner_id() {
		return partner_id;
	}
	public void setPartner_id(int partner_id) {
		this.partner_id = partner_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getTo_user() {
		return to_user;
	}
	public void setTo_user(String to_user) {
		this.to_user = to_user;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMsg_type() {
		return msg_type;
	}
	public void setMsg_type(String msg_type) {
		this.msg_type = msg_type;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPic_url() {
		return pic_url;
	}
	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}
	public int getSend_status() {
		return send_status;
	}
	public void setSend_status(int send_status) {
		this.send_status = send_status;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getSend_time() {
		return send_time;
	}
	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}
	public int getP_msg_id() {
		return p_msg_id;
	}
	public void setP_msg_id(int p_msg_id) {
		this.p_msg_id = p_msg_id;
	}
	public WxCustomMsg(int id, int partner_id, int p_msg_id, int user_id, int book_id, String to_user, String type,
			String msg_type, String title, String description, String url, String pic_url, int send_status,
			String create_time, String send_time) {
		super();
		this.id = id;
		this.partner_id = partner_id;
		this.p_msg_id = p_msg_id;
		this.user_id = user_id;
		this.book_id = book_id;
		this.to_user = to_user;
		this.type = type;
		this.msg_type = msg_type;
		this.title = title;
		this.description = description;
		this.url = url;
		this.pic_url = pic_url;
		this.send_status = send_status;
		this.create_time = create_time;
		this.send_time = send_time;
	}
	public WxCustomMsg() {
		super();
	}
	@Override
	public String toString() {
		return "WxCustomMsg [id=" + id + ", partner_id=" + partner_id + ", p_msg_id=" + p_msg_id + ", user_id="
				+ user_id + ", book_id=" + book_id + ", to_user=" + to_user + ", type=" + type + ", msg_type="
				+ msg_type + ", title=" + title + ", description=" + description + ", url=" + url + ", pic_url="
				+ pic_url + ", send_status=" + send_status + ", create_time=" + create_time + ", send_time=" + send_time
				+ "]";
	}
	public int getIs_last() {
		return is_last;
	}
	public void setIs_last(int is_last) {
		this.is_last = is_last;
	}
	
}
