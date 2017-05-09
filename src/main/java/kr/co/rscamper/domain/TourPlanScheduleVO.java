package kr.co.rscamper.domain;

public class TourPlanScheduleVO {
	
	private int locationNo;
	private int recordNo;
	private String title;
	private int contentCode;
	private String imageUrl;
	private String detailDepartureDate;
	private String detailArriveDate;
	private String departureDate;
	private int contentTypeId;
	private String mapX;
	private String mapY;
	
	// 상세 - 공통정보
	private String overview;
	private String homepage;
	private String addr1;
	private String tel;
	
	
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
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
	public String getDetailDepartureDate() {
		return detailDepartureDate;
	}
	public void setDetailDepartureDate(String detailDepartureDate) {
		this.detailDepartureDate = detailDepartureDate;
	}
	public String getDetailArriveDate() {
		return detailArriveDate;
	}
	public void setDetailArriveDate(String detailArriveDate) {
		this.detailArriveDate = detailArriveDate;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public int getContentTypeId() {
		return contentTypeId;
	}
	public void setContentTypeId(int contentTypeId) {
		this.contentTypeId = contentTypeId;
	}
	public String getMapX() {
		return mapX;
	}
	public void setMapX(String mapX) {
		this.mapX = mapX;
	}
	public String getMapY() {
		return mapY;
	}
	public void setMapY(String mapY) {
		this.mapY = mapY;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	
}
