package cn.edu.hunnu.lab.action.delete;

import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.dao.delete.DeleteUser;
import cn.edu.hunnu.lab.util.GetUpdate;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteNoticeAction extends ActionSupport{
	public String execute() throws Exception {
		System.out.println(ServletActionContext.getRequest().getParameter("delete_notice_ids"));
		String delete_notice_ids = ServletActionContext.getRequest().getParameter("delete_notice_ids");
		delete_notice_ids = URLDecoder.decode(delete_notice_ids, "utf-8");
		System.out.println(delete_notice_ids);
		
		String delete_notice_id[] = delete_notice_ids.split("-");  
		for(int i = 0;i < delete_notice_id.length; ++i){ 
			String noticeid = delete_notice_id[i];
			//if(noticeid.isEmpty())
			//	continue;
			String sql = "DELETE FROM notice where id='"+noticeid+"'";
			System.out.println(sql);
			GetUpdate.updata(sql);		    
		} 
		return "success";
	}
}
