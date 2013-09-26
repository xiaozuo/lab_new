package cn.edu.hunnu.lab.action.model;

public class UpdatePasswordUserModel {
	String password;
	String new_password;
	String new_password_confirm;
	String password_change_flag;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNew_password() {
		return new_password;
	}
	public void setNew_password(String newPassword) {
		new_password = newPassword;
	}
	public String getNew_password_confirm() {
		return new_password_confirm;
	}
	public void setNew_password_confirm(String newPasswordConfirm) {
		new_password_confirm = newPasswordConfirm;
	}
	public String getPassword_change_flag() {
		return password_change_flag;
	}
	public void setPassword_change_flag(String passwordChangeFlag) {
		password_change_flag = passwordChangeFlag;
	}
}
