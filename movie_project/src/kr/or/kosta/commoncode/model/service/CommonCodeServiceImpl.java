package kr.or.kosta.commoncode.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.kosta.common.vo.ZipcodeVO;
import kr.or.kosta.commoncode.model.dao.CommonCodeDAO;
import kr.or.kosta.commoncode.vo.CommonCodeVO;

@Service
public class CommonCodeServiceImpl implements CommonCodeService {

	@Autowired
	private CommonCodeDAO dao;
	
	@Override
	public List<CommonCodeVO> getCodeList(String codeNo) {
		return dao.selectCodeList(codeNo);
	}

	@Override
	public List<ZipcodeVO> getZipcodeList(String keyword) {
		return dao.selectZipodeList(keyword);
	}

}
