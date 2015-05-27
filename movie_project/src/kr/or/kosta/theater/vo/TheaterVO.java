package kr.or.kosta.theater.vo;

import java.io.Serializable;

public class TheaterVO implements Serializable{
	private String theaNo;
	
	public TheaterVO() {}
	
	public TheaterVO(String theaNo) {
		super();
		this.theaNo = theaNo;
	}

	public String getTheaNo() {
		return theaNo;
	}

	public void setTheaNo(String theaNo) {
		this.theaNo = theaNo;
	}

	@Override
	public String toString() {
		return "TheaterVO [theaNo=" + theaNo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((theaNo == null) ? 0 : theaNo.hashCode());
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
		if (theaNo == null) {
			if (other.theaNo != null)
				return false;
		} else if (!theaNo.equals(other.theaNo))
			return false;
		return true;
	}
}
