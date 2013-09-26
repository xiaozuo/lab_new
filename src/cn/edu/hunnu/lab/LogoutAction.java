package cn.edu.hunnu.lab;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.dao.Login;

public class LogoutAction {
	public String execute() throws Exception 
	{ 
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("s_user",null);
			return "success";
	} 
}
