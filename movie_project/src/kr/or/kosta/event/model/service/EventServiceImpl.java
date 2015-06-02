package kr.or.kosta.event.model.service;

import java.util.List;

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
}
