package cn.edu.hunnu.lab.action.read;

import cn.edu.hunnu.lab.action.model.IndexUserModel;
import cn.edu.hunnu.lab.dao.read.GetInfoIndex;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReadNoticePageAction extends ActionSupport implements ModelDriven<IndexUserModel>{
	static IndexUserModel model = new IndexUserModel();
	public String execute() throws Exception{
		int page = model.getPage_index();
		model.setTotal_page_index(GetInfoIndex.getNoticeTotalPage());
		if(page <= 1)
		{
			model.setNoticeList(GetInfoIndex.getInfo_notice(0));
			model.setPage_index(1);
			System.out.println("if" + model.getPage_index());
		}
		else
		{
			model.setNoticeList(GetInfoIndex.getInfo_notice((page-1)*10));
			System.out.println("else" + model.getPage_index());
		}
		
		return "success";
	}
	public IndexUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}
}
