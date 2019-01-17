package com.kuaidu.nms.datastaticstics.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.kuaidu.nms.datastaticstics.mapper.UserInfoStatMapper;
import com.kuaidu.nms.entity.StatUserInfo;
import com.kuaidu.nms.utils.Utils;

/** 
 * @Title UserInfoStatMapperImpl.java 
 * @description TODO 
 * @time 2018年9月11日 下午2:01:37 
 * @author victor 
 * @version 1.0 
**/
@Service
public class UserInfoStatMapperImpl {
	
	@Resource
	UserInfoStatMapper uMapper;

	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	RedisTemplate<String, List<Map<String, Object>>> redisTemplate2;

	@SuppressWarnings("unchecked")
	public synchronized StatUserInfo getStatsToday(StatUserInfo statUserInfo) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> redisUsers = new ArrayList<Map<String, Object>>();
		String redisKey = "statUser:statUserTorday_"+statUserInfo.getPartner_id();
		if (!redisTemplate.hasKey(redisKey)) {
			try {
				redisUsers = uMapper.getStatsToday(statUserInfo);
				if (redisUsers!=null&&redisUsers.size()>0) {
					redisTemplate2.opsForValue().set(redisKey,redisUsers);
					redisTemplate2.expire(redisKey, 10, TimeUnit.MINUTES);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			redisUsers =  redisTemplate2.opsForValue().get(redisKey);
		}
		if (statUserInfo.getPartner_id()>0) {//根据客户id 筛选
	        Iterator<Map<String, Object>> iterator = redisUsers.iterator();
	        while (iterator.hasNext()) {
				Map<String, Object> sInfo = (Map<String, Object>) iterator.next();
				if (!(sInfo.get("partner_id")+"").equalsIgnoreCase(statUserInfo.getPartner_id()+"")) {
					iterator.remove();
				}
	        }
		}
		int m_new = 0,m_sub=0,m_charged = 0,wm_new = 0,wm_sub=0,wm_charged = 0,wz_new = 0,wz_sub=0,wz_charged = 0
				,m_unsub=0,wm_unsub=0,wz_unsub=0;
		for (Object object : redisUsers) {
			Map<Integer, Object> sInfo = (Map<Integer, Object>) object;
			int sex = Integer.parseInt(sInfo.get("sex")+"");
			int count = Integer.parseInt(sInfo.get("new")+"");
			int c_sub = Integer.parseInt(sInfo.get("sub")+"");
			int c_unsub = Integer.parseInt(sInfo.get("unsub")+"");
			int vip_type = Integer.parseInt(sInfo.get("vip_type")+"");
			//男新增
			if (sex==1) {
				m_new = m_new + count;
				m_sub = m_sub+c_sub;
				m_unsub = m_unsub + c_unsub;
				//付费
				if (vip_type>0) {
					m_charged = m_charged + count;
				}
			}else if (sex==2) {//女新增
				wm_new = wm_new + count;
				wm_sub = wm_sub+c_sub;
				wm_unsub = wm_unsub + c_unsub;
				//付费
				if (vip_type>0) {
					wm_charged = wm_charged + count;
				}
			}else {
				wz_new = wz_new + count;
				wz_sub = wz_sub+c_sub;
				wz_unsub = wz_unsub + c_unsub;
				//付费
				if (vip_type>0) {
					wz_charged = wz_charged + count;
				}
			}
			
		}
		statUserInfo.setM_new(m_new);
		statUserInfo.setM_sub(m_sub);
		statUserInfo.setM_charged(m_charged);
		statUserInfo.setM_unsub(m_unsub);
		statUserInfo.setWm_new(wm_new);
		statUserInfo.setWm_sub(wm_sub);
		statUserInfo.setWm_charged(wm_charged);
		statUserInfo.setWm_unsub(wm_unsub);
		statUserInfo.setWz_new(wz_new);
		statUserInfo.setWz_sub(wz_sub);
		statUserInfo.setWz_charged(wz_charged);
		statUserInfo.setWz_unsub(wz_unsub);
		
		return statUserInfo;
	
	}
	public StatUserInfo getStatsYesterDay(StatUserInfo statUserInfo) {
		// TODO Auto-generated method stub
		String redisKey = "statUser:statUserYestorday_"+statUserInfo.getPartner_id();
		if (!redisTemplate.hasKey(redisKey)) {
			try {
				StatUserInfo sInfo = uMapper.getStatsYesterDay(statUserInfo);
				if (sInfo!=null) {
					statUserInfo = sInfo;
					redisTemplate.opsForValue().set(redisKey,statUserInfo);
					redisTemplate.expireAt(redisKey, Utils.getDetailDate(1,1,0,0));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			statUserInfo = (StatUserInfo) redisTemplate.opsForValue().get(redisKey);
		}
		return statUserInfo;
	}
	public StatUserInfo getStatsMonthAll(StatUserInfo statUserInfo) {
		// TODO Auto-generated method stub
		String redisKey = "statUser:statUserMonthAll_"+statUserInfo.getPartner_id();
		if (!redisTemplate.hasKey(redisKey)) {
			StatUserInfo sInfo = uMapper.getStatsMonthAll(statUserInfo);
			if (sInfo!=null) {
				statUserInfo = sInfo;
				redisTemplate.opsForValue().set(redisKey,statUserInfo);
				redisTemplate.expireAt(redisKey, Utils.getDetailDate(1,1,0,0));
			}
		}else {
			statUserInfo = (StatUserInfo) redisTemplate.opsForValue().get(redisKey);
		}
		return statUserInfo;
	}
	public StatUserInfo getStatsAll(StatUserInfo statUserInfo) {
		// TODO Auto-generated method stub
		String redisKey = "statUser:statUserAll_"+statUserInfo.getPartner_id();
		if (!redisTemplate.hasKey(redisKey)) {
			StatUserInfo sInfo = uMapper.getStatsAll(statUserInfo);
			if (sInfo!=null) {
				statUserInfo = sInfo;
				redisTemplate.opsForValue().set(redisKey,statUserInfo);
				redisTemplate.expireAt(redisKey,  Utils.getDetailDate(1,1,0,0));
			}
		}else {
			statUserInfo = (StatUserInfo) redisTemplate.opsForValue().get(redisKey);
		}
		return statUserInfo;
	}
	public List<Object> getStatsList(StatUserInfo statUserInfo, Integer group_by_parent) {
		if (group_by_parent==0) {//不分组
			return  uMapper.getStatsList(statUserInfo);
		}else {
			return  uMapper.getStatsListGroup(statUserInfo);
		}
		
	}
}
