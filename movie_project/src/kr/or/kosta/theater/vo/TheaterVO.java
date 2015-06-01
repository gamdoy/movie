package kr.or.kosta.theater.vo;

import java.io.Serializable;

public class TheaterVO implements Serializable{
	private int theaNo;
	private int zipNo;
	private int zipZipcode;
	private String theaLocation;
	private String theaPhoneNo;
	private String theaAddress1;
	private String theaAddress2;
	private String theaStatus;
	
	public TheaterVO() {}

	public TheaterVO(int theaNo, int zipNo, int zipZipcode,
			String theaLocation, String theaPhoneNo, String theaAddress1,
			String theaAddress2, String theaStatus) {
		super();
		this.theaNo = theaNo;
		this.zipNo = zipNo;
		this.zipZipcode = zipZipcode;
		this.theaLocation = theaLocation;
		this.theaPhoneNo = theaPhoneNo;
		this.theaAddress1 = theaAddress1;
		this.theaAddress2 = theaAddress2;
		this.theaStatus = theaStatus;
	}

	public int getTheaNo() {
		return theaNo;
	}

	public void setTheaNo(int theaNo) {
		this.theaNo = theaNo;
	}

	public int getZipNo() {
		return zipNo;
	}

	public void setZipNo(int zipNo) {
		this.zipNo = zipNo;
	}

	public int getZipZipcode() {
		return zipZipcode;
	}

	public void setZipZipcode(int zipZipcode) {
		this.zipZipcode = zipZipcode;
	}

	public String getTheaLocation() {
		return theaLocation;
	}

	public void setTheaLocation(String theaLocation) {
		this.theaLocation = theaLocation;
	}

	public String getTheaPhoneNo() {
		return theaPhoneNo;
	}

	public void setTheaPhoneNo(String theaPhoneNo) {
		this.theaPhoneNo = theaPhoneNo;
	}

	public String getTheaAddress1() {
		return theaAddress1;
	}

	public void setTheaAddress1(String theaAddress1) {
		this.theaAddress1 = theaAddress1;
	}

	public String getTheaAddress2() {
		return theaAddress2;
	}

	public void setTheaAddress2(String theaAddress2) {
		this.theaAddress2 = theaAddress2;
	}

	public String getTheaStatus() {
		return theaStatus;
	}

	public void setTheaStatus(String theaStatus) {
		this.theaStatus = theaStatus;
	}

	@Override
	public String toString() {
		return "TheaterVO [theaNo=" + theaNo + ", zipNo=" + zipNo
				+ ", zipZipcode=" + zipZipcode + ", theaLocation="
				+ theaLocation + ", theaPhoneNo=" + theaPhoneNo
				+ ", theaAddress1=" + theaAddress1 + ", theaAddress2="
				+ theaAddress2 + ", theaStatus=" + theaStatus + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((theaAddress1 == null) ? 0 : theaAddress1.hashCode());
		result = prime * result
				+ ((theaAddress2 == null) ? 0 : theaAddress2.hashCode());
		result = prime * result
				+ ((theaLocation == null) ? 0 : theaLocation.hashCode());
		result = prime * result + theaNo;
		result = prime * result
				+ ((theaPhoneNo == null) ? 0 : theaPhoneNo.hashCode());
		result = prime * result
				+ ((theaStatus == null) ? 0 : theaStatus.hashCode());
		result = prime * result + zipNo;
		result = prime * result + zipZipcode;
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
		TheaterVO other = (TheaterVO) obj;
		if (theaAddress1 == null) {
			if (other.theaAddress1 != null)
				return false;
		} else if (!theaAddress1.equals(other.theaAddress1))
			return false;
		if (theaAddress2 == null) {
			if (other.theaAddress2 != null)
				return false;
		} else if (!theaAddress2.equals(other.theaAddress2))
			return false;
		if (theaLocation == null) {
			if (other.theaLocation != null)
				return false;
		} else if (!theaLocation.equals(other.theaLocation))
			return false;
		if (theaNo != other.theaNo)
			return false;
		if (theaPhoneNo == null) {
			if (other.theaPhoneNo != null)
				return false;
		} else if (!theaPhoneNo.equals(other.theaPhoneNo))
			return false;
		if (theaStatus == null) {
			if (other.theaStatus != null)
				return false;
		} else if (!theaStatus.equals(other.theaStatus))
			return false;
		if (zipNo != other.zipNo)
			return false;
		if (zipZipcode != other.zipZipcode)
			return false;
		return true;
	}
}