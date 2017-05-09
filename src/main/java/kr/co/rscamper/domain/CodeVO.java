package kr.co.rscamper.domain;

public class CodeVO {
	private int publicCodeNo;
	private String groupCodeNo;
	private int codeNo;
	private String groupCodeName;
	private String codeName;
	public int getPublicCodeNo() {
		return publicCodeNo;
	}
	public void setPublicCodeNo(int publicCodeNo) {
		this.publicCodeNo = publicCodeNo;
	}
	public String getGroupCodeNo() {
		return groupCodeNo;
	}
	public void setGroupCodeNo(String groupCodeNo) {
		this.groupCodeNo = groupCodeNo;
	}
	public int getCodeNo() {
		return codeNo;
	}
	public void setCodeNo(int codeNo) {
		this.codeNo = codeNo;
	}
	public String getGroupCodeName() {
		return groupCodeName;
	}
	public void setGroupCodeName(String groupCodeName) {
		this.groupCodeName = groupCodeName;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	
	@Override
	public String toString() {
		return "CodeVO [publicCodeNo=" + publicCodeNo + ", groupCodeNo=" + groupCodeNo + ", codeNo=" + codeNo
				+ ", groupCodeName=" + groupCodeName + ", codeName=" + codeName + "]";
	}
	
}
