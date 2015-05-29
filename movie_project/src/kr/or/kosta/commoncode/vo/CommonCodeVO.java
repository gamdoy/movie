package kr.or.kosta.commoncode.vo;

public class CommonCodeVO {
	private String cmnNo;
	private String cmnCodeEng;
	private String cmnCodeKor;
	
	public CommonCodeVO() {}

	public CommonCodeVO(String cmnNo, String cmnCodeEng, String cmnCodeKor) {
		super();
		this.cmnNo = cmnNo;
		this.cmnCodeEng = cmnCodeEng;
		this.cmnCodeKor = cmnCodeKor;
	}

	public String getCmnNo() {
		return cmnNo;
	}

	public void setCmnNo(String cmnNo) {
		this.cmnNo = cmnNo;
	}

	public String getCmnCodeEng() {
		return cmnCodeEng;
	}

	public void setCmnCodeEng(String cmnCodeEng) {
		this.cmnCodeEng = cmnCodeEng;
	}

	public String getCmnCodeKor() {
		return cmnCodeKor;
	}

	public void setCmnCodeKor(String cmnCodeKor) {
		this.cmnCodeKor = cmnCodeKor;
	}

	@Override
	public String toString() {
		return "CommonCodeVO [cmnNo=" + cmnNo + ", cmnCodeEng=" + cmnCodeEng
				+ ", cmnCodeKor=" + cmnCodeKor + "]";
	}
}
