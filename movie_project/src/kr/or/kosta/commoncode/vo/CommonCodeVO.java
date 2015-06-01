package kr.or.kosta.commoncode.vo;

public class CommonCodeVO {
	private String cmnNo;
	private String cmnCodeEng;
	private String cmnCodeKor;
	private String keyword;
	
	public CommonCodeVO() {}

	public CommonCodeVO(String cmnNo, String cmnCodeEng, String cmnCodeKor,
			String keyword) {
		super();
		this.cmnNo = cmnNo;
		this.cmnCodeEng = cmnCodeEng;
		this.cmnCodeKor = cmnCodeKor;
		this.keyword = keyword;
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

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "CommonCodeVO [cmnNo=" + cmnNo + ", cmnCodeEng=" + cmnCodeEng
				+ ", cmnCodeKor=" + cmnCodeKor + ", keyword=" + keyword + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cmnCodeEng == null) ? 0 : cmnCodeEng.hashCode());
		result = prime * result
				+ ((cmnCodeKor == null) ? 0 : cmnCodeKor.hashCode());
		result = prime * result + ((cmnNo == null) ? 0 : cmnNo.hashCode());
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
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
		CommonCodeVO other = (CommonCodeVO) obj;
		if (cmnCodeEng == null) {
			if (other.cmnCodeEng != null)
				return false;
		} else if (!cmnCodeEng.equals(other.cmnCodeEng))
			return false;
		if (cmnCodeKor == null) {
			if (other.cmnCodeKor != null)
				return false;
		} else if (!cmnCodeKor.equals(other.cmnCodeKor))
			return false;
		if (cmnNo == null) {
			if (other.cmnNo != null)
				return false;
		} else if (!cmnNo.equals(other.cmnNo))
			return false;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!keyword.equals(other.keyword))
			return false;
		return true;
	}
}
