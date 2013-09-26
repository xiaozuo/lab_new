package cn.edu.hunnu.lab.action.edit;

import java.net.URLDecoder;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.action.model.UpdateUserModel;
import cn.edu.hunnu.lab.action.model.UserInfoUserModel;
import cn.edu.hunnu.lab.util.GetUpdate;
import cn.edu.hunnu.lab.util.Helper;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserDetailEditAction extends ActionSupport implements ModelDriven<UserInfoUserModel>{
	static UserInfoUserModel model = new UserInfoUserModel();
	public String execute() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		String m_user = (String) session.getAttribute("s_user");
		//a_user = URLDecoder.decode(a_user, "utf-8");
		//new String(str.getBytes("ISO8859_1"), "UTF8")
		String m_username = ServletActionContext.getRequest().getParameter("username");
		m_username = URLDecoder.decode(m_username, "utf-8");
		GetUpdate.updata("update member set name='"+m_username+"' where user='"+m_user+"';");
		
		String m_sex = ServletActionContext.getRequest().getParameter("sex");
		m_sex = URLDecoder.decode(m_sex, "utf-8");
		GetUpdate.updata("update member set sex='"+m_sex+"' where user='"+m_user+"';");
		
		String m_birthday = ServletActionContext.getRequest().getParameter("birthday");
		m_birthday = URLDecoder.decode(m_birthday, "utf-8");
		GetUpdate.updata("update member set birthday='"+m_birthday+"' where user='"+m_user+"';");
		
		String m_enteryear = ServletActionContext.getRequest().getParameter("enteryear");
		m_enteryear = URLDecoder.decode(m_enteryear, "utf-8");
		GetUpdate.updata("update member set enteryear='"+m_enteryear+"' where user='"+m_user+"';");
		
		String m_major = ServletActionContext.getRequest().getParameter("major");
		m_major = URLDecoder.decode(m_major, "utf-8");
		GetUpdate.updata("update member set major='"+m_major+"' where user='"+m_user+"';");
		
		String m_education = ServletActionContext.getRequest().getParameter("education");
		m_education = URLDecoder.decode(m_education, "utf-8");
		GetUpdate.updata("update member set education='"+m_education+"' where user='"+m_user+"';");
		
		String m_research = ServletActionContext.getRequest().getParameter("research");
		m_research = URLDecoder.decode(m_research, "utf-8");
		GetUpdate.updata("update member set research='"+m_research+"' where user='"+m_user+"';");
		
		String m_membertype = ServletActionContext.getRequest().getParameter("membertype");
		m_membertype = URLDecoder.decode(m_membertype, "utf-8");
		GetUpdate.updata("update member set membertype='"+m_membertype+"' where user='"+m_user+"';");
		
		//String m_photo;
		
		String m_resume = ServletActionContext.getRequest().getParameter("resume");
		m_resume = URLDecoder.decode(m_resume, "utf-8");
		GetUpdate.updata("update member set resume='"+m_resume+"' where user='"+m_user+"';");
		
		String m_telno = ServletActionContext.getRequest().getParameter("telno");
		m_telno = URLDecoder.decode(m_telno, "utf-8");
		GetUpdate.updata("update member set telno='"+m_telno+"' where user='"+m_user+"';");
		
		String m_email = ServletActionContext.getRequest().getParameter("email");
		m_email = URLDecoder.decode(m_email, "utf-8");
		GetUpdate.updata("update member set email='"+m_email+"' where user='"+m_user+"';");
		
		String m_workexperience = ServletActionContext.getRequest().getParameter("workexperience");
		m_workexperience = URLDecoder.decode(m_workexperience, "utf-8");
		GetUpdate.updata("update member set workexperience='"+m_workexperience+"' where user='"+m_user+"';");
		
		String m_QQ = ServletActionContext.getRequest().getParameter("QQ");
		m_QQ = URLDecoder.decode(m_QQ, "utf-8");
		GetUpdate.updata("update member set QQ='"+m_QQ+"' where user='"+m_user+"';");
		
		model.setUpdate_flag("Update_Success!");
		return "success";
		
	}
	public UserInfoUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}

}
