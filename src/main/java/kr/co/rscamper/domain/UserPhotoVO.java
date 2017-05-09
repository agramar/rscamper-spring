package kr.co.rscamper.domain;

import java.util.Date;

public class UserPhotoVO {
	private int photoNo;
	private String userUid;
	private int type;
	private String path;
	private long size;
	private Date regDate;
	
	public int getPhotoNo() {
		return photoNo;
	}
	public void setPhotoNo(int photoNo) {
		this.photoNo = photoNo;
	}
	public String getUserUid() {
		return userUid;
	}
	public void setUserUid(String userUid) {
		this.userUid = userUid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "UserPhotoVO [photoNo=" + photoNo + ", userUid=" + userUid + ", type=" + type + ", path=" + path
				+ ", size=" + size + ", regDate=" + regDate + "]";
	}
}
