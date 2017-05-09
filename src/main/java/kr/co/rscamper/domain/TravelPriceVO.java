package kr.co.rscamper.domain;

public class TravelPriceVO {
	private int travelPriceNo;
	private int recordNo;
	private int contentId;
	private String userUid;
	private String content;
	private int travelPrice;
	private int priceType;
	private String $$hashKey;
	private int locationNo;
	private int scheduleMemoNo;
	
	
	@Override
	public String toString() {
		return "TravelPriceVO [travelPriceNo=" + travelPriceNo + ", recordNo=" + recordNo + ", contentId=" + contentId
				+ ", userUid=" + userUid + ", content=" + content + ", travelPrice=" + travelPrice + ", priceType="
				+ priceType + ", $$hashKey=" + $$hashKey + ", locationNo=" + locationNo + ", scheduleMemoNo="
				+ scheduleMemoNo + "]";
	}

	public int getScheduleMemoNo() {
		return scheduleMemoNo;
	}

	public void setScheduleMemoNo(int scheduleMemoNo) {
		this.scheduleMemoNo = scheduleMemoNo;
	}

	public int getLocationNo() {
		return locationNo;
	}
	public void setLocationNo(int locationNo) {
		this.locationNo = locationNo;
	}
	public int getTravelPriceNo() {
		return travelPriceNo;
	}
	public void setTravelPriceNo(int travelPriceNo) {
		this.travelPriceNo = travelPriceNo;
	}
	public int getRecordNo() {
		return recordNo;
	}
	public void setRecordNo(int recordNo) {
		this.recordNo = recordNo;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public String getUserUid() {
		return userUid;
	}
	public void setUserUid(String userUid) {
		this.userUid = userUid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getTravelPrice() {
		return travelPrice;
	}
	public void setTravelPrice(int travelPrice) {
		this.travelPrice = travelPrice;
	}
	public int getPriceType() {
		return priceType;
	}
	public void setPriceType(int priceType) {
		this.priceType = priceType;
	}
	public String get$$hashKey() {
		return $$hashKey;
	}
	public void set$$hashKey(String $$hashKey) {
		this.$$hashKey = $$hashKey;
	}
	
}
