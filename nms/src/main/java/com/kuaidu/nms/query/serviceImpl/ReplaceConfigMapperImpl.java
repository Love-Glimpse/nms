package com.kuaidu.nms.query.serviceImpl;

import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaidu.nms.entity.ReplaceConfig;
import com.kuaidu.nms.query.mapper.ReplaceConfigMapper;
/*
 * 接口实现类
 * */
@Service
@Transactional 
public class ReplaceConfigMapperImpl {
	@Resource
	ReplaceConfigMapper rMapper;
	public List<ReplaceConfig> getAllConfigs(ReplaceConfig replaceConfig) {
		// TODO Auto-generated method stub
		return rMapper.getAllConfigs(replaceConfig) ;
	}
	public int getCount(ReplaceConfig replaceConfig) {
		// TODO Auto-generated method stub
		return rMapper.getCount(replaceConfig);
	}
	public int add_rConfig(ReplaceConfig replaceConfig) {
		// TODO Auto-generated method stub
		int ret = 1;
		try {
			Pattern.compile(replaceConfig.getTarget());
			rMapper.add_rConfig(replaceConfig);
			ret = 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ret = 2;//正则表达式不正确
		}
		return ret;
	}
	public void del_rConfig(ReplaceConfig replaceConfig) {
		// TODO Auto-generated method stub
		rMapper.del_rConfig(replaceConfig);
	}
	public void update_rConfig(ReplaceConfig replaceConfig) {
		// TODO Auto-generated method stub
		rMapper.update_rConfig(replaceConfig);
	}
	
}
