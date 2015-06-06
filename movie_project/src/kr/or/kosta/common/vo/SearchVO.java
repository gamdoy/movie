package kr.or.kosta.common.vo;

public class SearchVO {
	private String serachType;
	private String serachKeyword;
	
	public SearchVO() {	}

	public SearchVO(String serachType, String serachKeyword) {
		super();
		this.serachType = serachType;
		this.serachKeyword = serachKeyword;
	}

	public String getSerachType() {
		return serachType;
	}

	public void setSerachType(String serachType) {
		this.serachType = serachType;
	}

	public String getSerachKeyword() {
		return serachKeyword;
	}

	public void setSerachKeyword(String serachKeyword) {
		this.serachKeyword = serachKeyword;
	}

	@Override
	public String toString() {
		return "SearchVO [serachType=" + serachType + ", serachKeyword="
				+ serachKeyword + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((serachKeyword == null) ? 0 : serachKeyword.hashCode());
		result = prime * result
				+ ((serachType == null) ? 0 : serachType.hashCode());
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
		SearchVO other = (SearchVO) obj;
		if (serachKeyword == null) {
			if (other.serachKeyword != null)
				return false;
		} else if (!serachKeyword.equals(other.serachKeyword))
			return false;
		if (serachType == null) {
			if (other.serachType != null)
				return false;
		} else if (!serachType.equals(other.serachType))
			return false;
		return true;
	}
}
