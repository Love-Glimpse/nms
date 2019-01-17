package com.kuaidu.nms.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserOrder {
	private Integer id;
	private Integer user_id;
	private Integer parent_id;
	private Integer partner_id;
	private Integer push_id;
	private String order_id;
	private String third_order_id;
	private Integer status;
	private String created_time;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date pay_time;
	private Integer product_id;
	private String product_price;
	private String total_price;
	private Integer is_promotion;
	private Integer channel_id;
	private Integer quantity;
	private Integer kl_flag;
	private String url;
	private String amount;
	private String product_desc;
	private String channel_name;
	private String partner_name;
	private String parent_partner;
	private String nick_name;
	private String cname;// 派单渠道
	private String start_time;
	private String end_time;

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getPartner_gradation() {
		return partner_gradation;
	}

	public void setPartner_gradation(int partner_gradation) {
		this.partner_gradation = partner_gradation;
	}

	private String picture;
	private int partner_gradation;
	private Integer start_rows; // 起始行
	private Integer end_rows; // 末尾行

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

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	
	

	public Integer getKl_flag() {
		return kl_flag;
	}

	public void setKl_flag(Integer kl_flag) {
		this.kl_flag = kl_flag;
	}

	

	public String getThird_order_id() {
		return third_order_id;
	}

	public void setThird_order_id(String third_order_id) {
		this.third_order_id = third_order_id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreated_time() {
		return created_time;
	}

	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}

	

	public Date getPay_time() {
		return pay_time;
	}

	public void setPay_time(Date pay_time) {
		this.pay_time = pay_time;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProduct_price() {
		return product_price;
	}

	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}

	public String getTotal_price() {
		return total_price;
	}

	public void setTotal_price(String total_price) {
		this.total_price = total_price;
	}

	public Integer getIs_promotion() {
		return is_promotion;
	}

	public void setIs_promotion(Integer is_promotion) {
		this.is_promotion = is_promotion;
	}

	public Integer getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(Integer channel_id) {
		this.channel_id = channel_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public String getChannel_name() {
		return channel_name;
	}

	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}

	public Integer getStart_rows() {
		return start_rows;
	}

	public void setStart_rows(Integer start_rows) {
		this.start_rows = start_rows;
	}

	public Integer getEnd_rows() {
		return end_rows;
	}

	public void setEnd_rows(Integer end_rows) {
		this.end_rows = end_rows;
	}

	public UserOrder(Integer id, Integer user_id, String order_id, String third_order_id,
			Integer status, String created_time, Date pay_time, Integer product_id, String product_price,
			String total_price, Integer is_promotion, Integer channel_id, Integer quantity, String sub_class,
			String third_buyer_id, String third_buyer_acount, String my_expiry_date, String url, String amount,
			String product_desc, String channel_name, String partner_name, String nick_name, Integer start_rows,
			Integer end_rows) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.order_id = order_id;
		this.third_order_id = third_order_id;
		this.status = status;
		this.created_time = created_time;
		this.pay_time = pay_time;
		this.product_id = product_id;
		this.product_price = product_price;
		this.total_price = total_price;
		this.is_promotion = is_promotion;
		this.channel_id = channel_id;
		this.quantity = quantity;
		this.url = url;
		this.amount = amount;
		this.product_desc = product_desc;
		this.channel_name = channel_name;
		this.partner_name = partner_name;
		this.nick_name = nick_name;
		this.start_rows = start_rows;
		this.end_rows = end_rows;
	}

	public String getPartner_name() {
		return partner_name;
	}

	public void setPartner_name(String partner_name) {
		this.partner_name = partner_name;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public UserOrder() {
		super();
	}

	public Integer getPartner_id() {
		return partner_id;
	}

	public void setPartner_id(Integer partner_id) {
		this.partner_id = partner_id;
	}

	public String getParent_partner() {
		return parent_partner;
	}

	public void setParent_partner(String parent_partner) {
		this.parent_partner = parent_partner;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getPush_id() {
		return push_id;
	}

	public void setPush_id(Integer push_id) {
		this.push_id = push_id;
	}

}
