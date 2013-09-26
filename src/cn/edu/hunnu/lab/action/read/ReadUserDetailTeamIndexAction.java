package cn.edu.hunnu.lab.action.read;

import cn.edu.hunnu.lab.action.model.UserInfoListUserModel;
import cn.edu.hunnu.lab.dao.read.GetUserDetailByType;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReadUserDetailTeamIndexAction extends ActionSupport implements ModelDriven<UserInfoListUserModel>{
	static UserInfoListUserModel model = new UserInfoListUserModel();
	public String execute() throws Exception {
		
		model.setType("固定研究人员");
		model.setMemberList(GetUserDetailByType.GetMembers("固定研究人员",0));
		model.setPage_index(1);
		model.setTotal_page_index(GetUserDetailByType.GetPage("固定研究人员"));
		
		return "success";
		
	}
	public UserInfoListUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
}
