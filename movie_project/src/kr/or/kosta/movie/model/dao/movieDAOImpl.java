package kr.or.kosta.movie.model.dao;


import java.util.List;

import kr.or.kosta.movie.vo.ActorVO;
import kr.or.kosta.movie.vo.DirectorVO;
import kr.or.kosta.movie.vo.MovieVO;
import kr.or.kosta.movie.vo.ProductionVO;

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
	
		 return session.insert(namespace+"insertMovie",movie);
		
	}

	@Override
	public int modifyMovie(MovieVO movie) {
		return session.insert(namespace+"updateMovie",movie);
		
	}

	
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
