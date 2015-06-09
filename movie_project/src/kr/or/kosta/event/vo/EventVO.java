 package kr.or.kosta.event.vo;


import org.springframework.web.multipart.MultipartFile;


public class EventVO {
	private int evtNo;
	private String evtStartDate;
	private String evtEndDate;
	private String evtRegDate;
	private String evtTitle;
	private String evtContent;
	private String evtFile;
	
	private MultipartFile evtImageFile;
	
	public EventVO(){}

	public EventVO(int evtNo, String evtStartDate, String evtEndDate,
			String evtRegDate, String evtTitle, String evtContent,
			String evtFile, MultipartFile evtImageFile) {
		super();
		this.evtNo = evtNo;
		this.evtStartDate = evtStartDate;
		this.evtEndDate = evtEndDate;
		this.evtRegDate = evtRegDate;
		this.evtTitle = evtTitle;
		this.evtContent = evtContent;
		this.evtFile = evtFile;
		this.evtImageFile = evtImageFile;
	}

	@Override
	public String toString() {
		return "EventVO [evtNo=" + evtNo + ", evtStartDate=" + evtStartDate
				+ ", evtEndDate=" + evtEndDate + ", evtRegDate=" + evtRegDate
				+ ", evtTitle=" + evtTitle + ", evtContent=" + evtContent
				+ ", evtFile=" + evtFile + ", evtImageFile=" + evtImageFile
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((evtContent == null) ? 0 : evtContent.hashCode());
		result = prime * result
				+ ((evtEndDate == null) ? 0 : evtEndDate.hashCode());
		result = prime * result + ((evtFile == null) ? 0 : evtFile.hashCode());
		result = prime * result
				+ ((evtImageFile == null) ? 0 : evtImageFile.hashCode());
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
		if (evtContent == null) {
			if (other.evtContent != null)
				return false;
		} else if (!evtContent.equals(other.evtContent))
			return false;
		if (evtEndDate == null) {
			if (other.evtEndDate != null)
				return false;
		} else if (!evtEndDate.equals(other.evtEndDate))
			return false;
		if (evtFile == null) {
			if (other.evtFile != null)
				return false;
		} else if (!evtFile.equals(other.evtFile))
			return false;
		if (evtImageFile == null) {
			if (other.evtImageFile != null)
				return false;
		} else if (!evtImageFile.equals(other.evtImageFile))
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

	public int getEvtNo() {
		return evtNo;
	}

	public void setEvtNo(int evtNo) {
		this.evtNo = evtNo;
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

	public String getEvtContent() {
		return evtContent;
	}

	public void setEvtContent(String evtContent) {
		this.evtContent = evtContent;
	}

	public String getEvtFile() {
		return evtFile;
	}

	public void setEvtFile(String evtFile) {
		this.evtFile = evtFile;
	}

	public MultipartFile getEvtImageFile() {
		return evtImageFile;
	}

	public void setEvtImageFile(MultipartFile evtImageFile) {
		this.evtImageFile = evtImageFile;
	}

	
}
