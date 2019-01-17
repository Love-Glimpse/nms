package com.kuaidu.nms.spider.mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.kuaidu.nms.entity.BookLabel;
import com.kuaidu.nms.entity.Book_list;
import com.kuaidu.nms.entity.ChapterList;
import com.kuaidu.nms.entity.Label;
import com.kuaidu.nms.entity.ReplaceConfig;
import com.kuaidu.nms.entity.SpiderConfig;
import com.kuaidu.nms.entity.TaskConfig;

public interface WebSpiderMapper {
	SpiderConfig getSpiderConfig(@Param("url")String url);

	Integer getCheckCount(@Param("chapter_name")String chapter_name);

	List<ChapterList> getAllChapterList(@Param("book_id")Integer book_id, @Param("content_upload_flag")int content_upload_flag);

	List<ReplaceConfig> getReplaces(@Param("book_id")Integer sbook_id);
	
	List<Map<String, Object>> getBooksInfo(@Param("set")Set<Object> book_ids);

	int getNovelType(@Param("type_name")String typeName);

	void saveNovel(@Param("type_name")String typeName);

	int getTypeId(@Param("type_name")String typeName);

	void saveBookInfo(Book_list book_list);

	void updateBook(Book_list book_list);

	int getDownChapterCount(@Param("book_id")Integer book_id);

	void saveChapterDown(List<ChapterList> saveLists);

	ChapterList getChapterInfo(ChapterList chapterList);

	void updateChapter(@Param("chapter_name")String chapter_name,@Param("filePath")String filePath);

	void updateBookAotuDown(@Param("book_id")Integer sbook_id);

	void updateFdfsPath(ChapterList chapterList);

	void updateDownBooKChapterCount(@Param("book_id")Integer sbook_id, @Param("words")int words);

	void updateBookNewestChapter(@Param("book_id")Integer sbook_id, @Param("newest_chapter")String newestChapterName, @Param("newest_chapter_num")Integer newestChapterNum);

	void updateBookStatus(Book_list book_list);

	void updateBookStatusAll();

	void updateTaskConfig(String ip);

	void saveTaskConfig(TaskConfig taskConfig);

	List<Book_list> getBooksInfo818();

	int getWordsMin(@Param("book_id")Integer sbook_id);

	Book_list getBookList(Book_list book_list);

	void savezBookId(@Param("zBookID")String zBookID, @Param("book_id")Integer book_id);

	List<BookLabel> getBookLabels();

	void updateBookLables(@Param("list")List<BookLabel> bookLabels);

	Label getLabelByName(@Param("tag")String tag);

	int saveLabel(Label label);

	List<Book_list> getNoSourceUrlBooks();

	void updateBookUrl(Book_list book_list);

	void deleteTaskConfigByBookId(@Param("book_id")Integer book_id);
}
