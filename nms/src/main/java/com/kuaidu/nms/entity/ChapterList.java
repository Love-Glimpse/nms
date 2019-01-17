package com.kuaidu.nms.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChapterList {
	private Integer chapter_id;
	private Integer type_id;
	private Integer book_id;
	private String chapter_name;
	private String chapter_name_old;
	private Integer chapter_num;
	private String chapter_url;
	private String chapter_filepath;
	private String chapter_filepath_fdfs;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date created_time;
	private Integer words;
	private Integer oldWords;
	private Integer vip_flag;
	private Integer chapter_checked;
	private Integer content_exist_flag;
	private Integer content_upload_flag;
	private Integer read_original_chapter_num;
	private Integer sub_chapter_num;
	private Integer partner_sub_chapter_num;
	private Integer status;//状态
	private String source_ids;

	private Integer start_rows;  //起始行
	private Integer end_rows;	//末尾行
	
	
	public ChapterList() {
	
	}

	public Integer getChapter_id() {
		return chapter_id;
	}

	public void setChapter_id(Integer chapter_id) {
		this.chapter_id = chapter_id;
	}

	public Integer getType_id() {
		return type_id;
	}

	public void setType_id(Integer type_id) {
		this.type_id = type_id;
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

	public String getChapter_url() {
		return chapter_url;
	}

	public void setChapter_url(String chapter_url) {
		this.chapter_url = chapter_url;
	}

	public String getChapter_filepath() {
		return chapter_filepath;
	}

	public void setChapter_filepath(String chapter_filepath) {
		this.chapter_filepath = chapter_filepath;
	}

	public String getChapter_filepath_fdfs() {
		return chapter_filepath_fdfs;
	}

	public void setChapter_filepath_fdfs(String chapter_filepath_fdfs) {
		this.chapter_filepath_fdfs = chapter_filepath_fdfs;
	}

	

	public Date getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}

	public Integer getContent_exist_flag() {
		return content_exist_flag;
	}

	public void setContent_exist_flag(Integer content_exist_flag) {
		this.content_exist_flag = content_exist_flag;
	}

	public Integer getContent_upload_flag() {
		return content_upload_flag;
	}

	public void setContent_upload_flag(Integer content_upload_flag) {
		this.content_upload_flag = content_upload_flag;
	}

	public String getSource_ids() {
		return source_ids;
	}

	public void setSource_ids(String source_ids) {
		this.source_ids = source_ids;
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


	public String getChapter_name_old() {
		return chapter_name_old;
	}

	public void setChapter_name_old(String chapter_name_old) {
		this.chapter_name_old = chapter_name_old;
	}


	public ChapterList(Integer chapter_id, Integer type_id, Integer book_id, String chapter_name,
			String chapter_name_old, Integer chapter_num, String chapter_url, String chapter_filepath,
			String chapter_filepath_fdfs, Date created_time, Integer words, Integer vip_flag, Integer chapter_checked,
			Integer content_exist_flag, Integer content_upload_flag, String source_ids, Integer start_rows,
			Integer end_rows) {
		super();
		this.chapter_id = chapter_id;
		this.type_id = type_id;
		this.book_id = book_id;
		this.chapter_name = chapter_name;
		this.chapter_name_old = chapter_name_old;
		this.chapter_num = chapter_num;
		this.chapter_url = chapter_url;
		this.chapter_filepath = chapter_filepath;
		this.chapter_filepath_fdfs = chapter_filepath_fdfs;
		this.created_time = created_time;
		this.words = words;
		this.vip_flag = vip_flag;
		this.chapter_checked = chapter_checked;
		this.content_exist_flag = content_exist_flag;
		this.content_upload_flag = content_upload_flag;
		this.source_ids = source_ids;
		this.start_rows = start_rows;
		this.end_rows = end_rows;
	}

	@Override
	public String toString() {
		return "ChapterList [chapter_id=" + chapter_id + ", type_id=" + type_id + ", book_id=" + book_id
				+ ", chapter_name=" + chapter_name + ", chapter_name_old=" + chapter_name_old + ", chapter_num="
				+ chapter_num + ", chapter_url=" + chapter_url + ", chapter_filepath=" + chapter_filepath
				+ ", chapter_filepath_fdfs=" + chapter_filepath_fdfs + ", created_time=" + created_time + ", words="
				+ words + ", vip_flag=" + vip_flag + ", content_exist_flag=" + content_exist_flag
				+ ", content_upload_flag=" + content_upload_flag + ", source_ids=" + source_ids + ", start_rows="
				+ start_rows + ", end_rows=" + end_rows + "]";
	}

	public Integer getVip_flag() {
		return vip_flag;
	}

	public void setVip_flag(Integer vip_flag) {
		this.vip_flag = vip_flag;
	}

	public Integer getWords() {
		return words;
	}

	public void setWords(Integer words) {
		this.words = words;
	}

	public Integer getChapter_checked() {
		return chapter_checked;
	}

	public void setChapter_checked(Integer chapter_checked) {
		this.chapter_checked = chapter_checked;
	}

	public Integer getOldWords() {
		return oldWords;
	}

	public void setOldWords(Integer oldWords) {
		this.oldWords = oldWords;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getRead_original_chapter_num() {
		return read_original_chapter_num;
	}

	public void setRead_original_chapter_num(Integer read_original_chapter_num) {
		this.read_original_chapter_num = read_original_chapter_num;
	}

	public Integer getSub_chapter_num() {
		return sub_chapter_num;
	}

	public void setSub_chapter_num(Integer sub_chapter_num) {
		this.sub_chapter_num = sub_chapter_num;
	}

	public Integer getPartner_sub_chapter_num() {
		return partner_sub_chapter_num;
	}

	public void setPartner_sub_chapter_num(Integer partner_sub_chapter_num) {
		this.partner_sub_chapter_num = partner_sub_chapter_num;
	}
}
