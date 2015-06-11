package kr.or.kosta.movie.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.kosta.event.controller.PagingBean;
import kr.or.kosta.movie.model.dao.MovieDAO;
import kr.or.kosta.movie.vo.ActorVO;
import kr.or.kosta.movie.vo.DirectorVO;
import kr.or.kosta.movie.vo.MovieVO;
import kr.or.kosta.movie.vo.ProductionVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieDAO dao;
	
	//영화등록
	@Override
	public int registerMovie(MovieVO movie) {
		return dao.insertMovie(movie);
	}
	//영화수정
	@Override
	public int updateMovie(MovieVO movie){
		return dao.updateMovie(movie);
	}
	//모든영화 조회-paging
	@Override
	public Map allMovieList(int pageNo) {
		//목록에 뿌려줄 List<MovieVO> 조회
		List<MovieVO> list = dao.allMovieList(pageNo);
		int count = dao.totalCount();
		//PagingBean 생성
		PagingBean pagingBean = new PagingBean(count, pageNo);
		//두개의 값(List, PagingBean)을 Map에 넣어 return
		HashMap map = new HashMap();
		map.put("movie", list);
		map.put("pagingBean", pagingBean);
		return map;
	}
	@Override
	public int totalCount() {
		return dao.totalCount();
	}
	//movNo로 영화조회
	@Override
	public MovieVO getMovieByNo(String movNo) {
		return dao.getMovieByNo(movNo);
	}
	
	
	//개별table 조회
	@Override
	public List<DirectorVO> getDirector() {
		return dao.getDirector();
	}
	@Override
	public List<ActorVO> getActor() {
		return dao.getActor();
	}
	@Override
	public List<ProductionVO> getProduction() {
		return dao.getProduction();
	}
	

	


	
	

}
