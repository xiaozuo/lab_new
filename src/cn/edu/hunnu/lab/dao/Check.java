package cn.edu.hunnu.lab.dao;

import java.net.URLDecoder;
import java.sql.ResultSet;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.util.GetQuery;

public class Check {
	public static String permission_Check() throws Exception{
		String a_user = ServletActionContext.getRequest().getParameter("user");
		a_user = URLDecoder.decode(a_user, "utf-8");
		
		System.out.println(a_user);
		
		String sql = "select usertype from member where user='" + a_user + "'";
		ResultSet rs = GetQuery.query(sql);
		
		if(rs.next()){
			if(rs.getString("usertype").equals("admin"))return "admin";
			else return "user";
		}
		else return "error";
	}
	
}
