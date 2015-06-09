package kr.or.kosta.admin.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.kosta.admin.vo.AdminVO;
import kr.or.kosta.common.vo.SearchVO;
import kr.or.kosta.coupon.vo.CouponVO;
import kr.or.kosta.member.vo.MemberVO;

public interface AdminService {
	public abstract Map getMemberList(int page);

	public abstract AdminVO selectMemberById(String id);

	public abstract AdminVO selectMemberByNo(int memNo);
	
	public abstract int insertCoupon(CouponVO cvo);
	
	public List<CouponVO> selectCouponByMemberNo(int memNo);

	public abstract int updateMemberMileage(MemberVO member);

	public abstract List<AdminVO> selectMemberBySearchVO(SearchVO svo);

	public HashMap selectMemberBySearchVOPaging(SearchVO svo, int page);
	
	public int selectSearchMemberCount(SearchVO svo);
}
