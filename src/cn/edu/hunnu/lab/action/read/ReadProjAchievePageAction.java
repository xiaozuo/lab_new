package cn.edu.hunnu.lab.action.read;

import java.net.URLDecoder;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.action.model.ResearchUserModel;
import cn.edu.hunnu.lab.dao.read.GetResearchInfo;
import cn.edu.hunnu.lab.dao.read.GetType;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReadProjAchievePageAction extends ActionSupport implements ModelDriven<ResearchUserModel>{
	ResearchUserModel model = new ResearchUserModel();
	public String execute() throws Exception{
		ServletContext application = ServletActionContext.getRequest().getSession().getServletContext();
		String method = (String) application.getAttribute("method");
		System.out.println(method);
		String a_type = ServletActionContext.getRequest().getParameter("type");
		a_type = URLDecoder.decode(a_type, "utf-8");
		//a_type = URLDecoder.decode(a_type, "utf-8");
		System.out.println(a_type);
		if(method == null){
			application.setAttribute("method", "按时间前后显示");
			method = "按时间前后显示";
		}

		String pageString = ServletActionContext.getRequest().getParameter("currentPage");
		pageString = URLDecoder.decode(pageString, "utf-8");
		int page = Integer.parseInt(pageString);
		System.out.println(page);
		if(page < 2){
			model.setCurrentPage(1);
			model.setAchieve(GetType.GetAchievements(0,a_type, method));
		}
		else{
			model.setAchieve(GetType.GetAchievements((page-1)*10,a_type, method));
			model.setCurrentPage(page);
		}
		model.setTotalPage(GetResearchInfo.GetResearchTotalPage(a_type));
		return "success";
	}

	public ResearchUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}

}
