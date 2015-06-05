package kr.or.kosta.event.model.service;

import java.util.List;
import java.util.Map;

import kr.or.kosta.event.vo.EventVO;


public interface EventService {
	
	public abstract List<EventVO> getEventList();
	
	public abstract EventVO getEventByEvtNo(int evtNo);
	
	public int registEvent(EventVO vo);
	
	public int setEvent(EventVO vo);
	
	public int removeEventByEventNumber(int evtNo);
	
	/*
	 * 문자열 검색
	 */
	public List<EventVO> searchEventByText(String text);
	
	/*
	 *페이징 처리
	 */
	public abstract Map getEventListPaging(int pageNo);
}
