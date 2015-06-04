package kr.or.kosta.admin.vo;

import kr.or.kosta.coupon.vo.CouponVO;

public class AdminVO {
	private int memNo;
	private String memberId;
	private String memberName;
	private String memberBirthdate;
	private String memberEmail;
	private String memberPhone;
	private int memberMileage;
	private String memberType;
	private String memberJoindate;
	private CouponVO coupon;
	
	public AdminVO() {
		// TODO Auto-generated constructor stub
	}

	public AdminVO(int memNo, String memberId, String memberName,
			String memberBirthdate, String memberEmail, String memberPhone,
			int memberMileage, String memberType, String memberJoindate,
			CouponVO coupon) {
		super();
		this.memNo = memNo;
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberBirthdate = memberBirthdate;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.memberMileage = memberMileage;
		this.memberType = memberType;
		this.memberJoindate = memberJoindate;
		this.coupon = coupon;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberBirthdate() {
		return memberBirthdate;
	}

	public void setMemberBirthdate(String memberBirthdate) {
		this.memberBirthdate = memberBirthdate;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public int getMemberMileage() {
		return memberMileage;
	}

	public void setMemberMileage(int memberMileage) {
		this.memberMileage = memberMileage;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public String getMemberJoindate() {
		return memberJoindate;
	}

	public void setMemberJoindate(String memberJoindate) {
		this.memberJoindate = memberJoindate;
	}

	public CouponVO getCoupon() {
		return coupon;
	}

	public void setCoupon(CouponVO coupon) {
		this.coupon = coupon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coupon == null) ? 0 : coupon.hashCode());
		result = prime * result + memNo;
		result = prime * result
				+ ((memberBirthdate == null) ? 0 : memberBirthdate.hashCode());
		result = prime * result
				+ ((memberEmail == null) ? 0 : memberEmail.hashCode());
		result = prime * result
				+ ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result
				+ ((memberJoindate == null) ? 0 : memberJoindate.hashCode());
		result = prime * result + memberMileage;
		result = prime * result
				+ ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result
				+ ((memberPhone == null) ? 0 : memberPhone.hashCode());
		result = prime * result
				+ ((memberType == null) ? 0 : memberType.hashCode());
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
		AdminVO other = (AdminVO) obj;
		if (coupon == null) {
			if (other.coupon != null)
				return false;
		} else if (!coupon.equals(other.coupon))
			return false;
		if (memNo != other.memNo)
			return false;
		if (memberBirthdate == null) {
			if (other.memberBirthdate != null)
				return false;
		} else if (!memberBirthdate.equals(other.memberBirthdate))
			return false;
		if (memberEmail == null) {
			if (other.memberEmail != null)
				return false;
		} else if (!memberEmail.equals(other.memberEmail))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (memberJoindate == null) {
			if (other.memberJoindate != null)
				return false;
		} else if (!memberJoindate.equals(other.memberJoindate))
			return false;
		if (memberMileage != other.memberMileage)
			return false;
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		if (memberPhone == null) {
			if (other.memberPhone != null)
				return false;
		} else if (!memberPhone.equals(other.memberPhone))
			return false;
		if (memberType == null) {
			if (other.memberType != null)
				return false;
		} else if (!memberType.equals(other.memberType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AdminVO [memNo=" + memNo + ", memberId=" + memberId
				+ ", memberName=" + memberName + ", memberBirthdate="
				+ memberBirthdate + ", memberEmail=" + memberEmail
				+ ", memberPhone=" + memberPhone + ", memberMileage="
				+ memberMileage + ", memberType=" + memberType
				+ ", memberJoindate=" + memberJoindate + ", coupon=" + coupon
				+ "]";
	}

	
}
