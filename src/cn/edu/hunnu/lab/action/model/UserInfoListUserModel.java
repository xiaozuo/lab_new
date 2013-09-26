package cn.edu.hunnu.lab.action.model;

import java.util.List;

public class UserInfoListUserModel {
	List<members> memberList;
	String Type;
	int page_index = 0;
	int total_page_index = 0;
	
	public List<members> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<members> memberList) {
		this.memberList = memberList;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public int getPage_index() {
		return page_index;
	}

	public void setPage_index(int pageIndex) {
		page_index = pageIndex;
	}

	public int getTotal_page_index() {
		return total_page_index;
	}

	public void setTotal_page_index(int totalPageIndex) {
		total_page_index = totalPageIndex;
	}

}
