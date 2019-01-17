package com.kuaidu.nms.partner.financial.serviceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuaidu.nms.entity.PartnerBill;
import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.entity.PartnerWithdraw;
import com.kuaidu.nms.entity.RestReturn;
import com.kuaidu.nms.partner.financial.mapper.PartnerBillMapper;
import com.kuaidu.nms.partner.financial.mapper.PartnerWithdrawMapper;

@Service
public class PartnerWithdrawServiceImpl {
	
	
	@Autowired
	PartnerWithdrawMapper partnerWithdrawMapper;
	@Autowired
	PartnerBillMapper partnerBillMapper;

	@Transient
	public synchronized RestReturn withdrawRequest(PartnerInfo partnerInfo) {
		int group_id = partnerInfo.getGroup_id();
		int partner_id = partnerInfo.getPartner_id();
		int parent_id = partnerInfo.getParent_id();
		//默认手续费0
		BigDecimal bankCharge = new BigDecimal(0.00);
		//渠道申请提现
		if (group_id == 1) {
			List<PartnerBill> list  = partnerBillMapper.getPendingBillByParentId(parent_id);
			BigDecimal withdrawPrice = new BigDecimal(0.00);
			for (PartnerBill partnerBill : list) {
				if (partnerBill != null) {
					BigDecimal withdraw_price = partnerBill.getWithdraw_price();
					withdrawPrice = withdrawPrice.add(withdraw_price);
				}
			}
			if (withdrawPrice.doubleValue() < 100) {
				return RestReturn.fail("余额满 100 元才能提现");
			}else if (withdrawPrice.doubleValue() < 1000) {
				bankCharge = bankCharge.add(new BigDecimal(1));
			}
			BigDecimal payPrice = withdrawPrice.subtract(bankCharge);
			PartnerWithdraw partnerWithdraw = partnerWithdrawMapper.getPartnerWithAccountByPartnerId(partner_id);
			if (partnerWithdraw == null) {
				return RestReturn.fail("请先设置结算方式");
			}
			partnerWithdraw = removeOtherAccount(partnerWithdraw);
			partnerWithdraw.setStatus(0);
			partnerWithdraw.setWithdraw_price(withdrawPrice);
			partnerWithdraw.setBank_charge(bankCharge);
			partnerWithdraw.setPay_price(payPrice);
			partnerWithdrawMapper.insertSelective(partnerWithdraw);
			partnerWithdrawMapper.savePartnerWithAndBill(partnerWithdraw.getId(),list);
			partnerBillMapper.updatePartnerBillStatus(list,2);
			return RestReturn.success();
		//代理申请提现	
		}else {
			List<PartnerBill> list = partnerBillMapper.getPendingBillByPartnerId(partner_id);
			BigDecimal withdrawPrice = new BigDecimal(0.00);
			for (PartnerBill partnerBill : list) {
				if (partnerBill != null) {
					BigDecimal everyDaywithdrawPrice = partnerBill.getWithdraw_price();
					withdrawPrice = withdrawPrice.add(everyDaywithdrawPrice);
				}
			}
			if (withdrawPrice.doubleValue() < 100) {
				return RestReturn.fail("余额满 100 元才能提现");
			}
			PartnerWithdraw partnerWithdraw = partnerWithdrawMapper.getPartnerWithAccountByPartnerId(partner_id);
			if (partnerWithdraw == null) {
				return RestReturn.fail("请先设置结算方式");
			}
			partnerWithdraw.setWithdraw_price(withdrawPrice);
			partnerWithdraw.setStatus(0);
			partnerWithdraw.setPay_price(withdrawPrice);
			partnerWithdrawMapper.insertSelective(partnerWithdraw);
			partnerWithdrawMapper.savePartnerWithAndBill(partnerWithdraw.getId(),list);
			partnerBillMapper.updatePartnerBillStatus(list,2);
			return RestReturn.success();
		}
		
	}

	public void getPartnerWithdraw(PartnerInfo partnerInfo, String start, String end,HttpServletRequest request) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		if (start == null || end == null) {
			LocalDate now = LocalDate.now();
			LocalDate startDate = LocalDate.now().minusDays(31);
			end = now.format(dateTimeFormatter);
			start = startDate.format(dateTimeFormatter);
		}
		request.setAttribute("start", start);
		request.setAttribute("end", end);
        int group_id = partnerInfo.getGroup_id();
        request.setAttribute("group_id", group_id);
        List<PartnerWithdraw> list = new ArrayList<>();
        if (group_id == 1) {
        	 list = partnerWithdrawMapper.getparentWithdrawByPartnerId(partnerInfo.getPartner_id(),start,end);
		}else {
			list = partnerWithdrawMapper.getPartnerWithdrawByPartnerId(partnerInfo.getPartner_id(),start,end);
		}
        request.setAttribute("list", list);
        
	}
	
	
	
	public PartnerWithdraw removeOtherAccount(PartnerWithdraw partnerWithdraw) {
		Integer pay_type = partnerWithdraw.getPay_type();
		if (pay_type == 1) {
			partnerWithdraw.setAlipay_account(null);
			partnerWithdraw.setAlipay_name(null);
			partnerWithdraw.setWechat_account(null);
			partnerWithdraw.setWechat_name(null);
		}else if(pay_type == 2) {
			partnerWithdraw.setBank_account(null);
			partnerWithdraw.setBank_branch(null);
			partnerWithdraw.setBank_city(null);
			partnerWithdraw.setBank_name(null);
			partnerWithdraw.setBank_province(null);
			partnerWithdraw.setBank_charge(null);
			partnerWithdraw.setWechat_account(null);
			partnerWithdraw.setWechat_name(null);
		}else if (pay_type == 3) {
			partnerWithdraw.setBank_account(null);
			partnerWithdraw.setBank_branch(null);
			partnerWithdraw.setBank_city(null);
			partnerWithdraw.setBank_name(null);
			partnerWithdraw.setBank_province(null);
			partnerWithdraw.setBank_charge(null);
			partnerWithdraw.setAlipay_account(null);
			partnerWithdraw.setAlipay_name(null);
		}
		return partnerWithdraw;
	}

	public PartnerWithdraw getParentWithdrawById(Integer id) {
		return partnerWithdrawMapper.getParentWithdrawById( id);
	}

	public PartnerWithdraw getPartnerWithdrawById(Integer id) {
		return partnerWithdrawMapper.getPartnerWithdrawById(id);
	}

	

}
