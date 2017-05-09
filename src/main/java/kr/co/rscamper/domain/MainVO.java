/**-----------------------------------------------------------------------
 * rscamper Project
 * ------------------------------------------------------------------------
 * @Class MainVO.java
 * @Description 실시간 댓글 정보 공유 DTO
 * @author 김호동
 * @since 2016. 10. 15.
 */

package kr.co.rscamper.domain;

import java.util.Date;

public class MainVO {
	private String userUid;				// 사용자 UID
	private String displayName;			// 사용자 명
	private String providerPhotoUrl;	// 사진 URL
	private String mainContent;			// 댓글 내용
	private Date mainRegDate;			// 댓글 등록 시간
	
	
	public String getUserUid() {
		return userUid;
	}
	public void setUserUid(String userUid) {
		this.userUid = userUid;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public String getProviderPhotoUrl() {
		return providerPhotoUrl;
	}
	public void setProviderPhotoUrl(String providerPhotoUrl) {
		this.providerPhotoUrl = providerPhotoUrl;
	}
	public String getMainContent() {
		return mainContent;
	}
	public void setMainContent(String mainContent) {
		this.mainContent = mainContent;
	}
	public Date getMainRegDate() {
		return mainRegDate;
	}
	public void setMainRegDate(Date mainRegDate) {
		this.mainRegDate = mainRegDate;
	}
	
	
	@Override
	public String toString() {
		return "MainVO [userUid=" + userUid + ", displayName=" + displayName + ", providerPhotoUrl=" + providerPhotoUrl
				+ ", mainContent=" + mainContent + ", mainRegDate=" + mainRegDate + "]";
	}
}
