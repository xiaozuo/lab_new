package cn.edu.hunnu.lab.dao.delete;

import cn.edu.hunnu.lab.util.GetUpdate;

public class DeleteUser {
	public static boolean deleteuser(String d_user) throws Exception{
		String sql = "DELETE FROM member where user='"+d_user+"'";
		System.out.println(sql);
		return GetUpdate.updata(sql);
	}	
}
