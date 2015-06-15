package kr.or.kosta.notice.model.service;

import java.util.List;
import java.util.Map;

import kr.or.kosta.common.vo.SearchVO;
import kr.or.kosta.files.vo.FilesVo;
import kr.or.kosta.notice.vo.NoticeVO;

public interface NoticeService {

	public abstract Map getNoticeListPaging(int page);

	public abstract List<NoticeVO> getNoticeList();

	public abstract NoticeVO getNotice(int notiNo);

	public abstract int registerNoticeList(NoticeVO vo);

	public abstract int insertFiles(FilesVo svo);

	public abstract FilesVo selectFiles(int notiNo);

	public abstract int modifyNoticeFileNumber(NoticeVO vo);

	public abstract int modifyCount(NoticeVO vo);

	public abstract int deleteNotice(int notiNo);

	public abstract int modifyFile(FilesVo svo);

	public abstract int modifyNotice(NoticeVO vo);

	public abstract List<NoticeVO> selectNoticeBySearchVO(SearchVO svo);


	

	
	
	
}
