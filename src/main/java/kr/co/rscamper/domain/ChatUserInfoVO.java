package kr.co.rscamper.domain;

public class ChatUserInfoVO {
	private int chatUserInfoNo;
	private String userUid;
	private int chatRoomInfoNo;
	private String displayName;
	private String photoUrl;
	public int getChatUserInfoNo() {
		return chatUserInfoNo;
	}
	public void setChatUserInfoNo(int chatUserInfoNo) {
		this.chatUserInfoNo = chatUserInfoNo;
	}
	public String getUserUid() {
		return userUid;
	}
	public void setUserUid(String userUid) {
		this.userUid = userUid;
	}
	public int getChatRoomInfoNo() {
		return chatRoomInfoNo;
	}
	public void setChatRoomInfoNo(int chatRoomInfoNo) {
		this.chatRoomInfoNo = chatRoomInfoNo;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
}
