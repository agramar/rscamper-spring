package kr.co.rscamper.domain;

import java.util.Date;

public class TourPlanParamVO {
	
	// 페이징
	private int amount;
	private int pageNo;
	private int startRow;
	
	// 정렬
	private String standard;
	private String order;
	
	// 검색 및 필터
	private String word;
	private int datePeriod;
	private Date datePeriodDate;
	private int minTripDays;
	private int maxTripDays;
	
	
	
	@Override
	public String toString() {
		return "TourPlanParamVO [amount=" + amount + ", pageNo=" + pageNo + ", startRow=" + startRow + ", standard="
				+ standard + ", order=" + order + ", word=" + word + ", datePeriod=" + datePeriod + ", minTripDays="
				+ minTripDays + ", maxTripDays=" + maxTripDays + ", datePeriodDate=" + datePeriodDate + "]";
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}


	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getDatePeriod() {
		return datePeriod;
	}

	public void setDatePeriod(int datePeriod) {
		this.datePeriod = datePeriod;
	}

	public int getMinTripDays() {
		return minTripDays;
	}

	public void setMinTripDays(int minTripDays) {
		this.minTripDays = minTripDays;
	}

	public int getMaxTripDays() {
		return maxTripDays;
	}

	public void setMaxTripDays(int maxTripDays) {
		this.maxTripDays = maxTripDays;
	}

	public Date getDatePeriodDate() {
		return datePeriodDate;
	}

	public void setDatePeriodDate(Date datePeriodDate) {
		this.datePeriodDate = datePeriodDate;
	}

	
	
}
