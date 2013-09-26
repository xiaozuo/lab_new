package cn.edu.hunnu.lab.action.read;

import cn.edu.hunnu.lab.action.model.ReadLabUserModel;
import cn.edu.hunnu.lab.util.GetQuery;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReadLabInfoAction extends ActionSupport implements ModelDriven<ReadLabUserModel>{
	static ReadLabUserModel model = new ReadLabUserModel();
	public String execute() throws Exception{
		String sql = "select * from libinfo";
		GetQuery.query(sql);
		
		ResultSet rs = GetQuery.query(sql);
		if(rs.next()){
			model.setLab_name(rs.getString("name"));
			model.setLab_chief(rs.getString("chief"));
			model.setLab_settime(rs.getString("settime"));
			model.setLab_resume(rs.getString("resume"));
			model.setLab_detail(rs.getString("detail"));
			model.setLab_address(rs.getString("address"));
			model.setLab_telno(rs.getString("telno"));
			model.setLab_email(rs.getString("email"));
			model.setLab_fax(rs.getString("fax"));
			model.setLab_rule(rs.getString("rule"));
			model.setLab_researchArea(rs.getString("researchArea"));
			
		}
		
		return "success";
	}
	public ReadLabUserModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}

}
