package com.kuaidu.nms.user.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaidu.nms.config.Config;
import com.kuaidu.nms.entity.MessageLog;
import com.kuaidu.nms.entity.PartnerPmConfig;
import com.kuaidu.nms.entity.UserInfo;
import com.kuaidu.nms.entity.UserPointRecord;
import com.kuaidu.nms.entity.WxCustomMsg;
import com.kuaidu.nms.message.mapper.CustomMsgMapper;
import com.kuaidu.nms.user.mapper.UserManagementMapper;
import com.kuaidu.nms.utils.EasyUIReturn;
import com.kuaidu.nms.utils.Log4jUtil;
import com.kuaidu.nms.utils.MyWxUtils;
import com.kuaidu.nms.utils.ResultData;
import com.kuaidu.nms.utils.Utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/*
 * 接口实现类
 * */
@Service
@Transactional 
public class UserManagementMapperImpl {
	@Autowired
	UserManagementMapper uMapper;
	@Autowired
	CustomMsgMapper cMsgMapper;
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	//查询书籍
	public List<UserInfo> getAllRecords(UserInfo rList) {
		 List<UserInfo> allRecords = uMapper.getAllRecords(rList);
		 
		 Set<String> keys = redisTemplate.keys("RequestOnline--ID:**");
			 for (int i = 0; i < allRecords.size(); i++) {
				for (String string : keys) {
					int userId = Integer.parseInt(StringUtils.substringAfter(string, ":"));
					if (allRecords.get(i).getUser_id() == userId) {
						allRecords.get(i).setOnline(1);
					}
				}
			}
	
		 return allRecords;
	}
	
	public EasyUIReturn getAll(UserInfo userInfo, Integer isOnline, HttpServletRequest request, Integer timeFlag) {
		String page= request.getParameter("page");	
		String rows= request.getParameter("rows");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		
		if (timeFlag==null||timeFlag==0) {
			userInfo.setStart_time("");
			userInfo.setEnd_time("");
		}else {
			if (userInfo.getStart_time()==null|| userInfo.getStart_time().equalsIgnoreCase("")) {
				userInfo.setStart_time(sdf.format(Utils.getDateByDays(-7)));
			}
			if (userInfo.getEnd_time()==null|| userInfo.getEnd_time().equalsIgnoreCase("")) {
				userInfo.setEnd_time(sdf.format(new Date()));
			}
		}

		
		Integer start_rows = Integer.parseInt(page)*Integer.parseInt(rows)-Integer.parseInt(rows);
		userInfo.setStart_rows(start_rows);
		userInfo.setEnd_rows(Integer.parseInt(rows));
		Set<String> keys = redisTemplate.keys("RequestOnline--ID:**");
		List<Integer> ids = new ArrayList<>();
		if (keys != null) {
			for (String string : keys) {
				String substringAfterLast = StringUtils.substringAfterLast(string, ":");
				ids.add(Integer.parseInt(substringAfterLast));
			}
		}
		//查询全部用户
		if (isOnline ==null || isOnline ==  0) {
			 List<UserInfo> allRecords = uMapper.getAllRecords(userInfo);
				 for (int i = 0; i < allRecords.size(); i++) {
					for (Integer id : ids) {
						if (allRecords.get(i).getUser_id().equals(id) ) {
							allRecords.get(i).setOnline(1);
						}
					}
				}
				 int total = uMapper.getCount(userInfo);
				//return ResultData.toJsonString(total, allRecords);
				 return new EasyUIReturn(total, allRecords);
		//查询在线用户		
		} else if (isOnline == 1) {
			List<UserInfo> userInfos = uMapper.getUserInfosByIds(ids,userInfo);
			Integer onlineCount = uMapper.getOnlineCountUserInfosByIds(ids,userInfo);
			for (UserInfo userInfo1 : userInfos) {
				userInfo1.setOnline(1);
			}
			//return ResultData.toJsonString(onlineCount, userInfos);
			return new EasyUIReturn(onlineCount, userInfos);
		}
		return null;
	}
	
	
	
	//获取书籍记录总行数
	public int getCount(UserInfo rList) {
		return uMapper.getCount(rList);
	}

	public int getOnlineNum() {
		Set<String> keys = redisTemplate.keys("RequestOnline--ID:**");
		return keys.size();
	}
	public List<UserInfo> getActiveUsersByPartnerId(Integer partner_id) {
		// TODO Auto-generated method stub
		return uMapper.getActiveUsersByPartnerId(partner_id);
	}
	public UserInfo getUserInfoByUserId(Integer user_id) {
		// TODO Auto-generated method stub
		return uMapper.getUserInfoByUserId(user_id);
	}

	public void delUsers(List<Object> list) {
		// TODO Auto-generated method stub
		
	}

	public int clearUsers(String userArray) {
		int ret = 0;
		try {
			JSONArray jsonArray = JSONArray.fromObject(userArray);  
			List<Object> list= new ArrayList<Object>();
			for(int i=0;i<jsonArray.size();i++){
				JSONObject user = jsonArray.getJSONObject(i);
			    String key = "User:"+ DigestUtils.md5Hex(user.getString("userId")+Config.TOKEN_KEY);
			    redisTemplate.delete(key);
			    String key2 = "ActivityUser-ParentId:"+user.getString("parentId")+"userId:"+user.getString("userId");
			    redisTemplate.delete(key2);
			    list.add(user.getString("userId"));
			}
			uMapper.clearUsers(list);
			ret = 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	

	public List<UserInfo> getUnSubScuribeOpenIdAndParentId(String[] userIds) {
		return uMapper.getUnSubScuribeOpenIdAndParentId(userIds);
	}

	public String getUserPointRecord(UserPointRecord userPointRecord, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int page;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			page = 1;
		}	
		userPointRecord.setStart_rows((page-1)*userPointRecord.getRows());
		List<UserPointRecord> userPointRecords = uMapper.getUserPointRecord(userPointRecord);
		int count = uMapper.getUserPointRecordCount(userPointRecord);
		return ResultData.toJsonString(count, userPointRecords);
	}

	public JSONObject getUserMessageLog(MessageLog messageLog, HttpServletRequest request, Integer parent_id) {
		JSONObject retJson = new JSONObject();
		int page;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			page = 1;
		}
		messageLog.setStart_rows((page-1)*messageLog.getRows());
		List<MessageLog> userPointRecords = uMapper.getUserMessageLog(messageLog);
		String userPic = uMapper.getUserPic(messageLog.getUser_id());
		List<PartnerPmConfig>  ghPic   =uMapper.getGhPic(parent_id);
		
		retJson.put("rows", userPointRecords);
		retJson.put("userPic", userPic);
		retJson.put("ghPic", ghPic);
		System.out.println(ResultData.toJsonString(userPointRecords.size(), userPointRecords));
		return retJson;
	}

	@Transactional
	/**
	 * 发送文本消息
	 * **/
	public int sendAndSaveMsg(MessageLog messageLog) {
		int ret = 0;
		UserInfo userInfo = uMapper.getUserInfoByUserId(messageLog.getUser_id());
		if (userInfo==null) {
			ret = 10;//用户不存在
		}else {
			WxCustomMsg customMsg = new WxCustomMsg();
			customMsg.setUser_id(messageLog.getUser_id());
			customMsg.setMsg_type("text");
			customMsg.setTitle(messageLog.getContent());
			customMsg.setDescription("");
			customMsg.setPartner_id(userInfo.getParent_id());
			customMsg.setTo_user(userInfo.getOpenid());
			customMsg.setType("reply");
			String retStr = MyWxUtils.sendCustomMsg(customMsg);
			JSONObject jsonRet = JSONObject.fromObject(retStr);
			Log4jUtil.getBusinessLogger().info(jsonRet);
			ret = jsonRet.optInt("errcode", 11);
			if (ret == 0) {//发送成功
				ret = 2;
				customMsg.setSend_status(2);
				try {
					messageLog.setFlag(2);
					uMapper.saveMessageLog(messageLog);
					cMsgMapper.saveCustomMsg(customMsg);
					ret = 12;//发送成功，保存成功
				} catch (Exception e) {
					// TODO Auto-generated catch block
					ret = 13;//发送成功保存数据库失败
				}
			}

		}
		return ret;
	}
	
	

}
