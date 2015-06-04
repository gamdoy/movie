package kr.or.kosta.schedule.vo;

import java.io.Serializable;

public class ScheduleVO implements Serializable{
	private int schNo;
	private int movNo;
	private int mrNo;
	private String schDate;
	private int theaNo;
	
	public ScheduleVO() {}

	public ScheduleVO(int schNo, int movNo, int mrNo, String schDate, int theaNo) {
		super();
		this.schNo = schNo;
		this.movNo = movNo;
		this.mrNo = mrNo;
		this.schDate = schDate;
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

	public int getMrNo() {
		return mrNo;
	}

	public void setMrNo(int mrNo) {
		this.mrNo = mrNo;
	}

	public String getSchDate() {
		return schDate;
	}

	public void setSchDate(String schDate) {
		this.schDate = schDate;
	}

	public int getTheaNo() {
		return theaNo;
	}

	public void setTheaNo(int theaNo) {
		this.theaNo = theaNo;
	}

	@Override
	public String toString() {
		return "ScheduleVO [schNo=" + schNo + ", movNo=" + movNo + ", mrNo="
				+ mrNo + ", schDate=" + schDate + ", theaNo=" + theaNo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + movNo;
		result = prime * result + mrNo;
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
		ScheduleVO other = (ScheduleVO) obj;
		if (movNo != other.movNo)
			return false;
		if (mrNo != other.mrNo)
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
