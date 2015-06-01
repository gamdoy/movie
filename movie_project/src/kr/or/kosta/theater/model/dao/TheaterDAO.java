package kr.or.kosta.theater.model.dao;

import java.util.List;

import kr.or.kosta.theater.vo.TheaterVO;

public interface TheaterDAO {
	/**
	 * Theater 테이블의 전체 극장 조회 처리
	 * @return
	 */
	public abstract List<TheaterVO> selectAllTheater();

	/**
	 * Theater 테이블의 전체 극장 조회 처리
	 * @param theaNo 
	 * @return
	 */
	public abstract TheaterVO selectTheaterByTheaNo(int theaNo);

	public abstract int updateTheater(TheaterVO vo);

	public abstract int insertTheater(TheaterVO vo);
}