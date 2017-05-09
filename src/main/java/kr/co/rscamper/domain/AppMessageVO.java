package kr.co.rscamper.domain;

import java.util.Date;

public class AppMessageVO {
	private int notesNo;
	private String sentUserUid;
	private String recvUserUid;
	private String title;
	private String content;
	private Date dateSent;
	private Date dateRead;
	private String recvRead;
	private String photoUrl;
	private String displayName;
	
	public int getNotesNo() {
		return notesNo;
	}
	public void setNotesNo(int notesNo) {
		this.notesNo = notesNo;
	}
	public String getSentUserUid() {
		return sentUserUid;
	}
	public void setSentUserUid(String sentUserUid) {
		this.sentUserUid = sentUserUid;
	}
	public String getRecvUserUid() {
		return recvUserUid;
	}
	public void setRecvUserUid(String recvUserUid) {
		this.recvUserUid = recvUserUid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDateSent() {
		return dateSent;
	}
	public void setDateSent(Date dateSent) {
		this.dateSent = dateSent;
	}
	public Date getDateRead() {
		return dateRead;
	}
	public void setDateRead(Date dateRead) {
		this.dateRead = dateRead;
	}
	public String getRecvRead() {
		return recvRead;
	}
	public void setRecvRead(String recvRead) {
		this.recvRead = recvRead;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
