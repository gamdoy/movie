package kr.or.kosta.qa.model.dao;

import java.util.List;
import java.util.Map;

import kr.or.kosta.admin.vo.AdminVO;
import kr.or.kosta.center.vo.CommentVO;
import kr.or.kosta.center.vo.QaVO;
import kr.or.kosta.common.vo.SearchVO;
import kr.or.kosta.event.vo.EventVO;
import kr.or.kosta.files.vo.FilesVo;

public interface QaDAO {

	List<QaVO> selectQaList();

	int insertEvent(QaVO vo);

	QaVO selectQa(int num);

	int deleteQa(int num);

	int modifyQa(QaVO vo);

	int modifyCount(QaVO vo);

	int insertFiles(FilesVo svo);

	FilesVo selectFiles(int num);

	int modifyFile(FilesVo svo);

	int modifyQaFileNumber(QaVO svo);

	public abstract List<QaVO> selectAllQaPaging(int pageNo);
	
	public abstract int selectTotalQaCount();

	List<QaVO> selectQaBySearchVO(SearchVO svo);

	List<QaVO> selectQaBySearchVOPaging(SearchVO svo, int page);

	int selectSearchQaCount(SearchVO svo);

	int registerComment(CommentVO cvo);

	List<CommentVO> getComment(int fqNo);

	int deleteComment(int comNo);

	CommentVO getCommentByComNo(int comNo);

	int modifyComment(CommentVO cvo);

	int getCountComment(int fqNo);

	int register_reply(QaVO rvo);

	int  updateReply(QaVO vo);

	int plusReplyStep();

	int deleteFile(int fileNo);

}
