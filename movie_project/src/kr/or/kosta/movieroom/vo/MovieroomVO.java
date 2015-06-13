package kr.or.kosta.movieroom.vo;

import java.io.Serializable;

public class MovieroomVO implements Serializable{
	private int mrNo;
	private int theaNo;
	private int schNo;
	private int movNo;
	private String mrName;
	private String mrScreentype;
	private String mrScreenname;
	private String schDate;
	private int mrLine;
	private int mrSeat;
	
	public MovieroomVO() {}

	public MovieroomVO(int mrNo, int theaNo, int schNo, int movNo,
			String mrName, String mrScreentype, String mrScreenname,
			String schDate, int mrLine, int mrSeat) {
		super();
		this.mrNo = mrNo;
		this.theaNo = theaNo;
		this.schNo = schNo;
		this.movNo = movNo;
		this.mrName = mrName;
		this.mrScreentype = mrScreentype;
		this.mrScreenname = mrScreenname;
		this.schDate = schDate;
		this.mrLine = mrLine;
		this.mrSeat = mrSeat;
	}

	public int getMrNo() {
		return mrNo;
	}

	public void setMrNo(int mrNo) {
		this.mrNo = mrNo;
	}

	public int getTheaNo() {
		return theaNo;
	}

	public void setTheaNo(int theaNo) {
		this.theaNo = theaNo;
	}

	public int getSchNo() {
		return schNo;
	}

	public void setSchNo(int schNo) {
		this.schNo = schNo;
	}

	public int getMovNo() {
		return movNo;
	}

	public void setMovNo(int movNo) {
		this.movNo = movNo;
	}

	public String getMrName() {
		return mrName;
	}

	public void setMrName(String mrName) {
		this.mrName = mrName;
	}

	public String getMrScreentype() {
		return mrScreentype;
	}

	public void setMrScreentype(String mrScreentype) {
		this.mrScreentype = mrScreentype;
	}

	public String getMrScreenname() {
		return mrScreenname;
	}

	public void setMrScreenname(String mrScreenname) {
		this.mrScreenname = mrScreenname;
	}

	public String getSchDate() {
		return schDate;
	}

	public void setSchDate(String schDate) {
		this.schDate = schDate;
	}

	public int getMrLine() {
		return mrLine;
	}

	public void setMrLine(int mrLine) {
		this.mrLine = mrLine;
	}

	public int getMrSeat() {
		return mrSeat;
	}

	public void setMrSeat(int mrSeat) {
		this.mrSeat = mrSeat;
	}

	@Override
	public String toString() {
		return "MovieroomVO [mrNo=" + mrNo + ", theaNo=" + theaNo + ", schNo="
				+ schNo + ", movNo=" + movNo + ", mrName=" + mrName
				+ ", mrScreentype=" + mrScreentype + ", mrScreenname="
				+ mrScreenname + ", schDate=" + schDate + ", mrLine=" + mrLine
				+ ", mrSeat=" + mrSeat + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + movNo;
		result = prime * result + mrLine;
		result = prime * result + ((mrName == null) ? 0 : mrName.hashCode());
		result = prime * result + mrNo;
		result = prime * result
				+ ((mrScreenname == null) ? 0 : mrScreenname.hashCode());
		result = prime * result
				+ ((mrScreentype == null) ? 0 : mrScreentype.hashCode());
		result = prime * result + mrSeat;
		result = prime * result + ((schDate == null) ? 0 : schDate.hashCode());
		result = prime * result + schNo;
		result = prime * result + theaNo;
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
		MovieroomVO other = (MovieroomVO) obj;
		if (movNo != other.movNo)
			return false;
		if (mrLine != other.mrLine)
			return false;
		if (mrName == null) {
			if (other.mrName != null)
				return false;
		} else if (!mrName.equals(other.mrName))
			return false;
		if (mrNo != other.mrNo)
			return false;
		if (mrScreenname == null) {
			if (other.mrScreenname != null)
				return false;
		} else if (!mrScreenname.equals(other.mrScreenname))
			return false;
		if (mrScreentype == null) {
			if (other.mrScreentype != null)
				return false;
		} else if (!mrScreentype.equals(other.mrScreentype))
			return false;
		if (mrSeat != other.mrSeat)
			return false;
		if (schDate == null) {
			if (other.schDate != null)
				return false;
		} else if (!schDate.equals(other.schDate))
			return false;
		if (schNo != other.schNo)
			return false;
		if (theaNo != other.theaNo)
			return false;
		return true;
	}
}
