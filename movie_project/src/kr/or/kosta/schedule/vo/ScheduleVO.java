package kr.or.kosta.schedule.vo;

import java.io.Serializable;

import kr.or.kosta.movie.vo.MovieVO;

public class ScheduleVO implements Serializable{
	private int schNo;
	private int movNo;
	private String movTitle;
	private int mrNo;
	private String mrName;
	private int theaNo;
	private String schDate;
	private String movPoster;
	private int emptySeat;
	
	public ScheduleVO() {}

	public ScheduleVO(int schNo, int movNo, String movTitle, int mrNo,
			String mrName, int theaNo, String schDate, String movPoster,
			int emptySeat) {
		super();
		this.schNo = schNo;
		this.movNo = movNo;
		this.movTitle = movTitle;
		this.mrNo = mrNo;
		this.mrName = mrName;
		this.theaNo = theaNo;
		this.schDate = schDate;
		this.movPoster = movPoster;
		this.emptySeat = emptySeat;
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

	public String getMovTitle() {
		return movTitle;
	}

	public void setMovTitle(String movTitle) {
		this.movTitle = movTitle;
	}

	public int getMrNo() {
		return mrNo;
	}

	public void setMrNo(int mrNo) {
		this.mrNo = mrNo;
	}

	public String getMrName() {
		return mrName;
	}

	public void setMrName(String mrName) {
		this.mrName = mrName;
	}

	public int getTheaNo() {
		return theaNo;
	}

	public void setTheaNo(int theaNo) {
		this.theaNo = theaNo;
	}

	public String getSchDate() {
		return schDate;
	}

	public void setSchDate(String schDate) {
		this.schDate = schDate;
	}

	public String getMovPoster() {
		return movPoster;
	}

	public void setMovPoster(String movPoster) {
		this.movPoster = movPoster;
	}

	public int getEmptySeat() {
		return emptySeat;
	}

	public void setEmptySeat(int emptySeat) {
		this.emptySeat = emptySeat;
	}

	@Override
	public String toString() {
		return "ScheduleVO [schNo=" + schNo + ", movNo=" + movNo
				+ ", movTitle=" + movTitle + ", mrNo=" + mrNo + ", mrName="
				+ mrName + ", theaNo=" + theaNo + ", schDate=" + schDate
				+ ", movPoster=" + movPoster + ", emptySeat=" + emptySeat + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + emptySeat;
		result = prime * result + movNo;
		result = prime * result
				+ ((movPoster == null) ? 0 : movPoster.hashCode());
		result = prime * result
				+ ((movTitle == null) ? 0 : movTitle.hashCode());
		result = prime * result + ((mrName == null) ? 0 : mrName.hashCode());
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
		if (emptySeat != other.emptySeat)
			return false;
		if (movNo != other.movNo)
			return false;
		if (movPoster == null) {
			if (other.movPoster != null)
				return false;
		} else if (!movPoster.equals(other.movPoster))
			return false;
		if (movTitle == null) {
			if (other.movTitle != null)
				return false;
		} else if (!movTitle.equals(other.movTitle))
			return false;
		if (mrName == null) {
			if (other.mrName != null)
				return false;
		} else if (!mrName.equals(other.mrName))
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
