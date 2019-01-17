package com.kuaidu.nms.partner.push.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kuaidu.nms.entity.PartnerTemplateMsg;

import tk.mybatis.mapper.common.Mapper;

public interface TemplateInformationMapper extends Mapper<PartnerTemplateMsg>{
	List<PartnerTemplateMsg> getTemplateInformation(@Param("start_rows")Integer start_rows, @Param("rows")Integer rows,@Param("partner_id") int partner_id);

	int getTemplateInformationCount();

	void addTemplateMsg(PartnerTemplateMsg partnerTemplateMsg);

	void deletePartnerTemplateMsg(List<Object> list);

	Map<String, Object> getUserOpenidAndNiceName(Integer userId);

	void testSendTemplageMsg(@Param("userId")Integer userId,@Param("parentId")int parentId,@Param("openid")String openid
			,@Param("data")String data,@Param("url")String url,@Param("template_id") String template_id);

}
