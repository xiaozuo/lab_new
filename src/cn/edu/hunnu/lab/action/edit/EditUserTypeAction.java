package cn.edu.hunnu.lab.action.edit;

import java.net.URLDecoder;
import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.util.GetUpdate;

import com.opensymphony.xwork2.ActionSupport;

public class EditUserTypeAction extends ActionSupport{

	public String execute() throws Exception{
		String a_newType = ServletActionContext.getRequest().getParameter("newType");
		a_newType = URLDecoder.decode(a_newType, "utf-8");
		
		String a_username = ServletActionContext.getRequest().getParameter("username");
		a_username = URLDecoder.decode(a_username, "utf-8");
		
		String sql = "UPDATE member SET usertype = '" + a_newType + "' WHERE user = '" + a_username + "' ";
		GetUpdate.updata(sql);
		
		return "success";
	}

}
