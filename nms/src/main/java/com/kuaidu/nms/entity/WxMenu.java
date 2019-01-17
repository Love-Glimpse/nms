package com.kuaidu.nms.entity;

/** 
 * @Title WxMenu.java 
 * @description TODO 
 * @time 2018年10月12日 下午5:45:38 
 * @author victor 
 * @version 1.0 
**/
public class WxMenu {
	private Integer button_id;
	private Integer menu_id;
	private Integer button_level;
	private Integer order;
	private Integer parent_button_id;
	private String type;
	private String name;
	private String key;
	private String url;
	private int status;
	public Integer getButton_id() {
		return button_id;
	}
	public void setButton_id(Integer button_id) {
		this.button_id = button_id;
	}
	public Integer getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}
	public Integer getButton_level() {
		return button_level;
	}
	public void setButton_level(Integer button_level) {
		this.button_level = button_level;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public Integer getParent_button_id() {
		return parent_button_id;
	}
	public void setParent_button_id(Integer parent_button_id) {
		this.parent_button_id = parent_button_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "WxMenu [button_id=" + button_id + ", menu_id=" + menu_id + ", button_level=" + button_level + ", order="
				+ order + ", parent_button_id=" + parent_button_id + ", type=" + type + ", name=" + name + ", key="
				+ key + ", url=" + url + "]";
	}
	public WxMenu(Integer button_id, Integer menu_id, Integer button_level, Integer order, Integer parent_button_id,
			String type, String name, String key, String url) {
		super();
		this.button_id = button_id;
		this.menu_id = menu_id;
		this.button_level = button_level;
		this.order = order;
		this.parent_button_id = parent_button_id;
		this.type = type;
		this.name = name;
		this.key = key;
		this.url = url;
	}
	public WxMenu() {
		super();
	}
	
}
