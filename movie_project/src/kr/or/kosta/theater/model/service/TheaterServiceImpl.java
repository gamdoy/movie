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
	public List<TheaterVO> test(){
		List<TheaterVO> list = dao.selectAllMember();
		return list;
	}
}
