package com.kuaidu.nms.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/** 
 * @Title 活跃用户统计
 * @description TODO 
 * @time 2018年11月26日 上午9:44:12 
 * @author victor 
 * @version 1.0 
**/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatUserStayByDay {
    private	String create_date;
    private	int parent_id;
    private	int partner_id;
    private	int push_id;
    private	int new_count;
    private	String day1;
    private	String day2;
    private	String day3;
    private	String day4;
    private	String day5;
    private	String day6;
    private	String day7;
    private	String day8;
    private	String day9;
    private	String day10;
    private	String day15;
    private	String day30;
    private	String day60;
    private	String day90;
    private	String dayAll;
    private	String start_date;
    private	String end_date;
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public int getPartner_id() {
		return partner_id;
	}
	public void setPartner_id(int partner_id) {
		this.partner_id = partner_id;
	}
	public int getPush_id() {
		return push_id;
	}
	public void setPush_id(int push_id) {
		this.push_id = push_id;
	}
	public int getNew_count() {
		return new_count;
	}
	public void setNew_count(int new_count) {
		this.new_count = new_count;
	}
	public String getDay1() {
		return day1;
	}
	public void setDay1(String day1) {
		this.day1 = day1;
	}
	public String getDay2() {
		return day2;
	}
	public void setDay2(String day2) {
		this.day2 = day2;
	}
	public String getDay3() {
		return day3;
	}
	public void setDay3(String day3) {
		this.day3 = day3;
	}
	public String getDay4() {
		return day4;
	}
	public void setDay4(String day4) {
		this.day4 = day4;
	}
	public String getDay5() {
		return day5;
	}
	public void setDay5(String day5) {
		this.day5 = day5;
	}
	public String getDay6() {
		return day6;
	}
	public void setDay6(String day6) {
		this.day6 = day6;
	}
	public String getDay7() {
		return day7;
	}
	public void setDay7(String day7) {
		this.day7 = day7;
	}
	public String getDay8() {
		return day8;
	}
	public void setDay8(String day8) {
		this.day8 = day8;
	}
	public String getDay9() {
		return day9;
	}
	public void setDay9(String day9) {
		this.day9 = day9;
	}
	public String getDay10() {
		return day10;
	}
	public void setDay10(String day10) {
		this.day10 = day10;
	}
	public String getDay15() {
		return day15;
	}
	public void setDay15(String day15) {
		this.day15 = day15;
	}
	public String getDay30() {
		return day30;
	}
	public void setDay30(String day30) {
		this.day30 = day30;
	}
	public String getDay60() {
		return day60;
	}
	public void setDay60(String day60) {
		this.day60 = day60;
	}
	public String getDay90() {
		return day90;
	}
	public void setDay90(String day90) {
		this.day90 = day90;
	}
	public String getDayAll() {
		return dayAll;
	}
	public void setDayAll(String dayAll) {
		this.dayAll = dayAll;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public StatUserStayByDay(String create_date, int parent_id, int partner_id, int push_id, int new_count, String day1,
			String day2, String day3, String day4, String day5, String day6, String day7, String day8, String day9,
			String day10, String day15, String day30, String day60, String day90, String dayAll, String start_date,
			String end_date) {
		super();
		this.create_date = create_date;
		this.parent_id = parent_id;
		this.partner_id = partner_id;
		this.push_id = push_id;
		this.new_count = new_count;
		this.day1 = day1;
		this.day2 = day2;
		this.day3 = day3;
		this.day4 = day4;
		this.day5 = day5;
		this.day6 = day6;
		this.day7 = day7;
		this.day8 = day8;
		this.day9 = day9;
		this.day10 = day10;
		this.day15 = day15;
		this.day30 = day30;
		this.day60 = day60;
		this.day90 = day90;
		this.dayAll = dayAll;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	@Override
	public String toString() {
		return "StatUserStayByDay [create_date=" + create_date + ", parent_id=" + parent_id + ", partner_id="
				+ partner_id + ", push_id=" + push_id + ", new_count=" + new_count + ", day1=" + day1 + ", day2=" + day2
				+ ", day3=" + day3 + ", day4=" + day4 + ", day5=" + day5 + ", day6=" + day6 + ", day7=" + day7
				+ ", day8=" + day8 + ", day9=" + day9 + ", day10=" + day10 + ", day15=" + day15 + ", day30=" + day30
				+ ", day60=" + day60 + ", day90=" + day90 + ", dayAll=" + dayAll + ", start_date=" + start_date
				+ ", end_date=" + end_date + "]";
	}
	public StatUserStayByDay() {
		super();
	}
    
}
