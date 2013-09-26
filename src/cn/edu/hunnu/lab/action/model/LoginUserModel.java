package cn.edu.hunnu.lab.action.model;

public class LoginUserModel {	
	String user;
	String password;
	String result;
	String check_result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCheck_result() {
		return check_result;
	}

	public void setCheck_result(String checkResult) {
		check_result = checkResult;
	}

}
