package kr.co.rscamper.domain;

public class RecordCoverVO {
	private int coverNo;
	private int recordNo;
	private String realPath;
	private String filePath;
	private String oriName;
	private String fileName;
	
	public int getCoverNo() {
		return coverNo;
	}
	public void setCoverNo(int coverNo) {
		this.coverNo = coverNo;
	}
	public int getRecordNo() {
		return recordNo;
	}
	public void setRecordNo(int recordNo) {
		this.recordNo = recordNo;
	}
	public String getRealPath() {
		return realPath;
	}
	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getOriName() {
		return oriName;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
