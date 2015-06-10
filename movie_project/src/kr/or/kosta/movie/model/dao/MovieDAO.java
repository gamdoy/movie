package kr.or.kosta.movie.model.dao;

import java.util.List;
import java.util.Map;

import kr.or.kosta.movie.vo.ActorVO;
import kr.or.kosta.movie.vo.DirectorVO;
import kr.or.kosta.movie.vo.MovieVO;
import kr.or.kosta.movie.vo.ProductionVO;

public interface MovieDAO {
	
	//영화등록
	public abstract int insertMovie(MovieVO movie);
	//영화수정
	public abstract int updateMovie(MovieVO movie);
	//movNo로 영화조회
	public abstract MovieVO getMovieByNo(String movNo);
	//모든영화 조회-paging
	public abstract List<MovieVO> allMovieList(int pageNo);
	//모든영화 카운트
	public abstract int totalCount();
	
	//개별table 감독 조회
	public abstract List<DirectorVO> getDirector();
	//개별table 배우 조회
	public abstract List<ActorVO> getActor();
	//개별table 제작사 조회
	public abstract List<ProductionVO> getProduction();
	
	

 
}
