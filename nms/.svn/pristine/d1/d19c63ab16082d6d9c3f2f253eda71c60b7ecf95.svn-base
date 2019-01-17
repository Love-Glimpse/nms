package com.kuaidu.nms.partner.push.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuaidu.nms.entity.Book_list;
import com.kuaidu.nms.entity.ChapterList;
import com.kuaidu.nms.entity.PartnerKeyword;
import com.kuaidu.nms.entity.PartnerPushUrl;
import com.kuaidu.nms.entity.PromotionActive;
import com.kuaidu.nms.entity.RecCover;
import com.kuaidu.nms.entity.RecTitle;

public interface KeywordReplyMapper{
	List<PartnerKeyword> getKeywordReply(@Param("start_rows")Integer start_rows, @Param("rows")Integer rows,@Param("partner_id") int partner_id);

	int getKeywordReplyCount();

	public void delKeywords(List<Object> list);

	void addKeyword(PartnerKeyword partnerKeyword);
	
	List<Book_list> seachBook(Book_list book_list);
	
	List<ChapterList> seaChapter(ChapterList chapter_list);
	/*查询所有图*/
	List<RecCover> searchImg(RecCover rec_cover);
	
	List<RecTitle> AllTitle(RecTitle recTitle);
	
	List<RecTitle> randTitle(RecTitle recTitle);
	
	List<RecCover> randPic(RecCover rec_cover);
	//平台活动
	List<PromotionActive> platActive(PromotionActive promotionActive);
	//渠道活动
	List<PromotionActive> partActive(PromotionActive promotionActive);
	//内推
	List<PartnerPushUrl> internalPush(PartnerPushUrl partnerPushUrl);
}
