package cn.edu.hunnu.lab.action.read;

import java.net.URLDecoder;
import java.sql.ResultSet;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.action.model.UserInfoUserModel;
import cn.edu.hunnu.lab.dao.read.GetUserDetailByType;
import cn.edu.hunnu.lab.util.GetQuery;
import cn.edu.hunnu.lab.util.Helper;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReadMemberDetailAction extends ActionSupport implements ModelDriven<UserInfoUserModel>{
	static UserInfoUserModel model = new UserInfoUserModel();
	public String execute() throws Exception {
		
		String name = ServletActionContext.getRequest().getParameter("name");
		name = URLDecoder.decode(name, "utf-8");
		
		ResultSet rs = GetQuery.query("SELECT * FROM member where name='" + name + "'");
		Helper.showRS(rs);
		rs = GetQuery.query("SELECT * FROM member where name='" + name + "'");
		if(!rs.next())
			return "fail";
		model.setUsername(name);
		model.setBirthday(rs.getString("birthday"));
		model.setSex(rs.getString("sex"));
		model.setEnteryear(rs.getString("enteryear"));
		model.setMajor(rs.getString("major"));
		model.setEducation(rs.getString("education"));
		model.setResearch(rs.getString("research"));
		model.setMembertype(rs.getString("membertype"));
		model.setResume(rs.getString("resume"));
		model.setTelno(rs.getString("telno"));
		model.setEmail(rs.getString("email"));
		model.setWorkexperience(rs.getString("workexperience"));
		model.setQQ(rs.getString("QQ"));
		String m_photo;
		
		return "success";
		
	}
	public UserInfoUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
}
