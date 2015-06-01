package kr.or.kosta.movie.model.service;

import java.util.List;

import kr.or.kosta.movie.vo.ActorVO;
import kr.or.kosta.movie.vo.DirectorVO;
import kr.or.kosta.movie.vo.MovieVO;
import kr.or.kosta.movie.vo.ProductionVO;

public interface movieService {

	/**
	 * 영화 등록 메소드
	 * 
	 * @param movie
	 */
	public abstract void registerMovie(MovieVO movie);

	/**
	 * 영화 수정 메소드
	 * 
	 * @param movie
	 */
	public abstract void modifyMovie(MovieVO movie);
	
	public List<DirectorVO> getDirector();

	public List<ActorVO> getActor();

	public List<ProductionVO> getProduction();

}
