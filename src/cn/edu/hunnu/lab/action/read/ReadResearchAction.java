package cn.edu.hunnu.lab.action.read;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.action.model.ResearchUserModel;
import cn.edu.hunnu.lab.action.model.achievement;
import cn.edu.hunnu.lab.action.model.news;
import cn.edu.hunnu.lab.dao.read.GetInfoIndex;
import cn.edu.hunnu.lab.dao.read.GetResearchInfo;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReadResearchAction extends ActionSupport implements ModelDriven<ResearchUserModel> {
	ResearchUserModel model = new ResearchUserModel();
	public String execute() throws Exception{
			ServletContext application = ServletActionContext.getRequest().getSession().getServletContext();
			String method = (String) application.getAttribute("method");
			//System.out.println(method);
			if(method == null){
				application.setAttribute("method", "按时间前后显示");
				method = "按时间前后显示";
				//System.out.println(method);
			}
			
			model.setCurrentPage(1);
			
			List<achievement> list_achievement = new ArrayList<achievement>();
			list_achievement = GetResearchInfo.GetResearchList(0,method);
			if(list_achievement.isEmpty()){
				model.setIsAchievementNull("暂无内容");
			}
			
			model.setAchieve(list_achievement);
			model.setTotalPage(GetResearchInfo.GetResearchTotalPage());
		return "success";
	}
	public ResearchUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}

}
