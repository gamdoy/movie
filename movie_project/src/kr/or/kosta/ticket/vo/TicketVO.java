package kr.or.kosta.ticket.vo;

public class TicketVO {
	private int ticNo;
	private String ticDate;
	private int ticPrice;
	private String ticPaytype;
	private String ticPaytypename;
	private String ticPaytypecode;
	private String ticSeatno;
	private String ticStatus;
	private String ticStatusname;
	private int ticTotalcustomer;
	private int memNo;
	private String memId;
	private int schNo;
	private String schDate;
	private int mrNo;
	private String mrName;
	private String mrScreentype;
	private String mrScreenname;
	private int mrLine;
	private int mrSeat;
	private int theaNo;
	private String theaLocation;
	private String movTitle;
	private String movNo;
	
	public TicketVO() {}

	public TicketVO(int ticNo, String ticDate, int ticPrice, String ticPaytype,
			String ticPaytypename, String ticPaytypecode, String ticSeatno,
			String ticStatus, String ticStatusname, int ticTotalcustomer,
			int memNo, String memId, int schNo, String schDate, int mrNo,
			String mrName, String mrScreentype, String mrScreenname,
			int mrLine, int mrSeat, int theaNo, String theaLocation,
			String movTitle, String movNo) {
		this.ticNo = ticNo;
		this.ticDate = ticDate;
		this.ticPrice = ticPrice;
		this.ticPaytype = ticPaytype;
		this.ticPaytypename = ticPaytypename;
		this.ticPaytypecode = ticPaytypecode;
		this.ticSeatno = ticSeatno;
		this.ticStatus = ticStatus;
		this.ticStatusname = ticStatusname;
		this.ticTotalcustomer = ticTotalcustomer;
		this.memNo = memNo;
		this.memId = memId;
		this.schNo = schNo;
		this.schDate = schDate;
		this.mrNo = mrNo;
		this.mrName = mrName;
		this.mrScreentype = mrScreentype;
		this.mrScreenname = mrScreenname;
		this.mrLine = mrLine;
		this.mrSeat = mrSeat;
		this.theaNo = theaNo;
		this.theaLocation = theaLocation;
		this.movTitle = movTitle;
		this.movNo = movNo;
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

	public String getTicPaytypename() {
		return ticPaytypename;
	}

	public void setTicPaytypename(String ticPaytypename) {
		this.ticPaytypename = ticPaytypename;
	}

	public String getTicPaytypecode() {
		return ticPaytypecode;
	}

	public void setTicPaytypecode(String ticPaytypecode) {
		this.ticPaytypecode = ticPaytypecode;
	}

	public String getTicSeatno() {
		return ticSeatno;
	}

	public void setTicSeatno(String ticSeatno) {
		this.ticSeatno = ticSeatno;
	}

	public String getTicStatus() {
		return ticStatus;
	}

	public void setTicStatus(String ticStatus) {
		this.ticStatus = ticStatus;
	}

	public String getTicStatusname() {
		return ticStatusname;
	}

	public void setTicStatusname(String ticStatusname) {
		this.ticStatusname = ticStatusname;
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

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
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

	public String getTheaLocation() {
		return theaLocation;
	}

	public void setTheaLocation(String theaLocation) {
		this.theaLocation = theaLocation;
	}

	public String getMovTitle() {
		return movTitle;
	}

	public void setMovTitle(String movTitle) {
		this.movTitle = movTitle;
	}

	public String getMovNo() {
		return movNo;
	}

	public void setMovNo(String movNo) {
		this.movNo = movNo;
	}

	@Override
	public String toString() {
		return "TicketVO [ticNo=" + ticNo + ", ticDate=" + ticDate
				+ ", ticPrice=" + ticPrice + ", ticPaytype=" + ticPaytype
				+ ", ticPaytypename=" + ticPaytypename + ", ticPaytypecode="
				+ ticPaytypecode + ", ticSeatno=" + ticSeatno + ", ticStatus="
				+ ticStatus + ", ticStatusname=" + ticStatusname
				+ ", ticTotalcustomer=" + ticTotalcustomer + ", memNo=" + memNo
				+ ", memId=" + memId + ", schNo=" + schNo + ", schDate="
				+ schDate + ", mrNo=" + mrNo + ", mrName=" + mrName
				+ ", mrScreentype=" + mrScreentype + ", mrScreenname="
				+ mrScreenname + ", mrLine=" + mrLine + ", mrSeat=" + mrSeat
				+ ", theaNo=" + theaNo + ", theaLocation=" + theaLocation
				+ ", movTitle=" + movTitle + ", movNo=" + movNo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memId == null) ? 0 : memId.hashCode());
		result = prime * result + memNo;
		result = prime * result + ((movNo == null) ? 0 : movNo.hashCode());
		result = prime * result
				+ ((movTitle == null) ? 0 : movTitle.hashCode());
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
		result = prime * result
				+ ((theaLocation == null) ? 0 : theaLocation.hashCode());
		result = prime * result + theaNo;
		result = prime * result + ((ticDate == null) ? 0 : ticDate.hashCode());
		result = prime * result + ticNo;
		result = prime * result
				+ ((ticPaytype == null) ? 0 : ticPaytype.hashCode());
		result = prime * result
				+ ((ticPaytypecode == null) ? 0 : ticPaytypecode.hashCode());
		result = prime * result
				+ ((ticPaytypename == null) ? 0 : ticPaytypename.hashCode());
		result = prime * result + ticPrice;
		result = prime * result
				+ ((ticSeatno == null) ? 0 : ticSeatno.hashCode());
		result = prime * result
				+ ((ticStatus == null) ? 0 : ticStatus.hashCode());
		result = prime * result
				+ ((ticStatusname == null) ? 0 : ticStatusname.hashCode());
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
		if (memId == null) {
			if (other.memId != null)
				return false;
		} else if (!memId.equals(other.memId))
			return false;
		if (memNo != other.memNo)
			return false;
		if (movNo == null) {
			if (other.movNo != null)
				return false;
		} else if (!movNo.equals(other.movNo))
			return false;
		if (movTitle == null) {
			if (other.movTitle != null)
				return false;
		} else if (!movTitle.equals(other.movTitle))
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
		if (theaLocation == null) {
			if (other.theaLocation != null)
				return false;
		} else if (!theaLocation.equals(other.theaLocation))
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
		if (ticPaytypecode == null) {
			if (other.ticPaytypecode != null)
				return false;
		} else if (!ticPaytypecode.equals(other.ticPaytypecode))
			return false;
		if (ticPaytypename == null) {
			if (other.ticPaytypename != null)
				return false;
		} else if (!ticPaytypename.equals(other.ticPaytypename))
			return false;
		if (ticPrice != other.ticPrice)
			return false;
		if (ticSeatno == null) {
			if (other.ticSeatno != null)
				return false;
		} else if (!ticSeatno.equals(other.ticSeatno))
			return false;
		if (ticStatus == null) {
			if (other.ticStatus != null)
				return false;
		} else if (!ticStatus.equals(other.ticStatus))
			return false;
		if (ticStatusname == null) {
			if (other.ticStatusname != null)
				return false;
		} else if (!ticStatusname.equals(other.ticStatusname))
			return false;
		if (ticTotalcustomer != other.ticTotalcustomer)
			return false;
		return true;
	}
}