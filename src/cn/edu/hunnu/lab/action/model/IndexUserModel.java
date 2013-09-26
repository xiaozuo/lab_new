package cn.edu.hunnu.lab.action.model;

import java.util.List;

public class IndexUserModel {
	String resume;
	String address;
	String telno;
	String email;
	String fax;
	
	List<achievement> achievement;
	String isAchieveNull;
	
	List<notice> noticeList;
	List<String> noticeDetail;
	List<String> noticePublishTime;
	List<String> noticeReleaser;
	int page_index = 0;
	int total_page_index = 0;
	
	String isNoticeNull;
	
	List<news> newsList;
	List<String> newsDetail;
	List<String> newsTitle;
	List<String> newsTime;
	List<String> newsReleaser;
	int news_page_index = 0;
	int news_total_page_index = 0;
	
	String isNewsNull;
	
	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public List<achievement> getAchievement() {
		return achievement;
	}

	public void setAchievement(List<achievement> achievement) {
		this.achievement = achievement;
	}

	public List<notice> getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List<notice> noticeList) {
		this.noticeList = noticeList;
	}

	
	public List<news> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<news> newsList) {
		this.newsList = newsList;
	}

	public List<String> getNoticeDetail() {
		return noticeDetail;
	}

	public void setNoticeDetail(List<String> noticeDetail) {
		this.noticeDetail = noticeDetail;
	}

	public List<String> getNoticePublishTime() {
		return noticePublishTime;
	}

	public void setNoticePublishTime(List<String> noticePublishTime) {
		this.noticePublishTime = noticePublishTime;
	}

	public List<String> getNoticeReleaser() {
		return noticeReleaser;
	}

	public void setNoticeReleaser(List<String> noticeReleaser) {
		this.noticeReleaser = noticeReleaser;
	}

	public List<String> getNewsDetail() {
		return newsDetail;
	}

	public void setNewsDetail(List<String> newsDetail) {
		this.newsDetail = newsDetail;
	}

	public List<String> getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(List<String> newsTitle) {
		this.newsTitle = newsTitle;
	}

	public List<String> getNewsTime() {
		return newsTime;
	}

	public void setNewsTime(List<String> newsTime) {
		this.newsTime = newsTime;
	}

	public List<String> getNewsReleaser() {
		return newsReleaser;
	}

	public void setNewsReleaser(List<String> newsReleaser) {
		this.newsReleaser = newsReleaser;
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

	public int getNews_page_index() {
		return news_page_index;
	}

	public void setNews_page_index(int newsPageIndex) {
		news_page_index = newsPageIndex;
	}

	public int getNews_total_page_index() {
		return news_total_page_index;
	}

	public void setNews_total_page_index(int newsTotalPageIndex) {
		news_total_page_index = newsTotalPageIndex;
	}

	public String getIsAchieveNull() {
		return isAchieveNull;
	}

	public void setIsAchieveNull(String isAchieveNull) {
		this.isAchieveNull = isAchieveNull;
	}

	public String getIsNoticeNull() {
		return isNoticeNull;
	}

	public void setIsNoticeNull(String isNoticeNull) {
		this.isNoticeNull = isNoticeNull;
	}

	public String getIsNewsNull() {
		return isNewsNull;
	}

	public void setIsNewsNull(String isNewsNull) {
		this.isNewsNull = isNewsNull;
	}



}
