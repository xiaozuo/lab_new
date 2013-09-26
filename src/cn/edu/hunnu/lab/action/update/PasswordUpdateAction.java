package cn.edu.hunnu.lab.action.update;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.action.model.UpdatePasswordUserModel;
import cn.edu.hunnu.lab.dao.update.UpdatePassword;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PasswordUpdateAction extends ActionSupport implements ModelDriven<UpdatePasswordUserModel>{
	UpdatePasswordUserModel model = new UpdatePasswordUserModel();
	public String execute() throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		System.out.println(session.getAttribute("s_user"));
		String m_user = (String) session.getAttribute("s_user");
		String m_password = model.getPassword();
		String m_newPassword = model.getNew_password();
		String m_newPasswordConfirm = model.getNew_password_confirm();
		String result = UpdatePassword.updatePassword(m_user, m_password, m_newPassword, m_newPasswordConfirm);
		if(result.equals("password_change_success")){
			model.setPassword_change_flag("密码修改成功！");
		}
		else if(result.equals("wrong_confirm")){
			model.setNew_password_confirm("新密码两次输入不一致，请重新输入！");
		}
		else
			model.setNew_password_confirm("旧密码输入错误！");
		return "success";
	}
	public UpdatePasswordUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}

}
