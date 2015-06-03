package kr.or.kosta.event.model.service;

import java.util.List;

import kr.or.kosta.event.vo.EventVO;


public interface EventService {
	
	public abstract List<EventVO> getEventList();
	
	public abstract EventVO getEventByEvtNo(int evtNo);
	
	public int registEvent(EventVO vo);
	
	public int setEvent(EventVO vo);
}
