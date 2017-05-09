package kr.co.rscamper.domain;

public class TrainMapVO {
	private int mapNo;
	private int train_line_no;
	private String mapStationTitle;
	private String mapLatitude;
	private String mapLongitude;
	private String train_type;
	public int getMapNo() {
		return mapNo;
	}
	public void setMapNo(int mapNo) {
		this.mapNo = mapNo;
	}
	public int getTrain_line_no() {
		return train_line_no;
	}
	public void setTrain_line_no(int train_line_no) {
		this.train_line_no = train_line_no;
	}
	public String getMapStationTitle() {
		return mapStationTitle;
	}
	public void setMapStationTitle(String mapStationTitle) {
		this.mapStationTitle = mapStationTitle;
	}
	public String getMapLatitude() {
		return mapLatitude;
	}
	public void setMapLatitude(String mapLatitude) {
		this.mapLatitude = mapLatitude;
	}
	public String getMapLongitude() {
		return mapLongitude;
	}
	public void setMapLongitude(String mapLongitude) {
		this.mapLongitude = mapLongitude;
	}
	public String getTrain_type() {
		return train_type;
	}
	public void setTrain_type(String train_type) {
		this.train_type = train_type;
	}
	@Override
	public String toString() {
		return "TrainMapVO [mapNo=" + mapNo + ", train_line_no=" + train_line_no + ", mapStationTitle="
				+ mapStationTitle + ", mapLatitude=" + mapLatitude + ", mapLongitude=" + mapLongitude + ", train_type="
				+ train_type + "]";
	}
		
}
