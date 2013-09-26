package cn.edu.hunnu.lab.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;
import cn.edu.hunnu.lab.action.model.UploadFileModel;
import cn.edu.hunnu.lab.dao.Upload;
import cn.edu.hunnu.lab.util.GetUpdate;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UploadAction extends ActionSupport implements ModelDriven<UploadFileModel>{
	
	static UploadFileModel model = new UploadFileModel();
	public String execute() throws Exception
	{	
		InputStream inStream = new FileInputStream(model.getClientFile());
		String uploadDir = ServletActionContext.getServletContext().getRealPath("\\upload");

		String filename = model.getClientFileFileName();
		File targetFile = new File(uploadDir, filename);
		
		String filepath = "\\upload\\" + filename ;
		Upload.InsertIntoSQL(filename, filepath);
		System.out.println(filepath);
		
		if(!targetFile.getParentFile().exists())
			targetFile.getParentFile().mkdirs();
		
		OutputStream outStream = new FileOutputStream(targetFile);
		
		byte[] buffer = new byte[1024];
		int length = 0;
		
		while((length = inStream.read(buffer)) > 0)
		{
			outStream.write(buffer, 0, length);
		}
		
		outStream.close();
		inStream.close();
		
		return "success";
	}
	public UploadFileModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}
}
