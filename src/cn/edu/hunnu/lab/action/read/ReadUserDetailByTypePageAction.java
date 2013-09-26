package cn.edu.hunnu.lab.action.read;

import java.net.URLDecoder;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.action.model.UserInfoListUserModel;
import cn.edu.hunnu.lab.dao.read.GetUserDetailByType;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReadUserDetailByTypePageAction extends ActionSupport implements ModelDriven<UserInfoListUserModel>{
	static UserInfoListUserModel model = new UserInfoListUserModel();
	public String execute() throws Exception {
		
		String type = ServletActionContext.getRequest().getParameter("type");
		type = URLDecoder.decode(type, "utf-8");
		
		model.setType(type);
		
		String page = ServletActionContext.getRequest().getParameter("currentPage");
		page = URLDecoder.decode(page, "utf-8");
		int pageIndex = Integer.parseInt(page);

		model.setPage_index(pageIndex);
		System.out.println(pageIndex);
		
		if(pageIndex < 2){
			model.setMemberList(GetUserDetailByType.GetMembers(type,0));
		}
		else
			model.setMemberList(GetUserDetailByType.GetMembers(type,(pageIndex-1)*3));
		
		model.setTotal_page_index(GetUserDetailByType.GetPage(type));
		
		return "success";
		
	}
	public UserInfoListUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
}