package cn.edu.hunnu.lab.action.add;

import java.net.URLDecoder;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.util.GetUpdate;

import com.opensymphony.xwork2.ActionSupport;

public class AddResearchAction extends ActionSupport{
	public String execute() throws Exception{
		System.out.println("????");
		String a_type = ServletActionContext.getRequest().getParameter("new_research_type");
		a_type = URLDecoder.decode(a_type, "utf-8");
		System.out.println(a_type);
		String a_name = ServletActionContext.getRequest().getParameter("new_research_name");
		a_name = URLDecoder.decode(a_name, "utf-8");
		
		String a_detail = ServletActionContext.getRequest().getParameter("new_research_detail");
		a_detail = URLDecoder.decode(a_detail, "utf-8");
		
		String a_time = ServletActionContext.getRequest().getParameter("new_research_time");
		a_time = URLDecoder.decode(a_time, "utf-8");
		
		String a_level = ServletActionContext.getRequest().getParameter("new_research_level");
		a_level = URLDecoder.decode(a_level, "utf-8");
		
		String a_chief = ServletActionContext.getRequest().getParameter("new_research_chief");
		a_chief = URLDecoder.decode(a_chief, "utf-8");
		
		String a_members = ServletActionContext.getRequest().getParameter("new_research_members");
		a_members = URLDecoder.decode(a_members, "utf-8");
		
		String sql = "insert into research (type,name,detail,time,level,chief,members) values ('" 
											+ a_type + "','" 
											+ a_name + "','"
											+ a_detail + "','" 
											+ a_time + "','" 
											+ a_level+ "','" 
											+ a_chief+ "','" 
											+ a_members + "')"; 

		GetUpdate.updata(sql);
		
		return "success";
	}
}
