package kr.co.rscamper.domain;

public class ChatUserVO {
	private int chatUserInfoNo;
	private String userUid;
	private int chatRoomInfoNo;
	private String displayName;
	
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
	@Override
	public String toString() {
		return "ChatUserVO [chatUserInfoNo=" + chatUserInfoNo + ", userUid=" + userUid + ", chatRoomInfoNo="
				+ chatRoomInfoNo + ", displayName=" + displayName + "]";
	}

}
