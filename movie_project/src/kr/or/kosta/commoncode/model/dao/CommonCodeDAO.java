package kr.or.kosta.commoncode.model.dao;

import java.util.List;

import kr.or.kosta.common.vo.ZipcodeVO;
import kr.or.kosta.commoncode.vo.CommonCodeVO;

public interface CommonCodeDAO {

	public List<CommonCodeVO> selectCodeList(String codeNo);

	public List<ZipcodeVO> selectZipodeList(String keyword);

	public String selectCommonNo(String searchKeyword);

}