package kr.co.rscamper.domain;

import java.util.Date;

public class AppMainCommentVO {
	private int no;
	private String title;
	private Date regDate;
	private String targetType;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getTargetType() {
		return targetType;
	}
	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
	
	@Override
	public String toString() {
		return "AppMainCommentVO [no=" + no + ", title=" + title + ", regDate=" + regDate + ", targetType=" + targetType
				+ "]";
	}
}
