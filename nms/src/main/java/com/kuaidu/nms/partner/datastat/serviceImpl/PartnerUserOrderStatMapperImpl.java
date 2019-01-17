package com.kuaidu.nms.partner.datastat.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.kuaidu.nms.entity.StatUserOrder;
import com.kuaidu.nms.partner.datastat.mapper.PartnerUserOrderStatMapper;
import com.kuaidu.nms.utils.Utils;

/** 
 * @Title UserOrderStat.java 
 * @description TODO 
 * @time 2018年9月11日 下午2:01:37 
 * @author victor 
 * @version 1.0 
**/
@Service
public class PartnerUserOrderStatMapperImpl {
	
	@Resource
	PartnerUserOrderStatMapper uMapper;

	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	public synchronized StatUserOrder getStatsToday(StatUserOrder statUserOrder) {
		try {
			List<Object> redisOrders = new ArrayList<Object>();
			String redisKey = "order:partner:StatOrderToday_"+statUserOrder.getPartner_id();
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
			for (Object object : redisOrders) {
				StatUserOrder sOrder = (StatUserOrder) object;
				if (sOrder.getProduct_type()==1) {
					noChargedQuantity = noChargedQuantity + sOrder.getNm_nocharged_quantity();
					chargedQuantity = chargedQuantity + sOrder.getNm_charged_quantity();
					totalPrice = totalPrice + sOrder.getNm_charged_quantity()*sOrder.getProduct_price();
				}else {
					vipNoChargedQuantity = vipNoChargedQuantity + sOrder.getNm_nocharged_quantity();
					vipChargedQuantity = vipChargedQuantity + sOrder.getNm_charged_quantity();
					vipTotalPrice = vipTotalPrice + sOrder.getNm_charged_quantity()*sOrder.getProduct_price();
				}
			}
			statUserOrder.setNm_nocharged_quantity(noChargedQuantity);
			statUserOrder.setNm_charged_quantity(chargedQuantity);
			statUserOrder.setNm_total_price(totalPrice);
			
			statUserOrder.setVip_nocharged_quantity(vipNoChargedQuantity);
			statUserOrder.setVip_charged_quantity(vipChargedQuantity);
			statUserOrder.setVip_total_price(vipTotalPrice);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statUserOrder;
	}
	public StatUserOrder getStatsYesterDay(StatUserOrder statUserOrder) {
		// TODO Auto-generated method stub
		String redisKey = "order:partner:statOrderYestorday_"+statUserOrder.getPartner_id();
		if (!redisTemplate.hasKey(redisKey)) {
			try {
				StatUserOrder sOrder = uMapper.getStatsYesterDay(statUserOrder);
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
					redisTemplate.expireAt(redisKey,  Utils.getNextDate());
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
		String redisKey = "order:partner:statOrderMonthAll_"+statUserOrder.getPartner_id();
		if (!redisTemplate.hasKey(redisKey)) {
			StatUserOrder sOrder = uMapper.getStatsMonthAll(statUserOrder);
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
				redisTemplate.expireAt(redisKey,  Utils.getNextDate());
			}
		}else {
			statUserOrder = (StatUserOrder) redisTemplate.opsForValue().get(redisKey);
		}
		return statUserOrder;
	}
	public StatUserOrder getStatsAll(StatUserOrder statUserOrder) {
		// TODO Auto-generated method stub
		String redisKey = "order:partner:statOrderAll_"+statUserOrder.getPartner_id();
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
				redisTemplate.expireAt(redisKey,  Utils.getNextDate());
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
}
