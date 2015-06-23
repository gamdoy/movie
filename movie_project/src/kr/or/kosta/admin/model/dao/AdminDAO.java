package kr.or.kosta.admin.model.dao;

import java.util.List;

import kr.or.kosta.admin.vo.AdminVO;
import kr.or.kosta.common.vo.SearchVO;
import kr.or.kosta.coupon.vo.CouponVO;
import kr.or.kosta.member.vo.MemberVO;

public interface AdminDAO {
	public List<AdminVO> selectMemberList(int page);

	public AdminVO selectMemberById(String id);

	public int insertCoupon(CouponVO copVo);
	
	public AdminVO selectMemberByNo(int memNo);
	
	public  List<CouponVO>  selectCouponByMemberNo(int memNo);

	public List<AdminVO> selectMemberBySearchVO(SearchVO svo);

	public int selectTotalMemberCount();

	List<AdminVO> selectMemberBySearchVOPaging(SearchVO svo, int page);

	public int selectSearchMemberCount(SearchVO svo);

	public int updateMemberMileage(AdminVO member);

	public void updateMember(AdminVO admin);

	public void updateMemberType(AdminVO admin);
	
	
}
