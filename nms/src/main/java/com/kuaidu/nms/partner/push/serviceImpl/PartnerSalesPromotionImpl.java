package com.kuaidu.nms.partner.push.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuaidu.nms.entity.Product;
import com.kuaidu.nms.entity.PromotionActive;
import com.kuaidu.nms.partner.push.mapper.PartnerSalesPromotionMapper;
import com.kuaidu.nms.utils.Utils;

/** 
 * @Title SalesPromotion.java 
 * @description 促销活动
 * @time 2018年11月2日 上午10:31:56 
 * @author victor 
 * @version 1.0 
**/
@Service
public class PartnerSalesPromotionImpl {
	@Autowired
	PartnerSalesPromotionMapper sMapper;

	public List<Product> getPromotionProducts() {
		// TODO Auto-generated method stub
		return sMapper.getPromotionProducts();
	}

	/**
	 * 平台活动
	 * flag = 0 平台活动列表
	 * flag =1  渠道活动列表
	 * */
	public List<PromotionActive> getPromotionActiveList(PromotionActive pList) {
		// TODO Auto-generated method stub
		return sMapper.getPromotionActiveList(pList);
	}
	//查询count
	public int  getPromotionProductsCount(PromotionActive pList) {
			return sMapper.getPromotionProductsCount(pList);
	}

	public void removeActive(int partner_id, Integer active_id) {
		// TODO Auto-generated method stub
		sMapper.removeActive(partner_id, active_id);
	}

	public int createActive(PromotionActive promotionActive, String product_list) {
		// TODO Auto-generated method stub
		int ret = 0;
		List<PromotionActive> list = new ArrayList<PromotionActive>();
		String batch_id = System.currentTimeMillis() + "";
		/* 判断模式 1，充值活动 2，免费送书币 */
		int type = promotionActive.getActive_type();
		if (type == 1) {
			/* 获取活动个数，批量插入活动 */
			String[] product_ids = product_list.split(",");
			for (int i = 0; i < product_ids.length; i++) {
				if (product_ids[i].trim().matches("\\d+")) {
					PromotionActive pActive = new PromotionActive();
					pActive.setBatch_id(batch_id);
					pActive.setPartner_id(promotionActive.getPartner_id());
					pActive.setProduct_id(Integer.parseInt(product_ids[i]));
					pActive.setActive_name(promotionActive.getActive_name());
					pActive.setActive_type(promotionActive.getActive_type());
					pActive.setPoint(promotionActive.getPoint());
					pActive.setLimit_count(promotionActive.getLimit_count());
					pActive.setActive_remark(promotionActive.getActive_remark());
					pActive.setActive_url("http://c" + promotionActive.getPartner_id() + ".mzshu.com/user/active/");

					String desc = sMapper.getProductDesc(Integer.parseInt(product_ids[i]));
					pActive.setActive_description(desc);

					if (promotionActive.getStart_time() == null) {
						pActive.setStart_time(Utils.getNowDate());
					} else {
						pActive.setStart_time(promotionActive.getStart_time());
					}
					if (promotionActive.getEnd_time() == null || promotionActive.getEnd_time() == "") {
						return 2;
					} else {
						pActive.setEnd_time(promotionActive.getEnd_time());
					}
					list.add(pActive);
				}
			}
		} else {
			promotionActive.setActive_url("http://c" + promotionActive.getPartner_id() + ".mzshu.com/user/active/");
			promotionActive.setActive_description("免费领取200书币");
			promotionActive.setBatch_id(batch_id);
			// 免费送书币
			if (promotionActive.getStart_time() == null) {
				promotionActive.setStart_time(Utils.getNowDate());
			}
			if (promotionActive.getEnd_time() == null || promotionActive.getEnd_time() == "") {
				return 2; //活动结束时间空
			}
			list.add(promotionActive);
		}
		if (list.size() > 0) {
			sMapper.createActive(list);
			ret = 1;
		}
		return ret;
	}

	public int getActiveCount(PromotionActive promotionActive) {
		// TODO Auto-generated method stub
		return sMapper.getActiveCount(promotionActive);
	}
}
