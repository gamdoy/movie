package kr.or.kosta.movie.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.kosta.common.vo.SearchVO;
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
	public Map allMovieList(int pageNo,SearchVO vo) {
		//목록에 뿌려줄 List<MovieVO> 조회
		List<MovieVO> list = dao.allMovieList(pageNo, vo);
		int count = dao.totalCount(vo);
		System.out.println("토탈카운트 "+count);
		//PagingBean 생성
		PagingBean pagingBean = new PagingBean(count, pageNo);
		//두개의 값(List, PagingBean)을 Map에 넣어 return
		HashMap map = new HashMap();
		map.put("movie", list);
		map.put("pagingBean", pagingBean);
		return map;
	}
	//모든영화 조회
	@Override
	public List<MovieVO> selectMovieList() {
		return dao.selectMovieList();
	}
	@Override
	public int totalCount(SearchVO vo) {
		return dao.totalCount(vo);
	}
	//movNo로 영화조회
	@Override
	public MovieVO getMovieByNo(String movNo) {
		return dao.getMovieByNo(movNo);
	}
	//movNo로 영화조회-list
	public List<MovieVO> getMovieByNoList(String movNo){
		return dao.getMovieByNoList(movNo);
	}
	
	//관심영화
	public  int addFavorite(Map map){
		return dao.addFavorite(map);		
	}
	//관심영화 조회
	@Override
	public List selFavorite() {
		return dao.selFavorite();
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
