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
	public int issueCouponByMemberNo(int memNo, int memberMileage,
			String coupType) {
		//멤버 마일리지 수정
		System.out.println("issueCouponByMemberNo"+memNo);
		MemberVO memVo = memberDao.selectMemberByNo(memNo);
		
		System.out.println("멤버객체"+memVo);
		memVo.setMemMileage(memberMileage);
		memberDao.updateMember(memVo);
		
		//쿠폰발행
		CouponVO copVo = new CouponVO();
		copVo.setMemNo(memVo.getMemNo());
		copVo.setCoupType(coupType);
		copVo.setCoupUsed("false");
		copVo.setCoupTypeName("");
		copVo.setCoupUsedValue("");
		copVo.setCoupUsedDate(null);
		int i = dao.insertCoupon(copVo);
		return i;
	}
}
