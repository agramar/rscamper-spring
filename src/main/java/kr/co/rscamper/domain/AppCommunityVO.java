package kr.co.rscamper.domain;

import java.util.Date;
import java.util.List;

public class AppCommunityVO {
	private int boardNo;
	private int orderNo;
	private String title;
	private String place;
	private String content;
	private Date regDate;
	private int categoryNo;
	private String categoryName;
	private String userUid;
	private String $$hashKey;
	private String displayName;
	private String photoUrl;
	private String targetType;
	private int commentCnt;
	private int likeCnt;
	private int bookmarkCnt;
	private List<AppCommunityVO> routeDetailList;
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
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
	public String getUserUid() {
		return userUid;
	}
	public void setUserUid(String userUid) {
		this.userUid = userUid;
	}
	public String get$$hashKey() {
		return $$hashKey;
	}
	public void set$$hashKey(String $$hashKey) {
		this.$$hashKey = $$hashKey;
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
	public String getTargetType() {
		return targetType;
	}
	public void setTargetType(String targetType) {
		this.targetType = targetType;
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
	public int getBookmarkCnt() {
		return bookmarkCnt;
	}
	public void setBookmarkCnt(int bookmarkCnt) {
		this.bookmarkCnt = bookmarkCnt;
	}
	public List<AppCommunityVO> getRouteDetailList() {
		return routeDetailList;
	}
	public void setRouteDetailList(List<AppCommunityVO> routeDetailList) {
		this.routeDetailList = routeDetailList;
	}
}
