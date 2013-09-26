package cn.edu.hunnu.lab.action.read;

import cn.edu.hunnu.lab.action.model.MemberTypeUserModel;
import cn.edu.hunnu.lab.dao.read.GetType;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReadMemberTypeAction extends ActionSupport implements ModelDriven<MemberTypeUserModel>{
	MemberTypeUserModel model = new MemberTypeUserModel();
	public String execute() throws Exception{
		model.setResearchMemberType(GetType.GetResearchMemberType());
		return "success";
	}
	public MemberTypeUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}
}
