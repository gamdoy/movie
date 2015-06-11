package kr.or.kosta.admin.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.kosta.admin.model.dao.AdminDAO;
import kr.or.kosta.admin.vo.AdminVO;
import kr.or.kosta.common.vo.PagingBean;
import kr.or.kosta.common.vo.SearchVO;
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
	public Map getMemberList(int page) {
		 List<AdminVO> list = dao.selectMemberList(page);
		 int totalContent = dao.selectTotalMemberCount();
		 System.out.println("totalContent "+totalContent );
		 PagingBean pagingbean = new PagingBean(totalContent, page);
		 HashMap map = new HashMap();
		 map.put("member_list", list);
		 map.put("pagingBean", pagingbean);
		 return map;
	//페이징추가
		 
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
	public int updateMemberMileage(AdminVO member) {
		return dao.updateMemberMileage(member);
	}
	
	@Override
	public List<AdminVO> selectMemberBySearchVO(SearchVO svo) {
		// TODO Auto-generated method stub
		return dao.selectMemberBySearchVO(svo);
	}
	
	@Override
	public HashMap selectMemberBySearchVOPaging(SearchVO svo, int page) {
		List<AdminVO> list = dao.selectMemberBySearchVOPaging(svo, page);
		 int totalSearchContent = dao.selectSearchMemberCount(svo);
		
		 System.out.println("totalContent "+totalSearchContent );
		 PagingBean pagingbean = new PagingBean(totalSearchContent, page);
		 HashMap map = new HashMap();
		 map.put("member_list", list);
		 map.put("pagingBean2", pagingbean);
		 System.out.println("서치페이징 현재페이지 : "+pagingbean.getCurrentPage());
		 return map;
	}
	
	@Override
	public int selectSearchMemberCount(SearchVO svo) {
		return dao.selectSearchMemberCount(svo);
	}
}
