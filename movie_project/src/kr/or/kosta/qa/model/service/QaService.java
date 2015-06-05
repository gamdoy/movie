package kr.or.kosta.qa.model.service;

import java.util.List;

import kr.or.kosta.center.vo.QaVO;


public interface QaService {
	public abstract List<QaVO> getQaList();
	public abstract QaVO getQa(int num);
	public int registerQaList(QaVO vo);
	
	
}
