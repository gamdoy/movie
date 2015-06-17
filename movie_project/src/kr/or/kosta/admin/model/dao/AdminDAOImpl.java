package kr.or.kosta.admin.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.kosta.admin.vo.AdminVO;
import kr.or.kosta.common.vo.PagingBean;
import kr.or.kosta.common.vo.SearchVO;
import kr.or.kosta.coupon.vo.CouponVO;
import kr.or.kosta.member.vo.MemberVO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAOImpl implements AdminDAO{
	private String namespace="admin.dao.adminMapper.";
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public List<AdminVO> selectMemberList(int page) {
		Map param = new HashMap();
		param.put("contentsPerPage", PagingBean.CONTENTS_PER_PAGE);
		param.put("pageNo", page);
		System.out.println("AdminDAOImpl - selectMemberList : "+PagingBean.CONTENTS_PER_PAGE);
		System.out.println("AdminDAOImpl - selectMemberList page값 : "+page);
		return session.selectList(namespace+"selectMemberListPaging", param);
	}
	
	@Override
	public List<AdminVO> selectMemberBySearchVOPaging(SearchVO svo, int page) {
		Map param = new HashMap();
		param.put("contentsPerPage", PagingBean.CONTENTS_PER_PAGE);
		param.put("pageNo", page);
		param.put("searchType", svo.getSearchType());
		param.put("searchKeyword", svo.getSearchKeyword());
		
		System.out.println("AdminDAOImpl - selectMemberList : "+PagingBean.CONTENTS_PER_PAGE);
		System.out.println("AdminDAOImpl - selectMemberList page값 : "+page);
		System.out.println(param);
		List<AdminVO> list = session.selectList(namespace+"selectMemberBySearchVOPaging", param);
		System.out.println("selectMemberBySearchVO : "+list);
		System.out.println("==================================");
		return list;
	}
	
	@Override
	public AdminVO selectMemberById(String id) {
		//System.out.println("AdminDAOImpl -> 보낼 id값 : "+id);
		AdminVO vo = session.selectOne(namespace+"selectMemberById", id);
		//System.out.println("AdminDAOImpl -> 받은데이터"+vo);
		return vo;
	}
	
	public int insertCoupon(CouponVO copVo){
		int i = session.insert(namespace+"insertCoupon", copVo);
		return i;
	}
	
	public AdminVO selectMemberByNo(int memNo){
		System.out.println("selectMemberByNo"+memNo);
		AdminVO vo = session.selectOne(namespace+"selectMemberByNo", memNo);
		return vo;
	}
	
	public List<CouponVO> selectCouponByMemberNo(int memNo){
		return session.selectList(namespace+"selectCouponByMemberNo", memNo);
	}
		
	public int updateMemberMileage(AdminVO member) {
		// TODO Auto-generated method stub
		return session.update(namespace+"updateMemberMileage", member);
	}
	
	@Override
	public List<AdminVO> selectMemberBySearchVO(SearchVO svo) {
		// TODO Auto-generated method stub
		List<AdminVO> vo = session.selectList(namespace+"selectMemberBySearchVO", svo);
	
		return vo;
	}
	
	@Override
	public void updateMember(AdminVO admin) {
		session.update(namespace+"updateMember", admin);
	}
	
	@Override
	public int selectTotalMemberCount() {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+"selectTotalMember");
	}
	
	
	@Override
//서치VO 넣어서 조회할 데이터값 count 가져올것
	public int selectSearchMemberCount(SearchVO svo) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+"selectSearchMemberCount", svo);
	}
	
	
}
