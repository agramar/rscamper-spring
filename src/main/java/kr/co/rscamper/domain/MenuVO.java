package kr.co.rscamper.domain;

public class MenuVO {
	private int menuNo;
	private String title;
	private String url;
	private int parentMenuNo;
	private int level;
	private String type;
	
	
	public int getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
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
	public int getParentMenuNo() {
		return parentMenuNo;
	}
	public void setParentMenuNo(int parentMenuNo) {
		this.parentMenuNo = parentMenuNo;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "MenuVO [menuNo=" + menuNo + ", title=" + title + ", url=" + url + ", parentMenuNo=" + parentMenuNo
				+ ", level=" + level + ", type=" + type + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
