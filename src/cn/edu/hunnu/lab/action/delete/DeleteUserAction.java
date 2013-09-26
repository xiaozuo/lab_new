package cn.edu.hunnu.lab.action.delete;

import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.hunnu.lab.action.model.UpdateUserModel;
import cn.edu.hunnu.lab.dao.delete.DeleteUser;

public class DeleteUserAction extends ActionSupport implements ModelDriven<UpdateUserModel>{
	static UpdateUserModel model = new UpdateUserModel();
	public String execute() throws Exception {
		System.out.println(ServletActionContext.getRequest().getParameter("delete_usernames"));
		String delete_users = ServletActionContext.getRequest().getParameter("delete_usernames");
		delete_users = URLDecoder.decode(delete_users, "utf-8");
		System.out.println(delete_users);
		
		String delete_user[] = delete_users.split("-");  
		for(int i = 0;i < delete_user.length; ++i){ 
			String username = delete_user[i];
			//if(username.isEmpty())
				//continue;
			DeleteUser.deleteuser(username);		    
		} 
		model.setUpdate_result(URLEncoder.encode(delete_users, "utf-8"));
		return "success";
	}
	
	public UpdateUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}
}
