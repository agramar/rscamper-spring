package kr.co.rscamper.domain;

import java.util.Date;

public class TourCommentVO {
	private int tourCommentNo;
	private int contentid;
	private String content;
	private Date regDate;
	private int likeCnt;
	private int commentCnt;
	private String likeStatus;
	private String bookmarkStatus;
	
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
	
	
	
	
	public int getTourCommentNo() {
		return tourCommentNo;
	}
	public void setTourCommentNo(int tourCommentNo) {
		this.tourCommentNo = tourCommentNo;
	}
	public String getLikeStatus() {
		return likeStatus;
	}
	public void setLikeStatus(String likeStatus) {
		this.likeStatus = likeStatus;
	}
	public int getContentid() {
		return contentid;
	}
	public void setContentid(int contentid) {
		this.contentid = contentid;
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
	public int getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	public int getCommentCnt() {
		return commentCnt;
	}
	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
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
	
	public String getBookmarkStatus() {
		return bookmarkStatus;
	}
	public void setBookmarkStatus(String bookmarkStatus) {
		this.bookmarkStatus = bookmarkStatus;
	}
	@Override
	public String toString() {
		return "TourCommentVO [tourCommentNo=" + tourCommentNo + ", contentid=" + contentid + ", content=" + content
				+ ", regDate=" + regDate + ", likeCnt=" + likeCnt + ", commentCnt=" + commentCnt + ", likeStatus="
				+ likeStatus + ", bookmarkStatus=" + bookmarkStatus + ", userUid=" + userUid + ", displayName="
				+ displayName + ", photoUrl=" + photoUrl + ", email=" + email + ", providerUid=" + providerUid
				+ ", providerName=" + providerName + ", providerDisplayName=" + providerDisplayName
				+ ", providerPhotoUrl=" + providerPhotoUrl + ", providerEmail=" + providerEmail + ", bgPhotoUrl="
				+ bgPhotoUrl + ", phoneNumber=" + phoneNumber + ", websiteUrl=" + websiteUrl + ", introduce="
				+ introduce + ", birthday=" + birthday + "]";
	}
}
