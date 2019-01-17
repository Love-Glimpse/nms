package com.kuaidu.nms.entity;

/** 
 * @Title PartnerCustomMsgConfig.java 
 * @description 
 * 1、关注后半小时首单福利（默认开启）
 * 2、关注用户图文推送（关注6小时后）（默认开启）
* 3、签到用户（默认关闭）（签到12小时后）
 * 4、订单待支付提醒（默认开启）（半小时后）
 * 5、继续阅读提醒 （8小时未阅读）
* 6、 智能托管 
 * @time 2018年11月20日 上午11:40:36 
 * @author victor 
 * @version 1.0 
**/
public class PartnerCustomMsgConfig {
	private Integer id;
	private Integer partner_id;
	private Integer type;
	private Integer status;
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public PartnerCustomMsgConfig(Integer id, Integer partner_id, Integer type, Integer status) {
		super();
		this.id = id;
		this.partner_id = partner_id;
		this.type = type;
		this.status = status;
	}
	public PartnerCustomMsgConfig() {
		super();
	}
	
}
