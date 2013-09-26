package cn.edu.hunnu.lab.action.edit;

import java.net.URLDecoder;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.action.model.ReadLabUserModel;
import cn.edu.hunnu.lab.util.GetUpdate;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EditLabResearchAreaAction extends ActionSupport implements ModelDriven<ReadLabUserModel>{
	ReadLabUserModel model = new ReadLabUserModel();
	public String execute() throws Exception{
		String a_labResearchArea = ServletActionContext.getRequest().getParameter("lab_researchArea");
		a_labResearchArea = URLDecoder.decode(a_labResearchArea, "utf-8");
		
		String sql = "update libinfo set researchArea='" + a_labResearchArea + "'";
		GetUpdate.updata(sql);
		
		return "success";
	}
	public ReadLabUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}

}
