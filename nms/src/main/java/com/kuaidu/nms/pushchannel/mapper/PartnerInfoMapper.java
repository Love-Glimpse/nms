package com.kuaidu.nms.pushchannel.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.entity.PartnerPmConfig;

public interface PartnerInfoMapper {

	List<PartnerInfo> getAllPartnerInfo(PartnerInfo partnerInfo);

	List<PartnerInfo> getSubPartner(PartnerInfo partnerInfo);

	void updatePartnerInfo(PartnerInfo partnerInfo);

	void addPartnerInfo(PartnerInfo partnerInfo);

	int getNextPartnerId();

	int checkPartnerSymbol(PartnerInfo partnerInfo);

	int checkPartnerName(PartnerInfo partnerInfo);

	int checkLoginName(PartnerInfo partnerInfo);

	void delPartnerInfo(int partner_id);

	List<PartnerInfo> getSubPartnerInfo(PartnerInfo partnerInfo);

	PartnerPmConfig getPartnerPmConfig(int partner_id);

	public int checkPaUser(@Param("partner_id")int id, @Param("md5_pwd")String s_pwd);

	public void changePaPwd(@Param("partner_id")int id,  @Param("md5_pwd")String n_pwd,  @Param("s_pwd")String s_pwd);

	void updateQrCodeUrl(@Param("qrCodeRul")String qrCodeRul,@Param("partnerId") Integer partnerId);

	void addPartnerPmConfig(PartnerPmConfig pmConfig);

	List<PartnerInfo> getWxAuthPartner();

	PartnerPmConfig getPartnerPmConfigByPartnerId(Integer partnerId);

	void changeKlFlag(@Param("partner_id")int partnerId, @Param("kl_flag")int kl_flag);

	void changeStatus(@Param("partner_id")int partnerId, @Param("status")int status);

	void addPartnerScale(@Param("partner_id")int partner_id);

	void changeProxyStatus(@Param("partner_id")int partnerId, @Param("status")int status);

	PartnerInfo getPartnerByPartnerId(@Param("partner_id")int partnerId);

	BigDecimal getPartnerAccountsScaleByPartnerId(int partner_id);
	
}
