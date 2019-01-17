package com.kuaidu.nms.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/** 
 * @Title MessageLog.java 
 * @description TODO 
 * @time 2018年12月26日 下午2:30:35 
 * @author victor 
 * @version 1.0 
**/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageLog {
	private Integer id;
	private Integer user_id;
	private Integer flag;
	private String msg_type;
	private String content;
	private String pic_url;
	private String create_time;
	private Integer start_rows;  //起始行
	private Integer rows;
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
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getMsg_type() {
		return msg_type;
	}
	public void setMsg_type(String msg_type) {
		this.msg_type = msg_type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPic_url() {
		return pic_url;
	}
	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

	
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public Integer getStart_rows() {
		return start_rows;
	}
	public void setStart_rows(Integer start_rows) {
		this.start_rows = start_rows;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}


	public MessageLog(Integer id, Integer user_id, Integer flag, String msg_type, String content, String pic_url,
			String create_time, Integer start_rows, Integer rows) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.flag = flag;
		this.msg_type = msg_type;
		this.content = content;
		this.pic_url = pic_url;
		this.create_time = create_time;
		this.start_rows = start_rows;
		this.rows = rows;
	}
	public MessageLog() {
		super();
	}
	@Override
	public String toString() {
		return "MessageLog [id=" + id + ", user_id=" + user_id + ", flag=" + flag + ", msg_type=" + msg_type
				+ ", content=" + content + ", pic_url=" + pic_url + ", create_time=" + create_time + ", start_rows="
				+ start_rows + ", rows=" + rows + "]";
	}

}
