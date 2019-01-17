package com.kuaidu.nms.partner.push.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuaidu.nms.entity.ExternalPushPonfig;
import com.kuaidu.nms.entity.PartnerPushUrl;
import com.kuaidu.nms.entity.RecCover;
import com.kuaidu.nms.entity.RecLeadUrl;
import com.kuaidu.nms.entity.RecTitle;

import tk.mybatis.mapper.common.Mapper;

public interface PartnerPushUrlMapper extends Mapper<PartnerPushUrl> {


	void savePartnerPushUrl(PartnerPushUrl partnerPushUrl);

	List<PartnerPushUrl> getPushUrlInfo(@Param("partnerId")int partner_id, @Param("name")String name);

	int deletePartnerPushUrl(Integer pushId);

	int updatePartnerPushUrl(@Param("pushId")Integer pushId,@Param("name") String name, @Param("cost")BigDecimal cost);

	List<RecCover> getCover();

	RecCover getRanDomRecCover();

	List<RecTitle> getRecTitle();

	PartnerPushUrl selectOpenUrlByPuahId(Integer pushId);

	String getExpiryDate(Integer pushId);

	PartnerPushUrl getPartnerPushUrlByRandom(String random);

	PartnerPushUrl getOpenUrlByPushId(@Param("pushId")Integer pushId, @Param("partnerId")int partnerId);

	List<RecCover> getRecCovers();

	List<RecLeadUrl> getRecLeadUrl();

	RecTitle getRecTitleById(Integer rec_title_id);

	RecCover getRecCoverById(Integer rec_cover_id);

	void creatExternal_push_config(ExternalPushPonfig external_push_config);

}
