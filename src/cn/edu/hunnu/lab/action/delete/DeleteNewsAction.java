package cn.edu.hunnu.lab.action.delete;

import java.net.URLDecoder;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.util.GetUpdate;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteNewsAction extends ActionSupport{
	public String execute() throws Exception {
		System.out.println(ServletActionContext.getRequest().getParameter("delete_news_ids"));
		String delete_news_ids = ServletActionContext.getRequest().getParameter("delete_news_ids");
		delete_news_ids = URLDecoder.decode(delete_news_ids, "utf-8");
		System.out.println(delete_news_ids);
		
		String delete_news_id[] = delete_news_ids.split("-");  
		for(int i = 0;i < delete_news_id.length; ++i){ 
			String newsid = delete_news_id[i];
			//if(newsid.isEmpty())
			//	continue;
			String sql = "DELETE FROM news where id='"+newsid+"'";
			System.out.println(sql);
			GetUpdate.updata(sql);		    
		} 
		return "success";
	}

}
