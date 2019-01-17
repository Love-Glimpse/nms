package com.kuaidu.nms.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @Title StatUserOrder.java
 * @description 订单统计
 * @time 2018年9月11日 下午1:47:28
 * @author victor
 * @version 1.0
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatUserOrder {
	private int id;
	private String order_time;
	private Integer parent_id;
	private Integer partner_id;
	private String partner_name;
	private String partner_symbol;
	private Integer push_id;
	private Integer user_id;
	private Integer kl_flag;
	//private int login_name;//用户登录名称
	private Integer channel_id;
	private String channel_name;//充值渠道名称
	private Integer product_id;
	private Integer product_type;//产品描述
	private String product_desc;//产品描述
	private Float product_price;
	
	private Integer nm_user_count;
	private Integer nm_nocharged_quantity;
	private Integer nm_charged_quantity;
	private Float nm_total_price;
	
	private Integer vip_user_count;
	private Integer vip_nocharged_quantity;
	private Integer vip_charged_quantity;
	private Float vip_total_price;
	
	private Integer pa_nm_user_count;
	private Integer pa_nm_nocharged_quantity;
	private Integer pa_nm_charged_quantity;
	private Float pa_nm_total_price;
	
	private Integer pa_vip_user_count;
	private Integer pa_vip_nocharged_quantity;
	private Integer pa_vip_charged_quantity;
	private Float pa_vip_total_price;
	
	private Float partner_accounts_scale;//结算比例
	private Float profit;//利润

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrder_time() {
		return order_time;
	}

	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
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

	public String getPartner_symbol() {
		return partner_symbol;
	}

	public void setPartner_symbol(String partner_symbol) {
		this.partner_symbol = partner_symbol;
	}

	public Integer getPush_id() {
		return push_id;
	}

	public void setPush_id(Integer push_id) {
		this.push_id = push_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getKl_flag() {
		return kl_flag;
	}

	public void setKl_flag(Integer kl_flag) {
		this.kl_flag = kl_flag;
	}

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

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Integer getProduct_type() {
		return product_type;
	}

	public void setProduct_type(Integer product_type) {
		this.product_type = product_type;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public Float getProduct_price() {
		return product_price;
	}

	public void setProduct_price(Float product_price) {
		this.product_price = product_price;
	}

	public Integer getNm_user_count() {
		return nm_user_count;
	}

	public void setNm_user_count(Integer nm_user_count) {
		this.nm_user_count = nm_user_count;
	}

	public Integer getNm_nocharged_quantity() {
		return nm_nocharged_quantity;
	}

	public void setNm_nocharged_quantity(Integer nm_nocharged_quantity) {
		this.nm_nocharged_quantity = nm_nocharged_quantity;
	}

	public Integer getNm_charged_quantity() {
		return nm_charged_quantity;
	}

	public void setNm_charged_quantity(Integer nm_charged_quantity) {
		this.nm_charged_quantity = nm_charged_quantity;
	}

	public Float getNm_total_price() {
		return nm_total_price;
	}

	public void setNm_total_price(Float nm_total_price) {
		this.nm_total_price = nm_total_price;
	}

	public Integer getVip_user_count() {
		return vip_user_count;
	}

	public void setVip_user_count(Integer vip_user_count) {
		this.vip_user_count = vip_user_count;
	}

	public Integer getVip_nocharged_quantity() {
		return vip_nocharged_quantity;
	}

	public void setVip_nocharged_quantity(Integer vip_nocharged_quantity) {
		this.vip_nocharged_quantity = vip_nocharged_quantity;
	}

	public Integer getVip_charged_quantity() {
		return vip_charged_quantity;
	}

	public void setVip_charged_quantity(Integer vip_charged_quantity) {
		this.vip_charged_quantity = vip_charged_quantity;
	}

	public Float getVip_total_price() {
		return vip_total_price;
	}

	public void setVip_total_price(Float vip_total_price) {
		this.vip_total_price = vip_total_price;
	}

	public Integer getPa_nm_user_count() {
		return pa_nm_user_count;
	}

	public void setPa_nm_user_count(Integer pa_nm_user_count) {
		this.pa_nm_user_count = pa_nm_user_count;
	}

	public Integer getPa_nm_nocharged_quantity() {
		return pa_nm_nocharged_quantity;
	}

	public void setPa_nm_nocharged_quantity(Integer pa_nm_nocharged_quantity) {
		this.pa_nm_nocharged_quantity = pa_nm_nocharged_quantity;
	}

	public Integer getPa_nm_charged_quantity() {
		return pa_nm_charged_quantity;
	}

	public void setPa_nm_charged_quantity(Integer pa_nm_charged_quantity) {
		this.pa_nm_charged_quantity = pa_nm_charged_quantity;
	}

	public Float getPa_nm_total_price() {
		return pa_nm_total_price;
	}

	public void setPa_nm_total_price(Float pa_nm_total_price) {
		this.pa_nm_total_price = pa_nm_total_price;
	}

	public Integer getPa_vip_user_count() {
		return pa_vip_user_count;
	}

	public void setPa_vip_user_count(Integer pa_vip_user_count) {
		this.pa_vip_user_count = pa_vip_user_count;
	}

	public Integer getPa_vip_nocharged_quantity() {
		return pa_vip_nocharged_quantity;
	}

	public void setPa_vip_nocharged_quantity(Integer pa_vip_nocharged_quantity) {
		this.pa_vip_nocharged_quantity = pa_vip_nocharged_quantity;
	}

	public Integer getPa_vip_charged_quantity() {
		return pa_vip_charged_quantity;
	}

	public void setPa_vip_charged_quantity(Integer pa_vip_charged_quantity) {
		this.pa_vip_charged_quantity = pa_vip_charged_quantity;
	}

	public Float getPa_vip_total_price() {
		return pa_vip_total_price;
	}

	public void setPa_vip_total_price(Float pa_vip_total_price) {
		this.pa_vip_total_price = pa_vip_total_price;
	}

	public Float getPartner_accounts_scale() {
		return partner_accounts_scale;
	}

	public void setPartner_accounts_scale(Float partner_accounts_scale) {
		this.partner_accounts_scale = partner_accounts_scale;
	}

	@Override
	public String toString() {
		return "StatUserOrder [id=" + id + ", order_time=" + order_time + ", parent_id=" + parent_id + ", partner_id="
				+ partner_id + ", partner_name=" + partner_name + ", partner_symbol=" + partner_symbol + ", push_id="
				+ push_id + ", user_id=" + user_id + ", kl_flag=" + kl_flag + ", channel_id=" + channel_id
				+ ", channel_name=" + channel_name + ", product_id=" + product_id + ", product_type=" + product_type
				+ ", product_desc=" + product_desc + ", product_price=" + product_price + ", nm_user_count="
				+ nm_user_count + ", nm_nocharged_quantity=" + nm_nocharged_quantity + ", nm_charged_quantity="
				+ nm_charged_quantity + ", nm_total_price=" + nm_total_price + ", vip_user_count=" + vip_user_count
				+ ", vip_nocharged_quantity=" + vip_nocharged_quantity + ", vip_charged_quantity="
				+ vip_charged_quantity + ", vip_total_price=" + vip_total_price + ", pa_nm_user_count="
				+ pa_nm_user_count + ", pa_nm_nocharged_quantity=" + pa_nm_nocharged_quantity
				+ ", pa_nm_charged_quantity=" + pa_nm_charged_quantity + ", pa_nm_total_price=" + pa_nm_total_price
				+ ", pa_vip_user_count=" + pa_vip_user_count + ", pa_vip_nocharged_quantity="
				+ pa_vip_nocharged_quantity + ", pa_vip_charged_quantity=" + pa_vip_charged_quantity
				+ ", pa_vip_total_price=" + pa_vip_total_price + ", partner_accounts_scale=" + partner_accounts_scale
				+ "]";
	}

	public StatUserOrder(int id, String order_time, Integer parent_id, Integer partner_id, String partner_name,
			String partner_symbol, Integer push_id, Integer user_id, Integer kl_flag, Integer channel_id,
			String channel_name, Integer product_id, Integer product_type, String product_desc, Float product_price,
			Integer nm_user_count, Integer nm_nocharged_quantity, Integer nm_charged_quantity, Float nm_total_price,
			Integer vip_user_count, Integer vip_nocharged_quantity, Integer vip_charged_quantity, Float vip_total_price,
			Integer pa_nm_user_count, Integer pa_nm_nocharged_quantity, Integer pa_nm_charged_quantity,
			Float pa_nm_total_price, Integer pa_vip_user_count, Integer pa_vip_nocharged_quantity,
			Integer pa_vip_charged_quantity, Float pa_vip_total_price, Float partner_accounts_scale) {
		super();
		this.id = id;
		this.order_time = order_time;
		this.parent_id = parent_id;
		this.partner_id = partner_id;
		this.partner_name = partner_name;
		this.partner_symbol = partner_symbol;
		this.push_id = push_id;
		this.user_id = user_id;
		this.kl_flag = kl_flag;
		this.channel_id = channel_id;
		this.channel_name = channel_name;
		this.product_id = product_id;
		this.product_type = product_type;
		this.product_desc = product_desc;
		this.product_price = product_price;
		this.nm_user_count = nm_user_count;
		this.nm_nocharged_quantity = nm_nocharged_quantity;
		this.nm_charged_quantity = nm_charged_quantity;
		this.nm_total_price = nm_total_price;
		this.vip_user_count = vip_user_count;
		this.vip_nocharged_quantity = vip_nocharged_quantity;
		this.vip_charged_quantity = vip_charged_quantity;
		this.vip_total_price = vip_total_price;
		this.pa_nm_user_count = pa_nm_user_count;
		this.pa_nm_nocharged_quantity = pa_nm_nocharged_quantity;
		this.pa_nm_charged_quantity = pa_nm_charged_quantity;
		this.pa_nm_total_price = pa_nm_total_price;
		this.pa_vip_user_count = pa_vip_user_count;
		this.pa_vip_nocharged_quantity = pa_vip_nocharged_quantity;
		this.pa_vip_charged_quantity = pa_vip_charged_quantity;
		this.pa_vip_total_price = pa_vip_total_price;
		this.partner_accounts_scale = partner_accounts_scale;
	}

	public StatUserOrder() {
		super();
	}

	public Float getProfit() {
		return profit;
	}

	public void setProfit(Float profit) {
		this.profit = profit;
	}
}
