package kr.co.rscamper.domain;

public class BenefitVO {
	private int benefitNo;			// 
	private String title;
	private String url;
	private String location;
	private String imageUrl;
	private String priceOrignal;
	private String priceDiscount;
	private String info;
	private String sapceText;
	private String space;
	private String discount;
	
	private String content;
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getBenefitNo() {
		return benefitNo;
	}
	public void setBenefitNo(int benefitNo) {
		this.benefitNo = benefitNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getPriceOrignal() {
		return priceOrignal;
	}
	public void setPriceOrignal(String priceOrignal) {
		this.priceOrignal = priceOrignal;
	}
	public String getPriceDiscount() {
		return priceDiscount;
	}
	public void setPriceDiscount(String priceDiscount) {
		this.priceDiscount = priceDiscount;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getSapceText() {
		return sapceText;
	}
	public void setSapceText(String sapceText) {
		this.sapceText = sapceText;
	}
	public String getSpace() {
		return space;
	}
	public void setSpace(String space) {
		this.space = space;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
	@Override
	public String toString() {
		return "BenefitVO [benefitNo=" + benefitNo + ", title=" + title + ", url=" + url + ", location=" + location
				+ ", imageUrl=" + imageUrl + ", priceOrignal=" + priceOrignal + ", priceDiscount=" + priceDiscount
				+ ", info=" + info + ", sapceText=" + sapceText + ", space=" + space + ", discount=" + discount
				+ ", content=" + content + "]";
	}
}
