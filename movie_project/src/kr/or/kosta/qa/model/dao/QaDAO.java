package kr.or.kosta.qa.model.dao;

import java.util.List;

import kr.or.kosta.center.vo.QaVO;

public interface QaDAO {

	List<QaVO> selectQaList();

	int insertEvent(QaVO vo);

	QaVO selectQa(int num);

	

}
