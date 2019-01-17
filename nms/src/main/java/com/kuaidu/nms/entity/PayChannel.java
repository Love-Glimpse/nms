package com.kuaidu.nms.entity;

import java.math.BigDecimal;

public class PayChannel {
	
	private Integer channel_id;
	
	private String channel_name;
	
	private Integer payee_id;
	
	private String payee_name;
	
	private BigDecimal discount;
	
	private Integer pay_type;
	
	private Integer order_num;
	
	private Integer limit_count;
	
	private Integer limit_amount;
	
	private Integer everyday_status;
	
	private Integer status;
	
	private String create_time;
	
	private Integer start_rows;
	
	private Integer rows;
	
	private Integer page;


	public Integer getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(Integer channel_id) {
		this.channel_id = channel_id;
	}

	public String getChannel_name() {
		return channel_name;
	}

	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}

	public Integer getPayee_id() {
		return payee_id;
	}

	public void setPayee_id(Integer payee_id) {
		this.payee_id = payee_id;
	}

	public String getPayee_name() {
		return payee_name;
	}

	public void setPayee_name(String payee_name) {
		this.payee_name = payee_name;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public Integer getPay_type() {
		return pay_type;
	}

	public void setPay_type(Integer pay_type) {
		this.pay_type = pay_type;
	}

	
	public Integer getOrder_num() {
		return order_num;
	}

	public void setOrder_num(Integer order_num) {
		this.order_num = order_num;
	}

	public Integer getLimit_count() {
		return limit_count;
	}

	public void setLimit_count(Integer limit_count) {
		this.limit_count = limit_count;
	}

	public Integer getEveryday_status() {
		return everyday_status;
	}

	public void setEveryday_status(Integer everyday_status) {
		this.everyday_status = everyday_status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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



	@Override
	public String toString() {
		return "PayChannel [channel_id=" + channel_id + ", channel_name=" + channel_name + ", payee_id=" + payee_id
				+ ", payee_name=" + payee_name + ", discount=" + discount + ", pay_type=" + pay_type + ", order_num="
				+ order_num + ", limit_count=" + limit_count + ", limit_amount=" + limit_amount + ", everyday_status="
				+ everyday_status + ", status=" + status + ", create_time=" + create_time + ", start_rows=" + start_rows
				+ ", rows=" + rows + ", page=" + page + "]";
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit_amount() {
		return limit_amount;
	}

	public void setLimit_amount(Integer limit_amount) {
		this.limit_amount = limit_amount;
	}
	
	
}
