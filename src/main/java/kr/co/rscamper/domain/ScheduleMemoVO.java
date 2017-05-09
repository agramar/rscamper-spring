package kr.co.rscamper.domain;

import java.util.Date;
import java.util.List;

public class ScheduleMemoVO {
	private int scheduleMemoNo;
	private int recordNo;
	private int contentId;
	private String userUid;
	private String title;
	private String content;
	private Date regDate;
	private int memoType;
	private String locationTitle;
	private String recordTitle;
	private int commentCnt;
	private String displayName;
	private String photoUrl;
	private int likeCnt;
	private int isLike;
	private int memoCnt;
	private List<TravelPriceVO> price;
	private int locationNo;
	
	
	@Override
	public String toString() {
		return "ScheduleMemoVO [scheduleMemoNo=" + scheduleMemoNo + ", recordNo=" + recordNo + ", contentId="
				+ contentId + ", userUid=" + userUid + ", title=" + title + ", content=" + content + ", regDate="
				+ regDate + ", memoType=" + memoType + ", locationTitle=" + locationTitle + ", recordTitle="
				+ recordTitle + ", commentCnt=" + commentCnt + ", displayName=" + displayName + ", photoUrl=" + photoUrl
				+ ", likeCnt=" + likeCnt + ", isLike=" + isLike + ", memoCnt=" + memoCnt + ", price=" + price
				+ ", locationNo=" + locationNo + "]";
	}
	public int getLocationNo() {
		return locationNo;
	}
	public void setLocationNo(int locationNo) {
		this.locationNo = locationNo;
	}
	public List<TravelPriceVO> getPrice() {
		return price;
	}
	public void setPrice(List<TravelPriceVO> price) {
		this.price = price;
	}
	public int getMemoCnt() {
		return memoCnt;
	}
	public void setMemoCnt(int memoCnt) {
		this.memoCnt = memoCnt;
	}
	public int getIsLike() {
		return isLike;
	}
	public void setIsLike(int isLike) {
		this.isLike = isLike;
	}
	public int getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
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
	public int getCommentCnt() {
		return commentCnt;
	}
	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}
	public String getLocationTitle() {
		return locationTitle;
	}
	public void setLocationTitle(String locationTitle) {
		this.locationTitle = locationTitle;
	}
	public String getRecordTitle() {
		return recordTitle;
	}
	public void setRecordTitle(String recordTitle) {
		this.recordTitle = recordTitle;
	}
	public int getMemoType() {
		return memoType;
	}
	public void setMemoType(int memoType) {
		this.memoType = memoType;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public int getScheduleMemoNo() {
		return scheduleMemoNo;
	}
	public void setScheduleMemoNo(int scheduleMemoNo) {
		this.scheduleMemoNo = scheduleMemoNo;
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
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
}
