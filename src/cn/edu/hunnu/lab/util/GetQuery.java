package cn.edu.hunnu.lab.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetQuery {

	static public ResultSet query(String sql) throws Exception
	{
		final String host = "localhost";
		final String username = "root";
		final String password = "123456";
		final String dbName = "test";
		Connection connection = DBUtil.getConn(host, username, password, dbName);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		return preparedStatement.executeQuery();
	}
	
}
