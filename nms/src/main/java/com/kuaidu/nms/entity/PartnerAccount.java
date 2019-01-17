package com.kuaidu.nms.entity;

public class PartnerAccount {

	
	private Integer partner_id;
	private Integer parent_id;
	private Integer pay_type;
	private String bank_account;
	private String bank_name;
	private String bank_province;
	private String bank_city;
	private String bank_branch;
	private String payee;
	private String alipay_account;
	private String alipay_name;
	private String wechat_account;
	private String wechat_name;
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
	public Integer getPay_type() {
		return pay_type;
	}
	public void setPay_type(Integer pay_type) {
		this.pay_type = pay_type;
	}
	public String getBank_account() {
		return bank_account;
	}
	public void setBank_account(String bank_account) {
		this.bank_account = bank_account;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getBank_province() {
		return bank_province;
	}
	public void setBank_province(String bank_province) {
		this.bank_province = bank_province;
	}
	public String getBank_city() {
		return bank_city;
	}
	public void setBank_city(String bank_city) {
		this.bank_city = bank_city;
	}
	public String getBank_branch() {
		return bank_branch;
	}
	public void setBank_branch(String bank_branch) {
		this.bank_branch = bank_branch;
	}
	public String getPayee() {
		return payee;
	}
	public void setPayee(String payee) {
		this.payee = payee;
	}
	public String getAlipay_account() {
		return alipay_account;
	}
	public void setAlipay_account(String alipay_account) {
		this.alipay_account = alipay_account;
	}
	public String getAlipay_name() {
		return alipay_name;
	}
	public void setAlipay_name(String alipay_name) {
		this.alipay_name = alipay_name;
	}
	public String getWechat_account() {
		return wechat_account;
	}
	public void setWechat_account(String wechat_account) {
		this.wechat_account = wechat_account;
	}
	public String getWechat_name() {
		return wechat_name;
	}
	public void setWechat_name(String wechat_name) {
		this.wechat_name = wechat_name;
	}
	@Override
	public String toString() {
		return "PartnerAccount [partner_id=" + partner_id + ", parent_id=" + parent_id + ", pay_type=" + pay_type
				+ ", bank_account=" + bank_account + ", bank_name=" + bank_name + ", bank_province=" + bank_province
				+ ", bank_city=" + bank_city + ", bank_branch=" + bank_branch + ", payee=" + payee + ", alipay_account="
				+ alipay_account + ", alipay_name=" + alipay_name + ", wechat_account=" + wechat_account
				+ ", wechat_name=" + wechat_name + "]";
	}
	
	

}
