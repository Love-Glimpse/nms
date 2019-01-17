package com.kuaidu.nms.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartnerBill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer partner_id;
	
	private Integer parent_id;
	
	@Transient
	private String partner_name;
	
	private Integer order_num;
	
	private BigDecimal order_price;
	
	private BigDecimal withdraw_price;
	
	private BigDecimal proxy_withdraw_price;
	
	private BigDecimal partner_accounts_scale;
	
	private BigDecimal proxy_accounts_scale;
	
	private Integer status;
	
	private Integer proxy_status;
	
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date create_time;
	
	@Transient
	private PartnerAccount partnerAccount;

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

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public Integer getOrder_num() {
		return order_num;
	}

	public void setOrder_num(Integer order_num) {
		this.order_num = order_num;
	}

	public BigDecimal getOrder_price() {
		return order_price;
	}

	public void setOrder_price(BigDecimal order_price) {
		this.order_price = order_price;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	
	

	public BigDecimal getProxy_withdraw_price() {
		return proxy_withdraw_price;
	}

	public void setProxy_withdraw_price(BigDecimal proxy_withdraw_price) {
		this.proxy_withdraw_price = proxy_withdraw_price;
	}

	public BigDecimal getProxy_accounts_scale() {
		return proxy_accounts_scale;
	}

	public void setProxy_accounts_scale(BigDecimal proxy_accounts_scale) {
		this.proxy_accounts_scale = proxy_accounts_scale;
	}

	public BigDecimal getWithdraw_price() {
		return withdraw_price;
	}

	public void setWithdraw_price(BigDecimal withdraw_price) {
		this.withdraw_price = withdraw_price;
	}

	public BigDecimal getPartner_accounts_scale() {
		return partner_accounts_scale;
	}

	public void setPartner_accounts_scale(BigDecimal partner_accounts_scale) {
		this.partner_accounts_scale = partner_accounts_scale;
	}

	public Integer getProxy_status() {
		return proxy_status;
	}

	public void setProxy_status(Integer proxy_status) {
		this.proxy_status = proxy_status;
	}
	
	

	public String getPartner_name() {
		return partner_name;
	}

	public void setPartner_name(String partner_name) {
		this.partner_name = partner_name;
	}

	public PartnerAccount getPartnerAccount() {
		return partnerAccount;
	}

	public void setPartnerAccount(PartnerAccount partnerAccount) {
		this.partnerAccount = partnerAccount;
	}

	@Override
	public String toString() {
		return "PartnerBill [id=" + id + ", partner_id=" + partner_id + ", parent_id=" + parent_id + ", order_num="
				+ order_num + ", order_price=" + order_price + ", partner_accounts_scale=" + partner_accounts_scale
				+ ", status=" + status + ", proxy_status=" + proxy_status + ", create_time=" + create_time + "]";
	}
	
	
	
	
	

}
