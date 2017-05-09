package kr.co.rscamper.domain;

import java.util.Date;

public class NoteVO {
	private int notesNo;
	private String recvUserUid;
	private String sentUserUid;
	private String title;
	private String content;
	private Date dateSent;
	private Date dateRead;
	private String recvRead;
	private String recvDel;
	private String sentRead;
	
	private String displayName;
	private String photoUrl;
	
	
	public int getNotesNo() {
		return notesNo;
	}
	public void setNotesNo(int notesNo) {
		this.notesNo = notesNo;
	}
	public String getRecvUserUid() {
		return recvUserUid;
	}
	public void setRecvUserUid(String recvUserUid) {
		this.recvUserUid = recvUserUid;
	}
	public String getSentUserUid() {
		return sentUserUid;
	}
	public void setSentUserUid(String sentUserUid) {
		this.sentUserUid = sentUserUid;
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
	public String getRecvDel() {
		return recvDel;
	}
	public void setRecvDel(String recvDel) {
		this.recvDel = recvDel;
	}
	public String getSentRead() {
		return sentRead;
	}
	public void setSentRead(String sentRead) {
		this.sentRead = sentRead;
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
	@Override
	public String toString() {
		return "NoteVO [notesNo=" + notesNo + ", recvUserUid=" + recvUserUid + ", sentUserUid=" + sentUserUid
				+ ", title=" + title + ", content=" + content + ", dateSent=" + dateSent + ", dateRead=" + dateRead
				+ ", recvRead=" + recvRead + ", recvDel=" + recvDel + ", sentRead=" + sentRead + ", displayName="
				+ displayName + ", photoUrl=" + photoUrl + "]";
	}
}
