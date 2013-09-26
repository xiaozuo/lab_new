package cn.edu.hunnu.lab.action.read;

import cn.edu.hunnu.lab.action.model.UserInfoUserModel;
import cn.edu.hunnu.lab.dao.read.GetInfoIndex;
import cn.edu.hunnu.lab.dao.read.GetInfo_User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReadUserInfoPageAction extends ActionSupport implements ModelDriven<UserInfoUserModel>{
	UserInfoUserModel model=new UserInfoUserModel();
	public String execute() throws Exception{
		int page = model.getCurrentPage();
		model.setTotalPage(GetInfo_User.getTotalPage());
		if(page <= 1)
		{
			model.setUsers(GetInfo_User.setUserInfo(0));
			model.setCurrentPage(1);
			System.out.println("if" + model.getCurrentPage());
		}
		else
		{
			model.setUsers(GetInfo_User.setUserInfo((page-1)*10));
			System.out.println("else" + model.getCurrentPage());
		}
		
		return "success";
	}
	public UserInfoUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}

}
