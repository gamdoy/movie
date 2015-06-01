package kr.or.kosta.movie.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MovieVO {
	//기본정보
	private int movieNo;//영화번호
	private String title;//영화제목
	private String sysnopsis;//줄거리
	private String officialSite;//공식사이트
	private String screeningGrade;//영화등급
	private MultipartFile poster;//포스터
	private String posterName; //포스터 파일명
	private String intheaters;//개봉일
	private String runtime;//상영시간
	private String trailer;//트레일러
	private double movGrade;// 영화평점
	private int movCount; //참여인원
	private String genre; //장르

	
	
	
	//fk 
	private DirectorVO dirVo; //감독 객체
	private ActorVO actVo; //배우 객체
	private ProductionVO proVo; //제작사 객체
	
	public MovieVO() {
		super();
	}

	public MovieVO(int movieNo, String title, String sysnopsis,
			String officialSite, String screeningGrade, MultipartFile poster,
			String posterName, String intheaters, String runtime,
			String trailer, double movGrade, int movCount, String genre,
			DirectorVO dirVo, ActorVO actVo, ProductionVO proVo) {
		super();
		this.movieNo = movieNo;
		this.title = title;
		this.sysnopsis = sysnopsis;
		this.officialSite = officialSite;
		this.screeningGrade = screeningGrade;
		this.poster = poster;
		this.posterName = posterName;
		this.intheaters = intheaters;
		this.runtime = runtime;
		this.trailer = trailer;
		this.movGrade = movGrade;
		this.movCount = movCount;
		this.genre = genre;
		this.dirVo = dirVo;
		this.actVo = actVo;
		this.proVo = proVo;
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

	public String getSysnopsis() {
		return sysnopsis;
	}

	public void setSysnopsis(String sysnopsis) {
		this.sysnopsis = sysnopsis;
	}

	public String getOfficialSite() {
		return officialSite;
	}

	public void setOfficialSite(String officialSite) {
		this.officialSite = officialSite;
	}

	public String getScreeningGrade() {
		return screeningGrade;
	}

	public void setScreeningGrade(String screeningGrade) {
		this.screeningGrade = screeningGrade;
	}

	public MultipartFile getPoster() {
		return poster;
	}

	public void setPoster(MultipartFile poster) {
		this.poster = poster;
	}

	public String getPosterName() {
		return posterName;
	}

	public void setPosterName(String posterName) {
		this.posterName = posterName;
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

	public double getMovGrade() {
		return movGrade;
	}

	public void setMovGrade(double movGrade) {
		this.movGrade = movGrade;
	}

	public int getMovCount() {
		return movCount;
	}

	public void setMovCount(int movCount) {
		this.movCount = movCount;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public DirectorVO getDirVo() {
		return dirVo;
	}

	public void setDirVo(DirectorVO dirVo) {
		this.dirVo = dirVo;
	}

	public ActorVO getActVo() {
		return actVo;
	}

	public void setActVo(ActorVO actVo) {
		this.actVo = actVo;
	}

	public ProductionVO getProVo() {
		return proVo;
	}

	public void setProVo(ProductionVO proVo) {
		this.proVo = proVo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actVo == null) ? 0 : actVo.hashCode());
		result = prime * result + ((dirVo == null) ? 0 : dirVo.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result
				+ ((intheaters == null) ? 0 : intheaters.hashCode());
		result = prime * result + movCount;
		long temp;
		temp = Double.doubleToLongBits(movGrade);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + movieNo;
		result = prime * result
				+ ((officialSite == null) ? 0 : officialSite.hashCode());
		result = prime * result + ((poster == null) ? 0 : poster.hashCode());
		result = prime * result
				+ ((posterName == null) ? 0 : posterName.hashCode());
		result = prime * result + ((proVo == null) ? 0 : proVo.hashCode());
		result = prime * result + ((runtime == null) ? 0 : runtime.hashCode());
		result = prime * result
				+ ((screeningGrade == null) ? 0 : screeningGrade.hashCode());
		result = prime * result
				+ ((sysnopsis == null) ? 0 : sysnopsis.hashCode());
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
		if (actVo == null) {
			if (other.actVo != null)
				return false;
		} else if (!actVo.equals(other.actVo))
			return false;
		if (dirVo == null) {
			if (other.dirVo != null)
				return false;
		} else if (!dirVo.equals(other.dirVo))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (intheaters == null) {
			if (other.intheaters != null)
				return false;
		} else if (!intheaters.equals(other.intheaters))
			return false;
		if (movCount != other.movCount)
			return false;
		if (Double.doubleToLongBits(movGrade) != Double
				.doubleToLongBits(other.movGrade))
			return false;
		if (movieNo != other.movieNo)
			return false;
		if (officialSite == null) {
			if (other.officialSite != null)
				return false;
		} else if (!officialSite.equals(other.officialSite))
			return false;
		if (poster == null) {
			if (other.poster != null)
				return false;
		} else if (!poster.equals(other.poster))
			return false;
		if (posterName == null) {
			if (other.posterName != null)
				return false;
		} else if (!posterName.equals(other.posterName))
			return false;
		if (proVo == null) {
			if (other.proVo != null)
				return false;
		} else if (!proVo.equals(other.proVo))
			return false;
		if (runtime == null) {
			if (other.runtime != null)
				return false;
		} else if (!runtime.equals(other.runtime))
			return false;
		if (screeningGrade == null) {
			if (other.screeningGrade != null)
				return false;
		} else if (!screeningGrade.equals(other.screeningGrade))
			return false;
		if (sysnopsis == null) {
			if (other.sysnopsis != null)
				return false;
		} else if (!sysnopsis.equals(other.sysnopsis))
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
				+ ", sysnopsis=" + sysnopsis + ", officialSite=" + officialSite
				+ ", screeningGrade=" + screeningGrade + ", poster=" + poster
				+ ", posterName=" + posterName + ", intheaters=" + intheaters
				+ ", runtime=" + runtime + ", trailer=" + trailer
				+ ", movGrade=" + movGrade + ", movCount=" + movCount
				+ ", genre=" + genre + ", dirVo=" + dirVo + ", actVo=" + actVo
				+ ", proVo=" + proVo + "]";
	}
	

}