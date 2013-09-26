package cn.edu.hunnu.lab.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Helper {
	
public static void log(String text)
{
	System.out.println(text);
}

public static void showRS(ResultSet rs) throws SQLException
{
	ResultSetMetaData meta = rs.getMetaData();
	int cs = meta.getColumnCount();
	for(int i = 1; i <= cs; ++i)
	{
		System.out.print(meta.getColumnName(i));
		System.out.print("\t");
	}
	System.out.println();
	
	while(rs.next())
	{
	    for(int i = 1; i <= cs; i++)
	    {
	     System.out.print(rs.getString(i));
	     System.out.print("\t");
	    }
	    System.out.println();
	}
}

public static String decodeUrl(String encodeUrl) throws UnsupportedEncodingException
{
	return URLDecoder.decode(encodeUrl, "utf-8");
}
}
