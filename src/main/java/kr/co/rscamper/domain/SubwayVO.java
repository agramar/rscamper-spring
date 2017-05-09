package kr.co.rscamper.domain;

public class SubwayVO {
	private String depPlaceId;
	private String arrPlaceId;
	private String trainGradeCode;
	private String depPlandTime;
	private String numOfRows;
	private String pageNo;
	private String startPage;
	private String pageSize;
	
	
	public String getStartPage() {
		return startPage;
	}
	public void setStartPage(String startPage) {
		this.startPage = startPage;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getDepPlaceId() {
		return depPlaceId;
	}
	public void setDepPlaceId(String depPlaceId) {
		this.depPlaceId = depPlaceId;
	}
	public String getArrPlaceId() {
		return arrPlaceId;
	}
	public void setArrPlaceId(String arrPlaceId) {
		this.arrPlaceId = arrPlaceId;
	}
	public String getTrainGradeCode() {
		return trainGradeCode;
	}
	public void setTrainGradeCode(String trainGradeCode) {
		this.trainGradeCode = trainGradeCode;
	}
	public String getDepPlandTime() {
		return depPlandTime;
	}
	public void setDepPlandTime(String depPlandTime) {
		this.depPlandTime = depPlandTime;
	}
	public String getNumOfRows() {
		return numOfRows;
	}
	public void setNumOfRows(String numOfRows) {
		this.numOfRows = numOfRows;
	}
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	@Override
	public String toString() {
		return "SubwayVO [depPlaceId=" + depPlaceId + ", arrPlaceId=" + arrPlaceId + ", trainGradeCode="
				+ trainGradeCode + ", depPlandTime=" + depPlandTime + ", numOfRows=" + numOfRows + ", pageNo=" + pageNo
				+ ", startPage=" + startPage + ", pageSize=" + pageSize + "]";
	}
	
	
	
}
