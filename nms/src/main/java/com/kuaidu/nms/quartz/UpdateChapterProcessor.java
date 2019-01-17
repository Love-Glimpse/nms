package com.kuaidu.nms.quartz;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.kuaidu.nms.entity.ChapterList;
import com.kuaidu.nms.query.serviceImpl.ChpterServerImpl;
import com.kuaidu.nms.utils.Log4jUtil;
import com.kuaidu.nms.utils.fastdfs.FastDFSException;
import com.kuaidu.nms.utils.fastdfs.FastDFSTemplate;
import com.kuaidu.nms.utils.fastdfs.FastDfsInfo;

/**
 * 下载线程
 */
public class UpdateChapterProcessor extends Thread {
	private boolean startflg = false;
	
	public static FastDFSTemplate fastDFSTemplate;
	public FastDFSTemplate getFastDFSTemplate() {
		return fastDFSTemplate;
	}
	@Autowired
	public void setFastDFSTemplate(FastDFSTemplate fastDFSTemplate) {
		UpdateChapterProcessor.fastDFSTemplate = fastDFSTemplate;
	}
	
	public static ChpterServerImpl cImpl;
	
	public ChpterServerImpl getcImpl() {
		return cImpl;
	}
	@Autowired
	public void setcImpl(ChpterServerImpl cImpl) {
		UpdateChapterProcessor.cImpl = cImpl;
	}
	public void run() {
		while(startflg){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				startflg = false;
			}
			Log4jUtil.getBusinessLogger().info("task begin!!");
			if (cImpl==null) {
				Log4jUtil.getBusinessLogger().info("cImpl null!!");
				continue;
			}
			List<ChapterList> chapterLists = cImpl.getChapterLists();
			//Log4jUtil.getBusinessLogger().info(Thread.currentThread().getName()+"=="+chapterLists.toString());
			for (ChapterList chapterList : chapterLists) {
				try {
					URL url = new URL(chapterList.getChapter_filepath_fdfs());
					byte[] bytes = IOUtils.toByteArray(url);
					if (bytes!=null&&bytes.length>0) {
						FastDfsInfo fInfo = fastDFSTemplate.upload(bytes, "zip");
						//Log4jUtil.getBusinessLogger().info("chapter_id="+chapterList.getChapter_id()+",path="+fInfo.getFileAbsolutePath());
						chapterList.setChapter_filepath_fdfs(fInfo.getFileAbsolutePath());
						chapterList.setContent_upload_flag(1);
						cImpl.updateChapterFdfs(chapterList);
					}else {
						cImpl.updateChapterDoFlag(chapterList);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					cImpl.updateChapterDoFlag(chapterList);
				} catch (FastDFSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					cImpl.updateChapterDoFlag(chapterList);
				}
			}
			if (chapterLists.size()>0) {
				cImpl.updateChapterRun(chapterLists,0);
			}
			
		}
	
	}

	public boolean isStartflg() {
		return startflg;
	}

	public void setStartflg(boolean startflg) {
		this.startflg = startflg;
	}

}
