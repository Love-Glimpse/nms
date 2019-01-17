package com.kuaidu.nms.partner.push.serviceImpl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kuaidu.nms.entity.Book_list;
import com.kuaidu.nms.entity.ChapterList;
import com.kuaidu.nms.entity.Novel_type;
import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.query.mapper.BooksQueryMapper;
import com.kuaidu.nms.query.mapper.ChapterMapper;
import com.kuaidu.nms.utils.Log4jUtil;
import com.kuaidu.nms.utils.Utils;

@Service
public class BookServiceImpl {

	@Autowired
	BooksQueryMapper booksQueryMapper;
	@Autowired
	ChapterMapper chapterMapper;
	
	
	
	
	public PageInfo<Book_list> getBooksBycondition(Integer sex, Integer isserial, Integer typeId, Integer hotValue, String bookName, Integer pn, Integer ps) {
		PageHelper.startPage(pn, ps);
		List<Book_list> list = booksQueryMapper.getBooksBycondition(sex,isserial,bookName,typeId,hotValue);
		return new PageInfo<Book_list>(list);
	}




	public List<Novel_type> getNovelTypeBy(Integer sex) {
		return booksQueryMapper.getNovelTypeBy(sex);
	}


	public HashMap<String, Object> catalog(Integer bookId,HttpSession session) {
		HashMap<String,Object> map = new HashMap<String, Object>();
		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		if (partnerInfo==null||partnerInfo.getPartner_id()<=0) {
			return map;
		}
		Book_list bookList = booksQueryMapper.getBookInfoBybookId(bookId);
		List<ChapterList> list = chapterMapper.getFreeChapterByBookId(bookId,partnerInfo.getPartner_id());
		map.put("book", bookList);
		map.put("chapters", list);
		return map;
	}




	public String getChapterContent(Integer chapterId) {
		String url = chapterMapper.getChapterUrl(chapterId);
		String content = "章节内容有误";
		try {
			content = Utils.getContentByUrl(url);
		} catch (Exception e) {
			Log4jUtil.getSimpleErrorLogger().error("章节内容有误，章节id："+chapterId, e);
		}
		return content;
	}
}
