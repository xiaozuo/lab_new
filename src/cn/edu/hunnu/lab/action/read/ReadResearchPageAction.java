package cn.edu.hunnu.lab.action.read;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.action.model.ResearchUserModel;
import cn.edu.hunnu.lab.dao.read.GetResearchInfo;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReadResearchPageAction extends ActionSupport implements ModelDriven<ResearchUserModel> {
	ResearchUserModel model = new ResearchUserModel();
	public String execute() throws Exception{
		ServletContext application = ServletActionContext.getRequest().getSession().getServletContext();
		String method = (String) application.getAttribute("method");
		
		int page = model.getCurrentPage();
		System.out.println(page);
		if(page < 2){
			model.setCurrentPage(1);
			model.setAchieve(GetResearchInfo.GetResearchList(0,method));
		}
		else{
			model.setAchieve(GetResearchInfo.GetResearchList((page-1)*10,method));
			model.setCurrentPage(page);
		}
		model.setTotalPage(GetResearchInfo.GetResearchTotalPage());
		return "success";
	}
	public ResearchUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}

}