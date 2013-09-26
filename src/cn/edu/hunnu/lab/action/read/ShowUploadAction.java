package cn.edu.hunnu.lab.action.read;

import cn.edu.hunnu.lab.action.model.ShowUploadUserModel;
import cn.edu.hunnu.lab.dao.read.GetUploadFile;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ShowUploadAction extends ActionSupport implements ModelDriven<ShowUploadUserModel>{
	
	static ShowUploadUserModel model = new ShowUploadUserModel();
	public String execute() throws Exception
	{	
		model.setUploadFileList(GetUploadFile.GetFiles());
		
		return "success";
	}
	public ShowUploadUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
}
