package com.kuaidu.nms.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartnerInfo {
	private int partner_id;
	private int group_id;
	private int parent_id;
	private int partner_plat_id;
	private String type_name;
	private String parent_partner;//所属渠道
	private String sub_partner_count;//子渠道数
	private int partner_level;
	private int partner_gradation;
	private String partner_symbol;
	private String partner_name;
	private String login_name;
	private String password;
	private String sub_domain;
	private BigDecimal partner_accounts_scale;
	private int status;
	private int kl_flag;
	private String payment_name;//结算款方式
	private String created_time;
	private Integer page;
	private Integer rows;
	public int getPartner_id() {
		return partner_id;
	}
	public void setPartner_id(int partner_id) {
		this.partner_id = partner_id;
	}
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public int getPartner_plat_id() {
		return partner_plat_id;
	}
	public void setPartner_plat_id(int partner_plat_id) {
		this.partner_plat_id = partner_plat_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getParent_partner() {
		return parent_partner;
	}
	public void setParent_partner(String parent_partner) {
		this.parent_partner = parent_partner;
	}
	public String getSub_partner_count() {
		return sub_partner_count;
	}
	public void setSub_partner_count(String sub_partner_count) {
		this.sub_partner_count = sub_partner_count;
	}
	public int getPartner_level() {
		return partner_level;
	}
	public void setPartner_level(int partner_level) {
		this.partner_level = partner_level;
	}
	public int getPartner_gradation() {
		return partner_gradation;
	}
	public void setPartner_gradation(int partner_gradation) {
		this.partner_gradation = partner_gradation;
	}
	public String getPartner_symbol() {
		return partner_symbol;
	}
	public void setPartner_symbol(String partner_symbol) {
		this.partner_symbol = partner_symbol;
	}
	public String getPartner_name() {
		return partner_name;
	}
	public void setPartner_name(String partner_name) {
		this.partner_name = partner_name;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSub_domain() {
		return sub_domain;
	}
	public void setSub_domain(String sub_domain) {
		this.sub_domain = sub_domain;
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
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public int getKl_flag() {
		return kl_flag;
	}
	public void setKl_flag(int kl_flag) {
		this.kl_flag = kl_flag;
	}
	public String getPayment_name() {
		return payment_name;
	}
	public void setPayment_name(String payment_name) {
		this.payment_name = payment_name;
	}
	public BigDecimal getPartner_accounts_scale() {
		return partner_accounts_scale;
	}
	public void setPartner_accounts_scale(BigDecimal partner_accounts_scale) {
		this.partner_accounts_scale = partner_accounts_scale;
	}
	
}
