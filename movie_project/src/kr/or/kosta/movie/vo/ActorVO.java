package kr.or.kosta.movie.vo;

public class ActorVO {
	
	private int actNo;
	private String actName;
	
	public ActorVO() {
		super();
	}
	public ActorVO(int actNo, String actName) {
		super();
		this.actNo = actNo;
		this.actName = actName;
	}
	public int getActNo() {
		return actNo;
	}
	public void setActNo(int actNo) {
		this.actNo = actNo;
	}
	public String getActName() {
		return actName;
	}
	public void setActName(String actName) {
		this.actName = actName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actName == null) ? 0 : actName.hashCode());
		result = prime * result + actNo;
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
		ActorVO other = (ActorVO) obj;
		if (actName == null) {
			if (other.actName != null)
				return false;
		} else if (!actName.equals(other.actName))
			return false;
		if (actNo != other.actNo)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ActorVO [actNo=" + actNo + ", actName=" + actName + "]";
	}
	
}
