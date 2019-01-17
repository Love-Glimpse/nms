package com.kuaidu.nms.datastaticstics.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuaidu.nms.datastaticstics.mapper.StatUserStayMapper;
import com.kuaidu.nms.entity.ActiveUser;
import com.kuaidu.nms.entity.StatUserStayByDay;
import com.kuaidu.nms.utils.ResultData;
import com.kuaidu.nms.utils.Utils;

/**
 * @description TODO
 * @time 2018年9月11日 下午2:01:37
 * @author victor
 * @version 1.0
 **/
@Service
public class StatUserStayMapperImpl {
	@Autowired
	StatUserStayMapper sMapper;

	public String getStatUserStays(StatUserStayByDay statUserStayByDay) {
		// TODO Auto-generated method stub
		List<StatUserStayByDay> statUserStayByDays = new ArrayList<StatUserStayByDay>();
		List<String> dates = Utils.findDates(statUserStayByDay.getStart_date(), statUserStayByDay.getEnd_date());
		ActiveUser activeUser = new ActiveUser();
		activeUser.setParent_id(statUserStayByDay.getParent_id());
		activeUser.setPartner_id(statUserStayByDay.getPartner_id());
		activeUser.setPush_id(statUserStayByDay.getPush_id());
		for (String date : dates) {
			activeUser.setCreate_date(date);
			StatUserStayByDay sByDay = new StatUserStayByDay();
			sByDay.setCreate_date(date);
			List<ActiveUser> activeUsers = sMapper.getStatUserStays(activeUser);
			int new_count = sMapper.getNewUserCount(activeUser);
			sByDay.setNew_count(new_count);
			for (int i = 0; i < activeUsers.size(); i++) {
				if (i==0) {
					sByDay.setDay1(String.valueOf(activeUsers.get(i).getActive_count()));
				}
				if (i==1) {
					sByDay.setDay2(String.valueOf(activeUsers.get(i).getActive_count()));
				}
				if (i==2) {
					sByDay.setDay3(String.valueOf(activeUsers.get(i).getActive_count()));
				}
				if (i==3) {
					sByDay.setDay4(String.valueOf(activeUsers.get(i).getActive_count()));
				}
				if (i==4) {
					sByDay.setDay5(String.valueOf(activeUsers.get(i).getActive_count()));
				}
				if (i==5) {
					sByDay.setDay6(String.valueOf(activeUsers.get(i).getActive_count()));
				}
				if (i==6) {
					sByDay.setDay7(String.valueOf(activeUsers.get(i).getActive_count()));
				}
				if (i==7) {
					sByDay.setDay8(String.valueOf(activeUsers.get(i).getActive_count()));
				}
				if (i==8) {
					sByDay.setDay9(String.valueOf(activeUsers.get(i).getActive_count()));
				}
				if (i==9) {
					sByDay.setDay10(String.valueOf(activeUsers.get(i).getActive_count()));
				}
				if (i==14) {
					sByDay.setDay15(String.valueOf(activeUsers.get(i).getActive_count()));
				}
				if (i==29) {
					sByDay.setDay30(String.valueOf(activeUsers.get(i).getActive_count()));
				}
				if (i==59) {
					sByDay.setDay60(String.valueOf(activeUsers.get(i).getActive_count()));
				}
				if (i==89) {
					sByDay.setDay90(String.valueOf(activeUsers.get(i).getActive_count()));
				}
			}
			statUserStayByDays.add(sByDay);
		}
		return ResultData.toJsonString(statUserStayByDays.size(), statUserStayByDays);
	}





	public String getUserStayDetail(Integer parentId, Integer pushId, String create_date,int days,int page, int rows) {
		// TODO Auto-generated method stub
		int start_row = (page-1)*rows;
		List<ActiveUser> activeUsers = sMapper.getActiveUserDetail(parentId,pushId,create_date,days,start_row,rows);
		int count = sMapper.getActiveUserDetailCount(parentId,pushId,create_date,days);
		return ResultData.toJsonString(count, activeUsers);
	}


	public String getUserStayDetailByUserId(int user_id) {
		// TODO Auto-generated method stub
		List<ActiveUser> activeUsers = sMapper.getUserStayDetailByUserId(user_id);
		return ResultData.toJsonString(activeUsers.size(), activeUsers);
	}
}
