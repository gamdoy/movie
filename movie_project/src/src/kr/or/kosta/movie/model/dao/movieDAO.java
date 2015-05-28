package src.kr.or.kosta.movie.model.dao;

import src.kr.or.kosta.movie.vo.MovieVO;


public interface movieDAO {
	
	public int insertMovie(MovieVO movie);
	
	public int modifyMovie(MovieVO movie);

}
