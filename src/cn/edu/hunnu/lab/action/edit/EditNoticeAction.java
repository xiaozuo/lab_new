package cn.edu.hunnu.lab.action.edit;

import java.net.URLDecoder;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.action.model.EditNoticeUserModel;
import cn.edu.hunnu.lab.util.GetUpdate;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EditNoticeAction extends ActionSupport implements ModelDriven<EditNoticeUserModel>{
	EditNoticeUserModel model = new EditNoticeUserModel();
	public String execute() throws Exception{
		String a_editNoticeId = ServletActionContext.getRequest().getParameter("editNoticeId");
		a_editNoticeId = URLDecoder.decode(a_editNoticeId, "utf-8");
		String a_editNoticeDetail = ServletActionContext.getRequest().getParameter("editNoticeDetail");
		a_editNoticeDetail = URLDecoder.decode(a_editNoticeDetail, "utf-8");
		String a_editNoticeReleaser = ServletActionContext.getRequest().getParameter("editNoticeReleaser");
		a_editNoticeReleaser = URLDecoder.decode(a_editNoticeReleaser, "utf-8");
		String a_editNoticePublishtime = ServletActionContext.getRequest().getParameter("editNoticePublishtime");
		a_editNoticePublishtime = URLDecoder.decode(a_editNoticePublishtime, "utf-8");
		
		String sql="update notice set detail='"+a_editNoticeDetail+"',publishtime='"+a_editNoticePublishtime+"',releaser='"+a_editNoticeReleaser+"' where id='"+a_editNoticeId+"'";
		
		GetUpdate.updata(sql);
		
		return "success";
	}
	public EditNoticeUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}

}
