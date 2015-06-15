package kr.or.kosta.notice.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.kosta.center.vo.QaVO;
import kr.or.kosta.common.vo.SearchVO;
import kr.or.kosta.event.controller.PagingBean;
import kr.or.kosta.files.vo.FilesVo;
import kr.or.kosta.notice.model.dao.NoticeDAO;
import kr.or.kosta.notice.vo.NoticeVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeDAO dao;
	
	@Override
	public Map getNoticeListPaging(int pageNo) {
		//목록에 뿌려줄 List<EventVO>조회
		List<NoticeVO> list=dao.selectAllNoticePaging(pageNo);
		//PagingBean생성
		int totalContent =dao.selectTotalNoticeCount();
		
		System.out.println("totalcontent : " +totalContent);
		PagingBean pagingBean= new PagingBean(totalContent, pageNo);
		//두개의 값(List, PagingBean)을 Map에 넣어 return
		HashMap map = new HashMap();
		map.put("notice_list", list);
		map.put("pagingBean",pagingBean);
		return map;
	}
	
	@Override
	public List<NoticeVO> getNoticeList() {
		List<NoticeVO> list =dao.selectNoticeList();
		return list;
	}
	
	@Override
	public NoticeVO getNotice(int num) {
		NoticeVO vo = dao.selectNotice(num);
		return vo;
	}
	
	@Override
	public List<NoticeVO> selectNoticeBySearchVO(SearchVO svo) {
		return dao.selectNoticeBySearchVO(svo);
	}
	
	@Override
	public int registerNoticeList(NoticeVO vo) {
		return dao.insertNotice(vo);
	}
	
	@Override
	public FilesVo selectFiles(int num) {
		return dao.selectFiles(num);
	}
	
	@Override
	public int modifyNoticeFileNumber(NoticeVO vo) {
		return dao.modifyNoticeFileNumber(vo);
	}
	
	@Override
	public int modifyNotice(NoticeVO vo) {
		return dao.modifyNotice(vo);
	}
	
	@Override
	public int modifyFile(FilesVo svo) {
		return dao.modifyFile(svo);
	}
	
	@Override
	public int modifyCount(NoticeVO vo) {
		return dao.modifyCount(vo);
	}
	
	@Override
	public int insertFiles(FilesVo svo) {
		return dao.insertFiles(svo);
	}
	
	@Override
	public int deleteNotice(int num) {
		return dao.deleteNotice(num);
	}
}
