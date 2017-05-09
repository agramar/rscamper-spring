package kr.co.rscamper.domain;

import java.util.Date;

public class BoardLikeVO {

	private int likeNo;
	private int targetNo;
	private int targetType;
	private String userUid;
	private Date regDate;
	
	public int getLikeNo() {
		return likeNo;
	}
	public void setLikeNo(int likeNo) {
		this.likeNo = likeNo;
	}
	public int getTargetNo() {
		return targetNo;
	}
	public void setTargetNo(int targetNo) {
		this.targetNo = targetNo;
	}
	public int getTargetType() {
		return targetType;
	}
	public void setTargetType(int targetType) {
		this.targetType = targetType;
	}
	public String getUserUid() {
		return userUid;
	}
	public void setUserUid(String userUid) {
		this.userUid = userUid;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "BoardLikeVO [likeNo=" + likeNo + ", targetNo=" + targetNo + ", targetType=" + targetType + ", userUid="
				+ userUid + ", regDate=" + regDate + "]";
	}
}
