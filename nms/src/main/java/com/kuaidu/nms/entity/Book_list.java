package com.kuaidu.nms.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/*书籍bean*/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book_list {
	private Integer book_id;  	//书Id
	private Integer type_id;	//类型
	private String type_name;	//类型名称
	private Integer sex;		//频道，男频/女频
	private String book_url;	//书链接地址
	private String book_pic_url;//书封面链接
	private Integer book_pic_changed;//书封面链接改变
	private String pic_path;	//封面路径
	private String book_name;	//书名
	private String author;		//作者	
	private Integer author_id;	//作者id
	private Integer newest_chapter_num;	//最新章节数
	private String newest_chapter;	//最新章节
	private String words;	//字数   （预留）
	private Integer isserial;//是否连载
	private String source_ids;//下载源
	private String created_time; //目标网站更新时间
	private String update_time_self;//获取时间
	private String description;//书简介
	private Integer total_chapter_count;//总章节
	private Integer downloaded_chapter_count;//下载的总章节
	private Integer free_chapter_num;//免费章节数
	private Integer hot_value;//热门值
	private Integer checked_ok;//是否检查过
	private Integer pic_down_flag;//
	private Integer update_flag; //是否有更新
	private Integer isUrlConfig; //是否有配置url匹配
	private String remark; //备注
	private Integer status; //0:stop 1:running 2:不可用
	private Integer words_min;//章节最小字数
	private Integer is_fixed;//是否修正
	private Integer read_original_chapter_num;//阅读原文章节
	private String  roles;//主角
	private Integer start_rows;  //起始行
	private Integer end_rows;	//末尾行
	private String small_pic;
	private Integer read_user_count;
	@Override
	public String toString() {
		return "Book_list [book_id=" + book_id + ", type_id=" + type_id + ", type_name=" + type_name + ", sex=" + sex
				+ ", book_url=" + book_url + ", book_pic_url=" + book_pic_url + ", book_pic_changed=" + book_pic_changed
				+ ", pic_path=" + pic_path + ", book_name=" + book_name + ", author=" + author + ", author_id="
				+ author_id + ", newest_chapter_num=" + newest_chapter_num + ", newest_chapter=" + newest_chapter
				+ ", words=" + words + ", isserial=" + isserial + ", source_ids=" + source_ids + ", created_time="
				+ created_time + ", update_time_self=" + update_time_self + ", description=" + description
				+ ", total_chapter_count=" + total_chapter_count + ", downloaded_chapter_count="
				+ downloaded_chapter_count + ", free_chapter_num=" + free_chapter_num + ", hot_value=" + hot_value
				+ ", checked_ok=" + checked_ok + ", pic_down_flag=" + pic_down_flag + ", update_flag=" + update_flag
				+ ", isUrlConfig=" + isUrlConfig + ", remark=" + remark + ", status=" + status + ", words_min="
				+ words_min + ", is_fixed=" + is_fixed + ", read_original_chapter_num=" + read_original_chapter_num
				+ ", roles=" + roles + ", start_rows=" + start_rows + ", end_rows=" + end_rows + ", small_pic="
				+ small_pic + ", read_user_count=" + read_user_count + "]";
	}
	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getBook_url() {
		return book_url;
	}
	public void setBook_url(String book_url) {
		this.book_url = book_url;
	}
	public String getBook_pic_url() {
		return book_pic_url;
	}
	public void setBook_pic_url(String book_pic_url) {
		this.book_pic_url = book_pic_url;
	}
	public Integer getBook_pic_changed() {
		return book_pic_changed;
	}
	public void setBook_pic_changed(Integer book_pic_changed) {
		this.book_pic_changed = book_pic_changed;
	}
	public String getPic_path() {
		return pic_path;
	}
	public void setPic_path(String pic_path) {
		this.pic_path = pic_path;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(Integer author_id) {
		this.author_id = author_id;
	}
	public Integer getNewest_chapter_num() {
		return newest_chapter_num;
	}
	public void setNewest_chapter_num(Integer newest_chapter_num) {
		this.newest_chapter_num = newest_chapter_num;
	}
	public String getNewest_chapter() {
		return newest_chapter;
	}
	public void setNewest_chapter(String newest_chapter) {
		this.newest_chapter = newest_chapter;
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	public Integer getIsserial() {
		return isserial;
	}
	public void setIsserial(Integer isserial) {
		this.isserial = isserial;
	}
	public String getSource_ids() {
		return source_ids;
	}
	public void setSource_ids(String source_ids) {
		this.source_ids = source_ids;
	}
	public String getCreated_time() {
		return created_time;
	}
	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}
	public String getUpdate_time_self() {
		return update_time_self;
	}
	public void setUpdate_time_self(String update_time_self) {
		this.update_time_self = update_time_self;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getTotal_chapter_count() {
		return total_chapter_count;
	}
	public void setTotal_chapter_count(Integer total_chapter_count) {
		this.total_chapter_count = total_chapter_count;
	}
	public Integer getDownloaded_chapter_count() {
		return downloaded_chapter_count;
	}
	public void setDownloaded_chapter_count(Integer downloaded_chapter_count) {
		this.downloaded_chapter_count = downloaded_chapter_count;
	}
	public Integer getFree_chapter_num() {
		return free_chapter_num;
	}
	public void setFree_chapter_num(Integer free_chapter_num) {
		this.free_chapter_num = free_chapter_num;
	}
	public Integer getHot_value() {
		return hot_value;
	}
	public void setHot_value(Integer hot_value) {
		this.hot_value = hot_value;
	}
	public Integer getChecked_ok() {
		return checked_ok;
	}
	public void setChecked_ok(Integer checked_ok) {
		this.checked_ok = checked_ok;
	}
	public Integer getPic_down_flag() {
		return pic_down_flag;
	}
	public void setPic_down_flag(Integer pic_down_flag) {
		this.pic_down_flag = pic_down_flag;
	}
	public Integer getUpdate_flag() {
		return update_flag;
	}
	public void setUpdate_flag(Integer update_flag) {
		this.update_flag = update_flag;
	}
	public Integer getIsUrlConfig() {
		return isUrlConfig;
	}
	public void setIsUrlConfig(Integer isUrlConfig) {
		this.isUrlConfig = isUrlConfig;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getWords_min() {
		return words_min;
	}
	public void setWords_min(Integer words_min) {
		this.words_min = words_min;
	}
	public Integer getIs_fixed() {
		return is_fixed;
	}
	public void setIs_fixed(Integer is_fixed) {
		this.is_fixed = is_fixed;
	}
	public Integer getRead_original_chapter_num() {
		return read_original_chapter_num;
	}
	public void setRead_original_chapter_num(Integer read_original_chapter_num) {
		this.read_original_chapter_num = read_original_chapter_num;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
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
	public String getSmall_pic() {
		return small_pic;
	}
	public void setSmall_pic(String small_pic) {
		this.small_pic = small_pic;
	}
	public Integer getRead_user_count() {
		return read_user_count;
	}
	public void setRead_user_count(Integer read_user_count) {
		this.read_user_count = read_user_count;
	}
	public Book_list(Integer book_id, Integer type_id, String type_name, Integer sex, String book_url,
			String book_pic_url, Integer book_pic_changed, String pic_path, String book_name, String author,
			Integer author_id, Integer newest_chapter_num, String newest_chapter, String words, Integer isserial,
			String source_ids, String created_time, String update_time_self, String description,
			Integer total_chapter_count, Integer downloaded_chapter_count, Integer free_chapter_num, Integer hot_value,
			Integer checked_ok, Integer pic_down_flag, Integer update_flag, Integer isUrlConfig, String remark,
			Integer status, Integer words_min, Integer is_fixed, Integer read_original_chapter_num, String roles,
			Integer start_rows, Integer end_rows, String small_pic, Integer read_user_count) {
		super();
		this.book_id = book_id;
		this.type_id = type_id;
		this.type_name = type_name;
		this.sex = sex;
		this.book_url = book_url;
		this.book_pic_url = book_pic_url;
		this.book_pic_changed = book_pic_changed;
		this.pic_path = pic_path;
		this.book_name = book_name;
		this.author = author;
		this.author_id = author_id;
		this.newest_chapter_num = newest_chapter_num;
		this.newest_chapter = newest_chapter;
		this.words = words;
		this.isserial = isserial;
		this.source_ids = source_ids;
		this.created_time = created_time;
		this.update_time_self = update_time_self;
		this.description = description;
		this.total_chapter_count = total_chapter_count;
		this.downloaded_chapter_count = downloaded_chapter_count;
		this.free_chapter_num = free_chapter_num;
		this.hot_value = hot_value;
		this.checked_ok = checked_ok;
		this.pic_down_flag = pic_down_flag;
		this.update_flag = update_flag;
		this.isUrlConfig = isUrlConfig;
		this.remark = remark;
		this.status = status;
		this.words_min = words_min;
		this.is_fixed = is_fixed;
		this.read_original_chapter_num = read_original_chapter_num;
		this.roles = roles;
		this.start_rows = start_rows;
		this.end_rows = end_rows;
		this.small_pic = small_pic;
		this.read_user_count = read_user_count;
	}
	public Book_list() {
		super();
	}
	
	
}
