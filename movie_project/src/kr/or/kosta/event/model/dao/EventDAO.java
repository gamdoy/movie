package kr.or.kosta.event.model.dao;

import java.util.List;

import kr.or.kosta.event.vo.EventVO;


public interface EventDAO {

	public abstract List<EventVO> selectEventList();
	
	public abstract EventVO selectEventByEvtNo(int evtNo);
	
	public abstract int insertEvent(EventVO vo);
	
	public abstract int updateEvent(EventVO vo);
	
	public abstract int deleteEventByEventNumber(int evtNo);
	
	/**
	 * Event 테이블의 페이징 처리 전체 이벤트 조회 처리
	 * @param pageNo 조회할 페이지 번호
	 * @return
	 */
	public abstract List<EventVO> selectAllEventPaging(int pageNo);
	
	public abstract int selectTotalEventCount();
}
