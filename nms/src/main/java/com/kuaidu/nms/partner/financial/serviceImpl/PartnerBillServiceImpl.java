package com.kuaidu.nms.partner.financial.serviceImpl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kuaidu.nms.entity.PartnerBill;
import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.partner.financial.mapper.PartnerBillMapper;
import com.kuaidu.nms.pushchannel.mapper.PartnerInfoMapper;

@Service
public class PartnerBillServiceImpl {

	@Autowired
	PartnerBillMapper partnerBillMapper;
	@Autowired
	PartnerInfoMapper partnerInfoMapper;

	/**
	 * 统计每日账单
	 */
	public void statisticalBill() {

		List<PartnerBill> list = partnerBillMapper.statisticalBill();
		if (list.size() > 0) {
			partnerBillMapper.saveEveryDayBill(list);
		}
	}

	public void getPartnerBill(PartnerInfo partnerInfo, HttpServletRequest request) {
		BigDecimal accountScale = partnerInfoMapper.getPartnerAccountsScaleByPartnerId(partnerInfo.getPartner_id());
		int group_id = partnerInfo.getGroup_id();
		request.setAttribute("group_id", group_id);
		List<PartnerBill> list = new ArrayList<>();
		int parent_id = partnerInfo.getParent_id();
		int partner_id = partnerInfo.getPartner_id();
		// 查询渠道的账单
		if (group_id == 1) {
			// 近30天账单情况
			list = partnerBillMapper.getPartnerBillOneMonthByParentId(parent_id);
		} else {
			list = partnerBillMapper.getPartnerBillByPartnerId(partner_id);
		}	
			// 未提现
			BigDecimal bigDecimal = new BigDecimal(0.00);
			// 已打款
			BigDecimal bigDecimal2 = new BigDecimal(0.00);
			// 待打款
			BigDecimal bigDecimal3 = new BigDecimal(0.00);
			// 总充值
			BigDecimal bigDecimalTotal = new BigDecimal(0.00);
			// PartnerBill partnerBillTotal = new PartnerBill();
			if (list.size() > 0 && list.get(0) != null) {
				for (PartnerBill partnerBill : list) {
					Integer status = partnerBill.getStatus();
					BigDecimal order_price = partnerBill.getOrder_price();
					if (status == 0) {
						bigDecimal = bigDecimal.add(order_price);
					} else if (status == 1) {
						bigDecimal2 = bigDecimal2.add(order_price);
					} else if (status == 2) {
						bigDecimal3 = bigDecimal3.add(order_price);
					}
					bigDecimalTotal = bigDecimalTotal.add(order_price);
				}
			}
			request.setAttribute("bigDecimal", bigDecimal);
			request.setAttribute("bigDecimal2", bigDecimal2);
			request.setAttribute("bigDecimal3", bigDecimal3);
			request.setAttribute("bigDecimalTotal", bigDecimalTotal);
			double doubleValue = accountScale.multiply(bigDecimalTotal).doubleValue();
			String account = String.format("%.2f", doubleValue);
			request.setAttribute("account", account);
			
			//未提现总额
			BigDecimal noWithdraw = new BigDecimal(0.00);
			//待打款总额
			BigDecimal waitPay = new BigDecimal(0.00);
			List<PartnerBill> list2 = partnerBillMapper.getPartnerWithdrawInfoByPartnerId(partner_id);
			for (PartnerBill partnerBill : list2) {
				Integer status = partnerBill.getStatus();
				BigDecimal order_price = partnerBill.getOrder_price();
				//未结算总额
				if (status == 0) {
					noWithdraw = order_price;
				}else if (status == 2) {
					waitPay = order_price;
				}
			}
			request.setAttribute("noWithdraw", noWithdraw);
			request.setAttribute("waitPay", waitPay);
			
			

	}

	public void sdfsdf() {
		List<PartnerBill> list = partnerBillMapper.selssect();
		for (PartnerBill partnerBill : list) {
			partnerBillMapper.insertSelective(partnerBill);
		}

	}

	public Object everyDayBill(PartnerInfo partnerInfo, Integer status,Integer pn)  {
		int group_id = partnerInfo.getGroup_id();
		PageHelper.startPage(pn, 15);
		if (group_id == 1) {
			List<PartnerBill> list = partnerBillMapper.getEveryDayBillByParentId(partnerInfo.getParent_id(),status);
			PageInfo<PartnerBill> pageInfo = new PageInfo<>(list);
			return pageInfo;
		}else {
			List<PartnerBill> list = partnerBillMapper.getEveryDayBillByPartnerId(partnerInfo.getPartner_id(),status);
			PageInfo<PartnerBill> pageInfo = new PageInfo<>(list);
			return pageInfo;
		}
		
	}
	
	
	public static String getDate(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String format = simpleDateFormat.format(date);
		return format;
	}

	/*public PartnerBill getPartnerBillById(Integer id) {
		return partnerBillMapper.getPartnerBillById( id);
	}*/

	public PartnerBill getParentBillById(Integer id) {
		
		return partnerBillMapper.getParentBillById( id);
	}

}
