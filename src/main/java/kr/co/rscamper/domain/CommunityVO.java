package kr.co.rscamper.domain;

import java.util.Date;

public class CommunityVO {
	
	private int boardNo;
	private String title;
	private String content;
	private int viewCnt;
	private Date regDate;
	
	private int categoryNo;
	private String categoryName;
	
	private String userUid;
	private String displayName;
	private String photoUrl;
	private String email;
	private String providerUid;
	private String providerName;
	private String providerDisplayName;
	private String providerPhotoUrl;
	private String providerEmail;
	private String bgPhotoUrl;
	private String phoneNumber;
	private String websiteUrl;
	private String introduce;
	private Date birthday;
	
	private int locationNo;
	private String locationName;
	
	private int likeCnt;
	private int commentCnt;
	private int bookmarkCnt;
	
	
	
	public int getBookmarkCnt() {
		return bookmarkCnt;
	}

	public void setBookmarkCnt(int bookmarkCnt) {
		this.bookmarkCnt = bookmarkCnt;
	}

	public int getCommentCnt() {
		return commentCnt;
	}

	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public int getLocationNo() {
		return locationNo;
	}

	public void setLocationNo(int locationNo) {
		this.locationNo = locationNo;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProviderUid() {
		return providerUid;
	}

	public void setProviderUid(String providerUid) {
		this.providerUid = providerUid;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getProviderDisplayName() {
		return providerDisplayName;
	}

	public void setProviderDisplayName(String providerDisplayName) {
		this.providerDisplayName = providerDisplayName;
	}

	public String getProviderPhotoUrl() {
		return providerPhotoUrl;
	}

	public void setProviderPhotoUrl(String providerPhotoUrl) {
		this.providerPhotoUrl = providerPhotoUrl;
	}

	public String getProviderEmail() {
		return providerEmail;
	}

	public void setProviderEmail(String providerEmail) {
		this.providerEmail = providerEmail;
	}

	public String getBgPhotoUrl() {
		return bgPhotoUrl;
	}

	public void setBgPhotoUrl(String bgPhotoUrl) {
		this.bgPhotoUrl = bgPhotoUrl;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getUserUid() {
		return userUid;
	}

	public void setUserUid(String userUid) {
		this.userUid = userUid;
	}

	@Override
	public String toString() {
		return "CommunityVO [boardNo=" + boardNo + ", title=" + title + ", content=" + content + ", viewCnt=" + viewCnt
				+ ", regDate=" + regDate + ", categoryNo=" + categoryNo + ", categoryName=" + categoryName
				+ ", userUid=" + userUid + ", displayName=" + displayName + ", photoUrl=" + photoUrl + ", email="
				+ email + ", providerUid=" + providerUid + ", providerName=" + providerName + ", providerDisplayName="
				+ providerDisplayName + ", providerPhotoUrl=" + providerPhotoUrl + ", providerEmail=" + providerEmail
				+ ", bgPhotoUrl=" + bgPhotoUrl + ", phoneNumber=" + phoneNumber + ", websiteUrl=" + websiteUrl
				+ ", introduce=" + introduce + ", birthday=" + birthday + ", locationNo=" + locationNo
				+ ", locationName=" + locationName + ", likeCnt=" + likeCnt + ", commentCnt=" + commentCnt + "]";
	}
	
}
