package kr.or.kosta.qa.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.kosta.admin.vo.AdminVO;
import kr.or.kosta.center.vo.CommentVO;
import kr.or.kosta.center.vo.QaVO;
import kr.or.kosta.common.vo.SearchVO;
import kr.or.kosta.event.controller.PagingBean;
import kr.or.kosta.event.vo.EventVO;
import kr.or.kosta.files.vo.FilesVo;
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
	public int modifyQaFileNumber(QaVO svo) {
		
		return dao.modifyQaFileNumber(svo);
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

	@Override
	public int deleteQa(int num) {
		return dao.deleteQa(num);
	}

	@Override
	public int modifyQa(QaVO vo) {
		return dao.modifyQa(vo);
	}

	@Override
	public int modifyCount(QaVO vo) {
		return dao.modifyCount(vo);
	}

	@Override
	public int insertFiles(FilesVo svo) {
		
		return dao.insertFiles(svo);
	}

	@Override
	public FilesVo selectFiles(int num) {
		
		return dao.selectFiles(num);
	}

	@Override
	public int modifyFile(FilesVo svo) {

		return dao.modifyFile(svo);
	}

	@Override
	public Map getQaListPaging(int pageNo) {
		//목록에 뿌려줄 List<EventVO>조회
		List<QaVO> list=dao.selectAllQaPaging(pageNo);
		//PagingBean생성
		int totalContent =dao.selectTotalQaCount();
		
		System.out.println("totalcontent : " +totalContent);
		PagingBean pagingBean= new PagingBean(totalContent, pageNo);
		//두개의 값(List, PagingBean)을 Map에 넣어 return
		HashMap map = new HashMap();
		map.put("qa_list", list);
		map.put("pagingBean",pagingBean);
		return map;
	}

	@Override
	public List<QaVO> selectQaBySearchVO(SearchVO svo) {
		// TODO Auto-generated method stub
		return dao.selectQaBySearchVO(svo);
	}
	
	@Override
	public HashMap selectQaBySearchVOPaging(SearchVO svo, int page) {
		List<QaVO> list = dao.selectQaBySearchVOPaging(svo, page);
		 int totalSearchContent = dao.selectSearchQaCount(svo);
		
		 System.out.println("totalContent "+totalSearchContent );
		 PagingBean pagingbean = new PagingBean(totalSearchContent, page);
		 HashMap map = new HashMap();
		 map.put("qa_list", list);
		 map.put("pagingBean", pagingbean);
		 System.out.println("서치페이징 현재페이지 : "+pagingbean.getCurrentPage());
		 return map;
	}

	@Override
	public int registerComment(CommentVO cvo) {
		return dao.registerComment(cvo);
	}

	@Override
	public List<CommentVO> getComment(int fqNo) {
		return dao.getComment(fqNo);
	}

	@Override
	public int deleteComment(int comNo) {
		return dao.deleteComment(comNo);
	}

	@Override
	public CommentVO getCommentByComNo(int comNo) {	
		return dao.getCommentByComNo(comNo);
	}

	@Override
	public int modifyComment(CommentVO cvo) {	
		return dao.modifyComment(cvo);
	}

	@Override
	public int getCountComment(int fqNo) {
		return dao.getCountComment(fqNo);
	}

	@Override
	public int register_reply(QaVO rvo) {
		
		return dao.register_reply(rvo);
	}
	
	@Override
	public int updateReply(QaVO vo) {
		return dao.updateReply(vo);
	}
}
