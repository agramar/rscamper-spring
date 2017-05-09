package kr.co.rscamper.domain;

public class LocationLikedVO {
	private int contentId;
	private String uid;
	private int postCnt;
	private int likeCnt;
	private int backLikeCnt;
	
	
	public int getBackLikeCnt() {
		return backLikeCnt;
	}
	public void setBackLikeCnt(int backLikeCnt) {
		this.backLikeCnt = backLikeCnt;
	}
	public int getPostCnt() {
		return postCnt;
	}
	public void setPostCnt(int postCnt) {
		this.postCnt = postCnt;
	}
	public int getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	
}
