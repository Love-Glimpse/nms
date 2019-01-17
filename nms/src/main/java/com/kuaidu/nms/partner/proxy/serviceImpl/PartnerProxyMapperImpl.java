package com.kuaidu.nms.partner.proxy.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.partner.proxy.mapper.PartnerProxyMapper;
import com.kuaidu.nms.pushchannel.mapper.PartnerInfoMapper;

/** 
 * @Title PartnerProxyMapperImpl.java 
 * @description TODO 
 * @time 2018年10月16日 上午11:31:44 
 * @author victor 
 * @version 1.0 
**/
@Service
public class PartnerProxyMapperImpl {
	@Resource
	PartnerProxyMapper proxyMapper;
	
	@Resource PartnerInfoMapper pMapper;

	public List<PartnerInfo> getProxy(PartnerInfo partnerInfo) {
		// TODO Auto-generated method stub
		
		List<PartnerInfo> partnerInfos = proxyMapper.getProxy(partnerInfo);
		return partnerInfos;
	}

	public int updateProxy(PartnerInfo partnerInfo) {
		// TODO Auto-generated method stub
		int ret = 0;
		try {
			proxyMapper.updateProxy(partnerInfo);
			ret = 10;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	@Transactional
	public int addProxy(PartnerInfo partnerInfo) {
		// TODO Auto-generated method stub
		int ret = 0;
		//查询partner_symbol, partner_symbol,login_name 是否存在
		try {
			if (pMapper.checkPartnerSymbol(partnerInfo)>0) {
				ret = 11;
			}
			if (pMapper.checkPartnerName(partnerInfo)>0) {
				ret = 12;
			}
			if (pMapper.checkLoginName(partnerInfo)>0) {
				ret = 13;
			}else {
				proxyMapper.addProxy(partnerInfo);
				pMapper.addPartnerScale(partnerInfo.getPartner_id());
				ret = 10;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

}
