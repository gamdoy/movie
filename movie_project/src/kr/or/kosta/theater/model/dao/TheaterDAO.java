package kr.or.kosta.theater.model.dao;

import java.util.List;

import kr.or.kosta.theater.vo.TheaterVO;

public interface TheaterDAO {
	/**
	 * Member 테이블의 전체 회원정보 조회 처리
	 * @return
	 */
	public abstract List<TheaterVO> selectAllMember();
}