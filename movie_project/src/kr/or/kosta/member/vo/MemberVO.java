package kr.or.kosta.member.vo;

import java.io.Serializable;

public class MemberVO implements Serializable{

	private int memNo;
	private int zipNo;
	private int memMileage;
	private String zipZipcode;
	private String zipAddress;
	private String memId;
	private String memName;
	private String memPassword;
	private String memAddressDetail;
	private String memBirthDate;
	private String memEmail;
	private String memPhoneNo;
	private String memMemberType;
	private String memJoinDate;
	private String memLastLogin;
	
	public MemberVO() {
		super();
	}

	public MemberVO(int memNo, int zipNo, int memMileage, String zipZipcode,
			String zipAddress, String memId, String memName,
			String memPassword, String memAddressDetail, String memBirthDate,
			String memEmail, String memPhoneNo, String memMemberType,
			String memJoinDate, String memLastLogin) {
		super();
		this.memNo = memNo;
		this.zipNo = zipNo;
		this.memMileage = memMileage;
		this.zipZipcode = zipZipcode;
		this.zipAddress = zipAddress;
		this.memId = memId;
		this.memName = memName;
		this.memPassword = memPassword;
		this.memAddressDetail = memAddressDetail;
		this.memBirthDate = memBirthDate;
		this.memEmail = memEmail;
		this.memPhoneNo = memPhoneNo;
		this.memMemberType = memMemberType;
		this.memJoinDate = memJoinDate;
		this.memLastLogin = memLastLogin;
	}

	@Override
	public String toString() {
		return "MemberVO [memNo=" + memNo + ", zipNo=" + zipNo
				+ ", memMileage=" + memMileage + ", zipZipcode=" + zipZipcode
				+ ", zipAddress=" + zipAddress + ", memId=" + memId
				+ ", memName=" + memName + ", memPassword=" + memPassword
				+ ", memAddressDetail=" + memAddressDetail + ", memBirthDate="
				+ memBirthDate + ", memEmail=" + memEmail + ", memPhoneNo="
				+ memPhoneNo + ", memMemberType=" + memMemberType
				+ ", memJoinDate=" + memJoinDate + ", memLastLogin="
				+ memLastLogin + "]";
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public int getZipNo() {
		return zipNo;
	}

	public void setZipNo(int zipNo) {
		this.zipNo = zipNo;
	}

	public int getMemMileage() {
		return memMileage;
	}

	public void setMemMileage(int memMileage) {
		this.memMileage = memMileage;
	}

	public String getZipZipcode() {
		return zipZipcode;
	}

	public void setZipZipcode(String zipZipcode) {
		this.zipZipcode = zipZipcode;
	}

	public String getZipAddress() {
		return zipAddress;
	}

	public void setZipAddress(String zipAddress) {
		this.zipAddress = zipAddress;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemPassword() {
		return memPassword;
	}

	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
	}

	public String getMemAddressDetail() {
		return memAddressDetail;
	}

	public void setMemAddressDetail(String memAddressDetail) {
		this.memAddressDetail = memAddressDetail;
	}

	public String getMemBirthDate() {
		return memBirthDate;
	}

	public void setMemBirthDate(String memBirthDate) {
		this.memBirthDate = memBirthDate;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public String getMemPhoneNo() {
		return memPhoneNo;
	}

	public void setMemPhoneNo(String memPhoneNo) {
		this.memPhoneNo = memPhoneNo;
	}

	public String getMemMemberType() {
		return memMemberType;
	}

	public void setMemMemberType(String memMemberType) {
		this.memMemberType = memMemberType;
	}

	public String getMemJoinDate() {
		return memJoinDate;
	}

	public void setMemJoinDate(String memJoinDate) {
		this.memJoinDate = memJoinDate;
	}

	public String getMemLastLogin() {
		return memLastLogin;
	}

	public void setMemLastLogin(String memLastLogin) {
		this.memLastLogin = memLastLogin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((memAddressDetail == null) ? 0 : memAddressDetail.hashCode());
		result = prime * result
				+ ((memBirthDate == null) ? 0 : memBirthDate.hashCode());
		result = prime * result
				+ ((memEmail == null) ? 0 : memEmail.hashCode());
		result = prime * result + ((memId == null) ? 0 : memId.hashCode());
		result = prime * result
				+ ((memJoinDate == null) ? 0 : memJoinDate.hashCode());
		result = prime * result
				+ ((memLastLogin == null) ? 0 : memLastLogin.hashCode());
		result = prime * result
				+ ((memMemberType == null) ? 0 : memMemberType.hashCode());
		result = prime * result + memMileage;
		result = prime * result + ((memName == null) ? 0 : memName.hashCode());
		result = prime * result + memNo;
		result = prime * result
				+ ((memPassword == null) ? 0 : memPassword.hashCode());
		result = prime * result
				+ ((memPhoneNo == null) ? 0 : memPhoneNo.hashCode());
		result = prime * result
				+ ((zipAddress == null) ? 0 : zipAddress.hashCode());
		result = prime * result + zipNo;
		result = prime * result
				+ ((zipZipcode == null) ? 0 : zipZipcode.hashCode());
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
		MemberVO other = (MemberVO) obj;
		if (memAddressDetail == null) {
			if (other.memAddressDetail != null)
				return false;
		} else if (!memAddressDetail.equals(other.memAddressDetail))
			return false;
		if (memBirthDate == null) {
			if (other.memBirthDate != null)
				return false;
		} else if (!memBirthDate.equals(other.memBirthDate))
			return false;
		if (memEmail == null) {
			if (other.memEmail != null)
				return false;
		} else if (!memEmail.equals(other.memEmail))
			return false;
		if (memId == null) {
			if (other.memId != null)
				return false;
		} else if (!memId.equals(other.memId))
			return false;
		if (memJoinDate == null) {
			if (other.memJoinDate != null)
				return false;
		} else if (!memJoinDate.equals(other.memJoinDate))
			return false;
		if (memLastLogin == null) {
			if (other.memLastLogin != null)
				return false;
		} else if (!memLastLogin.equals(other.memLastLogin))
			return false;
		if (memMemberType == null) {
			if (other.memMemberType != null)
				return false;
		} else if (!memMemberType.equals(other.memMemberType))
			return false;
		if (memMileage != other.memMileage)
			return false;
		if (memName == null) {
			if (other.memName != null)
				return false;
		} else if (!memName.equals(other.memName))
			return false;
		if (memNo != other.memNo)
			return false;
		if (memPassword == null) {
			if (other.memPassword != null)
				return false;
		} else if (!memPassword.equals(other.memPassword))
			return false;
		if (memPhoneNo == null) {
			if (other.memPhoneNo != null)
				return false;
		} else if (!memPhoneNo.equals(other.memPhoneNo))
			return false;
		if (zipAddress == null) {
			if (other.zipAddress != null)
				return false;
		} else if (!zipAddress.equals(other.zipAddress))
			return false;
		if (zipNo != other.zipNo)
			return false;
		if (zipZipcode == null) {
			if (other.zipZipcode != null)
				return false;
		} else if (!zipZipcode.equals(other.zipZipcode))
			return false;
		return true;
	}
	

	
	
	
	
}
