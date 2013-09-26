package cn.edu.hunnu.lab.action;

import java.net.URLDecoder;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ChooseMethodAction extends ActionSupport {
	public String execute()throws Exception{
		String choose = ServletActionContext.getRequest().getParameter("choosen");
		choose = URLDecoder.decode(choose, "utf-8");
		//System.out.println(choose);
		ServletContext application = ServletActionContext.getRequest().getSession().getServletContext();
		application.setAttribute("method", choose);
		System.out.println(application.getAttribute("method"));
		return "success";
	}
}
