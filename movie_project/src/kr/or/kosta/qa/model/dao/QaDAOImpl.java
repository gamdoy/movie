package kr.or.kosta.qa.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.kosta.admin.vo.AdminVO;
import kr.or.kosta.center.vo.CommentVO;
import kr.or.kosta.center.vo.QaVO;
import kr.or.kosta.common.vo.SearchVO;
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

	@Override
	public List<QaVO> selectQaBySearchVO(SearchVO svo){
		return session.selectList(namespace+"selectQaBySearchVO", svo);
	}

	@Override
	public List<QaVO> selectQaBySearchVOPaging(SearchVO svo, int page) {
		Map param = new HashMap();
		param.put("contentsPerPage", PagingBean.CONTENTS_PER_PAGE);
		param.put("pageNo", page);
		param.put("searchType", svo.getSearchType());
		param.put("searchKeyword", svo.getSearchKeyword());
		List<QaVO> list = session.selectList(namespace+"selectQaBySearchVOPaging", param);
		return list;
	}
	@Override
	public int selectSearchQaCount(SearchVO svo) {
		
		return session.selectOne(namespace+"selectSearchQaCount", svo);
	}

	@Override
	public int updateReply(QaVO vo) {
		return session.update(namespace+"updateReply",vo);
	}
	
	@Override
	public int registerComment(CommentVO cvo) {
		return session.insert(namespace+ "insertComment", cvo);
	}
	@Override
	public List<CommentVO> getComment(int fqNo) {
		return session.selectList(namespace+"selectComment",fqNo);
	}

	@Override
	public int deleteComment(int comNo) {
		return session.delete(namespace+"deleteComment",comNo);
	}

	@Override
	public CommentVO getCommentByComNo(int comNo) {
		
		return session.selectOne(namespace+"getCommentByComNo",comNo);
	}

	@Override
	public int modifyComment(CommentVO cvo) {
		return session.update(namespace+"modifyComment", cvo);
	}

	@Override
	public int getCountComment(int fqNo) {
		return session.selectOne(namespace+"getCountComment", fqNo);
	}

	@Override
	public int register_reply(QaVO rvo) {
		return session.insert(namespace+"insertQa_Re",rvo);
	}

	@Override
	public int plusReplyStep() {
		return session.selectOne(namespace+"plusReplyStep");
	}

	@Override
	public int deleteFile(int fileNo) {
		return session.delete(namespace+"deleteFile", fileNo);
	}
	
}
