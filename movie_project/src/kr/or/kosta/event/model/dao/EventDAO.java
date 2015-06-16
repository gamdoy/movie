package kr.or.kosta.event.model.dao;

import java.util.List;

import kr.or.kosta.center.vo.QaVO;
import kr.or.kosta.event.vo.EventVO;
import kr.or.kosta.event.vo.WinnerVO;


public interface EventDAO {

	public abstract List<EventVO> selectEventList();
	
	public abstract List<EventVO> selectEndEventList();
	
	public abstract EventVO selectEventByEvtNo(int evtNo);
	
	public abstract int insertEvent(EventVO vo);
	
	public abstract int updateEvent(EventVO vo);
	
	public abstract int deleteEventByEventNumber(int evtNo);
	
	/*
	 * 문자열 검색
	 */
	public abstract List<EventVO> findEventByText(String text);
	
	public abstract List<EventVO> findEndEventByText(String text);
	
	/**
	 * Event 테이블의 페이징 처리 전체 이벤트 조회 처리
	 * @param pageNo 조회할 페이지 번호
	 * @return
	 */
	public abstract List<EventVO> selectAllEventPaging(int pageNo);
	
	public abstract int selectTotalEventCount();
	
	public abstract int selectTotalWinnerCount();
	
	public List<WinnerVO> selectAllWinnerPaging(int pageNo); 
	
	/*
	 * 당첨자 게시판
	 */
	public abstract WinnerVO selectWinnerByWinNo(int winNo);
	
	public int deleteWinner(int winNo);
	
	public int modifyWinner(WinnerVO vo);
	
	public int insertWinner(WinnerVO vo);
}
