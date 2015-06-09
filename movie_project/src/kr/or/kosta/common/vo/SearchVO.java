package kr.or.kosta.common.vo;

public class SearchVO {
	private String searchType;
	private String searchKeyword;
	
	public SearchVO() {	}

	public SearchVO(String searchType, String searchKeyword) {
		super();
		this.searchType = searchType;
		this.searchKeyword = searchKeyword;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((searchKeyword == null) ? 0 : searchKeyword.hashCode());
		result = prime * result
				+ ((searchType == null) ? 0 : searchType.hashCode());
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
		if (searchKeyword == null) {
			if (other.searchKeyword != null)
				return false;
		} else if (!searchKeyword.equals(other.searchKeyword))
			return false;
		if (searchType == null) {
			if (other.searchType != null)
				return false;
		} else if (!searchType.equals(other.searchType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SearchVO [searchType=" + searchType + ", searchKeyword="
				+ searchKeyword + "]";
	}

}
