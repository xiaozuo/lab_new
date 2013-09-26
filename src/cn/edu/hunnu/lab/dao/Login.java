package cn.edu.hunnu.lab.dao;

import java.sql.ResultSet;

import cn.edu.hunnu.lab.util.GetQuery;

public class Login {
	public static String userlogin(String m_user, String m_password) throws Exception{
		String flag = "登陆失败！" ;	// 标记成功
		try{
			String sql = "SELECT * FROM member";
			ResultSet rs = GetQuery.query(sql);
			
			while(rs.next()){
				//如果查询到用户名存在
				if(m_user.equals(rs.getString("user"))){
					//用户名存在且密码匹配，找到，跳出循环，否则提示密码错误，跳出循环
					if(m_password.equals(rs.getString("password"))){
						flag = "success";
						break;
					}
					else{
						flag = "用户名与密码不匹配，请重新登录！";
						break;
					}		
				}
				//用户名不存在
				else{
					flag = "用户名不存在，请重新登录！";
				}
			}
		}catch(Exception e){
			throw e;
		}
		return flag;
	}
}
