package kr.co.rscamper.domain;

public class MypageCountVO {

	private int notificationCnt;
	private int messageCnt;
	private int myTourPlanCnt;
	private int myPostCnt;
	private int bookmarkPostCnt;
	private int bookmarkTourPlanCnt;
	private int bookmarkTourSpotCnt;
	
	@Override
	public String toString() {
		return "MypageCountVO [notificationCnt=" + notificationCnt + ", messageCnt=" + messageCnt + ", myTourPlanCnt="
				+ myTourPlanCnt + ", myPostCnt=" + myPostCnt + ", bookmarkPostCnt=" + bookmarkPostCnt
				+ ", bookmarkTourPlanCnt=" + bookmarkTourPlanCnt + ", bookmarkTourSpotCnt=" + bookmarkTourSpotCnt + "]";
	}
	
	public int getNotificationCnt() {
		return notificationCnt;
	}
	public void setNotificationCnt(int notificationCnt) {
		this.notificationCnt = notificationCnt;
	}
	public int getMessageCnt() {
		return messageCnt;
	}
	public void setMessageCnt(int messageCnt) {
		this.messageCnt = messageCnt;
	}
	public int getMyTourPlanCnt() {
		return myTourPlanCnt;
	}
	public void setMyTourPlanCnt(int myTourPlanCnt) {
		this.myTourPlanCnt = myTourPlanCnt;
	}
	public int getMyPostCnt() {
		return myPostCnt;
	}
	public void setMyPostCnt(int myPostCnt) {
		this.myPostCnt = myPostCnt;
	}
	public int getBookmarkPostCnt() {
		return bookmarkPostCnt;
	}
	public void setBookmarkPostCnt(int bookmarkPostCnt) {
		this.bookmarkPostCnt = bookmarkPostCnt;
	}
	public int getBookmarkTourPlanCnt() {
		return bookmarkTourPlanCnt;
	}
	public void setBookmarkTourPlanCnt(int bookmarkTourPlanCnt) {
		this.bookmarkTourPlanCnt = bookmarkTourPlanCnt;
	}
	public int getBookmarkTourSpotCnt() {
		return bookmarkTourSpotCnt;
	}
	public void setBookmarkTourSpotCnt(int bookmarkTourSpotCnt) {
		this.bookmarkTourSpotCnt = bookmarkTourSpotCnt;
	}
	
	
}
