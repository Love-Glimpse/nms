package com.kuaidu.nms.query.serviceImpl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaidu.nms.entity.Author;
import com.kuaidu.nms.entity.Book_list;
import com.kuaidu.nms.entity.Novel_type;
import com.kuaidu.nms.query.mapper.BooksQueryMapper;
import com.kuaidu.nms.query.mapper.ChapterMapper;
import com.kuaidu.nms.spider.mapper.WebSpiderMapper;
import com.kuaidu.nms.utils.Utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import us.codecraft.webmagic.selector.Html;
/*
 * 接口实现类
 * */
@Service
@Transactional 
public class BooksQueryMapperImpl {
	@Autowired
	private BooksQueryMapper bMapper;

	@Autowired 
	RedisTemplate<String, List<Object>> redisTemplate;
	
	@Autowired
	ChapterMapper cMapper;
	
	@Autowired 
	WebSpiderMapper wMapper;
	public BooksQueryMapper getbMapper() {
		return bMapper;
	}
	
	public void setbMapper(BooksQueryMapper bMapper) {
		this.bMapper = bMapper;
	}
	//查询书籍
	public List<Book_list> getAllbooks(Book_list bList) {
		return bMapper.getAllbooks(bList);
	}
	public List<Novel_type> getAllnovel_type() {
		return bMapper.getAllnovel_type();
	}
	//获取书籍记录总行数
	public int getCount(Book_list bList) {
		return bMapper.getCount(bList);
	}
	//获取同书名同作家记录总行数
	public int getSameCount(Book_list bList) {
		return bMapper.getSameCount(bList);
	}
	//添加书籍
	public void add_bList(Book_list bList){
		 bMapper.add_bList(bList);
		 //添加书主角名
		 bMapper.addBookLabelsByBookId(bList);
	}
	 //删除书籍
	@Transactional
	public void del_bList(List<Object> list){
		 bMapper.del_bList(list);
		 bMapper.delBookLables(list);
	}
	 //修改书籍
	public void edit_bList(Book_list bList){
		 bMapper.edit_bList(bList);
		 bMapper.addBookLabelsByBookId(bList);
	}

	 //查询作者表
	public List<Author> getAllAuthors(Author author){
		return bMapper.getAllAuthors(author);
	}

	public void add_author(Author author) {
	bMapper.add_author(author);
		
	}
	//添加章节后数据章节数加一
/*	public void updateBookList(ChapterList chapterList){
		bMapper.updateBookList(chapterList);
	}*/

	public void checkOk(Book_list book_list) {
		// TODO Auto-generated method stub
		bMapper.checkOk(book_list);
	}

	public void updateRemark(Book_list book_list) {
		// TODO Auto-generated method stub
		bMapper.updateRemark(book_list);
	}

	public List<Book_list> getNoPic() {
		return bMapper.getNoPic();
	}

	public List<Book_list> getPicByIds(String[] split) {
		return bMapper.getPicByIds(split);
	}

	public void updateBookPic(Integer bookId, String picPath) {
		bMapper.updateBookPic( bookId,  picPath);
	}

	public List<Book_list> getbookPic(Integer changed) {
		return bMapper.getbookPic(changed);
	}

	public String getBookPicUrl(Integer id) {
		return bMapper.getBookPicUrl(id);
	}

	public void updateBooksmallPic(Integer bookId, String substringBefore) {
		 bMapper.updateBooksmallPic(bookId,substringBefore);
	}

	public String getBookSmallPic(String name) {
		return bMapper.getBookSmallPic(name);
	}

	public String getbookPicById(Integer bookId) {
		return bMapper.getbookPicById(bookId);
	}

	public List<Book_list> getsmall() {
		return bMapper.getsmall();
	}

	public List<Book_list> getpic() {
		// TODO Auto-generated method stub
		return bMapper.getpic();
	}
	/**
	 * return 1 : 提交成功
	 * 		11:提交成功，但book_url没找到
	 * 		2:重复提交成功
	 * 		3:数据库错误
	 * 		4：redis 错误
	 * 		5：不支持操作
	 * 		0：失败
	 * @param book_name 
	 * */
	public int bookClear(Integer book_id, String book_name) {
		// TODO Auto-generated method stub
		int ret = 0;
		if (!Utils.getLocalHostIp().matches("69\\.171\\.67\\.171")) {
			return 5;
		}
		
		Book_list book_list = new Book_list();
		book_list.setBook_id(book_id);
		book_list.setStatus(3);
		//更新书状态
		wMapper.updateBookStatus(book_list);
		List<Object> chapterLists = cMapper.getAllChapterByBookID(book_id);
		String key = "clearBook:"+book_id;
		try {
			redisTemplate.opsForSet().remove("GetChapterJob", book_id);
			wMapper.deleteTaskConfigByBookId(book_list.getBook_id());
			redisTemplate.opsForValue().set(key, chapterLists);
			try {
				ret = chapterClear(book_id,book_name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ret = 3;
			}
		//	}
			//发送消息通知
			redisTemplate.convertAndSend("clearBook", key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = 4;
		}
		 
		return ret;
	}
	/**
	 * 1:成功
	 * 11：成功，但book_url没找到
	 * 0：失败
	 * @throws UnsupportedEncodingException 
	 * */
	@Transactional
	private int chapterClear(Integer book_id,String book_name) throws UnsupportedEncodingException{
		// TODO Auto-generated method stub
		cMapper.delChapterListsByBookId(book_id);
		String book_url = "";
		int ret = 0;
		JSONObject bookUrl = getUrlFromRzlib(book_name);
		JSONArray urlArray = bookUrl.optJSONArray("bookUrl");
		if (urlArray!=null&&urlArray.size()>0) {
			book_url = urlArray.getString(0);
			ret = 1;
		}else {
			ret = 11;
		}
		bMapper.clearBookList(book_id,book_url);
		return ret;
	}

	public static JSONObject getUrlFromRzlib(String book_name) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		JSONObject jsonRet = new JSONObject();
		String url = "https://www.rzlib.net/modules/article/search.php?searchkey="+URLEncoder.encode(book_name,"gbk");
		String htmlStr = Utils.getHtmlcodeWithoutHeader(url, "utf-8");
		if (htmlStr==null|| htmlStr.equalsIgnoreCase("")) {
			jsonRet.put("bookUrl",null);
			return jsonRet;
		}
		Html pageHtml = new Html(htmlStr);
		List<String> urls = pageHtml.xpath("//div[@class='inl']/ul/li/a").links().all();

		if (urls.size()>0) {
			JSONArray urlArray = new JSONArray();
			for (int i = 0; i < urls.size(); i++) {
				if (urls.get(i).matches("https://www\\.rzlib\\.net/b/\\d+/\\d+/")) {
					urlArray.add(urls.get(i));
				}
			}
			if (urlArray.size()>0) {
				jsonRet.put("bookUrl", urlArray);
			}else {
				jsonRet.put("bookUrl", null);
			}
		}else {
			jsonRet.put("bookUrl",null);
		}
		return jsonRet;
	}
	public static String getUrlFromRzlibStr(String book_name) {
		String book_url = "";
		JSONObject bookUrl;
		try {
			bookUrl = getUrlFromRzlib(book_name);
			JSONArray urlArray = bookUrl.optJSONArray("bookUrl");
			if (urlArray!=null&&urlArray.size()>0) {
				book_url = urlArray.getString(0);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book_url;
	}

	public int editReadOriginalChapter(Integer book_id, Integer chapter_num) {
		// TODO Auto-generated method stub
		try {
			bMapper.editReadOriginalChapter(book_id,chapter_num);
			return 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
	}

	public int editSubscribeChapter(int partner_id,Integer book_id, Integer chapter_num) {
		// TODO Auto-generated method stub
		try {
			
			bMapper.editSubscribeChapter(partner_id,book_id,chapter_num);
			return 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
	}

	public void editSubscribeChapterByBookName(int partner_id, String book_name, int sub_chapter_num) {
		// TODO Auto-generated method stub
		Integer book_id = bMapper.getbookIdByBookname(book_name);
		if (book_id!=null) {
			editSubscribeChapter(partner_id, book_id, sub_chapter_num);
		}
	}
	public Integer getbookIdByBookname(String book_name){
		return bMapper.getbookIdByBookname(book_name);
	}
	
}
