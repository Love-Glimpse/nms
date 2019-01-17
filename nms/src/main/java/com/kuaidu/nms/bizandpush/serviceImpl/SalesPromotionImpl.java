package com.kuaidu.nms.bizandpush.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuaidu.nms.bizandpush.mapper.SalesPromotionMapper;
import com.kuaidu.nms.entity.Product;
import com.kuaidu.nms.entity.PromotionActive;
import com.kuaidu.nms.utils.Utils;

/** 
 * @Title SalesPromotion.java 
 * @description 促销活动
 * @time 2018年11月2日 上午10:31:56 
 * @author victor 
 * @version 1.0 
**/
@Service
public class SalesPromotionImpl {
	@Autowired
	SalesPromotionMapper sMapper;

	public List<Product> getPromotionProducts() {
		// TODO Auto-generated method stub
		return sMapper.getPromotionProducts();
	}

	public int createActive(PromotionActive promotionActive) {
		// TODO Auto-generated method stub
		int ret = 0;
		if (promotionActive.getPartner_id()==null) {
			promotionActive.setPartner_id(0);
		}
		if (promotionActive.getStart_time()==null) {
			promotionActive.setStart_time(Utils.getNowDate());
		}
		if (promotionActive.getEnd_time()==null||promotionActive.getEnd_time()=="") {
			promotionActive.setEnd_time(null);
		}
		try {
			sMapper.createActive(promotionActive);
			ret = 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	/**
	 * 平台活动
	 * flag = 0 平台活动列表
	 * flag =1  所有渠道活动列表
	 * flag = 2 指定渠道活动列表
	 * */
	public List<PromotionActive> getPromotionActiveList(PromotionActive pList) {
		// TODO Auto-generated method stub
		return sMapper.getPromotionActiveList(pList);
	}
	//查询count
	public int  getAll(PromotionActive pList) {
			return sMapper.getAll(pList);
	}

	//删除
	public void delActive(int active_id){
		sMapper.delActive(active_id);
	}
}
