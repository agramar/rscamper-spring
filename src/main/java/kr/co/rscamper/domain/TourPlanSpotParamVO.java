package kr.co.rscamper.domain;

public class TourPlanSpotParamVO {
	
	// 페이징
	private int amount;
	private int pageNo;
	private int startRow;
	
	// 정렬
	private String standard;
	private String order;
	
	// 검색 및 필터
	private String word;
	private String category;
	
	// 북마크용 유저아이디
	private String userUid;
	
	@Override
	public String toString() {
		return "TourPlanSpotParamVO [amount=" + amount + ", pageNo=" + pageNo + ", startRow=" + startRow + ", standard="
				+ standard + ", order=" + order + ", word=" + word + ", category=" + category + ", userUid=" + userUid
				+ "]";
	}
	public String getUserUid() {
		return userUid;
	}
	public void setUserUid(String userUid) {
		this.userUid = userUid;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	
	
}
