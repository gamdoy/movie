package kr.or.kosta.movie.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.kosta.movie.model.dao.movieDAO;
import kr.or.kosta.movie.vo.MovieVO;
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
	public List getCommoncode() {
		List list = dao.getCommoncode();
		return list;
	}

}
