package cn.edu.hunnu.lab.action.model;

public class AddUserUserModel {
	String new_user;
	String new_password;
	String new_usertype;
	String isdone = "not_done";
	String update_result;
	public String getNew_user() {
		return new_user;
	}
	public void setNew_user(String newUser) {
		new_user = newUser;
	}
	public String getNew_password() {
		return new_password;
	}
	public void setNew_password(String newPassword) {
		new_password = newPassword;
	}
	public String getNew_usertype() {
		return new_usertype;
	}
	public void setNew_usertype(String newUsertype) {
		new_usertype = newUsertype;
	}
	public String getIsdone() {
		return isdone;
	}
	public void setIsdone(String isdone) {
		this.isdone = isdone;
	}
	public String getUpdate_result() {
		return update_result;
	}
	public void setUpdate_result(String updateResult) {
		update_result = updateResult;
	}

}
