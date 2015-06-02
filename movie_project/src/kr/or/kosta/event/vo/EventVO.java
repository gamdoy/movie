 package kr.or.kosta.event.vo;

public class EventVO {
	private int evtNo;
	private String evtName;
	private String evtStartDate;
	private String evtEndDate;
	private String evtRegDate;
	private String evtTitle;
	
	public EventVO(){}

	public EventVO(int evtNo, String evtName, String evtStartDate,
			String evtEndDate, String evtRegDate, String evtTitle) {
		super();
		this.evtNo = evtNo;
		this.evtName = evtName;
		this.evtStartDate = evtStartDate;
		this.evtEndDate = evtEndDate;
		this.evtRegDate = evtRegDate;
		this.evtTitle = evtTitle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((evtEndDate == null) ? 0 : evtEndDate.hashCode());
		result = prime * result + ((evtName == null) ? 0 : evtName.hashCode());
		result = prime * result + evtNo;
		result = prime * result
				+ ((evtRegDate == null) ? 0 : evtRegDate.hashCode());
		result = prime * result
				+ ((evtStartDate == null) ? 0 : evtStartDate.hashCode());
		result = prime * result
				+ ((evtTitle == null) ? 0 : evtTitle.hashCode());
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
		EventVO other = (EventVO) obj;
		if (evtEndDate == null) {
			if (other.evtEndDate != null)
				return false;
		} else if (!evtEndDate.equals(other.evtEndDate))
			return false;
		if (evtName == null) {
			if (other.evtName != null)
				return false;
		} else if (!evtName.equals(other.evtName))
			return false;
		if (evtNo != other.evtNo)
			return false;
		if (evtRegDate == null) {
			if (other.evtRegDate != null)
				return false;
		} else if (!evtRegDate.equals(other.evtRegDate))
			return false;
		if (evtStartDate == null) {
			if (other.evtStartDate != null)
				return false;
		} else if (!evtStartDate.equals(other.evtStartDate))
			return false;
		if (evtTitle == null) {
			if (other.evtTitle != null)
				return false;
		} else if (!evtTitle.equals(other.evtTitle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EventVO [evtNo=" + evtNo + ", evtName=" + evtName
				+ ", evtStartDate=" + evtStartDate + ", evtEndDate="
				+ evtEndDate + ", evtRegDate=" + evtRegDate + ", evtTitle="
				+ evtTitle + "]";
	}

	public int getEvtNo() {
		return evtNo;
	}

	public void setEvtNo(int evtNo) {
		this.evtNo = evtNo;
	}

	public String getEvtName() {
		return evtName;
	}

	public void setEvtName(String evtName) {
		this.evtName = evtName;
	}

	public String getEvtStartDate() {
		return evtStartDate;
	}

	public void setEvtStartDate(String evtStartDate) {
		this.evtStartDate = evtStartDate;
	}

	public String getEvtEndDate() {
		return evtEndDate;
	}

	public void setEvtEndDate(String evtEndDate) {
		this.evtEndDate = evtEndDate;
	}

	public String getEvtRegDate() {
		return evtRegDate;
	}

	public void setEvtRegDate(String evtRegDate) {
		this.evtRegDate = evtRegDate;
	}

	public String getEvtTitle() {
		return evtTitle;
	}

	public void setEvtTitle(String evtTitle) {
		this.evtTitle = evtTitle;
	}
	
	
}
