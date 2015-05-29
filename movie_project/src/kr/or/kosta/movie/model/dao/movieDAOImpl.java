package kr.or.kosta.movie.model.dao;


import kr.or.kosta.movie.vo.MovieVO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




@Repository
public class movieDAOImpl implements movieDAO {
	private String namespace = "kr.or.kosta.common.config.movieMapper.";
	@Autowired
	private SqlSessionTemplate session;
	
	
	//영화 등록 메소드
	@Override
	public int insertMovie(MovieVO movie) {
		System.out.println(movie.getTitle());
		System.out.println(movie.getSysnopsis());
		 return session.insert(namespace+"insertMovie",movie);
		
	}

	@Override
	public int modifyMovie(MovieVO movie) {
		return session.insert(namespace+"updateMovie",movie);
		
	}

	
}
