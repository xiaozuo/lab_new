package cn.edu.hunnu.lab.action.edit;

import java.net.URLDecoder;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.util.GetUpdate;

import com.opensymphony.xwork2.ActionSupport;

public class EditTypeAction extends ActionSupport{

	public String execute() throws Exception{
		String a_editId = ServletActionContext.getRequest().getParameter("editId");
		a_editId = URLDecoder.decode(a_editId, "utf-8");
		
		String a_editType = ServletActionContext.getRequest().getParameter("editType");
		a_editType = URLDecoder.decode(a_editType, "utf-8");
		
		String sql = "update typeupdate set name='" + a_editType + "' where id='" + a_editId + "'";
		
		GetUpdate.updata(sql);
		
		return "success";
	}
}
