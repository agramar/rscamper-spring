package kr.co.rscamper.domain;

import java.util.Date;

public class AppMainVO {
	private String categoryName;
	private int no;
	private Date regDate;
	private String userUid;
	private String title;
	private int picture;
	private String coverImgUrl;
	private String displayName;
	public int likeCnt;
	public String targetType;
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getUserUid() {
		return userUid;
	}
	public void setUserUid(String userUid) {
		this.userUid = userUid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPicture() {
		return picture;
	}
	public void setPicture(int picture) {
		this.picture = picture;
	}
	public String getCoverImgUrl() {
		return coverImgUrl;
	}
	public void setCoverImgUrl(String coverImgUrl) {
		this.coverImgUrl = coverImgUrl;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public int getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	public String getTargetType() {
		return targetType;
	}
	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
	
	@Override
	public String toString() {
		return "AppMainVO [categoryName=" + categoryName + ", no=" + no + ", regDate=" + regDate + ", userUid="
				+ userUid + ", title=" + title + ", picture=" + picture + ", coverImgUrl=" + coverImgUrl
				+ ", displayName=" + displayName + ", likeCnt=" + likeCnt + ", targetType=" + targetType + "]";
	}
}
