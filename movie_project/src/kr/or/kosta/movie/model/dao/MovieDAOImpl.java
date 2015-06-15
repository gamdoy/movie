package kr.or.kosta.movie.model.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.kosta.common.vo.SearchVO;
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
	public List<MovieVO> publicAllMovie(){
		
		return session.selectList(namespace+"selectMovieList");
		
	}
	//모든영화 조회-paging
	@Override
	public List<MovieVO> allMovieList(int pageNo, SearchVO vo) {
		Map param = new HashMap();
		param.put("contentsPerPage", PagingBean.CONTENTS_PER_PAGE);
		param.put("pageNo", pageNo);
		param.put("searchType", vo.getSearchType());
		param.put("searchKeyword", vo.getSearchKeyword());
		return session.selectList(namespace+"allMovie",param);
	}
	 //모든영화조회
	@Override
	public List<MovieVO> selectMovieList() {
		return session.selectList(namespace + "selectMovieList");
	}
	//모든영화 카운트
	@Override
	public int totalCount(SearchVO vo) {
		return session.selectOne(namespace+"totalMovieCount",vo);
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
