package com.kuaidu.nms.entity;

public class SpiderConfig {
	private int id;
	private String website_name;
	private String main_url;
	private String chapter_reg;
	private String chapter_url_reg;
	private String content_reg;
	private String next_page_reg;
	private String content_next_page_name_reg;
	private String content_next_page_name;
	private String content_next_page_reg;
	private String chapter_name;
	private int orderby;
	private int before_count;
	private int after_count;
	private String user_agent;
	private String cookie;
	private Integer method;
	private int sleep_mills;//每个网页休眠毫秒数
	private int stars;
	private String charset;
	private int spider_user_charset;//0:爬虫自动获取编码 1：按照设置的编码
	private int have_next_content;//是否有下一页内容
	private String created_time;
	private int should_filter;
	private Integer start_rows;  //起始行
	private Integer rows;	


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChapter_reg() {
		return chapter_reg;
	}
	public void setChapter_reg(String chapter_reg) {
		this.chapter_reg = chapter_reg;
	}
	public String getContent_reg() {
		return content_reg;
	}
	public void setContent_reg(String content_reg) {
		this.content_reg = content_reg;
	}
	public String getCreated_time() {
		return created_time;
	}
	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}
	public String getChapter_url_reg() {
		return chapter_url_reg;
	}
	public void setChapter_url_reg(String chapter_url_reg) {
		this.chapter_url_reg = chapter_url_reg;
	}

	public int getOrderby() {
		return orderby;
	}
	public void setOrderby(int orderby) {
		this.orderby = orderby;
	}
	public String getNext_page_reg() {
		return next_page_reg;
	}
	public void setNext_page_reg(String next_page_reg) {
		this.next_page_reg = next_page_reg;
	}
	public int getBefore_count() {
		return before_count;
	}
	public void setBefore_count(int before_count) {
		this.before_count = before_count;
	}
	public int getAfter_count() {
		return after_count;
	}
	public void setAfter_count(int after_count) {
		this.after_count = after_count;
	}
	public SpiderConfig() {
		super();
	}
	public String getUser_agent() {
		return user_agent;
	}
	public void setUser_agent(String user_agent) {
		this.user_agent = user_agent;
	}
	public String getCookie() {
		return cookie;
	}
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	public Integer getMethod() {
		return method;
	}
	public void setMethod(Integer method) {
		this.method = method;
	}
	public int getSleep_mills() {
		return sleep_mills;
	}
	public void setSleep_mills(int sleep_mills) {
		this.sleep_mills = sleep_mills;
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
	public String getWebsite_name() {
		return website_name;
	}
	public void setWebsite_name(String website_name) {
		this.website_name = website_name;
	}
	public String getMain_url() {
		return main_url;
	}
	public void setMain_url(String main_url) {
		this.main_url = main_url;
	}
	public String getContent_next_page_name_reg() {
		return content_next_page_name_reg;
	}
	public void setContent_next_page_name_reg(String content_next_page_name_reg) {
		this.content_next_page_name_reg = content_next_page_name_reg;
	}
	public String getContent_next_page_name() {
		return content_next_page_name;
	}
	public void setContent_next_page_name(String content_next_page_name) {
		this.content_next_page_name = content_next_page_name;
	}
	public String getContent_next_page_reg() {
		return content_next_page_reg;
	}
	public void setContent_next_page_reg(String content_next_page_reg) {
		this.content_next_page_reg = content_next_page_reg;
	}
	public String getChapter_name() {
		return chapter_name;
	}
	public void setChapter_name(String chapter_name) {
		this.chapter_name = chapter_name;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public String getCharset() {
		return charset;
	}
	public void setCharset(String charset) {
		this.charset = charset;
	}
	public SpiderConfig(int id, String website_name, String main_url, String chapter_reg, String chapter_url_reg,
			String content_reg, String next_page_reg, String content_next_page_name_reg, String content_next_page_name,
			String content_next_page_reg, String chapter_name, int orderby, int before_count, int after_count,
			String user_agent, String cookie, Integer method, int sleep_mills, int stars, String charset,
			String created_time, Integer start_rows, Integer rows) {
		super();
		this.id = id;
		this.website_name = website_name;
		this.main_url = main_url;
		this.chapter_reg = chapter_reg;
		this.chapter_url_reg = chapter_url_reg;
		this.content_reg = content_reg;
		this.next_page_reg = next_page_reg;
		this.content_next_page_name_reg = content_next_page_name_reg;
		this.content_next_page_name = content_next_page_name;
		this.content_next_page_reg = content_next_page_reg;
		this.chapter_name = chapter_name;
		this.orderby = orderby;
		this.before_count = before_count;
		this.after_count = after_count;
		this.user_agent = user_agent;
		this.cookie = cookie;
		this.method = method;
		this.sleep_mills = sleep_mills;
		this.stars = stars;
		this.charset = charset;
		this.created_time = created_time;
		this.start_rows = start_rows;
		this.rows = rows;
	}
	public int getHave_next_content() {
		return have_next_content;
	}
	public void setHave_next_content(int have_next_content) {
		this.have_next_content = have_next_content;
	}
	public int getSpider_user_charset() {
		return spider_user_charset;
	}
	public void setSpider_user_charset(int spider_user_charset) {
		this.spider_user_charset = spider_user_charset;
	}
	public int getShould_filter() {
		return should_filter;
	}
	public void setShould_filter(int should_filter) {
		this.should_filter = should_filter;
	}

	
}
