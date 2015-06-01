package kr.or.kosta.common.vo;

/**
 * @author Computer
 *
 */
public class ZipcodeVO {
	private int zipNo;
	private String zipZipcode;
	private String zipAddress;
	private String keyword;
		
	public ZipcodeVO() {}

	public ZipcodeVO(int zipNo, String zipZipcode, String zipAddress,
			String keyword) {
		this.zipNo = zipNo;
		this.zipZipcode = zipZipcode;
		this.zipAddress = zipAddress;
		this.keyword = keyword;
	}

	public int getZipNo() {
		return zipNo;
	}

	public void setZipNo(int zipNo) {
		this.zipNo = zipNo;
	}

	public String getZipZipcode() {
		return zipZipcode;
	}

	public void setZipZipcode(String zipZipcode) {
		this.zipZipcode = zipZipcode;
	}

	public String getZipAddress() {
		return zipAddress;
	}

	public void setZipAddress(String zipAddress) {
		this.zipAddress = zipAddress;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "ZipcodeVO [zipNo=" + zipNo + ", zipZipcode=" + zipZipcode
				+ ", zipAddress=" + zipAddress + ", keyword=" + keyword + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
		result = prime * result
				+ ((zipAddress == null) ? 0 : zipAddress.hashCode());
		result = prime * result + zipNo;
		result = prime * result
				+ ((zipZipcode == null) ? 0 : zipZipcode.hashCode());
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
		ZipcodeVO other = (ZipcodeVO) obj;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!keyword.equals(other.keyword))
			return false;
		if (zipAddress == null) {
			if (other.zipAddress != null)
				return false;
		} else if (!zipAddress.equals(other.zipAddress))
			return false;
		if (zipNo != other.zipNo)
			return false;
		if (zipZipcode == null) {
			if (other.zipZipcode != null)
				return false;
		} else if (!zipZipcode.equals(other.zipZipcode))
			return false;
		return true;
	}
}
