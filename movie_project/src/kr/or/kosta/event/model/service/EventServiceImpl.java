package kr.or.kosta.event.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.kosta.event.controller.PagingBean;
import kr.or.kosta.event.model.dao.EventDAO;
import kr.or.kosta.event.vo.EventVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDAO dao;
	
	@Override
	public List<EventVO> getEventList(){
		List<EventVO> list =dao.selectEventList();
		return list;
	}
	
	@Override
	public EventVO getEventByEvtNo(int evtNo) {
		EventVO vo=dao.selectEventByEvtNo(evtNo);
		return vo;
	}
	
	@Override
	public int registEvent(EventVO vo) {
		return dao.insertEvent(vo);
	}
	
	@Override
	public int setEvent(EventVO vo) {
		return dao.updateEvent(vo);
	}
	
	@Override
	public int removeEventByEventNumber(int evtNo) {
		return dao.deleteEventByEventNumber(evtNo);
	}
	
	
	/*
	 * 문자열 검색
	 */
	@Override
	public List<EventVO> searchEventByText(String text) {
		return dao.findEventByText(text);
	}
	
	
	/*
	 * 페이징 처리
	 */
	@Override
	public Map getEventListPaging(int pageNo) {
		//목록에 뿌려줄 List<EventVO>조회
		List<EventVO> list=dao.selectAllEventPaging(pageNo);
		//PagingBean생성
		int totalContent =dao.selectTotalEventCount();
		PagingBean pagingBean= new PagingBean(totalContent, pageNo);
		//두개의 값(List, PagingBean)을 Map에 넣어 return
		HashMap map = new HashMap();
		map.put("event_list", list);
		map.put("pagingBean",pagingBean);
		return map;
	}
}
