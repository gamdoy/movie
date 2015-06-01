package kr.or.kosta.movie.model.dao;

import java.util.List;

import kr.or.kosta.movie.vo.ActorVO;
import kr.or.kosta.movie.vo.DirectorVO;
import kr.or.kosta.movie.vo.MovieVO;
import kr.or.kosta.movie.vo.ProductionVO;

public interface movieDAO {

	public int insertMovie(MovieVO movie);

	public int modifyMovie(MovieVO movie);


	public List<DirectorVO> getDirector();

	public List<ActorVO> getActor();

	public List<ProductionVO> getProduction();

}
