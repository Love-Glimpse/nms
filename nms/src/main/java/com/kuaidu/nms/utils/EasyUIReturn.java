package com.kuaidu.nms.utils;

import java.util.List;

public class EasyUIReturn {
	
	private Integer total;
	
	private List<?> rows;
	
	

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Object getRows() {
		return rows;
	}

	
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	

	public EasyUIReturn(Integer total, List<?> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public EasyUIReturn() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EasyUIReturn [total=" + total + ", rows=" + rows + "]";
	}
	
	

}
