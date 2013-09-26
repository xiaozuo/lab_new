package cn.edu.hunnu.lab.action.add;

import java.net.URLDecoder;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.util.GetUpdate;

import com.opensymphony.xwork2.ActionSupport;

public class AddNoticeAction extends ActionSupport{
	public String execute() throws Exception {
		String a_noticeDetail = ServletActionContext.getRequest().getParameter("noticeDetail");
		a_noticeDetail = URLDecoder.decode(a_noticeDetail, "utf-8");
		String a_noticeReleaser = ServletActionContext.getRequest().getParameter("noticeReleaser");
		a_noticeReleaser = URLDecoder.decode(a_noticeReleaser, "utf-8");
		String a_noticePublishtime = ServletActionContext.getRequest().getParameter("noticePublishtime");
		a_noticePublishtime = URLDecoder.decode(a_noticePublishtime, "utf-8");
		
		String sql = "INSERT INTO notice (detail,releaser,publishtime) VALUES ('" + a_noticeDetail + "','" + a_noticeReleaser + "','" + a_noticePublishtime + "')";

		GetUpdate.updata(sql);//函数里有输出sql
		
		return "success";
	}
}
