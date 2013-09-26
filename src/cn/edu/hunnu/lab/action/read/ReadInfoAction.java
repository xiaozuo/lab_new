package cn.edu.hunnu.lab.action.read;

import cn.edu.hunnu.lab.action.model.UserInfoUserModel;
import cn.edu.hunnu.lab.dao.read.GetInfo_User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReadInfoAction extends ActionSupport implements ModelDriven<UserInfoUserModel>{

	UserInfoUserModel model=new UserInfoUserModel();
	public String execute() throws Exception 
	{ 
		model.setUser(GetInfo_User.getUser(0));
		model.setUsers(GetInfo_User.setUserInfo(0));
		model.setTotalPage(GetInfo_User.getTotalPage());
		model.setCurrentPage(1);
		return "success";
	} 
	public UserInfoUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}

}
