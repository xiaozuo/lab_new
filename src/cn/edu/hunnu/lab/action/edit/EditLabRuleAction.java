package cn.edu.hunnu.lab.action.edit;

import java.net.URLDecoder;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.action.model.ReadLabUserModel;
import cn.edu.hunnu.lab.util.GetUpdate;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EditLabRuleAction extends ActionSupport implements ModelDriven<ReadLabUserModel>{
	ReadLabUserModel model = new ReadLabUserModel();
	public String execute() throws Exception{
		String a_lab_rule = ServletActionContext.getRequest().getParameter("lab_rule");
		a_lab_rule = URLDecoder.decode(a_lab_rule, "utf-8");
		
		String sql = "update libinfo set rule='" + a_lab_rule + "'";
		GetUpdate.updata(sql);
		
		return "success";
	}
	public ReadLabUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}
}
