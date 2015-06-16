package kr.or.kosta.center.vo;

public class CommentVO {
	private int comNo;
	private int memNo;
	private String comText;
	private String comRegDate;
	private int comParentNumber;
	
	public CommentVO(){}

	public CommentVO(int comNo, int memNo, String comText, String comRegDate,
			int comParentNumber) {
		super();
		this.comNo = comNo;
		this.memNo = memNo;
		this.comText = comText;
		this.comRegDate = comRegDate;
		this.comParentNumber = comParentNumber;
	}

	public int getComNo() {
		return comNo;
	}

	public void setComNo(int comNo) {
		this.comNo = comNo;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getComText() {
		return comText;
	}

	public void setComText(String comText) {
		this.comText = comText;
	}

	public String getComRegDate() {
		return comRegDate;
	}

	public void setComRegDate(String comRegDate) {
		this.comRegDate = comRegDate;
	}

	public int getComParentNumber() {
		return comParentNumber;
	}

	public void setComParentNumber(int comParentNumber) {
		this.comParentNumber = comParentNumber;
	}

	@Override
	public String toString() {
		return "CommentVO [comNo=" + comNo + ", memNo=" + memNo + ", comText="
				+ comText + ", comRegDate=" + comRegDate + ", comParentNumber="
				+ comParentNumber + "]";
	}
	
}
