package cn.edu.hunnu.lab.action.read;

import cn.edu.hunnu.lab.action.model.IndexUserModel;
import cn.edu.hunnu.lab.dao.read.GetInfoIndex;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReadNewsPageAction extends ActionSupport implements ModelDriven<IndexUserModel>{
	static IndexUserModel model = new IndexUserModel();
	public String execute() throws Exception{
		int page = model.getNews_page_index();
		model.setNews_total_page_index(GetInfoIndex.getNewsTotalPage());
		if(page <= 1)
		{
			model.setNewsList(GetInfoIndex.getInfo_news(0));
			model.setNews_page_index(1);
			System.out.println("if" + model.getNews_page_index());
		}
		else
		{
			model.setNewsList(GetInfoIndex.getInfo_news((page-1)*10));
			System.out.println("else" + model.getNews_page_index());
		}
		
		return "success";
	}
	public IndexUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}
}
