package kr.co.rscamper.domain;

import java.util.Date;

public class TourPlanCommentVO {
	
	private int commentNo;
	private int recordNo;
	private String userUid;
	private String content;
	private Date regDate;
	
	// 유저정보
	private String displayName;
	private String photoUrl;
	
	// 알림 정보
	private String recivUserUid;
	private String title;
	private String url;
	
	
	
	
	
	public String getRecivUserUid() {
		return recivUserUid;
	}
	public void setRecivUserUid(String recivUserUid) {
		this.recivUserUid = recivUserUid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public int getRecordNo() {
		return recordNo;
	}
	public void setRecordNo(int recordNo) {
		this.recordNo = recordNo;
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
	
	@Override
	public String toString() {
		return "TourPlanCommentVO [commentNo=" + commentNo + ", recordNo=" + recordNo + ", userUid=" + userUid
				+ ", content=" + content + ", regDate=" + regDate + "]";
	}
	
}
