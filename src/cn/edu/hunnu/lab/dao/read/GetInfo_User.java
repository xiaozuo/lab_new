package cn.edu.hunnu.lab.dao.read;

import cn.edu.hunnu.lab.util.GetQuery;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import cn.edu.hunnu.lab.dao.read.UserInfo;

public class GetInfo_User {

	public static List<String> getUser(int begin) throws Exception{
		String sql = "SELECT * FROM member LIMIT " + begin + ", 10";
		ResultSet rs = GetQuery.query(sql);

		List<String> list_user = new ArrayList<String>();
		while(rs.next()){
			list_user.add(rs.getString("user"));
		}
		return list_user;
	}
	
	public static List<String> getName(int begin) throws Exception{
		String sql = "SELECT * FROM member LIMIT " + begin + ", 10" ;
		List<String> list_name = new ArrayList<String>();
		
		ResultSet rs = GetQuery.query(sql);
		
		while(rs.next()){
			list_name.add(rs.getString("name"));
		}
		return list_name;
	}
	
	public static List<String> getUsertype(int begin) throws Exception{
		String sql = "SELECT * FROM member LIMIT " + begin + ", 10" ;
		List<String> list_usertype = new ArrayList<String>();
		
		ResultSet rs = GetQuery.query(sql);		
		
		while(rs.next()){
			list_usertype.add(rs.getString("usertype"));
		}
		return list_usertype;
	}
	public static int getTotalPage() throws Exception{
		String sql = "SELECT * FROM member";
		int total = 0;
		int totalPage = 0;
		
		ResultSet rs = GetQuery.query(sql);
		while(rs.next()){
			++total;
		}
		if(total%10 == 0){
			totalPage = total/10;
		}else{
			totalPage = total/10 + 1;
		}
		
		return totalPage;
	}
	public static List<UserInfo> setUserInfo(int begin) throws Exception{
		List<String> list_user = new ArrayList<String>(GetInfo_User.getUser(begin));
		List<String> list_name = new ArrayList<String>(GetInfo_User.getName(begin));
		List<String> list_usertype = new ArrayList<String>(GetInfo_User.getUsertype(begin));
		List<UserInfo> list_info = new ArrayList<UserInfo>();//用户集合
		for(int i=0; i<list_user.size();++i){
			UserInfo userinfo = new UserInfo();//单个用户
			userinfo.setName(list_name.get(i));
			userinfo.setUser(list_user.get(i));
			userinfo.setUsertype(list_usertype.get(i));
			list_info.add(userinfo);
		}
		return list_info;
		} 
}
