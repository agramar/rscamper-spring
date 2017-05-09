package kr.co.rscamper.domain;

import java.util.Date;

public class LocationCommentVO {
	private int tourCommentNo;
	private int contentId;
	private String userUid;
	private String content;
	private Date regDate;
	private String photoUrl;
	private String displayName;
	
	public int getTourCommentNo() {
		return tourCommentNo;
	}
	public void setTourCommentNo(int tourCommentNo) {
		this.tourCommentNo = tourCommentNo;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
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
	
}
