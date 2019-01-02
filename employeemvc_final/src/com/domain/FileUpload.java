package com.domain;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	
	private String empId;
	private String content;
	private MultipartFile filename;
	private int pictureCount;
	
	//주의) 매개변수 있는 생성자를 사용하지 않는다.
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public MultipartFile getFilename() {
		return filename;
	}
	public void setFilename(MultipartFile filename) {
		this.filename = filename;
	}
	public int getPictureCount() {
		return pictureCount;
	}
	public void setPictureCount(int pictureCount) {
		this.pictureCount = pictureCount;
	}
	
}
