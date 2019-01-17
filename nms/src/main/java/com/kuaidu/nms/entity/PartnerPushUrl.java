package com.kuaidu.nms.entity;

import java.math.BigDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PartnerPushUrl {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer push_id;
	

	private String name;
	
	private Integer push_type;//外推内推

	private Integer type;
	
	private Integer parent_id;

	private Integer partner_id;

	private Integer chapter_id;

	private String book_name;

	private Integer book_id;

	private String chapter_name;

	private Integer chapter_num;

	//封面
	private Integer rec_cover_id;

	private String rec_cover_url;

	//标题
	private Integer rec_title_id;

	private String title;
	
	
	//原文引导
	private Integer rec_lead_url_id;

	private String rec_lead_url;

	private Integer mode;

	private Integer hits;

	private Integer text_template;

	private Integer qr_code_id;

	private String source_url;

	private String open_str;

	private String expiry_date;

	private Integer status;

	private String created_time;

	private BigDecimal price;//收益

	private BigDecimal cost;//成本
	
	private Integer order_count;

	private Integer user_count;
	
	private Integer start_rows;  //起始行
	private Integer end_rows;	//末尾行
	public Integer getPush_id() {
		return push_id;
	}
	public void setPush_id(Integer push_id) {
		this.push_id = push_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPush_type() {
		return push_type;
	}
	public void setPush_type(Integer push_type) {
		this.push_type = push_type;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
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
	public Integer getChapter_id() {
		return chapter_id;
	}
	public void setChapter_id(Integer chapter_id) {
		this.chapter_id = chapter_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}
	public String getChapter_name() {
		return chapter_name;
	}
	public void setChapter_name(String chapter_name) {
		this.chapter_name = chapter_name;
	}
	public Integer getChapter_num() {
		return chapter_num;
	}
	public void setChapter_num(Integer chapter_num) {
		this.chapter_num = chapter_num;
	}
	public Integer getRec_cover_id() {
		return rec_cover_id;
	}
	public void setRec_cover_id(Integer rec_cover_id) {
		this.rec_cover_id = rec_cover_id;
	}
	public String getRec_cover_url() {
		return rec_cover_url;
	}
	public void setRec_cover_url(String rec_cover_url) {
		this.rec_cover_url = rec_cover_url;
	}
	public Integer getRec_title_id() {
		return rec_title_id;
	}
	public void setRec_title_id(Integer rec_title_id) {
		this.rec_title_id = rec_title_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getRec_lead_url_id() {
		return rec_lead_url_id;
	}
	public void setRec_lead_url_id(Integer rec_lead_url_id) {
		this.rec_lead_url_id = rec_lead_url_id;
	}
	public String getRec_lead_url() {
		return rec_lead_url;
	}
	public void setRec_lead_url(String rec_lead_url) {
		this.rec_lead_url = rec_lead_url;
	}
	public Integer getMode() {
		return mode;
	}
	public void setMode(Integer mode) {
		this.mode = mode;
	}
	public Integer getHits() {
		return hits;
	}
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	public Integer getText_template() {
		return text_template;
	}
	public void setText_template(Integer text_template) {
		this.text_template = text_template;
	}
	public Integer getQr_code_id() {
		return qr_code_id;
	}
	public void setQr_code_id(Integer qr_code_id) {
		this.qr_code_id = qr_code_id;
	}
	public String getSource_url() {
		return source_url;
	}
	public void setSource_url(String source_url) {
		this.source_url = source_url;
	}
	public String getOpen_str() {
		return open_str;
	}
	public void setOpen_str(String open_str) {
		this.open_str = open_str;
	}
	public String getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getOrder_count() {
		return order_count;
	}
	public void setOrder_count(Integer order_count) {
		this.order_count = order_count;
	}
	public Integer getUser_count() {
		return user_count;
	}
	public void setUser_count(Integer user_count) {
		this.user_count = user_count;
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

	public PartnerPushUrl() {
		super();
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

}
