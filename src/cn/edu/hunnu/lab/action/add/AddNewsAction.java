package cn.edu.hunnu.lab.action.add;

import java.net.URLDecoder;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.util.GetUpdate;

import com.opensymphony.xwork2.ActionSupport;

public class AddNewsAction extends ActionSupport{
	public String execute() throws Exception {
		String a_newsTitle = ServletActionContext.getRequest().getParameter("newsTitle");
		a_newsTitle = URLDecoder.decode(a_newsTitle, "utf-8");
		String a_newsDetail = ServletActionContext.getRequest().getParameter("newsDetail");
		a_newsDetail = URLDecoder.decode(a_newsDetail, "utf-8");
		String a_newsReleaser = ServletActionContext.getRequest().getParameter("newsReleaser");
		a_newsReleaser = URLDecoder.decode(a_newsReleaser, "utf-8");
		String a_newsPublishtime = ServletActionContext.getRequest().getParameter("newsPublishtime");
		a_newsPublishtime = URLDecoder.decode(a_newsPublishtime, "utf-8");
		
		String sql = "INSERT INTO news (title,detail,releaser,time) VALUES ('" +
					a_newsTitle + "','" + a_newsDetail + "','" + a_newsReleaser + "','" + a_newsPublishtime + "')";

		GetUpdate.updata(sql);//函数里有输出sql
		
		return "success";
	}
}
