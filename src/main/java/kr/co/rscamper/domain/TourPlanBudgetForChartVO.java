package kr.co.rscamper.domain;

public class TourPlanBudgetForChartVO {

	private String content;
	private int travelPrice;
	private int priceType;
	private String title;
	private int dateArray;
	
	@Override
	public String toString() {
		return "TourPlanBudgetForCharVO [content=" + content + ", travelPrice=" + travelPrice + ", priceType="
				+ priceType + ", title=" + title + ", dateArray=" + dateArray + "]";
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getDateArray() {
		return dateArray;
	}
	public void setDateArray(int dateArray) {
		this.dateArray = dateArray;
	}

	
}
