package cn.edu.hunnu.lab.dao.read;

public class UserInfo {
	public String user;
	public String name;
	public String usertype;
	public String password;

	public UserInfo(){
		this.user = null;
		this.name = null;
		this.usertype = null;
		this.password = null;
	}

	public String getUser() {
		return user;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
