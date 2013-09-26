package cn.edu.hunnu.lab.action;

import cn.edu.hunnu.lab.action.model.LoginUserModel;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TestAction extends ActionSupport implements ModelDriven<LoginUserModel> {
	LoginUserModel model=new LoginUserModel();
    
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		model.setUser("tom");
		return this.SUCCESS;
	}

	public LoginUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}

}
