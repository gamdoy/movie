package kr.or.kosta.theater.model.service;

import java.util.List;

import kr.or.kosta.theater.model.dao.TheaterDAO;
import kr.or.kosta.theater.vo.TheaterVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterServiceImpl implements TheaterService {
	
	@Autowired
	private TheaterDAO dao;
	
	/**
	 * 전체 극장리스트를 받는 메소드
	 */
	@Override
	public List<TheaterVO> getTheaterList(){
		return dao.selectAllTheater();
	}

	/**
	 * 극장을 찾는 메소드
	 */
	@Override
	public TheaterVO getTheater(int theaNo) {
		return dao.selectTheaterByTheaNo(theaNo);
	}

	/**
	 * 극장을 수정하는 메소드
	 */
	@Override
	public int setTheater(TheaterVO vo) {
		return dao.updateTheater(vo);
	}

	/**
	 * 극장을 생성하는 메소드
	 */
	@Override
	public int registTheater(TheaterVO vo) {
		return dao.insertTheater(vo);
	}
}
