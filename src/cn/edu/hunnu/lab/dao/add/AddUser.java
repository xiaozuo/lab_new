package cn.edu.hunnu.lab.dao.add;

import java.sql.ResultSet;
import cn.edu.hunnu.lab.util.GetQuery;
import cn.edu.hunnu.lab.util.GetUpdate;

public class AddUser {
	public static void log(String message)
	{
		System.out.println(message);
	}
	
	
	public static boolean adduser(String a_user,String a_password,String a_usertype) throws Exception{
		if(check_same(a_user))
			return false;

		String sql = "INSERT INTO member (user,password,usertype) VALUES ('" + a_user + "', '" + a_password + "', '" + a_usertype + "')";
		log(sql);

		return GetUpdate.updata(sql);
	}
	
	private static boolean check_same(String c_user) throws Exception{
		String sql = "SELECT * FROM member where user='"+c_user+"'";

		ResultSet rs = GetQuery.query(sql);

		if(rs.next()){
			return true;
		}
		return false;
	}
}
