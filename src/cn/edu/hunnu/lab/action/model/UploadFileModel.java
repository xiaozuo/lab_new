package cn.edu.hunnu.lab.action.model;

import java.io.File;

public class UploadFileModel {
	File clientFile;
	String clientFileFileName;
	public String getClientFileFileName() {
		return clientFileFileName;
	}
	public void setClientFileFileName(String clientFileFileName) {
		this.clientFileFileName = clientFileFileName;
	}
	public File getClientFile() {
		return clientFile;
	}
	public void setClientFile(File clientFile) {
		this.clientFile = clientFile;
	}
	
}
