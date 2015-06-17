package kr.or.kosta.qa.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.kosta.center.vo.CommentVO;
import kr.or.kosta.center.vo.QaVO;
import kr.or.kosta.common.vo.SearchVO;
import kr.or.kosta.files.vo.FilesVo;


public interface QaService {
	
	public abstract List<QaVO> getQaList();
	public abstract QaVO getQa(int num);
	public int registerQaList(QaVO vo);
	public int deleteQa(int num);
	public int modifyQa(QaVO vo);
	public int modifyCount(QaVO vo);
	public int insertFiles(FilesVo svo);
	public abstract FilesVo selectFiles(int num);
	public int modifyFile(FilesVo svo);
	public int modifyQaFileNumber(QaVO svo);
	public abstract Map getQaListPaging(int page);
	public abstract List<QaVO> selectQaBySearchVO(SearchVO svo);
	public HashMap selectQaBySearchVOPaging(SearchVO svo, int page);
	public int registerComment(CommentVO cvo);
	public abstract List<CommentVO> getComment(int fqNo);
	public int deleteComment(int comNo);
	public abstract CommentVO getCommentByComNo(int comNo);
	public int modifyComment(CommentVO cvo);
	public int getCountComment(int fqNo);
	public int register_reply(QaVO rvo);
	public abstract int updateReply(QaVO vo);
	public int plusReplyStep();
	public int deleteFile(int fileNo);
	
}
