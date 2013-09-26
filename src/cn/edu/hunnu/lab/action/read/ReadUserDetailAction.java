package cn.edu.hunnu.lab.action.read;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import java.sql.ResultSetMetaData;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.hunnu.lab.action.model.UserInfoUserModel;
import cn.edu.hunnu.lab.util.GetQuery;
import cn.edu.hunnu.lab.util.Helper;

public class ReadUserDetailAction extends ActionSupport implements ModelDriven<UserInfoUserModel>{
	static UserInfoUserModel model = new UserInfoUserModel();
	public String execute() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		System.out.println(session.getAttribute("s_user"));
		String m_user = (String) session.getAttribute("s_user");
		System.out.println(m_user);
		ResultSet rs = GetQuery.query("SELECT * FROM member where user='" + m_user + "'");
		Helper.showRS(rs);
		rs = GetQuery.query("SELECT * FROM member where user='" + m_user + "'");
		if(!rs.next())
			return "fail";
		model.setUsername(rs.getString("name"));
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
