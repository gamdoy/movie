package kr.or.kosta.qa.model.service;

import java.util.List;
import java.util.Map;

import kr.or.kosta.center.vo.QaVO;
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
	
}
