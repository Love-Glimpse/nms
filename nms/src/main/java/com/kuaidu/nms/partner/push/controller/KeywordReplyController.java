package com.kuaidu.nms.partner.push.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kuaidu.nms.entity.Book_list;
import com.kuaidu.nms.entity.ChapterList;
import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.entity.PartnerKeyword;
import com.kuaidu.nms.entity.PartnerPushUrl;
import com.kuaidu.nms.entity.PromotionActive;
import com.kuaidu.nms.entity.RecCover;
import com.kuaidu.nms.entity.RecTitle;
import com.kuaidu.nms.partner.push.serviceImpl.KeywordReplyServiceImpl;
import com.kuaidu.nms.utils.ResultData;
import com.kuaidu.nms.utils.Utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/** 
 * @Title KeywordReplyController.java 
 * @description 关键词回复配置
 * @time 2018年11月7日 下午2:23:41 
 * @author victor 
 * @version 1.0 
**/
@Controller
@RequestMapping("partnerKeywordReply")
public class KeywordReplyController {
	@Autowired
	KeywordReplyServiceImpl kImpl;
	
	@RequestMapping("/keywordReplyIndex")
	public ModelAndView keywordReplyIndex(HttpSession session){
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("partner/PushChannel/keywordReply"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	@ResponseBody
	@RequestMapping("/getKeywordReply")
	public String getKeywordReply(HttpSession session,HttpServletRequest request){
		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		if (partnerInfo==null) {
			return null;
		}
		Integer page= Integer.parseInt(request.getParameter("page"));	
		Integer rows= Integer.parseInt(request.getParameter("rows"));
		Integer start_rows = (page-1)*rows;
		List<PartnerKeyword> pKeywords = kImpl.getKeywordReply(start_rows,rows,partnerInfo.getPartner_id());
		int total = kImpl.getKeywordReplyCount();
		return ResultData.toJsonString(total, pKeywords);
	}
	
	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping("/delKeyword")
	public String delKeywords(HttpSession session,HttpServletRequest request){
		String node =request.getParameter("node");
		JSONObject jsonObject = new JSONObject();
		JSONArray jArray = new JSONArray();
		try {
			JSONArray jsonArray = JSONArray.fromObject(node);  
	        List<Object> list= new ArrayList<Object>();
	        for(int i=0;i<jsonArray.size();i++){
	            list.add(jsonArray.get(i));
	        }
	        System.out.println(list);
	        kImpl.delKeywords(list);
	        jsonObject.put("result", "0");
	        
		} catch (Exception e) {
			 jsonObject.put("result", "1");
			e.printStackTrace();
			
		}finally {
			jArray.add(jsonObject.toString());
			return jArray.toString();
		}
	}
	
	
	
	
	
		@ResponseBody
		@RequestMapping("/addKeyword")
		public JSONObject addKeyword(HttpSession session,PartnerKeyword partnerKeyword){
			JSONObject retJson = new JSONObject();
			int ret=0;
			PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
			if (partnerInfo==null) {
				retJson.put("result", 3);
				return retJson;
			}
			partnerKeyword.setPartner_id(partnerInfo.getPartner_id());
			partnerKeyword.setStatus(1);
			
			ret = kImpl.addKeyword(partnerKeyword);
			retJson.put("result", ret);
			return retJson;
		
	}
		//查询书
		@ResponseBody
		@RequestMapping("/searchBook")
		public JSONObject searchBook(HttpSession session,Book_list book_list){
			PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
			JSONObject retJson = new JSONObject();
			List<Book_list> book_lists = kImpl.seachBook(book_list);
			retJson.put("book_name", book_lists);
			retJson.put("partnerId", partnerInfo.getPartner_id());
			return retJson;
		
		}
		//查询章节
		@ResponseBody
		@RequestMapping("/searchChapter")
		public JSONObject searchChapter(HttpSession session,ChapterList chapter_list){
			JSONObject retJson = new JSONObject();
			List<ChapterList> chapter_lists = kImpl.seaChapter(chapter_list);
			retJson.put("chapter_name", chapter_lists);
			return retJson;
			
		}
		//图
		@ResponseBody
		@RequestMapping("/activeImg")
		public JSONObject activeImg(HttpSession session,RecCover rec_cover){
			JSONObject retJson = new JSONObject();
			List<RecCover> rec_covers = kImpl.searchImg(rec_cover);
			retJson.put("active_img", rec_covers);
			return retJson;
			
		}
		//所有标题
		@ResponseBody
		@RequestMapping("/getTitle")
		public JSONObject getTitle(HttpSession session,RecTitle recTitle){
			JSONObject retJson = new JSONObject();
			List<RecTitle> rec_title = kImpl.AllTitle(recTitle);
			retJson.put("title", rec_title);
			return retJson;
			
		}
		//随机标题
		@ResponseBody
		@RequestMapping("/randomTitle")
		public JSONObject randTitle(HttpSession session,RecTitle recTitle){
			JSONObject retJson = new JSONObject();
			List<RecTitle> rec_Title = kImpl.randTitle(recTitle);
			retJson.put("randTitle", rec_Title);
			System.out.println(retJson);
			return retJson;
			
		}
		//随机图片
		@ResponseBody
		@RequestMapping("/randomPic")
		public JSONObject randPic(HttpSession session,RecCover rec_cover){
			JSONObject retJson = new JSONObject();
			List<RecCover> rec_Pic = kImpl.randPic(rec_cover);
			retJson.put("randPic", rec_Pic);
			System.out.println(retJson);
			return retJson;
			
		}
		
		//平台活动
		@ResponseBody
		@RequestMapping("/PlatActive")
		public JSONObject platActive(HttpSession session,PromotionActive promotionActive){
			PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
			JSONObject retJson = new JSONObject();
			List<PromotionActive> plat_Active = kImpl.platActive(promotionActive);
			for (PromotionActive pActive : plat_Active) {
				pActive.setActive_url(pActive.getActive_url().replace("####", partnerInfo.getPartner_id()+"")+pActive.getActive_id());
			}
			retJson.put("platActive", plat_Active);
			System.out.println(retJson);
			return retJson;
			
		}
		//渠道活动
		@ResponseBody
		@RequestMapping("/PartActive")
		public JSONObject partActive(HttpSession session,PromotionActive promotionActive){
			PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
			if(partnerInfo!=null){
				JSONObject retJson = new JSONObject();
				/*获取渠道id*/
				promotionActive.setPartner_id(partnerInfo.getPartner_id());
				
				List<PromotionActive> part_Active = kImpl.partActive(promotionActive);
				for (PromotionActive pActive : part_Active) {
					pActive.setActive_url(pActive.getActive_url().replace("####", partnerInfo.getPartner_id()+"")+pActive.getActive_id());
				}
				retJson.put("partActive", part_Active);
				return retJson;
				
			}else{
				return null;
			}
		}
		
		//内推链接
		@ResponseBody
		@RequestMapping("/internalPush")
		public JSONObject internalPush(HttpSession session,PartnerPushUrl partnerPushUrl){
			PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
			if(partnerInfo!=null){
				JSONObject retJson = new JSONObject();
				partnerPushUrl.setPartner_id(partnerInfo.getPartner_id());
				List<PartnerPushUrl> internal_Push = kImpl.internalPush(partnerPushUrl);
				retJson.put("internalPush", internal_Push);
				System.out.println(retJson);
				return retJson;
				
			}else{
				return null;
			}
		}
		
	
}
