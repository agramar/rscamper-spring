package kr.co.rscamper.domain;

public class PageMaker {
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int displayPageNum = 10;
	private PageVO page;
	
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}
	private void calcData() {
//		System.out.println("in calcData");
		endPage = (int) (Math.ceil(page.getPage() / (double) displayPageNum) * displayPageNum);
		
//		System.out.println("endPage : " + endPage);
		startPage = (endPage - displayPageNum) + 1;
		
		int tempEndPage = (int) (Math.ceil(totalCount / (double) page.getPerPageNum()));
		
		if (endPage > tempEndPage) {
//			System.out.println(" endPage > tempEndPage ");
			endPage = tempEndPage;
//			System.out.println("endPage : " + endPage);
		}
		
		prev = startPage == 1? false : true;
		next = endPage * page.getPerPageNum() >= totalCount ? false : true;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	public PageVO getPage() {
		return page;
	}
	public void setPage(PageVO page) {
		this.page = page;
	}
	
	
}
