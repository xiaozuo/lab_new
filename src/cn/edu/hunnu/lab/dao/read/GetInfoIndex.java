package cn.edu.hunnu.lab.dao.read;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.edu.hunnu.lab.action.model.news;
import cn.edu.hunnu.lab.action.model.notice;
import cn.edu.hunnu.lab.util.GetQuery;

public class GetInfoIndex {
	
	protected String latest_time(String time1,String time2){
		String m_time1[] = time1.split("/");//获取时间月日年
		String m_time2[] = time2.split("/");
		int i_time1[] = {0,0,0};
		int i_time2[] = {0,0,0};
		//将字符串转化为int
		for(int i = 0; i < m_time1.length; ++i){
			i_time1[i] = Integer.parseInt(m_time1[i]);
			System.out.println(i_time1[i]);
			i_time2[i] = Integer.parseInt(m_time2[i]);
			System.out.println(i_time2[i]);
		}
		//比较时间，取最新
		if(i_time1[2] < i_time2[2]){
			return time2;
		}
		else if(i_time1[2] == i_time2[2]){//年份相等，比较月份
			if(i_time1[0] < i_time2[0]){
				return time2;
			}
			else if(i_time1[0] == i_time2[0]){//月份相等，比较日期
				if(i_time1[1] < i_time2[2])
					return time2;
				else return time1;
			}
			else return time1;
		}
		else return time2;
	}
	//获取实验室简介
	public static String getInfo_resume() throws Exception{
		
		String sql = "SELECT resume FROM libinfo" ;	
		ResultSet rs = GetQuery.query(sql);
		if(rs.next()){
			return(rs.getString(1)) ;
		}
		else return "false";
	}
	//获取通知id
	public static List<String> getInfo_noticeId(int begin) throws Exception{
		String sql = "SELECT * FROM notice ORDER BY id desc LIMIT " + begin + ", 10";
		ResultSet rs = GetQuery.query(sql);
		
		List<String> list_noticeId = new ArrayList<String>();
		while(rs.next()){
			list_noticeId.add(rs.getString("Id").toString());
		}
		return list_noticeId;
	}
	//获取通知详情
	public static List<String> getInfo_noticeDetail(int begin) throws Exception{
		String sql = "SELECT * FROM notice ORDER BY id desc LIMIT " + begin + ", 10";
		ResultSet rs = GetQuery.query(sql);
		
		List<String> list_noticeDetail = new ArrayList<String>();
		while(rs.next()){
			list_noticeDetail.add(rs.getString("detail"));
		}
		return list_noticeDetail;
	}
	//获取通知时间
	public static List<String> getInfo_noticePublishTime(int begin) throws Exception{
		String sql = "SELECT * FROM notice ORDER BY id desc LIMIT " + begin + ", 10";
		ResultSet rs = GetQuery.query(sql);
		
		List<String> list_noticePublishTime = new ArrayList<String>();
		while(rs.next()){
			list_noticePublishTime.add(rs.getString("publishtime"));
		}
		return list_noticePublishTime;
	}
	//获取通知人
	public static List<String> getInfo_noticeReleaser(int begin) throws Exception{
		String sql = "SELECT * FROM notice ORDER BY id desc LIMIT " + begin + ", 10";
		ResultSet rs = GetQuery.query(sql);
		
		List<String> list_noticeReleaser = new ArrayList<String>();
		while(rs.next()){
			list_noticeReleaser.add(rs.getString("releaser"));
		}
		return list_noticeReleaser;
	}
	//获取通知对象
	public static List<notice> getInfo_notice(int begin) throws Exception{
		List<String> list_noticeId = getInfo_noticeId(begin);
		List<String> list_noticeDetail = getInfo_noticeDetail(begin);
		List<String> list_noticePublishTime = getInfo_noticePublishTime(begin);
		List<String> list_noticeReleaser = getInfo_noticeReleaser(begin);
		List<notice> list_notice = new ArrayList<notice>();//通知集合
		for(int i=0; i < list_noticeDetail.size();++i){
			notice notice = new notice();//单个用户
			notice.setId(list_noticeId.get(i));
			notice.setDetail(list_noticeDetail.get(i));
			notice.setPublishtime(list_noticePublishTime.get(i));
			notice.setReleaser(list_noticeReleaser.get(i));
			list_notice.add(notice);
		}
		return list_notice;
	}
	//获取通知的总数，并计算每页10条记录的情况下有多少页
	public static int getNoticeTotalPage() throws Exception{
		String sql = "SELECT * FROM notice";
		ResultSet rs = GetQuery.query(sql);
		int totalNotice = 0;
		while(rs.next()){
			++totalNotice;
		}
		int totalPage = 0;
		if(totalNotice <= 10){
			totalPage = 1;
		}
		else if(totalNotice%10 == 0){
			totalPage = totalNotice/10;
		}
		else totalPage = (totalNotice/10) + 1;
		
		return totalPage;
	}
	//获取新闻id
	public static List<String> getInfo_newsId(int begin) throws Exception{
		String sql = "SELECT * FROM news ORDER BY id desc LIMIT " + begin + ", 10";
		ResultSet rs = GetQuery.query(sql);
		
		List<String> list_newsId = new ArrayList<String>();
		while(rs.next()){
			list_newsId.add(rs.getString("Id").toString());
		}
		return list_newsId;
	}
	//获取新闻详情
	public static List<String> getInfo_newsDetail(int begin) throws Exception{
		String sql = "SELECT * FROM news ORDER BY id desc LIMIT " + begin + ", 10";
		ResultSet rs = GetQuery.query(sql);

		List<String> list_newsDetail = new ArrayList<String>();
		while(rs.next()){
			list_newsDetail.add(rs.getString("detail"));
		}
		return list_newsDetail;
	}
	//获取新闻标题
	public static List<String> getInfo_newsTitle(int begin) throws Exception{
		String sql = "SELECT * FROM news ORDER BY id desc LIMIT " + begin + ", 10";
		ResultSet rs = GetQuery.query(sql);

		List<String> list_newsTitle = new ArrayList<String>();
		while(rs.next()){
			list_newsTitle.add(rs.getString("title"));
		}
		return list_newsTitle;
	}
	//获取新闻发布时间
	public static List<String> getInfo_newsTime(int begin) throws Exception{
		String sql = "SELECT * FROM news ORDER BY id desc LIMIT " + begin + ", 10";
		ResultSet rs = GetQuery.query(sql);

		List<String> list_newsTime = new ArrayList<String>();
		while(rs.next()){
			list_newsTime.add(rs.getString("time"));
		}
		return list_newsTime;
	}	
	//获取新闻发布人
	public static List<String> getInfo_newsReleaser(int begin) throws Exception{
		String sql = "SELECT * FROM news ORDER BY id desc LIMIT " + begin + ", 10";
		ResultSet rs = GetQuery.query(sql);

		List<String> list_newsReleaser = new ArrayList<String>();
		while(rs.next()){
			list_newsReleaser.add(rs.getString("releaser"));
		}
		return list_newsReleaser;
	}
	//获取新闻对象
	public static List<news> getInfo_news(int begin) throws Exception{
		List<String> list_newsId = getInfo_newsId(begin);
		List<String> list_newsDetail = getInfo_newsDetail(begin);
		List<String> list_newsTitle = getInfo_newsTitle(begin);
		List<String> list_newsTime = getInfo_newsTime(begin);
		List<String> list_newsReleaser = getInfo_newsReleaser(begin);
	
		List<news> list_news = new ArrayList<news>();//新闻集合
		for(int i=0; i<list_newsDetail.size();++i){
			news news = new news();//单个新闻
			news.setId(list_newsId.get(i));
			news.setDetail(list_newsDetail.get(i));
			news.setTitle(list_newsTitle.get(i));
			news.setTime(list_newsTime.get(i));
			news.setReleaser(list_newsReleaser.get(i));
			list_news.add(news);
		}
		return list_news;
	}
	//获取新闻的总数，并计算每页10条记录的情况下有多少页
	public static int getNewsTotalPage() throws Exception{
		String sql = "SELECT * FROM news";
		ResultSet rs = GetQuery.query(sql);
		int totalNews = 0;
		while(rs.next()){
			++totalNews;
		}
		int totalPage = 0;
		if(totalNews <= 10){
			totalPage = 1;
		}
		else if(totalNews%10 == 0){
			totalPage = totalNews/10;
		}
		else totalPage = (totalNews/10) + 1;
		
		return totalPage;
	}
}
