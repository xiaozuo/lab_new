package cn.edu.hunnu.lab.dao.update;

import cn.edu.hunnu.lab.util.GetQuery;
import cn.edu.hunnu.lab.util.GetUpdate;

import java.sql.ResultSet;

public class UpdatePassword {
	public static String updatePassword(String user, String password, String new_password, String confirm) throws Exception{
		String sql="select password from member where user='"+ user +"'";
		ResultSet rs = GetQuery.query(sql);
		if(rs.next()){
			if(password.equals(rs.getString("password"))){
				if(new_password.equals(confirm)){
					String update = "update member set password='"+new_password+"' where user='"+user+"'";
					GetUpdate.updata(update);
					//System.out.println(new_password);
					return "password_change_success";
				}
				else
					return "wrong_confirm";
			}
			else
				return "wrong_password";
		}
		else
			return "fail";
	}
}
