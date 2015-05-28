package src.kr.or.kosta.movie.vo;

public class MovieVO {
	//기본정보
	private int movieNo;//영화번호
	private String title;//영화제목
	private String synopsis;//줄거리
	private String officialsite;//공식사이트
	private String screeninggrade;//영화등급
	private String poster;//포스터
	private String intheaters;//개봉일
	private String runtime;//상영시간
	private String trailer;//트레일러
	private double grade;// 영화평점
	private int count; //참여인원
	
	//fk 
	private int dirNo; //감독번호
	private int actNo; //배우번호
	private int proNo; //제작사 번호
	
	public MovieVO() {
		super();
	}

	public MovieVO(int movieNo, String title, String synopsis,
			String officialSsite, String screeninggrade, String poster,
			String intheaters, String runtime, String trailer, double grade,
			int count) {
		super();
		this.movieNo = movieNo;
		this.title = title;
		this.synopsis = synopsis;
		this.officialsite = officialSsite;
		this.screeninggrade = screeninggrade;
		this.poster = poster;
		this.intheaters = intheaters;
		this.runtime = runtime;
		this.trailer = trailer;
		this.grade = grade;
		this.count = count;
	}

	public MovieVO(int movieNo, String title, String synopsis,
			String officialSsite, String screeninggrade, String poster,
			String intheaters, String runtime, String trailer, double grade,
			int count, int dirNo, int actNo, int proNo) {
		super();
		this.movieNo = movieNo;
		this.title = title;
		this.synopsis = synopsis;
		this.officialsite = officialSsite;
		this.screeninggrade = screeninggrade;
		this.poster = poster;
		this.intheaters = intheaters;
		this.runtime = runtime;
		this.trailer = trailer;
		this.grade = grade;
		this.count = count;
		this.dirNo = dirNo;
		this.actNo = actNo;
		this.proNo = proNo;
	}

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getOfficialSsite() {
		return officialsite;
	}

	public void setOfficialSsite(String officialSsite) {
		this.officialsite = officialSsite;
	}

	public String getScreeninggrade() {
		return screeninggrade;
	}

	public void setScreeninggrade(String screeninggrade) {
		this.screeninggrade = screeninggrade;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getIntheaters() {
		return intheaters;
	}

	public void setIntheaters(String intheaters) {
		this.intheaters = intheaters;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getDirNo() {
		return dirNo;
	}

	public void setDirNo(int dirNo) {
		this.dirNo = dirNo;
	}

	public int getActNo() {
		return actNo;
	}

	public void setActNo(int actNo) {
		this.actNo = actNo;
	}

	public int getProNo() {
		return proNo;
	}

	public void setProNo(int proNo) {
		this.proNo = proNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + actNo;
		result = prime * result + count;
		result = prime * result + dirNo;
		long temp;
		temp = Double.doubleToLongBits(grade);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((intheaters == null) ? 0 : intheaters.hashCode());
		result = prime * result + movieNo;
		result = prime * result
				+ ((officialsite == null) ? 0 : officialsite.hashCode());
		result = prime * result + ((poster == null) ? 0 : poster.hashCode());
		result = prime * result + proNo;
		result = prime * result + ((runtime == null) ? 0 : runtime.hashCode());
		result = prime * result
				+ ((screeninggrade == null) ? 0 : screeninggrade.hashCode());
		result = prime * result
				+ ((synopsis == null) ? 0 : synopsis.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((trailer == null) ? 0 : trailer.hashCode());
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
		MovieVO other = (MovieVO) obj;
		if (actNo != other.actNo)
			return false;
		if (count != other.count)
			return false;
		if (dirNo != other.dirNo)
			return false;
		if (Double.doubleToLongBits(grade) != Double
				.doubleToLongBits(other.grade))
			return false;
		if (intheaters == null) {
			if (other.intheaters != null)
				return false;
		} else if (!intheaters.equals(other.intheaters))
			return false;
		if (movieNo != other.movieNo)
			return false;
		if (officialsite == null) {
			if (other.officialsite != null)
				return false;
		} else if (!officialsite.equals(other.officialsite))
			return false;
		if (poster == null) {
			if (other.poster != null)
				return false;
		} else if (!poster.equals(other.poster))
			return false;
		if (proNo != other.proNo)
			return false;
		if (runtime == null) {
			if (other.runtime != null)
				return false;
		} else if (!runtime.equals(other.runtime))
			return false;
		if (screeninggrade == null) {
			if (other.screeninggrade != null)
				return false;
		} else if (!screeninggrade.equals(other.screeninggrade))
			return false;
		if (synopsis == null) {
			if (other.synopsis != null)
				return false;
		} else if (!synopsis.equals(other.synopsis))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (trailer == null) {
			if (other.trailer != null)
				return false;
		} else if (!trailer.equals(other.trailer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MovieVO [movieNo=" + movieNo + ", title=" + title
				+ ", synopsis=" + synopsis + ", officialSsite=" + officialsite
				+ ", screeninggrade=" + screeninggrade + ", poster=" + poster
				+ ", intheaters=" + intheaters + ", runtime=" + runtime
				+ ", trailer=" + trailer + ", grade=" + grade + ", count="
				+ count + ", dirNo=" + dirNo + ", actNo=" + actNo + ", proNo="
				+ proNo + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
