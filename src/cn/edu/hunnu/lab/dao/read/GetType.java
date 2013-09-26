package cn.edu.hunnu.lab.dao.read;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.action.model.achievement;
import cn.edu.hunnu.lab.action.model.type;
import cn.edu.hunnu.lab.util.GetQuery;

public class GetType {
	
	//科学研究
	public static List<String> GetAchievementTypeId() throws Exception{
		List<String> achievemrntTypeIdList = new ArrayList<String>();
		String sql = "select id from typeUpdate where pid in(select pid from typeCheck where pname='科学研究')";
		ResultSet rs = GetQuery.query(sql);
		
		while(rs.next()){
			//System.out.println(rs.getString("name"));
			achievemrntTypeIdList.add(rs.getString("id"));
		}
		return achievemrntTypeIdList;
	}
	public static List<String> GetAchievementTypeName() throws Exception{
		List<String> achievemrntTypeNameList = new ArrayList<String>();
		String sql = "select name from typeUpdate where pid in(select pid from typeCheck where pname='科学研究')";
		ResultSet rs = GetQuery.query(sql);
		
		while(rs.next()){
			//System.out.println(rs.getString("name"));
			achievemrntTypeNameList.add(rs.getString("name"));
		}
		return achievemrntTypeNameList;
	}
	public static List<type> GetAchievementType() throws Exception{
		List<type> achievemrntTypeList = new ArrayList<type>();
		List<String> achievemrntTypeIdList = GetAchievementTypeId();
		List<String> achievemrntTypeNameList = GetAchievementTypeName();
	
		for(int i = 0; i < achievemrntTypeNameList.size(); ++i){
			type a_type = new type();
			a_type.setId(achievemrntTypeIdList.get(i));
			a_type.setName(achievemrntTypeNameList.get(i));
			achievemrntTypeList.add(a_type);
		}
		return achievemrntTypeList;
	}
	
		//项目成果,论文发表，申请专利
	//id
	public static List<String> GetAchievementId(int begin,String achieveType,String method) throws Exception{
		List<String> achievementId = new ArrayList<String>();
		ResultSet rs = null;
		
		if(method.equals("按级别高低显示")){
			String sql = "select * from research where type='" + achieveType + "' order by level desc";
			rs = GetQuery.query(sql);
		}
		else{
			String sql = "select * from research where type='" + achieveType + "' order by time desc";
			rs = GetQuery.query(sql);
		}
		
		while(rs.next()){
			achievementId.add(rs.getString("id"));
		}
		return achievementId;
	}
	//name
	public static List<String> GetAchievementName(int begin,String achieveType,String method) throws Exception{
		List<String> achievementName = new ArrayList<String>();
		ResultSet rs = null;
		
		if(method.equals("按级别高低显示")){
			String sql = "select * from research where type='" + achieveType + "' order by level desc";
			rs = GetQuery.query(sql);
		}
		else{
			String sql = "select * from research where type='" + achieveType + "' order by time desc";
			rs = GetQuery.query(sql);
		}
		
		while(rs.next()){
			achievementName.add(rs.getString("name"));
		}
		return achievementName;
	}
	//detail
	public static List<String> GetAchievementDetail(int begin,String achieveType,String method) throws Exception{
		List<String> achievementDetail = new ArrayList<String>();
		ResultSet rs = null;
		
		if(method.equals("按级别高低显示")){
			String sql = "select * from research where type='" + achieveType + "' order by level desc";
			rs = GetQuery.query(sql);
		}
		else{
			String sql = "select * from research where type='" + achieveType + "' order by time desc";
			rs = GetQuery.query(sql);
		}
		
		while(rs.next()){
			achievementDetail.add(rs.getString("detail"));
		}
		return achievementDetail;
	}
	//time
	public static List<String> GetAchievementTime(int begin,String achieveType,String method) throws Exception{
		List<String> achievementTime = new ArrayList<String>();
		ResultSet rs = null;
		
		if(method.equals("按级别高低显示")){
			String sql = "select * from research where type='" + achieveType + "' order by level desc";
			rs = GetQuery.query(sql);
		}
		else{
			String sql = "select * from research where type='" + achieveType + "' order by time desc";
			rs = GetQuery.query(sql);
		}
		
		while(rs.next()){
			achievementTime.add(rs.getString("time"));
		}
		return achievementTime;
	}
	//level
	public static List<String> GetAchievementLevel(int begin,String achieveType,String method) throws Exception{
		List<String> achievementLevel = new ArrayList<String>();
		ResultSet rs = null;
		
		if(method.equals("按级别高低显示")){
			String sql = "select * from research where type='" + achieveType + "' order by level desc";
			rs = GetQuery.query(sql);
		}
		else{
			String sql = "select * from research where type='" + achieveType + "' order by time desc";
			rs = GetQuery.query(sql);
		}
		
		while(rs.next()){
			achievementLevel.add(rs.getString("level"));
		}
		return achievementLevel;
	}
	//chief
	public static List<String> GetAchievementChief(int begin,String achieveType,String method) throws Exception{
		List<String> achievementChief = new ArrayList<String>();
		ResultSet rs = null;
		
		if(method.equals("按级别高低显示")){
			String sql = "select * from research where type='" + achieveType + "' order by level desc";
			rs = GetQuery.query(sql);
		}
		else{
			String sql = "select * from research where type='" + achieveType + "' order by time desc";
			rs = GetQuery.query(sql);
		}
		
		while(rs.next()){
			achievementChief.add(rs.getString("chief"));
		}
		return achievementChief;
	}
	//members
	public static List<String> GetAchievementMembers(int begin,String achieveType,String method) throws Exception{
		List<String> achievementMembers = new ArrayList<String>();
		ResultSet rs = null;
		
		if(method.equals("按级别高低显示")){
			String sql = "select * from research where type='" + achieveType + "' order by level desc";
			rs = GetQuery.query(sql);
		}
		else{
			String sql = "select * from research where type='" + achieveType + "' order by time desc";
			rs = GetQuery.query(sql);
		}
		
		while(rs.next()){
			achievementMembers.add(rs.getString("members"));
		}
		return achievementMembers;
	}
	//科学研究下分支的详细信息
	public static List<achievement> GetAchievements(int begin,String achieveType,String method) throws Exception{
		List<achievement> achievementList = new ArrayList<achievement>();
		
		List<String> achievementId = GetAchievementId(begin,achieveType, method);
		List<String> achievementName = GetAchievementName(begin,achieveType, method);
		List<String> achievementDetail = GetAchievementDetail(begin,achieveType, method);
		List<String> achievementTime = GetAchievementTime(begin,achieveType, method);
		List<String> achievementLevel = GetAchievementLevel(begin,achieveType, method);
		List<String> achievementChief = GetAchievementChief(begin,achieveType, method);
		List<String> achievementMembers = GetAchievementMembers(begin,achieveType, method);
		
		for(int i = 0; i < achievementId.size(); ++i){
			achievement a_achievement = new achievement();
			a_achievement.setId(achievementId.get(i));
			a_achievement.setName(achievementName.get(i));
			a_achievement.setDetail(achievementDetail.get(i));
			a_achievement.setTime(achievementTime.get(i));
			a_achievement.setLevel(achievementLevel.get(i));
			a_achievement.setChief(achievementChief.get(i));
			a_achievement.setMembers(achievementMembers.get(i));
			a_achievement.setType(achieveType);
			
			achievementList.add(a_achievement);
		}
		return achievementList;
	}
	
	//科研队伍
	public static List<String> GetResearchMemberTypeId() throws Exception{
		List<String> researchMemberTypeIdList = new ArrayList<String>();
		String sql = "select id from typeUpdate where pid in(select pid from typeCheck where pname='科研队伍')";
		ResultSet rs = GetQuery.query(sql);
		
		while(rs.next()){
			researchMemberTypeIdList.add(rs.getString("id"));
		}
		return researchMemberTypeIdList;
	}
	public static List<String> GetResearchMemberTypeName() throws Exception{
		List<String> researchMemberTypeNameList = new ArrayList<String>();
		String sql = "select name from typeUpdate where pid in(select pid from typeCheck where pname='科研队伍')";
		ResultSet rs = GetQuery.query(sql);
		
		while(rs.next()){
			researchMemberTypeNameList.add(rs.getString("name"));
		}
		return researchMemberTypeNameList;
	}
	public static List<type> GetResearchMemberType() throws Exception{
		List<type> researchMemberTypeList = new ArrayList<type>();
		List<String> researchMemberTypeIdList = GetResearchMemberTypeId();
		List<String> researchMemberTypeNameList = GetResearchMemberTypeName();
	
		for(int i = 0; i < researchMemberTypeNameList.size(); ++i){
			type a_type = new type();
			a_type.setId(researchMemberTypeIdList.get(i));
			a_type.setName(researchMemberTypeNameList.get(i));
			//System.out.println(researchMemberTypeNameList.get(i));
			researchMemberTypeList.add(a_type);
		}
		return researchMemberTypeList;
	}
}
