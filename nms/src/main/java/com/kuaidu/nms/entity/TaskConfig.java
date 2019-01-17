package com.kuaidu.nms.entity;

public class TaskConfig {
	private Integer id;
	private String ip_address;
	private String domain;
	private Integer book_id;
	private String down_count;
	private int status;
	private String created_time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}
	public String getDown_count() {
		return down_count;
	}
	public void setDown_count(String down_count) {
		this.down_count = down_count;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCreated_time() {
		return created_time;
	}
	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}
	public TaskConfig(Integer id, String ip_address, String domain, Integer book_id, String down_count, int status,
			String created_time) {
		super();
		this.id = id;
		this.ip_address = ip_address;
		this.domain = domain;
		this.book_id = book_id;
		this.down_count = down_count;
		this.status = status;
		this.created_time = created_time;
	}
	public TaskConfig() {
		super();
	}
	@Override
	public String toString() {
		return "TaskConfig [id=" + id + ", ip_address=" + ip_address + ", domain=" + domain + ", book_id=" + book_id
				+ ", down_count=" + down_count + ", status=" + status + ", created_time=" + created_time + "]";
	}
	
}
