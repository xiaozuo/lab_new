package cn.edu.hunnu.lab.action.read;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.action.model.AchievementTypeUserModel;
import cn.edu.hunnu.lab.dao.read.GetType;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReadAchievementTypeAction extends ActionSupport implements ModelDriven<AchievementTypeUserModel>{
	AchievementTypeUserModel model = new AchievementTypeUserModel();
	public String execute() throws Exception{
		model.setAchievementType(GetType.GetAchievementType());
		return "success";
	}
	public AchievementTypeUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}
}
