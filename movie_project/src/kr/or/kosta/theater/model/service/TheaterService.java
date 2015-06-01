package kr.or.kosta.theater.model.service;

import java.util.List;

import kr.or.kosta.theater.vo.TheaterVO;

public interface TheaterService {
	public List<TheaterVO> getTheaterList();

	public TheaterVO getTheater(int theaNo);

	public int setTheater(TheaterVO vo);

	public int registTheater(TheaterVO vo);
}