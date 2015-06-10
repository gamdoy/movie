package kr.or.kosta.event.vo;

public class WinnerVO {
	
	private int winNo;
	private String winRegdate;
	private String winText;
	private String winTitle;
	
	public WinnerVO(){}

	public WinnerVO(int winNo, String winRegdate, String winText,
			String winTitle) {
		super();
		this.winNo = winNo;
		this.winRegdate = winRegdate;
		this.winText = winText;
		this.winTitle = winTitle;
	}

	@Override
	public String toString() {
		return "WinnerVO [winNo=" + winNo + ", winRegdate=" + winRegdate
				+ ", winText=" + winText + ", winTitle=" + winTitle + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + winNo;
		result = prime * result
				+ ((winRegdate == null) ? 0 : winRegdate.hashCode());
		result = prime * result + ((winText == null) ? 0 : winText.hashCode());
		result = prime * result
				+ ((winTitle == null) ? 0 : winTitle.hashCode());
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
		WinnerVO other = (WinnerVO) obj;
		if (winNo != other.winNo)
			return false;
		if (winRegdate == null) {
			if (other.winRegdate != null)
				return false;
		} else if (!winRegdate.equals(other.winRegdate))
			return false;
		if (winText == null) {
			if (other.winText != null)
				return false;
		} else if (!winText.equals(other.winText))
			return false;
		if (winTitle == null) {
			if (other.winTitle != null)
				return false;
		} else if (!winTitle.equals(other.winTitle))
			return false;
		return true;
	}

	public int getWinNo() {
		return winNo;
	}

	public void setWinNo(int winNo) {
		this.winNo = winNo;
	}

	public String getWinRegdate() {
		return winRegdate;
	}

	public void setWinRegdate(String winRegdate) {
		this.winRegdate = winRegdate;
	}

	public String getWinText() {
		return winText;
	}

	public void setWinText(String winText) {
		this.winText = winText;
	}

	public String getWinTitle() {
		return winTitle;
	}

	public void setWinTitle(String winTitle) {
		this.winTitle = winTitle;
	}
	
	
}
