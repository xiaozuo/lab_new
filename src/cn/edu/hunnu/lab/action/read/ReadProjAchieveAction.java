package cn.edu.hunnu.lab.action.read;

import java.net.URLDecoder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.action.model.ResearchUserModel;
import cn.edu.hunnu.lab.dao.read.GetResearchInfo;
import cn.edu.hunnu.lab.dao.read.GetType;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReadProjAchieveAction extends ActionSupport implements ModelDriven<ResearchUserModel>{
	ResearchUserModel model = new ResearchUserModel();
	public String execute() throws Exception{
		ServletContext application = ServletActionContext.getRequest().getSession().getServletContext();
		String method = (String) application.getAttribute("method");
		
		String a_type = ServletActionContext.getRequest().getParameter("type");
		a_type = URLDecoder.decode(a_type, "utf-8");
		//a_type = URLDecoder.decode(a_type, "utf-8");
		System.out.println(a_type);
		if(method == null){
			application.setAttribute("method", "按时间前后显示");
			method = "按时间前后显示";
		}
		model.setAchieve(GetType.GetAchievements(0,a_type, method));

		model.setCurrentPage(1);
		model.setTotalPage(GetResearchInfo.GetResearchTotalPage(a_type));
		return "success";
	}

	public ResearchUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}

}
