package com.kuaidu.nms.user.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaidu.nms.entity.UserInfo;
import com.kuaidu.nms.entity.UserProposal;
import com.kuaidu.nms.entity.WxCustomMsg;
import com.kuaidu.nms.message.mapper.CustomMsgMapper;
import com.kuaidu.nms.user.mapper.UserFeedBackMapper;
import com.kuaidu.nms.user.mapper.UserManagementMapper;

import net.sf.json.JSONArray;
/*
 * 接口实现类
 * */
@Service
@Transactional 
public class UserFeedBackMapperImpl {
	@Resource
	private UserFeedBackMapper rMapper;
	
	@Autowired
	CustomMsgMapper cMsgMapper;
	@Autowired
	UserManagementMapper userMapper;

	@Resource
	private UserManagementMapper uMapper;
	
	public UserFeedBackMapper getrMapper() {
		return rMapper;
	}

	public void setrMapper(UserFeedBackMapper rMapper) {
		this.rMapper = rMapper;
	}
	//查询书籍
	public List<UserProposal> getAllRecords(UserProposal rList) {
		return rMapper.getAllRecords(rList);
	}
	//获取书籍记录总行数
	public int getCount(UserProposal rList) {
		return rMapper.getCount(rList);
	}

	public void ignore(List<Integer> ids,int status) throws Exception{
		rMapper.ignore(ids,status);
	}
	@Transactional
	public int changeStatus(UserProposal userProposal) {
		// TODO Auto-generated method stub
		int ret = 0;
		try {
			List<Integer> chapter_ids = new ArrayList<Integer>();
			chapter_ids.add(userProposal.getId());
			rMapper.ignore(chapter_ids,1);
			uMapper.addUserPoint50(userProposal.getUser_id());
			
			ret = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ret;
	}

	public void saveCustomMsg(Integer userId) throws Exception{
		// TODO Auto-generated method stub
		UserInfo userInfo = userMapper.getUserInfoByUserId(userId);
		if (userInfo!=null && userInfo.getSubscribe()==1) {
			WxCustomMsg wxCustomMsg = new WxCustomMsg();
			wxCustomMsg.setPartner_id(userInfo.getParent_id());
			wxCustomMsg.setUser_id(userInfo.getUser_id());
			wxCustomMsg.setTo_user(userInfo.getOpenid());
			wxCustomMsg.setType("feedback");
			wxCustomMsg.setMsg_type("text");
			wxCustomMsg.setDescription("");
			wxCustomMsg.setTitle("感谢您的细心反馈，50书币已经到账，请查收!\n当前书币余额："+userInfo.getUser_point()+"\n\n🉐可发送“书名”或“主角名”找到您想要的小说\n\n每日发送“签到”免费得书币🔥");
			cMsgMapper.saveCustomMsg(wxCustomMsg);
		}
	}
	@Transactional
	public int doFeedBack(String idstrs, String userIdStrs) {
		int ret = 0;
		try {
			JSONArray idsArray = JSONArray.fromObject(idstrs);
			JSONArray userIdsArray = JSONArray.fromObject(userIdStrs);
			List<Integer> addIds = new ArrayList<Integer>();
			List<Integer> ignoreIds = new ArrayList<Integer>();
			Set<Integer> userIds = new HashSet<Integer>();
			for (int i = 0; i < userIdsArray.size(); i++) {
				if (userIds.add(userIdsArray.getInt(i))) {
					addIds.add(idsArray.getInt(i));
				}else {
					ignoreIds.add(idsArray.getInt(i));
				}
			}
			if (addIds.size()>0) {
				ignore(addIds,1);
			}
			if (ignoreIds.size()>0) {
				ignore(ignoreIds,2);
			}
			if (userIds.size()>0) {
				uMapper.addUsersPoint50(userIds);
				for (Integer user_id : userIds) {
					saveCustomMsg(user_id);
				}
			}
			ret = 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

}
