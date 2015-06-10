package kr.or.kosta.commoncode.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.kosta.common.vo.ZipcodeVO;
import kr.or.kosta.commoncode.vo.CommonCodeVO;

@Repository
public class CommonCodeDAOImpl implements CommonCodeDAO {


	private String nameSpace = "commoncode.dao.commoncodeMapper.";
	/**
	 * SqlSession을 받기 위한 SqlSessionTemplate 
	 */
	@Autowired
	private SqlSessionTemplate session;
	
	/**
	 * 코드리스트를 받는 메소드
	 */
	@Override
	public List<CommonCodeVO> selectCodeList(String codeNo) {
		return session.selectList(nameSpace + "selectCommonCodeByNo", codeNo);
	}

	@Override
	public List<ZipcodeVO> selectZipodeList(String keyword) {
		return session.selectList(nameSpace + "selectZipcodeByKeyword", keyword);
	}

	@Override
	public String selectCommonNo(String searchKeyword) {
		return session.selectOne(nameSpace + "selectCommonNo", searchKeyword);
	}
}
