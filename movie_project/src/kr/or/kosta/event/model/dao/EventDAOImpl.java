package kr.or.kosta.event.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.kosta.event.controller.PagingBean;
import kr.or.kosta.event.vo.EventVO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EventDAOImpl implements EventDAO {
	private String namespace="event.dao.eventMapper.";
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public List<EventVO> selectEventList(){
		return session.selectList(namespace+"selectEventList");		
	}
	
	@Override
	public EventVO selectEventByEvtNo(int evtNo) {
		return session.selectOne(namespace+"selectEventByEvtNo",evtNo);
	}
	
	@Override
	public int insertEvent(EventVO vo) {
		return session.insert(namespace+ "insertEvent", vo);
	}
	
	@Override
	public int updateEvent(EventVO vo) {
		return session.update(namespace+ "updateEvent",vo);
	}
	
	@Override
	public int deleteEventByEventNumber(int evtNo) {
		return session.delete(namespace+"deleteEventByEventNumber",evtNo);
	}
	
	@Override
	public List<EventVO> selectAllEventPaging(int pageNo) {
		Map param = new HashMap();
		param.put("contentsPerPage", PagingBean.CONTENTS_PER_PAGE);
		param.put("pageNo", pageNo);
		return session.selectList(namespace+"selectAllEventPaging", param);
	}
	
	@Override
	public int selectTotalEventCount() {
		return session.selectOne(namespace+"selectTotalEventCount");
	}
}
