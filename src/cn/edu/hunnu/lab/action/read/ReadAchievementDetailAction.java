package cn.edu.hunnu.lab.action.read;

import java.sql.ResultSet;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.action.model.AchievementDetailUserModel;
import cn.edu.hunnu.lab.util.GetQuery;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReadAchievementDetailAction extends ActionSupport implements ModelDriven<AchievementDetailUserModel> {
	AchievementDetailUserModel model = new AchievementDetailUserModel();
	
	public String execute() throws Exception {
		String id = ServletActionContext.getRequest().getParameter("id");
		
		String sql = "select * from research where id='" + id + "'";
		ResultSet rs = GetQuery.query(sql);
		
		if(rs.next()){
			model.setChief(rs.getString("chief"));
			model.setDetail(rs.getString("detail"));
			model.setMembers(rs.getString("members"));
			model.setName(rs.getString("name"));
			model.setTime(rs.getString("time"));
		}
		
		return "success";
		}
	
	public AchievementDetailUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}

}
