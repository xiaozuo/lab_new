package cn.edu.hunnu.lab.dao.read;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.edu.hunnu.lab.action.model.members;
import cn.edu.hunnu.lab.util.GetQuery;

public class GetUserDetailByType {
	public static List<members> GetMembers(String type,int begin) throws Exception{
		
		List<String> memberName = new ArrayList<String>();
		List<String> memberBirthday = new ArrayList<String>();
		List<String> memberSex = new ArrayList<String>();
		List<String> memberEnteryear = new ArrayList<String>();
		List<String> memberMajor = new ArrayList<String>();
		List<String> memberEducation = new ArrayList<String>();
		List<String> memberResearch = new ArrayList<String>();
		List<String> memberPhoto = new ArrayList<String>();
		List<String> memberResume = new ArrayList<String>();
		List<String> memberTelno = new ArrayList<String>();
		List<String> memberEmail = new ArrayList<String>();
		List<String> memberWorkexperience = new ArrayList<String>();
		List<String> memberQQ = new ArrayList<String>();
		
		String sql = "select * from member where membertype='"+ type +"' ORDER BY useruid asc LIMIT "+ begin +", 3 ;";
		ResultSet rs = GetQuery.query(sql);

		while(rs.next()){
			memberName.add(rs.getString("name"));
			memberBirthday.add(rs.getString("birthday"));
			memberSex.add(rs.getString("sex"));
			memberEnteryear.add(rs.getString("enteryear"));
			memberMajor.add(rs.getString("major"));
			memberEducation.add(rs.getString("education"));
			memberResearch.add(rs.getString("research"));
			memberPhoto.add(rs.getString("photo"));
			memberResume.add(rs.getString("resume"));
			memberTelno.add(rs.getString("telno"));
			memberEmail.add(rs.getString("email"));
			memberWorkexperience.add(rs.getString("workexperience"));
			memberQQ.add(rs.getString("QQ"));
		}

		List<members> memberList = new ArrayList<members>();

		for(int i = 0; i < memberName.size(); ++i){
			members member = new members();
			
			member.setUsername(memberName.get(i));
			member.setBirthday(memberBirthday.get(i));
			member.setEducation(memberEducation.get(i));
			member.setEmail(memberEmail.get(i));
			member.setEnteryear(memberEnteryear.get(i));
			member.setMajor(memberMajor.get(i));
			member.setMembertype(type);
			member.setPhoto(memberPhoto.get(i));
			member.setQQ(memberQQ.get(i));
			member.setResearch(memberResearch.get(i));
			member.setResume(memberResume.get(i));
			member.setSex(memberSex.get(i));
			member.setTelno(memberTelno.get(i));
			member.setWorkexperience(memberWorkexperience.get(i));
			
			memberList.add(member);
		}
		return memberList;
	}
	public static int GetPage(String type) throws Exception{
		String sql = "select * from member where membertype='"+ type +"'";
		ResultSet rs = GetQuery.query(sql);
		
		int total = 0;
		int totalPage = 0;
		
		while(rs.next()){
			++total;
		}
		if(total%3 == 0){
			totalPage = total/3;
		}
		else totalPage = total/3 + 1;
		
		return totalPage;
	}
}
