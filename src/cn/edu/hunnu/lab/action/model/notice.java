package cn.edu.hunnu.lab.action.model;

public class notice {
	String id;
	String detail;
	String publishtime;
	String releaser;
	int current_page;
	public notice(){}
	public notice(String m_d,String m_p,String m_r){
		this.detail = m_d;
		this.publishtime = m_p;
		this.releaser = m_r;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getPublishtime() {
		return publishtime;
	}
	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}
	public String getReleaser() {
		return releaser;
	}
	public void setReleaser(String releaser) {
		this.releaser = releaser;
	}
	public int getCurrent_page() {
		return current_page;
	}
	public void setCurrent_page(int currentPage) {
		current_page = currentPage;
	}
	
	
}
