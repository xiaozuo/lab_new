package cn.edu.hunnu.lab.action.read;

import java.util.ArrayList;
import java.util.List;

import cn.edu.hunnu.lab.action.model.IndexUserModel;
import cn.edu.hunnu.lab.action.model.news;
import cn.edu.hunnu.lab.action.model.notice;
import cn.edu.hunnu.lab.dao.read.GetInfoIndex;
import cn.edu.hunnu.lab.util.Helper;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReadNoticeAction extends ActionSupport implements ModelDriven<IndexUserModel>{
	
	static IndexUserModel model = new IndexUserModel();
	
	public String execute() throws Exception{
		List<notice> list_notice = new ArrayList<notice>();
		list_notice = GetInfoIndex.getInfo_notice(0);
		if(list_notice.isEmpty()){
			model.setIsNoticeNull("暂无内容");
		}
		model.setNoticeList(list_notice);
		model.setPage_index(1);
		System.out.println("if" + model.getPage_index());
		model.setTotal_page_index(GetInfoIndex.getNoticeTotalPage());
		System.out.println(GetInfoIndex.getNoticeTotalPage());
		return "success";
	}
	public IndexUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}
}
