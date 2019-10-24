package com.ssafy.board;

import org.springframework.web.multipart.MultipartFile;

public class UploadDataVO
{
	private MultipartFile uploadFile;

	public UploadDataVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UploadDataVO(MultipartFile uploadFile) {
		super();
		this.uploadFile = uploadFile;
	}

	@Override
	public String toString() {
		return "UploadDataVO [uploadFile=" + uploadFile + "]";
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
}
