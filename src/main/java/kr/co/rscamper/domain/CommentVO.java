package kr.co.rscamper.domain;

import java.util.Date;

public class CommentVO {
	private Integer commentNo;
	private Integer targetCommentNo;
	private Integer boardNo;
	private String commentContent;
	private String content;

	private Date regDate;
	
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
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	
	public Integer getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(Integer commentNo) {
		this.commentNo = commentNo;
	}
	public Integer getTargetCommentNo() {
		return targetCommentNo;
	}
	public void setTargetCommentNo(Integer targetCommentNo) {
		this.targetCommentNo = targetCommentNo;
	}
	public Integer getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(Integer boardNo) {
		this.boardNo = boardNo;
	}
	public String getUserUid() {
		return userUid;
	}
	public void setUserUid(String userUid) {
		this.userUid = userUid;
	}
	
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	

	@Override
	public String toString() {
		return "CommentVO [commentNo=" + commentNo + ", targetCommentNo=" + targetCommentNo + ", boardNo=" + boardNo
				+ ", commentContent=" + commentContent + ", content=" + content + ", regDate=" + regDate + ", userUid="
				+ userUid + ", displayName=" + displayName + ", photoUrl=" + photoUrl + ", email=" + email
				+ ", providerUid=" + providerUid + ", providerName=" + providerName + ", providerDisplayName="
				+ providerDisplayName + ", providerPhotoUrl=" + providerPhotoUrl + ", providerEmail=" + providerEmail
				+ ", bgPhotoUrl=" + bgPhotoUrl + ", phoneNumber=" + phoneNumber + ", websiteUrl=" + websiteUrl
				+ ", introduce=" + introduce + ", birthday=" + birthday + ", locationNo=" + locationNo
				+ ", locationName=" + locationName + "]";
	}
	
}
