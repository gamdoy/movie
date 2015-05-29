package kr.or.kosta.movie.model.service;

import kr.or.kosta.movie.vo.MovieVO;

public interface movieService {
	
	/**
	 * 영화 등록 메소드
	 * @param movie
	 */
	public abstract void registerMovie(MovieVO movie);
	
	/**
	 * 영화 수정 메소드
	 * @param movie
	 */
	public abstract void modifyMevie(MovieVO movie);

}
