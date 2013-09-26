package cn.edu.hunnu.lab.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.action.model.LoginUserModel;
import cn.edu.hunnu.lab.dao.Login;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<LoginUserModel>{
	static LoginUserModel model=new LoginUserModel();

	public String execute() throws Exception 
	{ 
		
		String m_user = model.getUser();
		String m_password = model.getPassword();
		System.out.println(m_user + ", " + m_password);
		String result = Login.userlogin(m_user, m_password);
		if(result.equals("success")){
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("s_user",m_user);
		}
		//System.out.println(session.getId());
		//System.out.println(session.getAttribute("s_user"));
		model.setResult(result);
		return result;
	} 
	public static void main(String arg[]){
		try {
			String flag = Login.userlogin("luofengming","15084973966");
			System.out.println(flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public LoginUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}
}
