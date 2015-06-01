package kr.or.kosta.movie.vo;

public class DirectorVO {
	private int dirNo;
	private String dirName;
	
	public DirectorVO() {
		super();
	}

	public DirectorVO(int dirNo, String dirName) {
		super();
		this.dirNo = dirNo;
		this.dirName = dirName;
	}

	public int getDirNo() {
		return dirNo;
	}

	public void setDirNo(int dirNo) {
		this.dirNo = dirNo;
	}

	public String getDirName() {
		return dirName;
	}

	public void setDirName(String dirName) {
		this.dirName = dirName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dirName == null) ? 0 : dirName.hashCode());
		result = prime * result + dirNo;
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
		DirectorVO other = (DirectorVO) obj;
		if (dirName == null) {
			if (other.dirName != null)
				return false;
		} else if (!dirName.equals(other.dirName))
			return false;
		if (dirNo != other.dirNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DirectorVO [dirNo=" + dirNo + ", dirName=" + dirName + "]";
	}

	
	
	
	

}
