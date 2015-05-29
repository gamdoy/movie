package kr.or.kosta.common.vo;

/**
 * @author Computer
 *
 */
public class ZipcodeVO {
	private int zip_no;
	private String zip_zipcode;
	private String zip_sido;
	private String zip_sigoongoo;
	private String zip_eupmyundong;
	private String zip_dongli;
	private String zip_roadname;
	private int zip_buildingmno;
	private int zip_buildingsno;
	private String zip_buildingname;
	private String zip_san;
	private int zip_jibunmno;
	private int zip_jibunsno;
	private String keyword;
	
	public ZipcodeVO() {}

	public ZipcodeVO(int zip_no, String zip_zipcode, String zip_sido,
			String zip_sigoongoo, String zip_eupmyundong, String zip_dongli,
			String zip_roadname, int zip_buildingmno, int zip_buildingsno,
			String zip_buildingname, String zip_san, int zip_jibunmno,
			int zip_jibunsno, String keyword) {
		super();
		this.zip_no = zip_no;
		this.zip_zipcode = zip_zipcode;
		this.zip_sido = zip_sido;
		this.zip_sigoongoo = zip_sigoongoo;
		this.zip_eupmyundong = zip_eupmyundong;
		this.zip_dongli = zip_dongli;
		this.zip_roadname = zip_roadname;
		this.zip_buildingmno = zip_buildingmno;
		this.zip_buildingsno = zip_buildingsno;
		this.zip_buildingname = zip_buildingname;
		this.zip_san = zip_san;
		this.zip_jibunmno = zip_jibunmno;
		this.zip_jibunsno = zip_jibunsno;
		this.keyword = keyword;
	}

	public int getZip_no() {
		return zip_no;
	}

	public void setZip_no(int zip_no) {
		this.zip_no = zip_no;
	}

	public String getZip_zipcode() {
		return zip_zipcode;
	}

	public void setZip_zipcode(String zip_zipcode) {
		this.zip_zipcode = zip_zipcode;
	}

	public String getZip_sido() {
		return zip_sido;
	}

	public void setZip_sido(String zip_sido) {
		this.zip_sido = zip_sido;
	}

	public String getZip_sigoongoo() {
		return zip_sigoongoo;
	}

	public void setZip_sigoongoo(String zip_sigoongoo) {
		this.zip_sigoongoo = zip_sigoongoo;
	}

	public String getZip_eupmyundong() {
		return zip_eupmyundong;
	}

	public void setZip_eupmyundong(String zip_eupmyundong) {
		this.zip_eupmyundong = zip_eupmyundong;
	}

	public String getZip_dongli() {
		return zip_dongli;
	}

	public void setZip_dongli(String zip_dongli) {
		this.zip_dongli = zip_dongli;
	}

	public String getZip_roadname() {
		return zip_roadname;
	}

	public void setZip_roadname(String zip_roadname) {
		this.zip_roadname = zip_roadname;
	}

	public int getZip_buildingmno() {
		return zip_buildingmno;
	}

	public void setZip_buildingmno(int zip_buildingmno) {
		this.zip_buildingmno = zip_buildingmno;
	}

	public int getZip_buildingsno() {
		return zip_buildingsno;
	}

	public void setZip_buildingsno(int zip_buildingsno) {
		this.zip_buildingsno = zip_buildingsno;
	}

	public String getZip_buildingname() {
		return zip_buildingname;
	}

	public void setZip_buildingname(String zip_buildingname) {
		this.zip_buildingname = zip_buildingname;
	}

	public String getZip_san() {
		return zip_san;
	}

	public void setZip_san(String zip_san) {
		this.zip_san = zip_san;
	}

	public int getZip_jibunmno() {
		return zip_jibunmno;
	}

	public void setZip_jibunmno(int zip_jibunmno) {
		this.zip_jibunmno = zip_jibunmno;
	}

	public int getZip_jibunsno() {
		return zip_jibunsno;
	}

	public void setZip_jibunsno(int zip_jibunsno) {
		this.zip_jibunsno = zip_jibunsno;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "ZipcodeVO [zip_no=" + zip_no + ", zip_zipcode=" + zip_zipcode
				+ ", zip_sido=" + zip_sido + ", zip_sigoongoo=" + zip_sigoongoo
				+ ", zip_eupmyundong=" + zip_eupmyundong + ", zip_dongli="
				+ zip_dongli + ", zip_roadname=" + zip_roadname
				+ ", zip_buildingmno=" + zip_buildingmno + ", zip_buildingsno="
				+ zip_buildingsno + ", zip_buildingname=" + zip_buildingname
				+ ", zip_san=" + zip_san + ", zip_jibunmno=" + zip_jibunmno
				+ ", zip_jibunsno=" + zip_jibunsno + ", keyword=" + keyword
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
		result = prime * result + zip_buildingmno;
		result = prime
				* result
				+ ((zip_buildingname == null) ? 0 : zip_buildingname.hashCode());
		result = prime * result + zip_buildingsno;
		result = prime * result
				+ ((zip_dongli == null) ? 0 : zip_dongli.hashCode());
		result = prime * result
				+ ((zip_eupmyundong == null) ? 0 : zip_eupmyundong.hashCode());
		result = prime * result + zip_jibunmno;
		result = prime * result + zip_jibunsno;
		result = prime * result + zip_no;
		result = prime * result
				+ ((zip_roadname == null) ? 0 : zip_roadname.hashCode());
		result = prime * result + ((zip_san == null) ? 0 : zip_san.hashCode());
		result = prime * result
				+ ((zip_sido == null) ? 0 : zip_sido.hashCode());
		result = prime * result
				+ ((zip_sigoongoo == null) ? 0 : zip_sigoongoo.hashCode());
		result = prime * result
				+ ((zip_zipcode == null) ? 0 : zip_zipcode.hashCode());
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
		ZipcodeVO other = (ZipcodeVO) obj;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!keyword.equals(other.keyword))
			return false;
		if (zip_buildingmno != other.zip_buildingmno)
			return false;
		if (zip_buildingname == null) {
			if (other.zip_buildingname != null)
				return false;
		} else if (!zip_buildingname.equals(other.zip_buildingname))
			return false;
		if (zip_buildingsno != other.zip_buildingsno)
			return false;
		if (zip_dongli == null) {
			if (other.zip_dongli != null)
				return false;
		} else if (!zip_dongli.equals(other.zip_dongli))
			return false;
		if (zip_eupmyundong == null) {
			if (other.zip_eupmyundong != null)
				return false;
		} else if (!zip_eupmyundong.equals(other.zip_eupmyundong))
			return false;
		if (zip_jibunmno != other.zip_jibunmno)
			return false;
		if (zip_jibunsno != other.zip_jibunsno)
			return false;
		if (zip_no != other.zip_no)
			return false;
		if (zip_roadname == null) {
			if (other.zip_roadname != null)
				return false;
		} else if (!zip_roadname.equals(other.zip_roadname))
			return false;
		if (zip_san == null) {
			if (other.zip_san != null)
				return false;
		} else if (!zip_san.equals(other.zip_san))
			return false;
		if (zip_sido == null) {
			if (other.zip_sido != null)
				return false;
		} else if (!zip_sido.equals(other.zip_sido))
			return false;
		if (zip_sigoongoo == null) {
			if (other.zip_sigoongoo != null)
				return false;
		} else if (!zip_sigoongoo.equals(other.zip_sigoongoo))
			return false;
		if (zip_zipcode == null) {
			if (other.zip_zipcode != null)
				return false;
		} else if (!zip_zipcode.equals(other.zip_zipcode))
			return false;
		return true;
	}
}
