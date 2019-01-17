package com.kuaidu.nms.datastaticstics.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.kuaidu.nms.datastaticstics.mapper.UserOrderStatMapper;
import com.kuaidu.nms.entity.StatUserOrder;
import com.kuaidu.nms.utils.Utils;

/** 
 * @Title UserOrderStat.java 
 * @description TODO 
 * @time 2018年9月11日 下午2:01:37 
 * @author victor 
 * @version 1.0 
**/
@Service
public class UserOrderStatMapperImpl {
	
	@Resource
	UserOrderStatMapper uMapper;

	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	public synchronized StatUserOrder getStatsToday(StatUserOrder statUserOrder) {
		try {
			List<Object> redisOrders = new ArrayList<Object>();
			String redisKey = "order:statOrderToday_"+statUserOrder.getPartner_id();
			if (!redisTemplate.hasKey(redisKey)) {
				redisOrders = uMapper.getStatsToday(statUserOrder);
				if (redisOrders != null&&redisOrders.size()>0) {
					redisTemplate.opsForList().rightPushAll(redisKey, redisOrders);
					redisTemplate.expire(redisKey, 10, TimeUnit.MINUTES);
				}
			}else {
				redisOrders = redisTemplate.opsForList().range(redisKey, 0, -1);
				
			}
			int noChargedQuantity = 0;
			int chargedQuantity = 0;
			float totalPrice = 0;
			
			int vipNoChargedQuantity = 0;
			int vipChargedQuantity = 0;
			float vipTotalPrice = 0;
			
			int paNoChargedQuantity = 0;
			int paChargedQuantity = 0;
			float paTotalPrice = 0;
			
			int paVipNoChargedQuantity = 0;
			int paVipChargedQuantity = 0;
			float paVipTotalPrice = 0;
			Float profit = 0.0f;
			for (Object object : redisOrders) {
				StatUserOrder sOrder = (StatUserOrder) object;
				if (statUserOrder.getPartner_id()>0&&sOrder.getPartner_id()==statUserOrder.getPartner_id()) {//代理
					if (sOrder.getProduct_type() == 1) {//普通订单
						noChargedQuantity = noChargedQuantity + sOrder.getNm_nocharged_quantity();
						chargedQuantity = chargedQuantity + sOrder.getNm_charged_quantity();
						totalPrice = totalPrice + sOrder.getNm_charged_quantity() * sOrder.getProduct_price();
						
						if (sOrder.getKl_flag()==0) {//不扣量的
							paNoChargedQuantity = paNoChargedQuantity + sOrder.getNm_nocharged_quantity();
							paChargedQuantity = paChargedQuantity + sOrder.getNm_charged_quantity();
							paTotalPrice = paTotalPrice + sOrder.getNm_charged_quantity() * sOrder.getProduct_price();
							profit = profit+sOrder.getNm_charged_quantity() * sOrder.getProduct_price()*(1-sOrder.getPartner_accounts_scale());
						}else {
							profit = profit+sOrder.getNm_charged_quantity() * sOrder.getProduct_price();
						}
						
					} else {//vip
						vipNoChargedQuantity = vipNoChargedQuantity + sOrder.getNm_nocharged_quantity();
						vipChargedQuantity = vipChargedQuantity + sOrder.getNm_charged_quantity();
						vipTotalPrice = vipTotalPrice + sOrder.getNm_charged_quantity() * sOrder.getProduct_price();
						if (sOrder.getKl_flag()==0) {//不扣量的
							paVipNoChargedQuantity = paVipNoChargedQuantity + sOrder.getNm_nocharged_quantity();
							paVipChargedQuantity = paVipChargedQuantity + sOrder.getNm_charged_quantity();
							paVipTotalPrice = paVipTotalPrice + sOrder.getNm_charged_quantity() * sOrder.getProduct_price();
							profit = profit+sOrder.getNm_charged_quantity() * sOrder.getProduct_price()*(1-sOrder.getPartner_accounts_scale());
						}else {
							profit = profit+sOrder.getNm_charged_quantity() * sOrder.getProduct_price();
						}
						
					} 
				}else {//认证渠道
					if (sOrder.getProduct_type() == 1) {//普通订单
						noChargedQuantity = noChargedQuantity + sOrder.getNm_nocharged_quantity();
						chargedQuantity = chargedQuantity + sOrder.getNm_charged_quantity();
						totalPrice = totalPrice + sOrder.getNm_charged_quantity() * sOrder.getProduct_price();
						
						if (sOrder.getKl_flag()==0) {//不扣量的
							paNoChargedQuantity = paNoChargedQuantity + sOrder.getNm_nocharged_quantity();
							paChargedQuantity = paChargedQuantity + sOrder.getNm_charged_quantity();
							paTotalPrice = paTotalPrice + sOrder.getNm_charged_quantity() * sOrder.getProduct_price();
							profit = profit+sOrder.getNm_charged_quantity() * sOrder.getProduct_price()*(1-sOrder.getPartner_accounts_scale());
						}else {
							profit = profit+sOrder.getNm_charged_quantity() * sOrder.getProduct_price();
						}
						
					} else {//vip
						vipNoChargedQuantity = vipNoChargedQuantity + sOrder.getNm_nocharged_quantity();
						vipChargedQuantity = vipChargedQuantity + sOrder.getNm_charged_quantity();
						vipTotalPrice = vipTotalPrice + sOrder.getNm_charged_quantity() * sOrder.getProduct_price();
						if (sOrder.getKl_flag()==0) {//不扣量的
							paVipNoChargedQuantity = paVipNoChargedQuantity + sOrder.getNm_nocharged_quantity();
							paVipChargedQuantity = paVipChargedQuantity + sOrder.getNm_charged_quantity();
							paVipTotalPrice = paVipTotalPrice + sOrder.getNm_charged_quantity() * sOrder.getProduct_price();
							profit = profit+sOrder.getNm_charged_quantity() * sOrder.getProduct_price()*(1-sOrder.getPartner_accounts_scale());
						}else {
							profit = profit+sOrder.getNm_charged_quantity() * sOrder.getProduct_price();
						}
					} 
				}
			}
			statUserOrder.setNm_nocharged_quantity(noChargedQuantity);
			statUserOrder.setNm_charged_quantity(chargedQuantity);
			statUserOrder.setNm_total_price(totalPrice);
			
			statUserOrder.setVip_nocharged_quantity(vipNoChargedQuantity);
			statUserOrder.setVip_charged_quantity(vipChargedQuantity);
			statUserOrder.setVip_total_price(vipTotalPrice);
			
			statUserOrder.setPa_nm_nocharged_quantity(paNoChargedQuantity);
			statUserOrder.setPa_nm_charged_quantity(paChargedQuantity);
			statUserOrder.setPa_nm_total_price(paTotalPrice);
			
			statUserOrder.setPa_vip_nocharged_quantity(paVipNoChargedQuantity);
			statUserOrder.setPa_vip_charged_quantity(paVipChargedQuantity);
			statUserOrder.setPa_vip_total_price(paVipTotalPrice);
			
			statUserOrder.setProfit(profit);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statUserOrder;
	}
	public StatUserOrder getStatsYesterDay(StatUserOrder statUserOrder) {
		// TODO Auto-generated method stub
		String redisKey = "order:statOrderYestorday_"+statUserOrder.getPartner_id();
		if (!redisTemplate.hasKey(redisKey)) {
			try {
				StatUserOrder sOrder = uMapper.getStatsYesterDay(statUserOrder);
				if (sOrder==null) {
					statUserOrder.setNm_nocharged_quantity(0);
					statUserOrder.setNm_charged_quantity(0);
					statUserOrder.setNm_total_price(0F);
					
					statUserOrder.setVip_nocharged_quantity(0);
					statUserOrder.setVip_charged_quantity(0);
					statUserOrder.setVip_total_price(0F);
					
					statUserOrder.setPa_nm_nocharged_quantity(0);
					statUserOrder.setPa_nm_charged_quantity(0);
					statUserOrder.setPa_nm_total_price(0F);
					
					statUserOrder.setPa_vip_nocharged_quantity(0);
					statUserOrder.setPa_vip_charged_quantity(0);
					statUserOrder.setPa_vip_total_price(0F);
					
				}else {
					statUserOrder = sOrder;
					redisTemplate.opsForValue().set(redisKey,statUserOrder);
					redisTemplate.expireAt(redisKey,  Utils.getDetailDate(1,1,0,0));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			statUserOrder = (StatUserOrder) redisTemplate.opsForValue().get(redisKey);
		}
		return statUserOrder;
	}
	public StatUserOrder getStatsMonthAll(StatUserOrder statUserOrder) {
		// TODO Auto-generated method stub
		String redisKey = "order:statOrderMonthAll_"+statUserOrder.getPartner_id();
		if (!redisTemplate.hasKey(redisKey)) {
			StatUserOrder sOrder = uMapper.getStatsMonthAll(statUserOrder);
			if (sOrder==null) {
				statUserOrder.setNm_nocharged_quantity(0);
				statUserOrder.setNm_charged_quantity(0);
				statUserOrder.setNm_total_price(0F);
				statUserOrder.setVip_nocharged_quantity(0);
				statUserOrder.setVip_charged_quantity(0);
				statUserOrder.setVip_total_price(0F);
			}else {
				statUserOrder = sOrder;
				redisTemplate.opsForValue().set(redisKey,statUserOrder);
				redisTemplate.expireAt(redisKey,  Utils.getDetailDate(1,1,0,0));
			}
		}else {
			statUserOrder = (StatUserOrder) redisTemplate.opsForValue().get(redisKey);
		}
		return statUserOrder;
	}
	public StatUserOrder getStatsAll(StatUserOrder statUserOrder) {
		// TODO Auto-generated method stub
		String redisKey = "order:statOrderAll_"+statUserOrder.getPartner_id();
		if (!redisTemplate.hasKey(redisKey)) {
			StatUserOrder sOrder = uMapper.getStatsAll(statUserOrder);
			if (sOrder==null) {
				statUserOrder.setNm_nocharged_quantity(0);
				statUserOrder.setNm_charged_quantity(0);
				statUserOrder.setNm_total_price(0f);
				statUserOrder.setVip_nocharged_quantity(0);
				statUserOrder.setVip_charged_quantity(0);
				statUserOrder.setVip_total_price(0f);
			}else {
				statUserOrder = sOrder;
				redisTemplate.opsForValue().set(redisKey,statUserOrder);
				redisTemplate.expireAt(redisKey, Utils.getDetailDate(1,1,0,0));
			}
		}else {
			statUserOrder = (StatUserOrder) redisTemplate.opsForValue().get(redisKey);
		}
		return statUserOrder;
	}
	public List<Object> getStatsList(StatUserOrder statUserOrder) {
		// TODO Auto-generated method stub
/*		String redisKey = "order:statOrderList_"+statUserOrder.getPartner_id();
		List<Object> sOrders = new ArrayList<Object>();
		if (!redisTemplate.hasKey(redisKey)) {
			sOrders = uMapper.getStatsList(statUserOrder);
			if (sOrders!=null&&sOrders.size()>0) {
				redisTemplate.opsForList().rightPushAll(redisKey,sOrders);
				redisTemplate.expireAt(redisKey, Utils.getNextDate());
			}
		}else {
			redisTemplate.opsForValue().get(redisKey);
		}
		return sOrders;*/
		return  uMapper.getStatsList(statUserOrder);
	}
	public List<Object> getYestDayStatsList(StatUserOrder statUserOrder, String startDate, String endDate) {
		// TODO Auto-generated method stub
		return  uMapper.getYestDayStatsList(statUserOrder.getParent_id(),startDate,endDate);
	}
	public List<Object> getYestDayStatsListDetail(StatUserOrder statUserOrder) {
		// TODO Auto-generated method stub
		return uMapper.getYestDayStatsListDetail(statUserOrder);
	}
}
