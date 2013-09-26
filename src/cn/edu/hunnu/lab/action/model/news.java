package cn.edu.hunnu.lab.action.model;

public class news {
	String id;
	String detail;
	String title;
	String time;
	String releaser;
	public news(String m_d,String m_title,String m_time,String m_r){
		this.detail = m_d;
		this.releaser = m_r;
		this.time = m_time;
		this.title = m_title;
	}
	
	public news() {
		// TODO Auto-generated constructor stub
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getReleaser() {
		return releaser;
	}
	public void setReleaser(String releaser) {
		this.releaser = releaser;
	}
	
	
}
