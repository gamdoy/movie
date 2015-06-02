package kr.or.kosta.center.vo;

public class QaVO {
	private int fqNo; //글번호
	private int memNo; //회원번호
	private String qaTitle; //제목
	private String fqRegdate; //등록일
	private String fqLastdate; //최종수정시간
	private int qaCount; //조회수
	private String qaText; //내용
	private String qaStatus; //상태
	private String qaSecret; //비밀여부
	private String qaPassword; //비밀번호
	private int fqParentNumber; //부모번호
	private int fileNo; //파일번호
	
	public QaVO(){}
	
	public QaVO(int fqNo, int memNo, String qaTitle, String fqRegdate,
			String fqLastdate, int qaCount, String qaText, String qaStatus,
			String qaSecret, String qaPassword, int fqParentNumber, int fileNo) {
		super();
		this.fqNo = fqNo;
		this.memNo = memNo;
		this.qaTitle = qaTitle;
		this.fqRegdate = fqRegdate;
		this.fqLastdate = fqLastdate;
		this.qaCount = qaCount;
		this.qaText = qaText;
		this.qaStatus = qaStatus;
		this.qaSecret = qaSecret;
		this.qaPassword = qaPassword;
		this.fqParentNumber = fqParentNumber;
		this.fileNo = fileNo;
	}

	public int getFqNo() {
		return fqNo;
	}

	public void setFqNo(int fqNo) {
		this.fqNo = fqNo;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getQaTitle() {
		return qaTitle;
	}

	public void setQaTitle(String qaTitle) {
		this.qaTitle = qaTitle;
	}

	public String getFqRegdate() {
		return fqRegdate;
	}

	public void setFqRegdate(String fqRegdate) {
		this.fqRegdate = fqRegdate;
	}

	public String getFqLastdate() {
		return fqLastdate;
	}

	public void setFqLastdate(String fqLastdate) {
		this.fqLastdate = fqLastdate;
	}

	public int getQaCount() {
		return qaCount;
	}

	public void setQaCount(int qaCount) {
		this.qaCount = qaCount;
	}

	public String getQaText() {
		return qaText;
	}

	public void setQaText(String qaText) {
		this.qaText = qaText;
	}

	public String getQaStatus() {
		return qaStatus;
	}

	public void setQaStatus(String qaStatus) {
		this.qaStatus = qaStatus;
	}

	public String getQaSecret() {
		return qaSecret;
	}

	public void setQaSecret(String qaSecret) {
		this.qaSecret = qaSecret;
	}

	public String getQaPassword() {
		return qaPassword;
	}

	public void setQaPassword(String qaPassword) {
		this.qaPassword = qaPassword;
	}

	public int getFqParentNumber() {
		return fqParentNumber;
	}

	public void setFqParentNumber(int fqParentNumber) {
		this.fqParentNumber = fqParentNumber;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fileNo;
		result = prime * result
				+ ((fqLastdate == null) ? 0 : fqLastdate.hashCode());
		result = prime * result + fqNo;
		result = prime * result + fqParentNumber;
		result = prime * result
				+ ((fqRegdate == null) ? 0 : fqRegdate.hashCode());
		result = prime * result + memNo;
		result = prime * result + qaCount;
		result = prime * result
				+ ((qaPassword == null) ? 0 : qaPassword.hashCode());
		result = prime * result
				+ ((qaSecret == null) ? 0 : qaSecret.hashCode());
		result = prime * result
				+ ((qaStatus == null) ? 0 : qaStatus.hashCode());
		result = prime * result + ((qaText == null) ? 0 : qaText.hashCode());
		result = prime * result + ((qaTitle == null) ? 0 : qaTitle.hashCode());
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
		QaVO other = (QaVO) obj;
		if (fileNo != other.fileNo)
			return false;
		if (fqLastdate == null) {
			if (other.fqLastdate != null)
				return false;
		} else if (!fqLastdate.equals(other.fqLastdate))
			return false;
		if (fqNo != other.fqNo)
			return false;
		if (fqParentNumber != other.fqParentNumber)
			return false;
		if (fqRegdate == null) {
			if (other.fqRegdate != null)
				return false;
		} else if (!fqRegdate.equals(other.fqRegdate))
			return false;
		if (memNo != other.memNo)
			return false;
		if (qaCount != other.qaCount)
			return false;
		if (qaPassword == null) {
			if (other.qaPassword != null)
				return false;
		} else if (!qaPassword.equals(other.qaPassword))
			return false;
		if (qaSecret == null) {
			if (other.qaSecret != null)
				return false;
		} else if (!qaSecret.equals(other.qaSecret))
			return false;
		if (qaStatus == null) {
			if (other.qaStatus != null)
				return false;
		} else if (!qaStatus.equals(other.qaStatus))
			return false;
		if (qaText == null) {
			if (other.qaText != null)
				return false;
		} else if (!qaText.equals(other.qaText))
			return false;
		if (qaTitle == null) {
			if (other.qaTitle != null)
				return false;
		} else if (!qaTitle.equals(other.qaTitle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QaVO [fqNo=" + fqNo + ", memNo=" + memNo + ", qaTitle="
				+ qaTitle + ", fqRegdate=" + fqRegdate + ", fqLastdate="
				+ fqLastdate + ", qaCount=" + qaCount + ", qaText=" + qaText
				+ ", qaStatus=" + qaStatus + ", qaSecret=" + qaSecret
				+ ", qaPassword=" + qaPassword + ", fqParentNumber="
				+ fqParentNumber + ", fileNo=" + fileNo + "]";
	}
	
}
