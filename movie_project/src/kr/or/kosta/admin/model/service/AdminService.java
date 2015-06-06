package kr.or.kosta.admin.model.service;

import java.util.List;

import kr.or.kosta.admin.vo.AdminVO;
import kr.or.kosta.coupon.vo.CouponVO;
import kr.or.kosta.member.vo.MemberVO;

public interface AdminService {
	public abstract List<AdminVO> getMemberList();

	public abstract AdminVO selectMemberById(String id);

	public abstract AdminVO selectMemberByNo(int memNo);
	
	public abstract int insertCoupon(CouponVO cvo);
	
	public List<CouponVO> selectCouponByMemberNo(int memNo);

	public abstract int updateMemberMileage(MemberVO member);
}
