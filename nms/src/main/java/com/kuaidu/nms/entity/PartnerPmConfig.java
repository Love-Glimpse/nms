package com.kuaidu.nms.entity;

public class PartnerPmConfig {
	private Integer id;
	private Integer type;
	private Integer partner_id;
	private String source_id;
	private String we_chat;
	private String we_chat_pm;
	private String we_app_id;
	private String we_app_secret;
	private String we_token;
	private String attention_mode;
	private String attention_url;
	private String logo_url;
	private String logo_name;
	private String qq;
	private String mail;
	private String qr_code_url;
	private String kf_qr_url;
	private String oldkf_qr_url;
	private String kf_media_id;
	private String kf_media_url;
	private Integer subscribe_mode;
	private String subscribe_url;
	private String create_time;
	private Integer menu_id;
	private Integer api_status;
	private Integer charge_temp_id;
	private Integer  vip_flag;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getPartner_id() {
		return partner_id;
	}
	public void setPartner_id(Integer partner_id) {
		this.partner_id = partner_id;
	}
	public String getSource_id() {
		return source_id;
	}
	public void setSource_id(String source_id) {
		this.source_id = source_id;
	}
	public String getWe_chat() {
		return we_chat;
	}
	public void setWe_chat(String we_chat) {
		this.we_chat = we_chat;
	}
	public String getWe_chat_pm() {
		return we_chat_pm;
	}
	public void setWe_chat_pm(String we_chat_pm) {
		this.we_chat_pm = we_chat_pm;
	}
	public String getWe_app_id() {
		return we_app_id;
	}
	public void setWe_app_id(String we_app_id) {
		this.we_app_id = we_app_id;
	}
	public String getWe_app_secret() {
		return we_app_secret;
	}
	public void setWe_app_secret(String we_app_secret) {
		this.we_app_secret = we_app_secret;
	}
	public String getWe_token() {
		return we_token;
	}
	public void setWe_token(String we_token) {
		this.we_token = we_token;
	}
	public String getAttention_mode() {
		return attention_mode;
	}
	public void setAttention_mode(String attention_mode) {
		this.attention_mode = attention_mode;
	}
	public String getAttention_url() {
		return attention_url;
	}
	public void setAttention_url(String attention_url) {
		this.attention_url = attention_url;
	}
	public String getLogo_url() {
		return logo_url;
	}
	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
	}
	public String getLogo_name() {
		return logo_name;
	}
	public void setLogo_name(String logo_name) {
		this.logo_name = logo_name;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getQr_code_url() {
		return qr_code_url;
	}
	public void setQr_code_url(String qr_code_url) {
		this.qr_code_url = qr_code_url;
	}
	public String getKf_qr_url() {
		return kf_qr_url;
	}
	public void setKf_qr_url(String kf_qr_url) {
		this.kf_qr_url = kf_qr_url;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	
	public Integer getSubscribe_mode() {
		return subscribe_mode;
	}
	public void setSubscribe_mode(Integer subscribe_mode) {
		this.subscribe_mode = subscribe_mode;
	}
	public String getSubscribe_url() {
		return subscribe_url;
	}
	public void setSubscribe_url(String subscribe_url) {
		this.subscribe_url = subscribe_url;
	}
	
	@Override
	public String toString() {
		return "PartnerPmConfig [id=" + id + ", type=" + type + ", partner_id=" + partner_id + ", source_id="
				+ source_id + ", we_chat=" + we_chat + ", we_chat_pm=" + we_chat_pm + ", we_app_id=" + we_app_id
				+ ", we_app_secret=" + we_app_secret + ", we_token=" + we_token + ", attention_mode=" + attention_mode
				+ ", attention_url=" + attention_url + ", logo_url=" + logo_url + ", logo_name=" + logo_name + ", qq="
				+ qq + ", mail=" + mail + ", qr_code_url=" + qr_code_url + ", kf_qr_url=" + kf_qr_url
				+ ", subscribe_mode=" + subscribe_mode + ", subscribe_url=" + subscribe_url + ", create_time="
				+ create_time + "]";
	}
	public PartnerPmConfig(Integer id, Integer type, Integer partner_id, String source_id, String we_chat,
			String we_chat_pm, String we_app_id, String we_app_secret, String we_token, String attention_mode,
			String attention_url, String logo_url, String logo_name, String qq, String mail, String qr_code_url,
			String kf_qr_url, Integer subscribe_mode, String subscribe_url, String create_time) {
		super();
		this.id = id;
		this.type = type;
		this.partner_id = partner_id;
		this.source_id = source_id;
		this.we_chat = we_chat;
		this.we_chat_pm = we_chat_pm;
		this.we_app_id = we_app_id;
		this.we_app_secret = we_app_secret;
		this.we_token = we_token;
		this.attention_mode = attention_mode;
		this.attention_url = attention_url;
		this.logo_url = logo_url;
		this.logo_name = logo_name;
		this.qq = qq;
		this.mail = mail;
		this.qr_code_url = qr_code_url;
		this.kf_qr_url = kf_qr_url;
		this.subscribe_mode = subscribe_mode;
		this.subscribe_url = subscribe_url;
		this.create_time = create_time;
	}
	public PartnerPmConfig() {
		super();
	}
	public Integer getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}
	public String getOldkf_qr_url() {
		return oldkf_qr_url;
	}
	public void setOldkf_qr_url(String oldkf_qr_url) {
		this.oldkf_qr_url = oldkf_qr_url;
	}
	public String getKf_media_id() {
		return kf_media_id;
	}
	public void setKf_media_id(String kf_media_id) {
		this.kf_media_id = kf_media_id;
	}
	public String getKf_media_url() {
		return kf_media_url;
	}
	public void setKf_media_url(String kf_media_url) {
		this.kf_media_url = kf_media_url;
	}
	public Integer getApi_status() {
		return api_status;
	}
	public void setApi_status(Integer api_status) {
		this.api_status = api_status;
	}
	public Integer getCharge_temp_id() {
		return charge_temp_id;
	}
	public void setCharge_temp_id(Integer charge_temp_id) {
		this.charge_temp_id = charge_temp_id;
	}
	public Integer getVip_flag() {
		return vip_flag;
	}
	public void setVip_flag(Integer vip_flag) {
		this.vip_flag = vip_flag;
	}
	

}
