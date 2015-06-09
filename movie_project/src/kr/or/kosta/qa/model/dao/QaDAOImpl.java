package kr.or.kosta.qa.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.kosta.center.vo.QaVO;
import kr.or.kosta.event.controller.PagingBean;
import kr.or.kosta.event.vo.EventVO;
import kr.or.kosta.files.vo.FilesVo;

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

	@Override
	public int insertFiles(FilesVo svo) {
		return session.insert(namespace+"insertFiles", svo);
	}

	public FilesVo selectFiles(int num) {
		return session.selectOne(namespace+"selectFiles", num);
	}

	@Override
	public int modifyFile(FilesVo svo) {
		
		return session.update(namespace+"modifyFile", svo);
	}

	@Override
	public int modifyQaFileNumber(QaVO svo) {
		
		return session.update(namespace+"modify_Qa_FileNumber", svo);
		
	}

	public List<QaVO> selectAllQaPaging(int pageNo) {
		Map param = new HashMap();
		param.put("contentsPerPage", PagingBean.CONTENTS_PER_PAGE);
		System.out.println("contents per page : " +PagingBean.CONTENTS_PER_PAGE);
		param.put("pageNo", pageNo);
		System.out.println("pageNo : " + pageNo);
		List<QaVO> vo = session.selectList(namespace+"selectAllQaPaging", param);
		System.out.println("selectAllQaPaging : "+vo.size());
		return vo;
	}
	
	public int selectTotalQaCount(){
		return session.selectOne(namespace+"selectTotalQaCount");
	}

}
