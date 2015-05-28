package src.kr.or.kosta.movie.model.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import src.kr.or.kosta.movie.vo.MovieVO;




@Repository
public class movieDAOImpl implements movieDAO {
	private String namespace = "com.domain.config.mapper.";
	private SqlSessionTemplate session;
	
	
	//영화 등록 메소드
	@Override
	public int insertMovie(MovieVO movie) {
		 return session.insert(namespace+"insertMovie",movie);
		
	}

	@Override
	public int modifyMovie(MovieVO movie) {
		return session.insert(namespace+"insertMovie",movie);
		
	}

	
}
