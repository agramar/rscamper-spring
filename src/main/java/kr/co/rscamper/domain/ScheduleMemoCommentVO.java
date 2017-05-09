package kr.co.rscamper.domain;

import java.util.Date;

public class ScheduleMemoCommentVO {
	private int commentNo;
	private int scheduleMemoNo;
	private String userUid;
	private String content;
	private Date regDate;
	private String photoUrl;
	private String displayName;
	
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public int getScheduleMemoNo() {
		return scheduleMemoNo;
	}
	public void setScheduleMemoNo(int scheduleMemoNo) {
		this.scheduleMemoNo = scheduleMemoNo;
	}
	public String getUserUid() {
		return userUid;
	}
	public void setUserUid(String userUid) {
		this.userUid = userUid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
}
