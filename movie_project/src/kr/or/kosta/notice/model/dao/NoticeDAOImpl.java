package kr.or.kosta.notice.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.kosta.common.vo.SearchVO;
import kr.or.kosta.event.controller.PagingBean;
import kr.or.kosta.files.vo.FilesVo;
import kr.or.kosta.notice.vo.NoticeVO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAOImpl implements NoticeDAO{
	
	private String namespace="notice.dao.noticeMapper.";
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int deleteNotice(int num) {
		return session.delete(namespace+"deleteNotice", num);
	}
	
	@Override
	public int insertFiles(FilesVo svo) {
		return session.insert(namespace+"insertFiles", svo);
	}
	@Override
	public int insertNotice(NoticeVO vo) {
		return session.insert(namespace+ "insertNotice", vo);
	}
	@Override
	public int modifyCount(NoticeVO vo) {
		return session.update(namespace+"modifyCount", vo);	}
	
	@Override
	public int modifyFile(FilesVo svo) {
		return session.update(namespace+"modifyFile", svo);
	}
	
	@Override
	public int modifyNotice(NoticeVO vo) {
		return session.update(namespace+"modifyNotice", vo);
	}
	
	@Override
	public int modifyNoticeFileNumber(NoticeVO vo) {
		return session.update(namespace+"modify_Notice_FileNumber", vo);
	}
	
	@Override
	public List<NoticeVO> selectAllNoticePaging(int pageNo) {
		Map param = new HashMap();
		param.put("contentsPerPage", PagingBean.CONTENTS_PER_PAGE);
		param.put("pageNo", pageNo);
		List<NoticeVO> vo = session.selectList(namespace+"selectAllNoticePaging", param);
		return vo;
	}
	
	@Override
	public FilesVo selectFiles(int num) {
		return session.selectOne(namespace+"selectFiles", num);
	}
	
	@Override
	public NoticeVO selectNotice(int num) {
		return session.selectOne(namespace+"selectNotice", num);
	}
	
	@Override
	public List<NoticeVO> selectNoticeBySearchVO(SearchVO svo) {
		return session.selectList(namespace+"selectNoticeBySearchVO", svo);
	}
	
	@Override
	public List<NoticeVO> selectNoticeList() {
		return session.selectList(namespace+"selectNoticeList");		
	}
	
	@Override
	public int selectTotalNoticeCount() {
		return session.selectOne(namespace+"selectTotalNoticeCount");
	}
	
	
}
