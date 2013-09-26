package cn.edu.hunnu.lab.action.model;

import java.util.List;

public class ResearchUserModel {

	int totalPage = 0;
	int currentPage = 0;
	
	List<achievement> achieve;
	String isAchievementNull;

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<achievement> getAchieve() {
		return achieve;
	}

	public void setAchieve(List<achievement> achieve) {
		this.achieve = achieve;
	}

	public String getIsAchievementNull() {
		return isAchievementNull;
	}

	public void setIsAchievementNull(String isAchievementNull) {
		this.isAchievementNull = isAchievementNull;
	}

}
