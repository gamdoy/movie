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
	public List<TheaterVO> selectAllTheater() {
		return session.selectList(namespace + "selectAllTheater");
	}

	/**
	 * 극장을 찾는 메소드
	 */
	@Override
	public TheaterVO selectTheaterByTheaNo(int theaNo) {
		return session.selectOne(namespace + "selectTheaterByTheaNo", theaNo);
	}

	/**
	 * 극장을 수정하는 메소드
	 */
	@Override
	public int updateTheater(TheaterVO vo) {
		return session.update(namespace + "updateTheater", vo);
	}

	/**
	 * 극장을 추가하는 메소드
	 */
	@Override
	public int insertTheater(TheaterVO vo) {
		return session.insert(namespace + "insertTheater", vo);
	}

}
