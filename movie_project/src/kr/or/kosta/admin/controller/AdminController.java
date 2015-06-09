package kr.or.kosta.admin.controller;

import java.util.List;

import kr.or.kosta.admin.model.service.AdminService;
import kr.or.kosta.admin.vo.AdminVO;
import kr.or.kosta.coupon.vo.CouponVO;
import kr.or.kosta.event.model.service.EventService;
import kr.or.kosta.member.model.service.MemberService;
import kr.or.kosta.member.vo.MemberVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@Autowired
	private MemberService mService;
	
	@RequestMapping("member_list")
	public String memberList(ModelMap map){
		List<AdminVO> list = service.getMemberList();
		map.addAttribute("member_list", list);
		
		return "admin/member_list.tiles";
	}
	
	//멤버 ID에서 멤버 No 추출하여 쿠폰리스트 출력
	@RequestMapping("getMemberById")
	public String getMemberById(ModelMap map,@RequestParam("memberId") String id){
		AdminVO member = service.selectMemberById(id);
		int memNo = member.getMemNo();
		List<CouponVO> couponlist= service.selectCouponByMemberNo(memNo);
		map.addAttribute("member_info", member);
		map.addAttribute("coupon_list", couponlist);
		System.out.println("쿠폰리스트 : "+couponlist);
		return "admin/member_info.tiles";
	}
	
	@RequestMapping("issueCouponById")
	public String issueCouponById(@ModelAttribute  CouponVO vo,  @ModelAttribute  AdminVO aVo, ModelMap map){
		String couponType = vo.getCoupType();
		int memNo = aVo.getMemNo();
		int memMil = aVo.getMemberMileage();
		
		System.out.println("aVo"+aVo);
		MemberVO member = mService.getMemberByNo(memNo);
		int CurrentMileage = member.getMemMileage() - memMil;
		
		System.out.println("Controller - issueCouponById : "+member);
		member.setMemMileage(CurrentMileage);
		//업데이트멤버 추가
		System.out.println("member:" + member);
		service.updateMemberMileage(member);
		
		System.out.println("Controller - issueCouponById - modifyMember 호출 후 : "+member);
		
		CouponVO copVo = new CouponVO();
		copVo.setMemNo(memNo);
		copVo.setCoupType(couponType);
		copVo.setCoupUsed("false");
		copVo.setCoupTypeName("1");
		copVo.setCoupUsedValue("1");
		copVo.setCoupUsedDate(null);
		service.insertCoupon(copVo);
		System.out.println("issueCouponById : "+member);
		
		return "redirect:/admin/getMemberById.do?memberId="+member.getMemId();
	}
	
	//타일즈 안타는 쿠폰팝업창
	@RequestMapping("getCouponList")
	public String getCouponList(ModelMap map,@RequestParam("memNo") int memNo){
		List<CouponVO> clist = service.selectCouponByMemberNo(memNo);
		map.addAttribute("coupon_list", clist);
		return "/WEB-INF/view/admin/coupon_list.jsp";
	}
}
