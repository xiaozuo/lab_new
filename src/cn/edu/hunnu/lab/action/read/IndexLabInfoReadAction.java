package cn.edu.hunnu.lab.action.read;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.action.model.IndexUserModel;
import cn.edu.hunnu.lab.action.model.achievement;
import cn.edu.hunnu.lab.action.model.news;
import cn.edu.hunnu.lab.action.model.notice;
import cn.edu.hunnu.lab.dao.read.GetInfoIndex;
import cn.edu.hunnu.lab.dao.read.GetResearchInfo;
import cn.edu.hunnu.lab.util.GetQuery;
import cn.edu.hunnu.lab.util.Helper;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class IndexLabInfoReadAction extends ActionSupport implements ModelDriven<IndexUserModel> {
	public static IndexUserModel model=new IndexUserModel();
	public String execute() throws Exception 
	{ 
		String sql = "select * from libinfo";
		GetQuery.query(sql);
		
		ResultSet rs = GetQuery.query(sql);
		if(rs.next()){
			model.setAddress(rs.getString("address"));
			model.setTelno(rs.getString("telno"));
			model.setEmail(rs.getString("email"));
			model.setFax(rs.getString("fax"));
		}
		
		ServletContext application = ServletActionContext.getRequest().getSession().getServletContext();
		String method = (String) application.getAttribute("method");
		if(method == null){
			application.setAttribute("method", "按时间前后显示");
			method = "按时间前后显示";
		}
		
		//如果为空就显示暂无内容
		List<achievement> list_achievement = new ArrayList<achievement>();
		list_achievement = GetResearchInfo.GetResearchList(0,method);
		if(list_achievement.isEmpty()){
			model.setIsAchieveNull("暂无内容");
		}
		
		List<notice> list_notice = new ArrayList<notice>();
		list_notice = GetInfoIndex.getInfo_notice(0);
		if(list_notice.isEmpty()){
			model.setIsNoticeNull("暂无内容");
		}
		
		List<news> list_news = new ArrayList<news>();
		list_news = GetInfoIndex.getInfo_news(0);
		if(list_news.isEmpty()){
			model.setIsNewsNull("暂无内容");
		}
		
		model.setResume(GetInfoIndex.getInfo_resume());
		model.setNewsList(list_news);
		model.setNoticeList(list_notice);
		model.setAchievement(list_achievement);
		
		return this.SUCCESS;
	}
	
	public IndexUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}
}
