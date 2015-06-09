package kr.or.kosta.admin.model.service;

import java.util.List;

import kr.or.kosta.admin.model.dao.AdminDAO;
import kr.or.kosta.admin.vo.AdminVO;
import kr.or.kosta.coupon.vo.CouponVO;
import kr.or.kosta.event.model.dao.EventDAO;
import kr.or.kosta.member.model.dao.MemberDAO;
import kr.or.kosta.member.vo.MemberVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDAO dao;
	
	private MemberDAO memberDao;
	
	@Override
	public List<AdminVO> getMemberList() {
		 List<AdminVO> list = dao.selectMemberList();
		 return list;
	}
	
	@Override
	public AdminVO selectMemberById(String id) {
		AdminVO member = dao.selectMemberById(id);
		return member;
	}
	
	@Override
	public AdminVO selectMemberByNo(int memNo){
		AdminVO member = dao.selectMemberByNo(memNo);
		return member;
	}

	public int insertCoupon(CouponVO cvo){
		//쿠폰발행
		int i = dao.insertCoupon(cvo);
		return i;
	}
	
	@Override
	public List<CouponVO> selectCouponByMemberNo(int memNo){
		return dao.selectCouponByMemberNo(memNo);
	}
	
	@Override
	public int updateMemberMileage(MemberVO member) {
		return dao.updateMemberMileage(member);
	}
}
