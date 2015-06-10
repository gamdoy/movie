package kr.or.kosta.movie.model.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.kosta.event.controller.PagingBean;
import kr.or.kosta.movie.vo.ActorVO;
import kr.or.kosta.movie.vo.DirectorVO;
import kr.or.kosta.movie.vo.MovieVO;
import kr.or.kosta.movie.vo.ProductionVO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




@Repository
public class MovieDAOImpl implements MovieDAO {
	private String namespace = "kr.or.kosta.common.config.movieMapper.";
	@Autowired
	private SqlSessionTemplate session;
	
	//영화등록
	@Override
	public int insertMovie(MovieVO movie) {
		 return session.insert(namespace+"insertMovie",movie);
	}
	//영화수정
	@Override
	public int updateMovie(MovieVO movie) {
		return session.update(namespace+"updateMovie",movie);
	}
	//movNo로 영화조회
	@Override
	public MovieVO getMovieByNo(String movNo) {
		return session.selectOne(namespace+"getMovieByNo",movNo);
	}
	//모든영화 조회-paging
	@Override
	public List<MovieVO> allMovieList(int pageNo) {
		Map param = new HashMap();
		param.put("contentsPerPage", PagingBean.CONTENTS_PER_PAGE);
		param.put("pageNo", pageNo);
		return session.selectList(namespace+"allMovie",pageNo);
	}
	 
	//모든영화 카운트
	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	//개별table 조회
	@Override
	public List<DirectorVO> getDirector() {
		return session.selectList(namespace+"director");
	}
	@Override
	public List<ActorVO> getActor() {
		return session.selectList(namespace+"actor");
	}
	@Override
	public List<ProductionVO> getProduction() {
		return session.selectList(namespace+"production");
	}

	
	



	
}
