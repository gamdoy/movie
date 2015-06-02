package kr.or.kosta.event.model.dao;

import java.util.List;

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
}
