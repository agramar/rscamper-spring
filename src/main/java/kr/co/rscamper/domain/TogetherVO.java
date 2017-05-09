package kr.co.rscamper.domain;

import java.util.Date;

public class TogetherVO {
	private int togetherlNo;
	private String url;
	private String title1;
	private String title2;
	private Date regDate;
	
	private int togetherDetailNo;
	private int togetherNo;
	private String content;
	
	
	public int getTogetherlNo() {
		return togetherlNo;
	}
	public void setTogetherlNo(int togetherlNo) {
		this.togetherlNo = togetherlNo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle1() {
		return title1;
	}
	public void setTitle1(String title1) {
		this.title1 = title1;
	}
	public String getTitle2() {
		return title2;
	}
	public void setTitle2(String title2) {
		this.title2 = title2;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getTogetherDetailNo() {
		return togetherDetailNo;
	}
	public void setTogetherDetailNo(int togetherDetailNo) {
		this.togetherDetailNo = togetherDetailNo;
	}
	public int getTogetherNo() {
		return togetherNo;
	}
	public void setTogetherNo(int togetherNo) {
		this.togetherNo = togetherNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	

	
}
