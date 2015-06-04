package kr.or.kosta.admin.model.service;

import java.util.List;

import kr.or.kosta.admin.vo.AdminVO;
import kr.or.kosta.coupon.vo.CouponVO;

public interface AdminService {
	public abstract List<AdminVO> getMemberList();

	public abstract AdminVO selectMemberById(String id);

	public abstract int issueCouponByMemberNo(int memNo, int memberMileage, String coupType);
	
}