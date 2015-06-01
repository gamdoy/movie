package kr.or.kosta.movie.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.kosta.movie.model.dao.movieDAO;
import kr.or.kosta.movie.vo.ActorVO;
import kr.or.kosta.movie.vo.DirectorVO;
import kr.or.kosta.movie.vo.MovieVO;
import kr.or.kosta.movie.vo.ProductionVO;
@Service
public class movieServiceImpl implements movieService {
	
	@Autowired
	private movieDAO dao;

	@Override
	public void registerMovie(MovieVO movie) {
		dao.insertMovie(movie);
		
	}

	@Override
	public void modifyMovie(MovieVO movie) {
		dao.insertMovie(movie);
		
	}

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