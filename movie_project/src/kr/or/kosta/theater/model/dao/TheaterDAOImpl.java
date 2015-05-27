package kr.or.kosta.theater.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.or.kosta.theater.vo.TheaterVO;

@Component
public class TheaterDAOImpl implements TheaterDAO {
	private String namespace="theater.dao.theaterMapper.";
	
	/**
	 * SqlSession을 받기 위한 SqlSessionTemplate 
	 */
	@Autowired
	private SqlSessionTemplate session;
	
	/**
	 * 전체 극장리스트를 받는 메소드
	 */
	@Override
	public List<TheaterVO> selectAllMember() {
		return session.selectList(namespace + "selectAllTheater");
	}

}
