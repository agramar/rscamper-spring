package kr.co.rscamper.domain;

import java.util.Date;
import java.util.List;

public class BoardRouteVO {
	private int boardRouteNo;
	private int orderNo;
	private String targetType;
	private String title;
	private String place;
	private String content;
	private String userUid;
	private Date regDate;
	private String $$hashKey;
	private String displayName;
	private String photoUrl;
	private List<BoardRouteVO> routeDetailList;
	
	public int getBoardRouteNo() {
		return boardRouteNo;
	}
	public void setBoardRouteNo(int boardRouteNo) {
		this.boardRouteNo = boardRouteNo;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getTargetType() {
		return targetType;
	}
	public void setTargetType(String targetType) {
		this.targetType = targetType;
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
	public String getUserUid() {
		return userUid;
	}
	public void setUserUid(String userUid) {
		this.userUid = userUid;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
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
	public List<BoardRouteVO> getRouteDetailList() {
		return routeDetailList;
	}
	public void setRouteDetailList(List<BoardRouteVO> routeDetailList) {
		this.routeDetailList = routeDetailList;
	}
}
