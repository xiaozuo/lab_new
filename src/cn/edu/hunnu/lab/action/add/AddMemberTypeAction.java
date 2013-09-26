package cn.edu.hunnu.lab.action.add;

import java.net.URLDecoder;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.util.GetUpdate;

import com.opensymphony.xwork2.ActionSupport;

public class AddMemberTypeAction extends ActionSupport{
	public String execute() throws Exception{
		String a_newType = ServletActionContext.getRequest().getParameter("newType");
		a_newType = URLDecoder.decode(a_newType, "utf-8");
		
		String sql = "insert into typeUpdate (pid,name) values ('2','" + a_newType + "')";
		GetUpdate.updata(sql);
		
		return "success";
	}

}
