package kr.or.kosta.notice.vo;

import org.springframework.web.multipart.MultipartFile;

public class NoticeVO {
	private int notiNo;
	private int memNo;
	private String notiTitle;
	private String notiRegdate;
	private int notiCount;
	private String notiText;
	private int fileNo;
	
	private MultipartFile notiFile;
	
	public NoticeVO(){}

	public NoticeVO(int notiNo, int memNo, String notiTitle,
			String notiRegdate, int notiCount, String notiText, int fileNo,
			MultipartFile notiFile) {
		super();
		this.notiNo = notiNo;
		this.memNo = memNo;
		this.notiTitle = notiTitle;
		this.notiRegdate = notiRegdate;
		this.notiCount = notiCount;
		this.notiText = notiText;
		this.fileNo = fileNo;
		this.notiFile = notiFile;
	}

	@Override
	public String toString() {
		return "NoticeVO [notiNo=" + notiNo + ", memNo=" + memNo
				+ ", notiTitle=" + notiTitle + ", notiRegdate=" + notiRegdate
				+ ", notiCount=" + notiCount + ", notiText=" + notiText
				+ ", fileNo=" + fileNo + ", notiFile=" + notiFile + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fileNo;
		result = prime * result + memNo;
		result = prime * result + notiCount;
		result = prime * result
				+ ((notiFile == null) ? 0 : notiFile.hashCode());
		result = prime * result + notiNo;
		result = prime * result
				+ ((notiRegdate == null) ? 0 : notiRegdate.hashCode());
		result = prime * result
				+ ((notiText == null) ? 0 : notiText.hashCode());
		result = prime * result
				+ ((notiTitle == null) ? 0 : notiTitle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NoticeVO other = (NoticeVO) obj;
		if (fileNo != other.fileNo)
			return false;
		if (memNo != other.memNo)
			return false;
		if (notiCount != other.notiCount)
			return false;
		if (notiFile == null) {
			if (other.notiFile != null)
				return false;
		} else if (!notiFile.equals(other.notiFile))
			return false;
		if (notiNo != other.notiNo)
			return false;
		if (notiRegdate == null) {
			if (other.notiRegdate != null)
				return false;
		} else if (!notiRegdate.equals(other.notiRegdate))
			return false;
		if (notiText == null) {
			if (other.notiText != null)
				return false;
		} else if (!notiText.equals(other.notiText))
			return false;
		if (notiTitle == null) {
			if (other.notiTitle != null)
				return false;
		} else if (!notiTitle.equals(other.notiTitle))
			return false;
		return true;
	}

	public int getNotiNo() {
		return notiNo;
	}

	public void setNotiNo(int notiNo) {
		this.notiNo = notiNo;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getNotiTitle() {
		return notiTitle;
	}

	public void setNotiTitle(String notiTitle) {
		this.notiTitle = notiTitle;
	}

	public String getNotiRegdate() {
		return notiRegdate;
	}

	public void setNotiRegdate(String notiRegdate) {
		this.notiRegdate = notiRegdate;
	}

	public int getNotiCount() {
		return notiCount;
	}

	public void setNotiCount(int notiCount) {
		this.notiCount = notiCount;
	}

	public String getNotiText() {
		return notiText;
	}

	public void setNotiText(String notiText) {
		this.notiText = notiText;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public MultipartFile getNotiFile() {
		return notiFile;
	}

	public void setNotiFile(MultipartFile notiFile) {
		this.notiFile = notiFile;
	}

	public void setNoticeParentNumber(int fileNo2) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
