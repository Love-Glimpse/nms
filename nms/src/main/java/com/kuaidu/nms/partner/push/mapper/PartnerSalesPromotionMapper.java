package com.kuaidu.nms.partner.push.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuaidu.nms.entity.Product;
import com.kuaidu.nms.entity.PromotionActive;

public interface PartnerSalesPromotionMapper {

	List<Product> getPromotionProducts();

	void createActive(List<PromotionActive> list);
	

	List<PromotionActive> getPromotionActiveList(PromotionActive plist);
	
	public int getPromotionProductsCount(PromotionActive plist);

	void removeActive(@Param("partner_id")int partner_id, @Param("active_id")Integer active_id);

	String getProductDesc(@Param("product_id")int product_id);

	int getActiveCount(PromotionActive promotionActive);
	
}
