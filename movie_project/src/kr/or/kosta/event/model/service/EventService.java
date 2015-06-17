package kr.or.kosta.event.model.service;

import java.util.List;
import java.util.Map;

import kr.or.kosta.center.vo.QaVO;
import kr.or.kosta.event.vo.EventVO;
import kr.or.kosta.event.vo.WinnerVO;


public interface EventService {
	
	public abstract List<EventVO> getEventList();
	
	public abstract List<EventVO> getEndEventList();
	
	public abstract EventVO getEventByEvtNo(int evtNo);
	
	public int registEvent(EventVO vo);
	
	public int setEvent(EventVO vo);
	
	public int removeEventByEventNumber(int evtNo);
	
	/*
	 * 문자열 검색
	 */
	public List<EventVO> searchEventByText(String text);
	
	public List<EventVO> searchEndEventByText(String text);
	
	/*
	 *페이징 처리
	 */
	//public abstract Map getEventListPaging(int pageNo);
	
	public abstract Map getWinnerListPaging(int pageNo);
	
	/*
	 * 당첨자 게시판 
	 */
	
	public abstract WinnerVO getWinnerByWinNo(int winNo);
	
	public int deleteWinner(int winNo);
	
	public int modifyWinner(WinnerVO vo);
	
	public int insertWinner(WinnerVO vo);
}
