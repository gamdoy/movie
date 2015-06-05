package kr.or.kosta.qa.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.kosta.center.vo.QaVO;
import kr.or.kosta.event.vo.EventVO;

@Repository
public class QaDAOImpl implements QaDAO{
	private String namespace="center.dao.centerMapper.";
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public List<QaVO> selectQaList() {	
		return session.selectList(namespace+"selectQaList");		
	}

	@Override
	public int insertEvent(QaVO vo) {
		return session.insert(namespace+ "insertQa", vo);
	}

	@Override
	public QaVO selectQa(int num) {
		return session.selectOne(namespace+"selectQa", num);
	}

	@Override
	public int deleteQa(int num) {
		return session.delete(namespace+"deleteQa", num);
	}

	@Override
	public int modifyQa(QaVO vo) {
		return session.update(namespace+"modifyQa", vo);
	}

	@Override
	public int modifyCount(QaVO vo) {
		return session.update(namespace+"modifyCount", vo);
	}
	
	
}
