package com.kuaidu.nms.query.serviceImpl;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kuaidu.nms.entity.Book_list;
import com.kuaidu.nms.entity.H5PushConfig;
import com.kuaidu.nms.entity.Ranking;
import com.kuaidu.nms.entity.RestReturn;
import com.kuaidu.nms.query.mapper.BooksQueryMapper;
import com.kuaidu.nms.query.mapper.H5PushConfigMapper;
import com.kuaidu.nms.utils.Log4jUtil;
import com.kuaidu.nms.utils.fastdfs.FastDFSException;
import com.kuaidu.nms.utils.fastdfs.FastDFSTemplate;
import com.kuaidu.nms.utils.fastdfs.FastDfsInfo;

@Service
public class H5PushConfigServiceImpl {
	@Autowired
	H5PushConfigMapper h5PushConfigMapper;
	@Autowired
	BooksQueryMapper booksQueryMapper;
	
	@Autowired
	FastDFSTemplate fastDFSTemplatel;

	public List<H5PushConfig> getH5PushConfigServicebySex(Integer sex, Integer moduleId) {
		 List<H5PushConfig> list = h5PushConfigMapper.getH5PushConfigServicebySex(sex,moduleId);
		 return list;
	}

	public List<Ranking> getRankIngs() {
		return  h5PushConfigMapper.getRankIngs();
	}

	

	public List<Book_list> getBookNameAndPicture(String condition) {
		return booksQueryMapper.getBookNameAndPicture(condition);
	}

	public RestReturn uploadCarouselMap(MultipartFile file, Integer id)  {
		String fileAbsolutePath = "";
		try {
			byte[] bytes = file.getBytes();
			String originalFilename = file.getOriginalFilename();
			String type = StringUtils.substringAfterLast(originalFilename, ".");
			
			FastDfsInfo fastDfsInfo = fastDFSTemplatel.upload(bytes, type);
			fileAbsolutePath = fastDfsInfo.getFileAbsolutePath();
			int num  = h5PushConfigMapper.updateCarouselMapUrl(id,fileAbsolutePath);
			if (num == 0) {
				return RestReturn.fail("没有找到这本书");
			}
			return RestReturn.success();
		} catch (IOException e) {
			Log4jUtil.getSimpleErrorLogger().error(e);
		} catch (FastDFSException e) {
			Log4jUtil.getSimpleErrorLogger().error(e);
		}
		if (!fileAbsolutePath.equals("")) {
			try {
				fastDFSTemplatel.deleteFile(fileAbsolutePath);
			} catch (Exception e) {
				Log4jUtil.getSimpleErrorLogger().error(e);
			}
		}
		return RestReturn.fail("文件上传异常");
	}

	public RestReturn updateH5ConfigBook(Integer id, Integer bookId, Integer moduleId) {
		if (moduleId == 6) {
			int num =  h5PushConfigMapper.updateRanking(id,bookId);
			if (num == 0) {
				return RestReturn.fail();
			}
			
			return RestReturn.success();
			
		}else {
			int num =  h5PushConfigMapper.updateH5ConfigBook(id,bookId);
			if (num == 0) {
				return RestReturn.fail();
			}
			
			return RestReturn.success();
		}
	}

	
}
