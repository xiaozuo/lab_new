package cn.edu.hunnu.lab.util;

import java.sql.Connection;
import java.sql.Statement;

public class GetUpdate {
	static public boolean updata(String sql) throws Exception
	{
		Helper.log(sql);
		final String host = "localhost";
		final String username = "root";
		final String password = "123456";
		final String dbName = "test";
		Connection connection = DBUtil.getConn(host, username, password, dbName);
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		return true;
	}
	
}
