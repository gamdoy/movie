package kr.or.kosta.ticket.vo;

public class TicketVO {
	private int ticNo;
	private String ticDate;
	private int ticPrice;
	private String ticPaytype;
	private String ticSeatno;
	private int ticTotalcustomer;
	private int memNo;
	private int schNo;
	private String schDate;
	private int mrNo;
	private String mrName;
	private String mrScreentype;
	private String mrScreenname;
	private int mrLine;
	private int mrSeat;
	private int theaNo;
	
	public TicketVO() {}

	public TicketVO(int ticNo, String ticDate, int ticPrice, String ticPaytype,
			String ticSeatno, int ticTotalcustomer, int memNo, int schNo,
			String schDate, int mrNo, String mrName, String mrScreentype,
			String mrScreenname, int mrLine, int mrSeat, int theaNo) {
		super();
		this.ticNo = ticNo;
		this.ticDate = ticDate;
		this.ticPrice = ticPrice;
		this.ticPaytype = ticPaytype;
		this.ticSeatno = ticSeatno;
		this.ticTotalcustomer = ticTotalcustomer;
		this.memNo = memNo;
		this.schNo = schNo;
		this.schDate = schDate;
		this.mrNo = mrNo;
		this.mrName = mrName;
		this.mrScreentype = mrScreentype;
		this.mrScreenname = mrScreenname;
		this.mrLine = mrLine;
		this.mrSeat = mrSeat;
		this.theaNo = theaNo;
	}

	public int getTicNo() {
		return ticNo;
	}

	public void setTicNo(int ticNo) {
		this.ticNo = ticNo;
	}

	public String getTicDate() {
		return ticDate;
	}

	public void setTicDate(String ticDate) {
		this.ticDate = ticDate;
	}

	public int getTicPrice() {
		return ticPrice;
	}

	public void setTicPrice(int ticPrice) {
		this.ticPrice = ticPrice;
	}

	public String getTicPaytype() {
		return ticPaytype;
	}

	public void setTicPaytype(String ticPaytype) {
		this.ticPaytype = ticPaytype;
	}

	public String getTicSeatno() {
		return ticSeatno;
	}

	public void setTicSeatno(String ticSeatno) {
		this.ticSeatno = ticSeatno;
	}

	public int getTicTotalcustomer() {
		return ticTotalcustomer;
	}

	public void setTicTotalcustomer(int ticTotalcustomer) {
		this.ticTotalcustomer = ticTotalcustomer;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public int getSchNo() {
		return schNo;
	}

	public void setSchNo(int schNo) {
		this.schNo = schNo;
	}

	public String getSchDate() {
		return schDate;
	}

	public void setSchDate(String schDate) {
		this.schDate = schDate;
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

	public int getTheaNo() {
		return theaNo;
	}

	public void setTheaNo(int theaNo) {
		this.theaNo = theaNo;
	}

	@Override
	public String toString() {
		return "TicketVO [ticNo=" + ticNo + ", ticDate=" + ticDate
				+ ", ticPrice=" + ticPrice + ", ticPaytype=" + ticPaytype
				+ ", ticSeatno=" + ticSeatno + ", ticTotalcustomer="
				+ ticTotalcustomer + ", memNo=" + memNo + ", schNo=" + schNo
				+ ", schDate=" + schDate + ", mrNo=" + mrNo + ", mrName="
				+ mrName + ", mrScreentype=" + mrScreentype + ", mrScreenname="
				+ mrScreenname + ", mrLine=" + mrLine + ", mrSeat=" + mrSeat
				+ ", theaNo=" + theaNo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + memNo;
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
		result = prime * result + ((ticDate == null) ? 0 : ticDate.hashCode());
		result = prime * result + ticNo;
		result = prime * result
				+ ((ticPaytype == null) ? 0 : ticPaytype.hashCode());
		result = prime * result + ticPrice;
		result = prime * result
				+ ((ticSeatno == null) ? 0 : ticSeatno.hashCode());
		result = prime * result + ticTotalcustomer;
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
		TicketVO other = (TicketVO) obj;
		if (memNo != other.memNo)
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
		if (ticDate == null) {
			if (other.ticDate != null)
				return false;
		} else if (!ticDate.equals(other.ticDate))
			return false;
		if (ticNo != other.ticNo)
			return false;
		if (ticPaytype == null) {
			if (other.ticPaytype != null)
				return false;
		} else if (!ticPaytype.equals(other.ticPaytype))
			return false;
		if (ticPrice != other.ticPrice)
			return false;
		if (ticSeatno == null) {
			if (other.ticSeatno != null)
				return false;
		} else if (!ticSeatno.equals(other.ticSeatno))
			return false;
		if (ticTotalcustomer != other.ticTotalcustomer)
			return false;
		return true;
	}
}