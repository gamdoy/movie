package kr.or.kosta.coupon.vo;

public class CouponVO {
	private int coupNo;
	private int MemNo;
	private String coupType;
	private String coupUsed;
	private String coupTypeName;
	private String coupUsedValue;
	private String coupUsedDate;
	public CouponVO() {
		// TODO Auto-generated constructor stub
	}
	public CouponVO(int coupNo, int memNo, String coupType, String coupUsed,
			String coupTypeName, String coupUsedValue, String coupUsedDate) {
		super();
		this.coupNo = coupNo;
		MemNo = memNo;
		this.coupType = coupType;
		this.coupUsed = coupUsed;
		this.coupTypeName = coupTypeName;
		this.coupUsedValue = coupUsedValue;
		this.coupUsedDate = coupUsedDate;
	}
	public int getCoupNo() {
		return coupNo;
	}
	public void setCoupNo(int coupNo) {
		this.coupNo = coupNo;
	}
	public int getMemNo() {
		return MemNo;
	}
	public void setMemNo(int memNo) {
		MemNo = memNo;
	}
	public String getCoupType() {
		return coupType;
	}
	public void setCoupType(String coupType) {
		this.coupType = coupType;
	}
	public String getCoupUsed() {
		return coupUsed;
	}
	public void setCoupUsed(String coupUsed) {
		this.coupUsed = coupUsed;
	}
	public String getCoupTypeName() {
		return coupTypeName;
	}
	public void setCoupTypeName(String coupTypeName) {
		this.coupTypeName = coupTypeName;
	}
	public String getCoupUsedValue() {
		return coupUsedValue;
	}
	public void setCoupUsedValue(String coupUsedValue) {
		this.coupUsedValue = coupUsedValue;
	}
	public String getCoupUsedDate() {
		return coupUsedDate;
	}
	public void setCoupUsedDate(String coupUsedDate) {
		this.coupUsedDate = coupUsedDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + MemNo;
		result = prime * result + coupNo;
		result = prime * result
				+ ((coupType == null) ? 0 : coupType.hashCode());
		result = prime * result
				+ ((coupTypeName == null) ? 0 : coupTypeName.hashCode());
		result = prime * result
				+ ((coupUsed == null) ? 0 : coupUsed.hashCode());
		result = prime * result
				+ ((coupUsedDate == null) ? 0 : coupUsedDate.hashCode());
		result = prime * result
				+ ((coupUsedValue == null) ? 0 : coupUsedValue.hashCode());
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
		CouponVO other = (CouponVO) obj;
		if (MemNo != other.MemNo)
			return false;
		if (coupNo != other.coupNo)
			return false;
		if (coupType == null) {
			if (other.coupType != null)
				return false;
		} else if (!coupType.equals(other.coupType))
			return false;
		if (coupTypeName == null) {
			if (other.coupTypeName != null)
				return false;
		} else if (!coupTypeName.equals(other.coupTypeName))
			return false;
		if (coupUsed == null) {
			if (other.coupUsed != null)
				return false;
		} else if (!coupUsed.equals(other.coupUsed))
			return false;
		if (coupUsedDate == null) {
			if (other.coupUsedDate != null)
				return false;
		} else if (!coupUsedDate.equals(other.coupUsedDate))
			return false;
		if (coupUsedValue == null) {
			if (other.coupUsedValue != null)
				return false;
		} else if (!coupUsedValue.equals(other.coupUsedValue))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CouponVO [coupNo=" + coupNo + ", MemNo=" + MemNo
				+ ", coupType=" + coupType + ", coupUsed=" + coupUsed
				+ ", coupTypeName=" + coupTypeName + ", coupUsedValue="
				+ coupUsedValue + ", coupUsedDate=" + coupUsedDate + "]";
	}
}
	
	