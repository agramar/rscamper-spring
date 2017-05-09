package kr.co.rscamper.domain;

import java.util.Date;

public class TourPlanVO {

	// 기본정보
	private int recordNo;
	private String userUid;
	private Date departureDate;
	private Date arriveDate;
	private String title;
	private int budGet;
	private int picture;
	private String period;
	private String strapline;
	private String introduce;

	private Date regDate;
	private int isOpen;
	
	// 카운트(좋아요 북마크 일정복사 댓글수)
	private int likeCnt;
	private int bookmarkCnt;
	private int customCnt;
	private int commentCnt;

	// 유저정보
	private String displayName;
	private String photoUrl;
	
	// 배경화면 이미지 정보
	private String filePath;
	
	// 페이징
	private int totalPages;

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

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArriveDate() {
		return arriveDate;
	}

	public void setArriveDate(Date arriveDate) {
		this.arriveDate = arriveDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getBudGet() {
		return budGet;
	}

	public void setBudGet(int budGet) {
		this.budGet = budGet;
	}

	public int getPicture() {
		return picture;
	}

	public void setPicture(int picture) {
		this.picture = picture;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(int isOpen) {
		this.isOpen = isOpen;
	}

//	public RecordCoverVO getCover() {
//		return cover;
//	}
//
//	public void setCover(RecordCoverVO cover) {
//		this.cover = cover;
//	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public int getBookmarkCnt() {
		return bookmarkCnt;
	}

	public void setBookmarkCnt(int bookmarkCnt) {
		this.bookmarkCnt = bookmarkCnt;
	}

	public int getCustomCnt() {
		return customCnt;
	}

	public void setCustomCnt(int customCnt) {
		this.customCnt = customCnt;
	}

	public int getCommentCnt() {
		return commentCnt;
	}

	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
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

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	@Override
	public String toString() {
		return "TourPlanVO [recordNo=" + recordNo + ", userUid=" + userUid + ", departureDate=" + departureDate
				+ ", arriveDate=" + arriveDate + ", title=" + title + ", budGet=" + budGet + ", picture=" + picture
				+ ", period=" + period + ", strapline=" + strapline + ", introduce=" + introduce + ", regDate="
				+ regDate + ", isOpen=" + isOpen + ",likeCnt=" + likeCnt + ", bookmarkCnt="
				+ bookmarkCnt + ", customCnt=" + customCnt + ", commentCnt=" + commentCnt + ", displayName="
				+ displayName + ", photoUrl=" + photoUrl + ", filePath=" + filePath + ", totalPages=" + totalPages
				+ "]";
	}

	
	
}
