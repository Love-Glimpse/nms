package com.kuaidu.nms.bizandpush.mapper;

import java.util.List;

import com.kuaidu.nms.entity.Product;
import com.kuaidu.nms.entity.PromotionActive;

public interface SalesPromotionMapper {

	List<Product> getPromotionProducts();

	void createActive(PromotionActive promotionActive);
	
	public void delActive(int list);

	List<PromotionActive> getPromotionActiveList(PromotionActive plist);
	
	public int getAll(PromotionActive plist);
	
}
