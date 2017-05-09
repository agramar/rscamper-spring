package kr.co.rscamper.domain;

import java.util.Date;

public class NotisficationVO {
	private int notisficationNo;
	private String recivUserUid;
	private String targetUserUid;
	private String type;			
	private String contentId;		// 해당 글 primary Key
	private String message;
	private String url;
	private Date date;
	
	private String displayName;
	private String photoUrl;
	private String title;
	private String codeName;
	
	
	public int getNotisficationNo() {
		return notisficationNo;
	}
	public void setNotisficationNo(int notisficationNo) {
		this.notisficationNo = notisficationNo;
	}
	public String getRecivUserUid() {
		return recivUserUid;
	}
	public void setRecivUserUid(String recivUserUid) {
		this.recivUserUid = recivUserUid;
	}
	public String getTargetUserUid() {
		return targetUserUid;
	}
	public void setTargetUserUid(String targetUserUid) {
		this.targetUserUid = targetUserUid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContentId() {
		return contentId;
	}
	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	@Override
	public String toString() {
		return "NotisficationVO [notisficationNo=" + notisficationNo + ", recivUserUid=" + recivUserUid
				+ ", targetUserUid=" + targetUserUid + ", type=" + type + ", contentId=" + contentId + ", message="
				+ message + ", url=" + url + ", date=" + date + ", displayName=" + displayName + ", photoUrl="
				+ photoUrl + ", title=" + title + ", codeName=" + codeName + "]";
	}

}
