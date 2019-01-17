package com.kuaidu.nms.spider.controller.serviceImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuaidu.nms.entity.BookLabel;
import com.kuaidu.nms.entity.Book_list;
import com.kuaidu.nms.entity.ChapterList;
import com.kuaidu.nms.entity.Label;
import com.kuaidu.nms.entity.ReplaceConfig;
import com.kuaidu.nms.entity.SpiderConfig;
import com.kuaidu.nms.entity.TaskConfig;
import com.kuaidu.nms.spider.mapper.WebSpiderMapper;
@Service
public class WebSpiderImpl {
	@Autowired
	WebSpiderMapper wMapper;

	public SpiderConfig getSpiderConfig(String url) {
		// TODO Auto-generated method stub
		return wMapper.getSpiderConfig(url);
	}
	/**检查小说章节的状态
	 * return 不存在或内容未下载，返回false
	 * 		  章节状态完好，返回true 
	 * 
	 * 效率太低
	 * */
	public boolean checkChapter(String chapter_name) {
		// TODO Auto-generated method stub
		Integer count= wMapper.getCheckCount(chapter_name);
		if (count==0) {
			return false;
		}
		return false;
	}
	
	public List<ChapterList> getAllChapterList(Integer book_id,int content_upload_flag) {
		// TODO Auto-generated method stub
		return wMapper.getAllChapterList(book_id,content_upload_flag);
	}
	public List<ReplaceConfig> getReplaces(Integer sbook_id) {
		// TODO Auto-generated method stub
		return wMapper.getReplaces(sbook_id);
	}
	public List<Map<String, Object>> getBooksInfo(Set<Object> book_ids) {
		// TODO Auto-generated method stub
		return wMapper.getBooksInfo(book_ids);
	}
	public boolean novelTypeExist(String typeName) {
		// TODO Auto-generated method stub
		if (wMapper.getNovelType(typeName)==0) {
			return false;
		}else {
			return true;
		}
	}
	public void saveNovel(String typeName) {
		// TODO Auto-generated method stub
		wMapper.saveNovel(typeName);
	}
	public int getTypeId(String typeName) {
		// TODO Auto-generated method stub
		return wMapper.getTypeId(typeName);
	}
	public void saveBookInfo(Book_list book_list) {
		// TODO Auto-generated method stub
		wMapper.saveBookInfo(book_list);
	}
	public void updateBook(Book_list book_list) {
		// TODO Auto-generated method stub
		wMapper.updateBook(book_list);
	}
	public int getDownChapterCount(Integer book_id) {
		// TODO Auto-generated method stub
		return wMapper.getDownChapterCount(book_id);
	}
	public ChapterList getChapterInfo(ChapterList chapterList) {
		return  wMapper.getChapterInfo(chapterList);
	}
	public void saveChapterDown(List<ChapterList> saveLists) {
		// TODO Auto-generated method stub
		wMapper.saveChapterDown(saveLists);
	}
	public void updateChapter(String chapter_name,String filePath) {
		// TODO Auto-generated method stub
		wMapper.updateChapter(chapter_name,filePath);
	}
	public void updateFdfsPath(ChapterList chapterList) {
		// TODO Auto-generated method stub
		wMapper.updateFdfsPath(chapterList);
	}
	public void updateDownBooKChapterCount(Integer sbook_id, int words) {
		// TODO Auto-generated method stub
		wMapper.updateDownBooKChapterCount(sbook_id,words);
	}
	public void updateBookNewestChapter(Integer sbook_id, String newestChapterName, Integer newestChapterNum) {
		// TODO Auto-generated method stub
		wMapper.updateBookNewestChapter(sbook_id,newestChapterName,newestChapterNum);
	}
	public void updateBookStatus(Book_list book_list) {
		// TODO Auto-generated method stub
		wMapper.updateBookStatus(book_list);
	}
	public void updateBookStatusAll() {
		// TODO Auto-generated method stub
		wMapper.updateBookStatusAll();
	}
	public void updateTaskConfig(String ip) {
		// TODO Auto-generated method stub
		wMapper.updateTaskConfig(ip);
	}
	public void saveTaskConfig(String ip, List<Map<String, Object>> book_lists) {
		// TODO Auto-generated method stub
		for (Map<String, Object> map : book_lists) {
			
			try {
				URL bookUrl = new URL(map.get("book_url")+"");
				TaskConfig taskConfig = new TaskConfig();
				taskConfig.setDomain(bookUrl.getHost());
				taskConfig.setIp_address(ip);
				taskConfig.setBook_id(Integer.parseInt(map.get("book_id")+""));
				wMapper.saveTaskConfig(taskConfig);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	}
	public List<Book_list> getBooksInfo818() {
		// TODO Auto-generated method stub
		return wMapper.getBooksInfo818();
	}
	public int getWordsMin(Integer sbook_id) {
		// TODO Auto-generated method stub
		return wMapper.getWordsMin(sbook_id);
	}
	public Book_list getBookList(Book_list book_list) {
		// TODO Auto-generated method stub
		return wMapper.getBookList(book_list);
	}
	public void savezBookId(String zBookID, Integer book_id) {
		// TODO Auto-generated method stub
		wMapper.savezBookId(zBookID,book_id);
	}
	public List<BookLabel> getBookLabels() {
		// TODO Auto-generated method stub
		return wMapper.getBookLabels();
	}
	public void updateBookLables(List<BookLabel> bookLabels) {
		// TODO Auto-generated method stub
		wMapper.updateBookLables(bookLabels);
	}
	public Label getLabelByName(String tag) {
		// TODO Auto-generated method stub
		return wMapper.getLabelByName(tag);
	}
	public int saveLabel(Label label) {
		// TODO Auto-generated method stub
		return wMapper.saveLabel(label);
	}
	public List<Book_list> getNoSourceUrlBooks() {
		// TODO Auto-generated method stub
		return wMapper.getNoSourceUrlBooks();
	}
	public void updateBookUrl(Book_list book_list) {
		// TODO Auto-generated method stub
		wMapper.updateBookUrl(book_list);
	}
}
