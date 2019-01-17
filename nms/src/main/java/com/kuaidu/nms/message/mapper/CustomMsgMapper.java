package com.kuaidu.nms.message.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kuaidu.nms.entity.PartnerCustomMsg;
import com.kuaidu.nms.entity.PartnerCustomMsgConfig;
import com.kuaidu.nms.entity.WxCustomMsg;

public interface CustomMsgMapper {

	void createCustomMsg();

	void updateMsgStatus(WxCustomMsg customMsg);

	List<WxCustomMsg> loadCustomMsg();

	void updateCustomMsg(List<WxCustomMsg> wxCustomMsgs);

	void batchInsertCustomMsg(List<WxCustomMsg> subList);

	List<PartnerCustomMsgConfig> getAutoSendPartner();

	String getCustomMsgInfoByUserId(@Param("userId")int userId);

	Map<String, Object> getReadBookIdByUserID(@Param("user_id")int userId);

	List<Integer> getSimilarBookIds(@Param("labelId")String labelId, @Param("rBookId")Integer readBookId, @Param("userId")int userId);

	String getCustomMsgInfoByBookId(@Param("partnerId")Integer partnerId,@Param("bookId")Integer sendBookId);

	List<PartnerCustomMsg> loadPartnerCustomMsg();

	void updatePartnerCustomMsgsStatus(List<PartnerCustomMsg> partnerCustomMsgs);

	void saveCustomMsg(WxCustomMsg wxCustomMsg);

	void updatePartnerCustomMsgStatusByMsgId(@Param("p_msg_id")int p_msg_id, @Param("send_status")int send_status);

	void updateSendMsgCount(WxCustomMsg customMsg);
	
}
