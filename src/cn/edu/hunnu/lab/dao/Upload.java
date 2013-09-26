package cn.edu.hunnu.lab.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.edu.hunnu.lab.util.GetUpdate;

public class Upload {
	public static String GetTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String time = df.format(new Date());// new Date()为获取当前系统时间
		//System.out.println(time);
		return time;
	}
	
	public static void InsertIntoSQL(String filename,String filepath) throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		String user = (String) session.getAttribute("s_user");
		//System.out.println("123:"+filepath);
		
		String time = GetTime();

		filepath = filepath.replace("\\", "\\\\");
		//filepath = filepath.replace("+", "");
		
		//System.out.println("456"+filepath);
		//String[] path = filepath.split("\\");
		//for(int i = 0; i < path.length; ++i){
		//	System.out.println(path[i]);
		//}
		
		String sql = "insert into fileUpload (filename,filepath,user,time) values ('" 
						+ filename + "','"
						+ filepath + "','" 
						+ user + "','" 
						+ time + "')";
		GetUpdate.updata(sql);
	} 
}
