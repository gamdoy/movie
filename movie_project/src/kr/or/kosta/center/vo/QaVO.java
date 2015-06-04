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
	private String memId; //글쓴이 Id
	
	public QaVO(){}

	public QaVO(int fqNo, int memNo, String qaTitle, String fqRegdate,
			String fqLastdate, int qaCount, String qaText, String qaStatus,
			String qaSecret, String qaPassword, int fqParentNumber, int fileNo,
			String memId) {
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
		this.memId = memId;
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

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

}