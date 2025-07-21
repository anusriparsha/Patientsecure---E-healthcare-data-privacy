package com.beans;

import java.io.InputStream;

public class UploadBean {
	private String doctorname, content, enc, key,fid,uid;
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	private InputStream photo1;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEnc() {
		return enc;
	}

	public void setEnc(String enc) {
		this.enc = enc;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setPhoto1(InputStream photo1) {
		// TODO Auto-generated method stub
		this.photo1 = photo1;
	}

	public InputStream getPhoto() {
		// TODO Auto-generated method stub
		return photo1;
	}

}
