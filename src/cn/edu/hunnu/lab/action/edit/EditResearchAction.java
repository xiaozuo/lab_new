package cn.edu.hunnu.lab.action.edit;

import java.net.URLDecoder;

import org.apache.struts2.ServletActionContext;
import cn.edu.hunnu.lab.util.GetUpdate;

import com.opensymphony.xwork2.ActionSupport;

public class EditResearchAction extends ActionSupport {
	public String execute() throws Exception{
		String a_type = ServletActionContext.getRequest().getParameter("research_type");
		a_type = URLDecoder.decode(a_type, "utf-8");
		
		String a_name = ServletActionContext.getRequest().getParameter("research_name");
		a_name = URLDecoder.decode(a_name, "utf-8");
		
		String a_detail = ServletActionContext.getRequest().getParameter("research_detail");
		a_detail = URLDecoder.decode(a_detail, "utf-8");
		
		String a_time = ServletActionContext.getRequest().getParameter("research_time");
		a_time = URLDecoder.decode(a_time, "utf-8");
		
		String a_level = ServletActionContext.getRequest().getParameter("research_level");
		a_level = URLDecoder.decode(a_level, "utf-8");
		
		String a_chief = ServletActionContext.getRequest().getParameter("research_chief");
		a_chief = URLDecoder.decode(a_chief, "utf-8");
		
		String a_members = ServletActionContext.getRequest().getParameter("research_members");
		a_members = URLDecoder.decode(a_members, "utf-8");
		
		String a_id = ServletActionContext.getRequest().getParameter("research_id");
		a_id = URLDecoder.decode(a_id, "utf-8");
		
		String sql = "update research set" 
					+ " type='" + a_type
					+ "',name='" + a_name 
					+ "',detail='" + a_detail 
					+ "',time='" + a_time 
					+ "',level='" + a_level
					+ "',chief='" + a_chief
					+ "',members='" + a_members 
					+ "' where id='" + a_id + "'";
		
		GetUpdate.updata(sql);
		
		return "success";
	}
}
