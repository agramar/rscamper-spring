package kr.co.rscamper.domain;

import java.util.Date;

public class RecordLocationVO {
	private int locationNo;
	private int recordNo;
	private String title;
	private int contentCode;
	private String imageUrl;
	private Date detailDepartureDate;
	private int contentTypeId;
	private String departureDate;
	private int likeCount;
	private int isLike;
	private double mapX;
	private double mapY;
	
	
	public double getMapX() {
		return mapX;
	}
	public void setMapX(double mapX) {
		this.mapX = mapX;
	}
	public double getMapY() {
		return mapY;
	}
	public void setMapY(double mapY) {
		this.mapY = mapY;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getIsLike() {
		return isLike;
	}
	public void setIsLike(int isLike) {
		this.isLike = isLike;
	}
	public Date getDetailDepartureDate() {
		return detailDepartureDate;
	}
	public void setDetailDepartureDate(Date detailDepartureDate) {
		this.detailDepartureDate = detailDepartureDate;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public int getLocationNo() {
		return locationNo;
	}
	public void setLocationNo(int locationNo) {
		this.locationNo = locationNo;
	}
	public int getRecordNo() {
		return recordNo;
	}
	public void setRecordNo(int recordNo) {
		this.recordNo = recordNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getContentCode() {
		return contentCode;
	}
	public void setContentCode(int contentCode) {
		this.contentCode = contentCode;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getContentTypeId() {
		return contentTypeId;
	}
	public void setContentTypeId(int contentTypeId) {
		this.contentTypeId = contentTypeId;
	}
	
	
}
