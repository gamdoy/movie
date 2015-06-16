package kr.or.kosta.notice.model.dao;

import java.util.List;

import kr.or.kosta.common.vo.SearchVO;
import kr.or.kosta.files.vo.FilesVo;
import kr.or.kosta.notice.vo.NoticeVO;



public interface NoticeDAO {

	List<NoticeVO> selectNoticeList();

	int insertNotice(NoticeVO vo);

	NoticeVO selectNotice(int num);

	int deleteNotice(int num);

	int modifyNotice(NoticeVO vo);

	int modifyCount(NoticeVO vo);

	int insertFiles(FilesVo svo);

	FilesVo selectFiles(int num);

	int modifyFile(FilesVo svo);

	int modifyNoticeFileNumber(NoticeVO vo);

	public abstract List<NoticeVO> selectAllNoticePaging(int pageNo);
	
	public abstract int selectTotalNoticeCount();

	List<NoticeVO> selectNoticeBySearchVO(SearchVO svo);

}
