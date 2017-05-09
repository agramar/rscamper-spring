package kr.co.rscamper.domain;

import java.util.Date;

public class BookMarkVO {
	private int no;
	private String targetType;
	private Date regDate;
	private String userUid;
	private String coverImgUrl;
	private String title;
	private String strapline;
	private String introduce;
	private int picture;
	private String photoUrl;
	private String displayName;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTargetType() {
		return targetType;
	}
	public void setTargetType(String targetType) {
		this.targetType = targetType;
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
	public String getCoverImgUrl() {
		return coverImgUrl;
	}
	public void setCoverImgUrl(String coverImgUrl) {
		this.coverImgUrl = coverImgUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStrapline() {
		return strapline;
	}
	public void setStrapline(String strapline) {
		this.strapline = strapline;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public int getPicture() {
		return picture;
	}
	public void setPicture(int picture) {
		this.picture = picture;
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
	
	@Override
	public String toString() {
		return "BookMarkVO [no=" + no + ", targetType=" + targetType + ", regDate=" + regDate + ", userUid=" + userUid
				+ ", coverImgUrl=" + coverImgUrl + ", title=" + title + ", strapline=" + strapline + ", introduce="
				+ introduce + ", picture=" + picture + ", photoUrl=" + photoUrl + ", displayName=" + displayName + "]";
	}
}
