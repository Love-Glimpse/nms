package com.kuaidu.nms.financial.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuaidu.nms.entity.PartnerAccount;
import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.entity.PartnerWithdraw;
import com.kuaidu.nms.entity.RestReturn;
import com.kuaidu.nms.financial.mapper.BillMapper;
import com.kuaidu.nms.financial.mapper.PartnerAccountMapper;
import com.kuaidu.nms.financial.mapper.WithdrawMapper;
import com.kuaidu.nms.pushchannel.mapper.PartnerInfoMapper;
import com.kuaidu.nms.utils.EasyUIReturn;

@Service
public class WithdrawServiceImpl {
	
	
	@Autowired
	WithdrawMapper  withdrawMapper;
	@Autowired
	PartnerInfoMapper partnerInfoMapper;
	@Autowired
	PartnerAccountMapper partnerAccountMapper;
	@Autowired
	BillMapper billMapper;

	public Object getWithdraw(PartnerWithdraw partnerWithdraw, Integer page, Integer rows) {
		int start =(page - 1)*rows;
		int end = page *rows;
		int total  = withdrawMapper.getCount(partnerWithdraw);
		
		List<PartnerWithdraw> list = withdrawMapper.getWithdraw(partnerWithdraw,start,end);
		return new EasyUIReturn(total, list);
	}

	public void getWxAuthPartner(HttpServletRequest request) {
		List<PartnerInfo> wxAuthPartner = partnerInfoMapper.getWxAuthPartner();
		request.setAttribute("partners", wxAuthPartner);
	}

	public Object getWithdrawPayType(int partnerId) {
		//PartnerAccount partnerAccount =  partnerAccountMapper.getWithdrawPayType(partnerId);
		PartnerAccount partnerAccount=  withdrawMapper.getPartnerAccountByPartnerId(partnerId);
		return RestReturn.success(partnerAccount);
		
	}

	public Object updatePartnerWithdraw(PartnerWithdraw partnerWithdraw) {
		int num = withdrawMapper.updateByPrimaryKeySelective(partnerWithdraw);
		return RestReturn.success(null, num);
	}

	public synchronized Object paySuccess(PartnerWithdraw partnerWithdraw) {
		Integer status = withdrawMapper.getWithdrawStatusById(partnerWithdraw.getId());
		if (status == null  || status == 1) {
			return RestReturn.fail("已经打款成功");
		}
		
		int num = withdrawMapper.updateByPrimaryKeySelective(partnerWithdraw);
		billMapper.updateBillPay(partnerWithdraw.getId());
		return RestReturn.success(null, num);
	}
	
	

}
