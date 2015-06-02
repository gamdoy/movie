package kr.or.kosta.event.model.dao;

import java.util.List;

import kr.or.kosta.event.vo.EventVO;

public interface EventDAO {

	public abstract List<EventVO> selectEventList();
	
	public abstract EventVO selectEventByEvtNo(int evtNo);
}
