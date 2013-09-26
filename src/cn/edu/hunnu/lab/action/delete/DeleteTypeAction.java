package cn.edu.hunnu.lab.action.delete;

import java.net.URLDecoder;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.util.GetUpdate;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteTypeAction extends ActionSupport{
	public String execute() throws Exception {
		String a_deleteType = ServletActionContext.getRequest().getParameter("deleteType");
		a_deleteType = URLDecoder.decode(a_deleteType, "utf-8");
		
		String sql = "delete from typeupdate where name='" + a_deleteType + "'";
		GetUpdate.updata(sql);
		
		return "success";
	}
}
