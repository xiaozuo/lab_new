package cn.edu.hunnu.lab.action.model;

import java.util.List;

import cn.edu.hunnu.lab.dao.read.UserInfo;

/**
 * @author Administrator
 *
 */
public class UserInfoUserModel {
	int useid;
	List<UserInfo> users;
	List<String> user;
	List<String> usertype;//用户类型，指定可访问的内容。指定选项
	List<String> name;
	int currentPage = 0;
	int totalPage = 0;
	
	String update_flag;
	String username;
	String password;
	String birthday;
	String sex;//指定选项
	String enteryear;//给时间模板
	String major;//专业
	String education;//学历
	String research;//研究方向
	String membertype;//人员类型。固定研究人员等
	String photo;
	String resume;//个人简介
	String telno;
	String email;
	String workexperience;//教育工作经历
	String QQ;
	
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getUpdate_flag() {
		return update_flag;
	}
	public void setUpdate_flag(String updateFlag) {
		update_flag = updateFlag;
	}
	public int getUseid() {
		return useid;
	}
	public void setUseid(int useid) {
		this.useid = useid;
	}
	public List<UserInfo> getUsers() {
		return users;
	}
	public void setUsers(List<UserInfo> users) {
		this.users = users;
	}
	public List<String> getUser() {
		return user;
	}
	public void setUser(List<String> user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getUsertype() {
		return usertype;
	}
	public void setUsertype(List<String> usertype) {
		this.usertype = usertype;
	}
	public List<String> getName() {
		return name;
	}
	public void setName(List<String> name) {
		this.name = name;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEnteryear() {
		return enteryear;
	}
	public void setEnteryear(String enteryear) {
		this.enteryear = enteryear;
	}
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getResearch() {
		return research;
	}
	public void setResearch(String research) {
		this.research = research;
	}
	public String getMembertype() {
		return membertype;
	}
	public void setMembertype(String membertype) {
		this.membertype = membertype;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWorkexperience() {
		return workexperience;
	}
	public void setWorkexperience(String workexperience) {
		this.workexperience = workexperience;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	
}
