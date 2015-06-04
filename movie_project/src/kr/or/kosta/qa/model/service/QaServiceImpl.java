package kr.or.kosta.qa.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.kosta.center.vo.QaVO;
import kr.or.kosta.event.vo.EventVO;
import kr.or.kosta.qa.model.dao.QaDAO;

@Service
public class QaServiceImpl implements QaService{
	
	@Autowired
	private QaDAO dao;
	
	@Override
	public List<QaVO> getQaList() {
		List<QaVO> list =dao.selectQaList();
		return list;
	}

	@Override
	public int registerQaList(QaVO vo) {
		return dao.insertEvent(vo);
	}

	@Override
	public QaVO getQa(int num) {
		QaVO vo = dao.selectQa(num);
		return vo;
	}
	
	
}
