package kr.or.kosta.movie.model.service;

import java.util.List;

import kr.or.kosta.movie.vo.ActorVO;
import kr.or.kosta.movie.vo.DirectorVO;
import kr.or.kosta.movie.vo.MovieVO;
import kr.or.kosta.movie.vo.ProductionVO;

public interface MovieService {

	//영화등록 
	public abstract void registerMovie(MovieVO movie);
	//영화수정
	public abstract void updateMovie(MovieVO movie);
	//no로 영화조회
	public abstract MovieVO getMovieByNo(String movNo);
	//모든영화 조회
	public abstract List<MovieVO> allMovieList();
	
	//개별table 감독 조회
	public abstract List<DirectorVO> getDirector();
	//개별table 배우 조회
	public abstract List<ActorVO> getActor();
	//개별table 제작사 조회
	public abstract List<ProductionVO> getProduction();
	
	

}
