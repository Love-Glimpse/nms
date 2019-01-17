package com.kuaidu.nms.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartnerWithdraw {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer partner_id;
	@Transient
	private String partner_name;

	private Integer parent_id;
	private BigDecimal withdraw_price;
	private BigDecimal bank_charge;
	private BigDecimal pay_price;
	private Integer status;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date create_time;

	private List<PartnerBill> partnerBills;

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

	private String voucher_url;

	private String transfer_order_number;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date pay_time;

	public PartnerWithdraw() {
		super();
	}

	public PartnerWithdraw(Integer partner_id, Integer parent_id, BigDecimal withdraw_price, BigDecimal bank_charge,
			BigDecimal pay_price, Integer status) {
		super();
		this.partner_id = partner_id;
		this.parent_id = parent_id;
		this.withdraw_price = withdraw_price;
		this.bank_charge = bank_charge;
		this.pay_price = pay_price;
		this.status = status;
	}

	public PartnerWithdraw(Integer id, Integer partner_id, Integer parent_id, BigDecimal withdraw_price,
			BigDecimal bank_charge, BigDecimal pay_price, Integer status, Date create_time, Date pay_time) {
		super();
		this.id = id;
		this.partner_id = partner_id;
		this.parent_id = parent_id;
		this.withdraw_price = withdraw_price;
		this.bank_charge = bank_charge;
		this.pay_price = pay_price;
		this.status = status;
		this.create_time = create_time;
		this.pay_time = pay_time;
	}
	
	

	public PartnerWithdraw(Integer id, Integer partner_id, String partner_name, Integer parent_id,
			BigDecimal withdraw_price, BigDecimal bank_charge, BigDecimal pay_price, Integer status, Date create_time,
			List<PartnerBill> partnerBills, Integer pay_type, String bank_account, String bank_name,
			String bank_province, String bank_city, String bank_branch, String payee, String alipay_account,
			String alipay_name, String wechat_account, String wechat_name, String voucher_url,
			String transfer_order_number, Date pay_time) {
		super();
		this.id = id;
		this.partner_id = partner_id;
		this.partner_name = partner_name;
		this.parent_id = parent_id;
		this.withdraw_price = withdraw_price;
		this.bank_charge = bank_charge;
		this.pay_price = pay_price;
		this.status = status;
		this.create_time = create_time;
		this.partnerBills = partnerBills;
		this.pay_type = pay_type;
		this.bank_account = bank_account;
		this.bank_name = bank_name;
		this.bank_province = bank_province;
		this.bank_city = bank_city;
		this.bank_branch = bank_branch;
		this.payee = payee;
		this.alipay_account = alipay_account;
		this.alipay_name = alipay_name;
		this.wechat_account = wechat_account;
		this.wechat_name = wechat_name;
		this.voucher_url = voucher_url;
		this.transfer_order_number = transfer_order_number;
		this.pay_time = pay_time;
	}

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

	public String getPartner_name() {
		return partner_name;
	}

	public void setPartner_name(String partner_name) {
		this.partner_name = partner_name;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public BigDecimal getWithdraw_price() {
		return withdraw_price;
	}

	public void setWithdraw_price(BigDecimal withdraw_price) {
		this.withdraw_price = withdraw_price;
	}

	public BigDecimal getBank_charge() {
		return bank_charge;
	}

	public void setBank_charge(BigDecimal bank_charge) {
		this.bank_charge = bank_charge;
	}

	public BigDecimal getPay_price() {
		return pay_price;
	}

	public void setPay_price(BigDecimal pay_price) {
		this.pay_price = pay_price;
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

	public List<PartnerBill> getPartnerBills() {
		return partnerBills;
	}

	public void setPartnerBills(List<PartnerBill> partnerBills) {
		this.partnerBills = partnerBills;
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

	public String getVoucher_url() {
		return voucher_url;
	}

	public void setVoucher_url(String voucher_url) {
		this.voucher_url = voucher_url;
	}

	public String getTransfer_order_number() {
		return transfer_order_number;
	}

	public void setTransfer_order_number(String transfer_order_number) {
		this.transfer_order_number = transfer_order_number;
	}

	public Date getPay_time() {
		return pay_time;
	}

	public void setPay_time(Date pay_time) {
		this.pay_time = pay_time;
	}

	@Override
	public String toString() {
		return "PartnerWithdraw [id=" + id + ", partner_id=" + partner_id + ", partner_name=" + partner_name
				+ ", parent_id=" + parent_id + ", withdraw_price=" + withdraw_price + ", bank_charge=" + bank_charge
				+ ", pay_price=" + pay_price + ", status=" + status + ", create_time=" + create_time + ", partnerBills="
				+ partnerBills + ", pay_type=" + pay_type + ", bank_account=" + bank_account + ", bank_name="
				+ bank_name + ", bank_province=" + bank_province + ", bank_city=" + bank_city + ", bank_branch="
				+ bank_branch + ", payee=" + payee + ", alipay_account=" + alipay_account + ", alipay_name="
				+ alipay_name + ", wechat_account=" + wechat_account + ", wechat_name=" + wechat_name + ", voucher_url="
				+ voucher_url + ", transfer_order_number=" + transfer_order_number + ", pay_time=" + pay_time + "]";
	}

	
}
