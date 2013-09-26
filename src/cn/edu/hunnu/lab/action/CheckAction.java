package cn.edu.hunnu.lab.action;

import cn.edu.hunnu.lab.action.model.LoginUserModel;
import cn.edu.hunnu.lab.dao.Check;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CheckAction extends ActionSupport implements ModelDriven<LoginUserModel>{
	static LoginUserModel model=new LoginUserModel();
	public String execute() throws Exception {
		String check_result = Check.permission_Check();
		model.setCheck_result(check_result);
		return check_result;
	}

	public LoginUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}
}
