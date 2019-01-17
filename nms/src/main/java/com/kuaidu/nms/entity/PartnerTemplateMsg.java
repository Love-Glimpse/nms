package com.kuaidu.nms.entity;

import javax.persistence.Id;

public class PartnerTemplateMsg {

	@Id
	private Integer template_msg_id;
	private Integer partner_id;
	private String task_name;
	private String url;
	
	private String template_id;

	private String data;
	private Integer vip_type;
	private String sex;
	private String point_level;
	private String sub_time;
	private String send_time;
	private Integer send_status;
	private String create_time;

	public Integer getTemplate_msg_id() {
		return template_msg_id;
	}

	public void setTemplate_msg_id(Integer template_msg_id) {
		this.template_msg_id = template_msg_id;
	}

	public Integer getPartner_id() {
		return partner_id;
	}

	public void setPartner_id(Integer partner_id) {
		this.partner_id = partner_id;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getVip_type() {
		return vip_type;
	}
	

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public void setVip_type(Integer vip_type) {
		this.vip_type = vip_type;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPoint_level() {
		return point_level;
	}

	public void setPoint_level(String point_level) {
		this.point_level = point_level;
	}

	public String getSub_time() {
		return sub_time;
	}

	public void setSub_time(String sub_time) {
		this.sub_time = sub_time;
	}

	public String getSend_time() {
		return send_time;
	}

	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}

	public Integer getSend_status() {
		return send_status;
	}

	public void setSend_status(Integer send_status) {
		this.send_status = send_status;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	@Override
	public String toString() {
		return "PartnerTemplateMsg [template_msg_id=" + template_msg_id + ", partner_id=" + partner_id + ", task_name="
				+ task_name + ", url=" + url + ", template_id=" + template_id + ", data=" + data + ", vip_type="
				+ vip_type + ", sex=" + sex + ", point_level=" + point_level + ", sub_time=" + sub_time + ", send_time="
				+ send_time + ", send_status=" + send_status + ", create_time=" + create_time + "]";
	}

	
}
