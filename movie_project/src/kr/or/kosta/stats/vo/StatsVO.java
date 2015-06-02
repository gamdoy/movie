package kr.or.kosta.stats.vo;

import org.springframework.web.multipart.MultipartFile;

public class StatsVO {
	private int rank;//영화순위
	private String title;//영화제목
	private String intheaters;//개봉일
	private double bookingStatus;	//예매율
	private int weeklySales;//주간매출액
	private int cumulativeSales;//누적매출액
	private int bookingCount;//예매관객수
	private int cumulativeAttendance;//누적관객수	
	private int seats;//좌석수
	
	public StatsVO() {
		// TODO Auto-generated constructor stub
	}
	
	public StatsVO(int rank, String title, String intheaters,
			double bookingStatus, int weeklySales, int cumulativeSales,
			int bookingCount, int cumulativeAttendance, int seats) {
		super();
		this.rank = rank;
		this.title = title;
		this.intheaters = intheaters;
		this.bookingStatus = bookingStatus;
		this.weeklySales = weeklySales;
		this.cumulativeSales = cumulativeSales;
		this.bookingCount = bookingCount;
		this.cumulativeAttendance = cumulativeAttendance;
		this.seats = seats;
	}

	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIntheaters() {
		return intheaters;
	}
	public void setIntheaters(String intheaters) {
		this.intheaters = intheaters;
	}
	public double getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(double bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public int getWeeklySales() {
		return weeklySales;
	}
	public void setWeeklySales(int weeklySales) {
		this.weeklySales = weeklySales;
	}
	public int getCumulativeSales() {
		return cumulativeSales;
	}
	public void setCumulativeSales(int cumulativeSales) {
		this.cumulativeSales = cumulativeSales;
	}
	public int getBookingCount() {
		return bookingCount;
	}
	public void setBookingCount(int bookingCount) {
		this.bookingCount = bookingCount;
	}
	public int getCumulativeAttendance() {
		return cumulativeAttendance;
	}
	public void setCumulativeAttendance(int cumulativeAttendance) {
		this.cumulativeAttendance = cumulativeAttendance;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "StatsVO [rank=" + rank + ", title=" + title + ", intheaters="
				+ intheaters + ", bookingStatus=" + bookingStatus
				+ ", weeklySales=" + weeklySales + ", cumulativeSales="
				+ cumulativeSales + ", bookingCount=" + bookingCount
				+ ", cumulativeAttendance=" + cumulativeAttendance + ", seats="
				+ seats + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookingCount;
		long temp;
		temp = Double.doubleToLongBits(bookingStatus);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + cumulativeAttendance;
		result = prime * result + cumulativeSales;
		result = prime * result
				+ ((intheaters == null) ? 0 : intheaters.hashCode());
		result = prime * result + rank;
		result = prime * result + seats;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + weeklySales;
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
		StatsVO other = (StatsVO) obj;
		if (bookingCount != other.bookingCount)
			return false;
		if (Double.doubleToLongBits(bookingStatus) != Double
				.doubleToLongBits(other.bookingStatus))
			return false;
		if (cumulativeAttendance != other.cumulativeAttendance)
			return false;
		if (cumulativeSales != other.cumulativeSales)
			return false;
		if (intheaters == null) {
			if (other.intheaters != null)
				return false;
		} else if (!intheaters.equals(other.intheaters))
			return false;
		if (rank != other.rank)
			return false;
		if (seats != other.seats)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (weeklySales != other.weeklySales)
			return false;
		return true;
	}
	
	
}
