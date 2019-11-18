package com.ssafy.model;

import org.springframework.web.multipart.MultipartFile;

//폼에 대한 정보를 저장하는 vo
public class UploadDateVO {
	
	// 폼의 갯수만큼 다 만들어야한다.
	private String userName; // 사용자명을 입력받는 폼
	private MultipartFile uploadFile; //파일명을 입력받는폼
	public UploadDateVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	@Override
	public String toString() {
		return "UploadDateVO [userName=" + userName + ", uploadFile=" + uploadFile + "]";
	}
	public UploadDateVO(String userName, MultipartFile uploadFile) {
		super();
		this.userName = userName;
		this.uploadFile = uploadFile;
	}
	
}
