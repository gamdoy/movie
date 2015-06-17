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
	private  String MemId;
	
	private int replyLevel;
	private int replyStep;
	
	public QaVO(){}

	public QaVO(int fqNo, int memNo, String qaTitle, String fqRegdate,
			String fqLastdate, int qaCount, String qaText, String qaStatus,
			String qaSecret, String qaPassword, int fqParentNumber, int fileNo,
			int replyLevel, int replyStep) {
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
		this.replyLevel = replyLevel;
		this.replyStep = replyStep;
	}

	
	public String getMemId() {
		return MemId;
	}

	public void setMemId(String memId) {
		MemId = memId;
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

	public int getReplyLevel() {
		return replyLevel;
	}

	public void setReplyLevel(int replyLevel) {
		this.replyLevel = replyLevel;
	}

	public int getReplyStep() {
		return replyStep;
	}

	public void setReplyStep(int replyStep) {
		this.replyStep = replyStep;
	}

	@Override
	public String toString() {
		return "QaVO [fqNo=" + fqNo + ", memNo=" + memNo + ", qaTitle="
				+ qaTitle + ", fqRegdate=" + fqRegdate + ", fqLastdate="
				+ fqLastdate + ", qaCount=" + qaCount + ", qaText=" + qaText
				+ ", qaStatus=" + qaStatus + ", qaSecret=" + qaSecret
				+ ", qaPassword=" + qaPassword + ", fqParentNumber="
				+ fqParentNumber + ", fileNo=" + fileNo + ", replyLevel="
				+ replyLevel + ", replyStep=" + replyStep + "]";
	}
	
	
}
