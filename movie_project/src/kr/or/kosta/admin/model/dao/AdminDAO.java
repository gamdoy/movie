package kr.or.kosta.admin.model.dao;

import java.util.List;

import kr.or.kosta.admin.vo.AdminVO;
import kr.or.kosta.coupon.vo.CouponVO;

public interface AdminDAO {
	public List<AdminVO> selectMemberList();

	public AdminVO selectMemberById(String id);

	public int insertCoupon(CouponVO copVo);
	
	public AdminVO selectMemberByNo(int memNo);
	
	public  List<CouponVO>  selectCouponByMemberNo(int memNo);
}
