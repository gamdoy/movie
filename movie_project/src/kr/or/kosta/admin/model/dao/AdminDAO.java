package kr.or.kosta.admin.model.dao;

import java.util.List;

import kr.or.kosta.admin.vo.AdminVO;
import kr.or.kosta.coupon.vo.CouponVO;
import kr.or.kosta.member.vo.MemberVO;

public interface AdminDAO {
	public List<AdminVO> selectMemberList();

	public AdminVO selectMemberById(String id);

	public int insertCoupon(CouponVO copVo);
	
	public AdminVO selectMemberByNo(int memNo);
	
	public  List<CouponVO>  selectCouponByMemberNo(int memNo);

	public int updateMemberMileage(MemberVO member);
}
