package kr.co.rscamper.domain;

import java.util.Date;

public class TravelogVO {
	
	private int boardNo;
	private int categoryNo;
	private String categoryName;
	private String title;
	private String userUid;
	private String displayName;
	private String providerPhotoUrl;
	private String content;
	private int viewCnt;
	private Date regDate;
	private int imageNo;
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserUid() {
		return userUid;
	}
	public void setUserUid(String userUid) {
		this.userUid = userUid;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getProviderPhotoUrl() {
		return providerPhotoUrl;
	}
	public void setProviderPhotoUrl(String providerPhotoUrl) {
		this.providerPhotoUrl = providerPhotoUrl;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getImageNo() {
		return imageNo;
	}
	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}
	
	@Override
	public String toString() {
		return "TravelogVO [boardNo=" + boardNo + ", categoryNo=" + categoryNo + ", categoryName=" + categoryName
				+ ", title=" + title + ", userUid=" + userUid + ", displayName=" + displayName + ", content=" + content
				+ ", viewCnt=" + viewCnt + ", regDate=" + regDate + ", imageNo=" + imageNo + "]";
	}
	
}
