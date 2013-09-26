package cn.edu.hunnu.lab.dao.read;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.edu.hunnu.lab.action.model.achievement;
import cn.edu.hunnu.lab.util.GetQuery;

public class GetResearchInfo {
	//List Id
	public static List<String> GetResearchIdList(int begin,String method) throws Exception{
		List<String> researchIdList = new ArrayList<String>();		
		ResultSet rs = null;
		System.out.println(method);
		if(method.equals("按级别高低显示")){
			String sql = "select * from research order by level desc LIMIT " + begin + ", 10";
			rs = GetQuery.query(sql);
		}
		else{
			String sql = "select * from research order by time desc LIMIT " + begin + ", 10";
			rs = GetQuery.query(sql);
		}
		while(rs.next()){
			researchIdList.add(rs.getString("id").toString());
		}
		return researchIdList;
	}
	//List type
	public static List<String> GetResearchTypeList(int begin,String method) throws Exception{
		List<String> researchTypeList = new ArrayList<String>();
		ResultSet rs = null;
		if(method.equals("按级别高低显示")){
			String sql = "select * from research order by level desc LIMIT " + begin + ", 10";
			rs = GetQuery.query(sql);
		}
		else{
			String sql = "select * from research order by time desc LIMIT " + begin + ", 10";
			rs = GetQuery.query(sql);
		}
		
		while(rs.next()){
			researchTypeList.add(rs.getString("type"));
		}
		return researchTypeList;
	}
	//List name
	public static List<String> GetResearchNameList(int begin,String method) throws Exception{
		List<String> researchNameList = new ArrayList<String>();
		ResultSet rs = null;
		if(method.equals("按级别高低显示")){
			String sql = "select * from research order by level desc LIMIT " + begin + ", 10";
			rs = GetQuery.query(sql);
		}
		else{
			String sql = "select * from research order by time desc LIMIT " + begin + ", 10";
			rs = GetQuery.query(sql);
		}
		
		while(rs.next()){
			researchNameList.add(rs.getString("name"));
		}
		return researchNameList;
	}
	//List detail
	public static List<String> GetResearchDetailList(int begin,String method) throws Exception{
		List<String> researchDetailList = new ArrayList<String>();
		ResultSet rs = null;
		if(method.equals("按级别高低显示")){
			String sql = "select * from research order by level desc LIMIT " + begin + ", 10";
			rs = GetQuery.query(sql);
		}
		else{
			String sql = "select * from research order by time desc LIMIT " + begin + ", 10";
			rs = GetQuery.query(sql);
		}
		
		while(rs.next()){
			researchDetailList.add(rs.getString("detail"));
		}
		return researchDetailList;
	}
	//List time
	public static List<String> GetResearchTimeList(int begin,String method) throws Exception{
		List<String> researchTimeList = new ArrayList<String>();
		ResultSet rs = null;
		if(method.equals("按级别高低显示")){
			String sql = "select * from research order by level desc LIMIT " + begin + ", 10";
			rs = GetQuery.query(sql);
		}
		else{
			String sql = "select * from research order by time desc LIMIT " + begin + ", 10";
			rs = GetQuery.query(sql);
		}
		
		while(rs.next()){
			researchTimeList.add(rs.getString("time"));
		}
		return researchTimeList;
	}
	//List level
	public static List<String> GetResearchLevelList(int begin,String method) throws Exception{
		List<String> researchLevelList = new ArrayList<String>();
		ResultSet rs = null;
		if(method.equals("按级别高低显示")){
			String sql = "select * from research order by level desc LIMIT " + begin + ", 10";
			rs = GetQuery.query(sql);
		}
		else{
			String sql = "select * from research order by time desc LIMIT " + begin + ", 10";
			rs = GetQuery.query(sql);
		}
		
		while(rs.next()){
			researchLevelList.add(rs.getString("level"));
		}
		return researchLevelList;
	}
	//List chief
	public static List<String> GetResearchChiefList(int begin,String method) throws Exception{
		List<String> researchChiefList = new ArrayList<String>();
		ResultSet rs = null;
		if(method.equals("按级别高低显示")){
			String sql = "select * from research order by level desc LIMIT " + begin + ", 10";
			rs = GetQuery.query(sql);
		}
		else{
			String sql = "select * from research order by time desc LIMIT " + begin + ", 10";
			rs = GetQuery.query(sql);
		}
		
		while(rs.next()){
			researchChiefList.add(rs.getString("chief"));
		}
		return researchChiefList;
	}
	//List members
	public static List<String> GetResearchMembersList(int begin,String method) throws Exception{
		List<String> researchMembersList = new ArrayList<String>();
		ResultSet rs = null;
		if(method.equals("按级别高低显示")){
			String sql = "select * from research order by level desc LIMIT " + begin + ", 10";
			rs = GetQuery.query(sql);
		}
		else{
			String sql = "select * from research order by time desc LIMIT " + begin + ", 10";
			rs = GetQuery.query(sql);
		}
		
		while(rs.next()){
			researchMembersList.add(rs.getString("members"));
		}
		return researchMembersList;
	}
	
	//List achievements
	public static List<achievement> GetResearchList(int begin,String method) throws Exception{
		List<String> researchIdList = GetResearchIdList(begin,method);
		List<String> researchTypeList = GetResearchTypeList(begin,method);
		List<String> researchNameList = GetResearchNameList(begin,method);
		List<String> researchDetailList = GetResearchDetailList(begin,method);
		List<String> researchTimeList = GetResearchTimeList(begin,method);
		List<String> researchLevelList = GetResearchLevelList(begin,method);
		List<String> researchChiefList = GetResearchChiefList(begin,method);
		List<String> researchMembersList = GetResearchMembersList(begin,method);
		
		List<achievement> researchList = new ArrayList<achievement>();
		
		for(int i = 0; i < researchIdList.size(); ++i){
			achievement a_achievement = new achievement();
			a_achievement.setId(researchIdList.get(i));
			a_achievement.setType(researchTypeList.get(i));
			a_achievement.setName(researchNameList.get(i));
			a_achievement.setDetail(researchDetailList.get(i));
			a_achievement.setTime(researchTimeList.get(i));
			a_achievement.setLevel(researchLevelList.get(i));
			a_achievement.setChief(researchChiefList.get(i));
			a_achievement.setMembers(researchMembersList.get(i));
			
			researchList.add(a_achievement);
		}
		return researchList;
	}
	//page
	public static int GetResearchTotalPage() throws Exception{
		String sql = "select * from research";
		ResultSet rs = GetQuery.query(sql);
		int totalResearch = 0;
		int totalPage = 0;
		while(rs.next()){
			++totalResearch;
		}
		if(totalResearch%10 == 0){
			totalPage = totalResearch/10;
		}
		else totalPage = totalResearch/10 + 1;
		return totalPage;
	}
	//type page
	public static int GetResearchTotalPage(String type) throws Exception{
		String sql = "select * from research where type='" + type + "'";
		ResultSet rs = GetQuery.query(sql);
		int totalResearch = 0;
		int totalPage = 0;
		while(rs.next()){
			++totalResearch;
		}
		if(totalResearch%10 == 0){
			totalPage = totalResearch/10;
		}
		else totalPage = totalResearch/10 + 1;
		return totalPage;
	}
}
