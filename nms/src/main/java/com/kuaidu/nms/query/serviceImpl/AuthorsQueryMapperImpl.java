package com.kuaidu.nms.query.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaidu.nms.entity.Author;
import com.kuaidu.nms.query.mapper.AuthorsQueryMapper;
/*
 * 接口实现类
 * */
@Service
@Transactional 
public class AuthorsQueryMapperImpl {
	@Resource
	private AuthorsQueryMapper aMapper;

	public AuthorsQueryMapper getbMapper() {
		return aMapper;
	}
	public void setaMapper(AuthorsQueryMapper aMapper) {
		this.aMapper = aMapper;
	}
	//查询作者
	public List<Author> getAllAuthors(Author aList) {
		return aMapper.getAllAuthors(aList);
	}
	//获取作者记录总行数
	public int getCount(Author aList) {
		return aMapper.getCount(aList);
	}
	//添加作者
	public void add_aList(Author aList){
		 aMapper.add_aList(aList);
	}
	 //删除作者
	public void del_aList(List<Object> list){
		 aMapper.del_aList(list);
	}
	 //修改作者
	public void edit_aList(Author aList){
		 aMapper.edit_aList(aList);
	}	
}
