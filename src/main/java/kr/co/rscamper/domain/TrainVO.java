package kr.co.rscamper.domain;

import java.util.Date;

public class TrainVO {
	
	private int stationNo;
	private String stationTitle;
	private String trainId;
	private int stationVital;
	private int trainSaemaeul;
	private int trainMugunghwa;
	private int trainTonggeun;
	private int trainNuriro;
	private int trainItxchungchun;
	private int trainItxsaemaeul;
	//
	public int getStationNo() {
		return stationNo;
	}
	public void setStationNo(int stationNo) {
		this.stationNo = stationNo;
	}
	public String getStationTitle() {
		return stationTitle;
	}
	public void setStationTitle(String stationTitle) {
		this.stationTitle = stationTitle;
	}
	public String getTrainId() {
		return trainId;
	}
	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}
	public int getStationVital() {
		return stationVital;
	}
	public void setStationVital(int stationVital) {
		this.stationVital = stationVital;
	}
	public int getTrainSaemaeul() {
		return trainSaemaeul;
	}
	public void setTrainSaemaeul(int trainSaemaeul) {
		this.trainSaemaeul = trainSaemaeul;
	}
	public int getTrainMugunghwa() {
		return trainMugunghwa;
	}
	public void setTrainMugunghwa(int trainMugunghwa) {
		this.trainMugunghwa = trainMugunghwa;
	}
	public int getTrainTonggeun() {
		return trainTonggeun;
	}
	public void setTrainTonggeun(int trainTonggeun) {
		this.trainTonggeun = trainTonggeun;
	}
	public int getTrainNuriro() {
		return trainNuriro;
	}
	public void setTrainNuriro(int trainNuriro) {
		this.trainNuriro = trainNuriro;
	}
	public int getTrainItxchungchun() {
		return trainItxchungchun;
	}
	public void setTrainItxchungchun(int trainItxchungchun) {
		this.trainItxchungchun = trainItxchungchun;
	}
	public int getTrainItxsaemaeul() {
		return trainItxsaemaeul;
	}
	public void setTrainItxsaemaeul(int trainItxsaemaeul) {
		this.trainItxsaemaeul = trainItxsaemaeul;
	}
	@Override
	public String toString() {
		return "TrainVO [stationNo=" + stationNo + ", stationTitle=" + stationTitle + ", trainId=" + trainId
				+ ", stationVital=" + stationVital + ", trainSaemaeul=" + trainSaemaeul + ", trainMugunghwa="
				+ trainMugunghwa + ", trainTonggeun=" + trainTonggeun + ", trainNuriro=" + trainNuriro
				+ ", trainItxchungchun=" + trainItxchungchun + ", trainItxsaemaeul=" + trainItxsaemaeul + "]";
	}

	


}
