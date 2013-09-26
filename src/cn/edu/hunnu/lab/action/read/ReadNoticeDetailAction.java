package cn.edu.hunnu.lab.action.read;

import java.sql.ResultSet;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.action.model.NoticeDetailUserModel;
import cn.edu.hunnu.lab.util.GetQuery;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReadNoticeDetailAction extends ActionSupport implements ModelDriven<NoticeDetailUserModel> {
	NoticeDetailUserModel model = new NoticeDetailUserModel();
	
	public String execute() throws Exception {
		String id = ServletActionContext.getRequest().getParameter("id");
		
		String sql = "select * from notice where id='" + id + "'";
		ResultSet rs = GetQuery.query(sql);
		
		if(rs.next()){
			model.setDetail(rs.getString("detail"));
			model.setPublishtime(rs.getString("publishtime"));
			model.setReleaser(rs.getString("releaser"));
		}
		
		return "success";
		}
	
	public NoticeDetailUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}

}
