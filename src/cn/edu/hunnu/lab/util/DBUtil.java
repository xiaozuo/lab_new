package cn.edu.hunnu.lab.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class DBUtil {
	public static Connection getConn() throws NamingException, SQLException{
		Connection conn=null;
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/labDB");
		conn = ds.getConnection();
		
		return conn;
	}
	
	public static Connection getConn(String ip,String user,String pass)throws Exception{
		Connection conn=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://"+ip+":3306/test";
			conn=DriverManager.getConnection(url,user,pass);
			
		}catch(Exception e){
			throw e;
		}
		return conn;
	}
	public static Connection getConn(String ip,String user,String pass,String dbname)throws Exception{
		Connection conn=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://" + ip + ":3306/" + dbname;
			//System.out.println(url);
			conn=DriverManager.getConnection(url,user,pass);
			
		}catch(Exception e){
			throw e;
		}
		return conn;
	}
	public static Connection getConn(String url)throws Exception{
		Connection conn=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
		}catch(Exception e){
			throw e;
		}
		return conn;
	}
	public static void main(String arg[]){
		try {
			Connection conn=getConn("localhost","root","123456","test");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}