package cn.edu.hunnu.lab.dao.read;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.edu.hunnu.lab.action.model.uploadfile;
import cn.edu.hunnu.lab.util.GetQuery;

public class GetUploadFile {
	public static List<uploadfile> GetFiles() throws Exception{
		List<uploadfile> uploadFileList = new ArrayList<uploadfile>();
		
		String sql = "select * from fileUpload";
		ResultSet rs = GetQuery.query(sql);
		
		while(rs.next()){
			uploadfile file = new uploadfile();
			file.setFilename(rs.getString("filename"));
			file.setFilepath(rs.getString("filepath"));
			file.setUser(rs.getString("user"));
			file.setTime(rs.getString("time"));
			file.setId(rs.getString("id"));
			
			uploadFileList.add(file);
		}
		return uploadFileList;
	}
}
