package kr.or.kosta.commoncode.model.service;

import java.util.List;

import kr.or.kosta.common.vo.ZipcodeVO;
import kr.or.kosta.commoncode.vo.CommonCodeVO;

public interface CommonCodeService {
	public List<CommonCodeVO> getCodeList(String codeNo);

	public List<ZipcodeVO> getZipcodeList(String keyword);
}