package kr.or.kosta.admin.model.dao;

import java.util.List;

import kr.or.kosta.admin.vo.AdminVO;
import kr.or.kosta.coupon.vo.CouponVO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAOImpl implements AdminDAO{
	private String namespace="admin.dao.adminMapper.";
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public List<AdminVO> selectMemberList() {
		return session.selectList(namespace+"selectMemberList");
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
		AdminVO vo = session.selectOne(namespace+"selectMemberByNo", memNo);
		return vo;
	}
	
	public List<CouponVO> selectCouponByMemberNo(int memNo){
		return session.selectList(namespace+"selectCouponByMemberNo", memNo);
	}
		
}
