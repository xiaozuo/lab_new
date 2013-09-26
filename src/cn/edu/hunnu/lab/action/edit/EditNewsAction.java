package cn.edu.hunnu.lab.action.edit;

import java.net.URLDecoder;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.util.GetUpdate;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EditNewsAction extends ActionSupport{

	public String execute() throws Exception{
		String a_editNewsId = ServletActionContext.getRequest().getParameter("editNewsId");
		a_editNewsId = URLDecoder.decode(a_editNewsId, "utf-8");
		String a_editeditNewsTitle = ServletActionContext.getRequest().getParameter("editNewsTitle");
		a_editeditNewsTitle = URLDecoder.decode(a_editeditNewsTitle, "utf-8");
		String a_editNewsDetail = ServletActionContext.getRequest().getParameter("editNewsDetail");
		a_editNewsDetail = URLDecoder.decode(a_editNewsDetail, "utf-8");
		String a_editNewsReleaser = ServletActionContext.getRequest().getParameter("editNewsReleaser");
		a_editNewsReleaser = URLDecoder.decode(a_editNewsReleaser, "utf-8");
		String a_editNewsTime = ServletActionContext.getRequest().getParameter("editNewsTime");
		a_editNewsTime = URLDecoder.decode(a_editNewsTime, "utf-8");
		
		String sql="update news set title='" + a_editeditNewsTitle + "', detail='"+a_editNewsDetail+"',time='"+a_editNewsTime+"',releaser='"+a_editNewsReleaser+"' where id='"+a_editNewsId+"'";
		
		GetUpdate.updata(sql);
		
		return "success";
	}

}
