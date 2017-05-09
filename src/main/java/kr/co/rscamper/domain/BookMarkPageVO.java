package kr.co.rscamper.domain;

public class BookMarkPageVO {
	private int page;
	private int count;
	private String userUid;
	
	public BookMarkPageVO() {}
	public BookMarkPageVO(int page, int count, String userUid) {
		super();
		this.page = page;
		this.count = count;
		this.userUid = userUid;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getUserUid() {
		return userUid;
	}
	public void setUserUid(String userUid) {
		this.userUid = userUid;
	}
	
	@Override
	public String toString() {
		return "BookMarkPageVO [page=" + page + ", count=" + count + ", userUid=" + userUid + "]";
	}
}
