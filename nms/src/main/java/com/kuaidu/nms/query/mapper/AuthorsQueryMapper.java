package com.kuaidu.nms.query.mapper;

import java.util.List;

import com.kuaidu.nms.entity.Author;

public interface AuthorsQueryMapper {
	 //作者表查
	 public List<Author> getAllAuthors(Author aList);
	 //作者增
	 public int add_aList(Author aList);
	 //作者删
	 public void del_aList(List<Object> list);
	 //作者改
	 public void edit_aList(Author aList);
	 //查询分页
	 public int getCount(Author aList);
}
