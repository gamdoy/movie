package kr.or.kosta.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.kosta.admin.model.service.AdminService;
import kr.or.kosta.admin.vo.AdminVO;
import kr.or.kosta.common.vo.SearchVO;
import kr.or.kosta.coupon.vo.CouponVO;
import kr.or.kosta.member.model.service.MemberService;
import kr.or.kosta.member.vo.MemberVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@Autowired
	private MemberService mService;
	
/*	
	@RequestMapping("member_list")
	public String memberList(ModelMap map){
		List<AdminVO> list = service.getMemberList();
		map.addAttribute("member_list", list);
		
		return "admin/member_list.tiles";
	}
	*/
	@RequestMapping("member_list_Paging")
	public String memberListPaging(@RequestParam(defaultValue="1")int page,ModelMap map){
		Map memberMap = service.getMemberList(page);
		map.addAttribute("memberMap", memberMap);
		System.out.println(memberMap);
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
	
	@RequestMapping("getMemberByKeyword")
	public String getMemberByKeyword(ModelMap map, @RequestParam(defaultValue="1")int page, @RequestParam("searchType") String searchType, @RequestParam("searchKeyword") String searchKeyword){
		System.out.println("getMemberByKeyword"+searchType);
		System.out.println("getMemberByKeyword"+searchKeyword);
		SearchVO svo = new SearchVO();
		Map memberList = new HashMap();
		AdminVO member;
		svo.setSearchType(searchType);
		System.out.println(searchType);
		svo.setSearchKeyword(searchKeyword);
		if(svo.getSearchType().equals("MEM_ID")){
			member = service.selectMemberById(svo.getSearchKeyword());
			memberList.put("member_list", member);
			System.out.println("ID로검색 : "+memberList);
		}else{
			memberList = service.selectMemberBySearchVOPaging(svo, page);
		}
		map.addAttribute("memberMap", memberList);
		return "admin/member_list.tiles";
	}
}
