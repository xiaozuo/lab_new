package cn.edu.hunnu.lab.action.read;

import java.util.ArrayList;
import java.util.List;

import cn.edu.hunnu.lab.action.model.IndexUserModel;
import cn.edu.hunnu.lab.action.model.news;
import cn.edu.hunnu.lab.action.model.notice;
import cn.edu.hunnu.lab.dao.read.GetInfoIndex;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReadNewsAction extends ActionSupport implements ModelDriven<IndexUserModel>{
	static IndexUserModel model = new IndexUserModel();
	
	public String execute() throws Exception{
		List<news> list_news = new ArrayList<news>();
		list_news = GetInfoIndex.getInfo_news(0);
		if(list_news.isEmpty()){
			model.setIsNewsNull("暂无内容");
		}
		model.setNewsList(list_news);
		model.setNews_page_index(1);
		System.out.println("if" + model.getNews_page_index());
		model.setNews_total_page_index(GetInfoIndex.getNewsTotalPage());
		System.out.println(GetInfoIndex.getNewsTotalPage());
		return "success";
	}
	public IndexUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}

}
