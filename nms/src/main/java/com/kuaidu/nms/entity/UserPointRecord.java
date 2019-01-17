package com.kuaidu.nms.entity;

/** 
 * @Title UserPointRecord.java 
 * @description TODO 
 * @time 2018年12月18日 下午2:34:21 
 * @author victor 
 * @version 1.0 
**/
public class UserPointRecord {
	private Integer id;
	private Integer user_id;
	private Integer type;
	private Integer add_point;
	private String create_time;
	private Integer start_rows;  //起始行
	private Integer rows;
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getAdd_point() {
		return add_point;
	}
	public void setAdd_point(Integer add_point) {
		this.add_point = add_point;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public Integer getStart_rows() {
		return start_rows;
	}
	public void setStart_rows(Integer start_rows) {
		this.start_rows = start_rows;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public UserPointRecord(Integer id, Integer user_id, Integer type, Integer add_point, String create_time,
			Integer start_rows, Integer rows) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.type = type;
		this.add_point = add_point;
		this.create_time = create_time;
		this.start_rows = start_rows;
		this.rows = rows;
	}
	public UserPointRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
