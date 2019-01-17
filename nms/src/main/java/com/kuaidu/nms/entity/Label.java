package com.kuaidu.nms.entity;

/** 
 * @Title Label.java 
 * @description TODO 
 * @time 2018年11月5日 下午12:01:55 
 * @author victor 
 * @version 1.0 
**/
public class Label {
	private Integer label_id;
	private String tag;
	public Integer getLabel_id() {
		return label_id;
	}
	public void setLabel_id(Integer label_id) {
		this.label_id = label_id;
	}
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Label() {
		super();
	}
	
}
