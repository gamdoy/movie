package kr.or.kosta.movie.vo;

public class ProductionVO {
	private int proNo;
	private String proName;
	
	public ProductionVO() {
		super();
	}

	public ProductionVO(int proNo, String proName) {
		super();
		this.proNo = proNo;
		this.proName = proName;
	}

	public int getProNo() {
		return proNo;
	}

	public void setProNo(int proNo) {
		this.proNo = proNo;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((proName == null) ? 0 : proName.hashCode());
		result = prime * result + proNo;
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
		ProductionVO other = (ProductionVO) obj;
		if (proName == null) {
			if (other.proName != null)
				return false;
		} else if (!proName.equals(other.proName))
			return false;
		if (proNo != other.proNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductionVO [proNo=" + proNo + ", proName=" + proName + "]";
	}
	
}
