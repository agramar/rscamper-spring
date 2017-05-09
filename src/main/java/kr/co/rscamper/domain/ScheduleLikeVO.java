package kr.co.rscamper.domain;

public class ScheduleLikeVO {
	private String userUid;
	private int recordNo;
	private int targetRecordNo;
	private int afterRecordNo;
	
	public int getAfterRecordNo() {
		return afterRecordNo;
	}
	public void setAfterRecordNo(int afterRecordNo) {
		this.afterRecordNo = afterRecordNo;
	}
	public int getTargetRecordNo() {
		return targetRecordNo;
	}
	public void setTargetRecordNo(int targetRecordNo) {
		this.targetRecordNo = targetRecordNo;
	}
	public String getUserUid() {
		return userUid;
	}
	public void setUserUid(String userUid) {
		this.userUid = userUid;
	}
	public int getRecordNo() {
		return recordNo;
	}
	public void setRecordNo(int recordNo) {
		this.recordNo = recordNo;
	}
	@Override
	public String toString() {
		return "ScheduleLikeVO [userUid=" + userUid + ", recordNo=" + recordNo + ", targetRecordNo=" + targetRecordNo
				+ ", afterRecordNo=" + afterRecordNo + "]";
	}
	
	
}
