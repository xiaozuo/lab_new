package cn.edu.hunnu.lab.action.read;

import java.net.URLDecoder;
import java.sql.ResultSet;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.action.model.NewsDetailUserModel;
import cn.edu.hunnu.lab.util.GetQuery;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReadNewsDetailAction extends ActionSupport implements ModelDriven<NewsDetailUserModel>{
	NewsDetailUserModel model = new NewsDetailUserModel();

	public String execute() throws Exception {
		String id = ServletActionContext.getRequest().getParameter("id");
		
		String sql = "select * from news where id='" + id + "'";
		ResultSet rs = GetQuery.query(sql);
		
		if(rs.next()){
			model.setTitle(rs.getString("title"));
			model.setDetail(rs.getString("detail"));
			model.setReleaser(rs.getString("releaser"));
			model.setTime(rs.getString("time"));
		}
		
		return "success";
	}
	
	public NewsDetailUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
}
