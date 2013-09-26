package cn.edu.hunnu.lab.action.add;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.action.model.UpdateUserModel;
import cn.edu.hunnu.lab.dao.add.AddUser;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.net.URLDecoder;

public class AddUserAction extends ActionSupport implements ModelDriven<UpdateUserModel>{
	static UpdateUserModel model = new UpdateUserModel();
	public String execute() throws Exception {
		String a_user = ServletActionContext.getRequest().getParameter("new_user");
		a_user = URLDecoder.decode(a_user, "utf-8");
		String a_password = ServletActionContext.getRequest().getParameter("new_password");
		a_password = URLDecoder.decode(a_password, "utf-8");
		String a_usertype = ServletActionContext.getRequest().getParameter("new_usertype");
		a_usertype = URLDecoder.decode(a_usertype, "utf-8");
		boolean insert = AddUser.adduser(a_user, a_password, a_usertype);
		if(insert){
			model.setUpdate_result("add_user_success");		
		}
		else{
			model.setUpdate_result("add_user_fail");
		}
		return "success";
	}

	public UpdateUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}
}
