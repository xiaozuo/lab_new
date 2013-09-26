package cn.edu.hunnu.lab.action.edit;

import java.net.URLDecoder;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.hunnu.lab.action.model.ReadLabUserModel;
import cn.edu.hunnu.lab.util.GetUpdate;

public class EditLabInfoAction extends ActionSupport implements ModelDriven<ReadLabUserModel>{
	ReadLabUserModel model = new ReadLabUserModel();
	public String execute() throws Exception{
		String a_lab_chief = ServletActionContext.getRequest().getParameter("lab_chief");
		a_lab_chief = URLDecoder.decode(a_lab_chief, "utf-8");
		
		String a_lab_settime = ServletActionContext.getRequest().getParameter("lab_settime");
		a_lab_settime = URLDecoder.decode(a_lab_settime, "utf-8");
		
		String a_lab_address = ServletActionContext.getRequest().getParameter("lab_address");
		a_lab_address = URLDecoder.decode(a_lab_address, "utf-8");
		
		String a_lab_telno = ServletActionContext.getRequest().getParameter("lab_telno");
		a_lab_telno = URLDecoder.decode(a_lab_telno, "utf-8");
		
		String a_lab_email = ServletActionContext.getRequest().getParameter("lab_email");
		a_lab_email = URLDecoder.decode(a_lab_email, "utf-8");
		
		String a_lab_fax = ServletActionContext.getRequest().getParameter("lab_fax");
		a_lab_fax = URLDecoder.decode(a_lab_fax, "utf-8");
		
		String a_lab_resume = ServletActionContext.getRequest().getParameter("lab_resume");
		a_lab_resume = URLDecoder.decode(a_lab_resume, "utf-8");
		
		String a_lab_detail = ServletActionContext.getRequest().getParameter("lab_detail");
		a_lab_detail = URLDecoder.decode(a_lab_detail, "utf-8");
		
		String sql = "update libinfo set chief='" + a_lab_chief + "',settime='" + a_lab_settime + "',address='" + a_lab_address + "',telno='" + a_lab_telno + "',email='" + a_lab_email + "',fax='" + a_lab_fax + "',resume='" + a_lab_resume + "',detail='" + a_lab_detail + "'";
		GetUpdate.updata(sql);
		
		return "success";
	}
	public ReadLabUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}
}
