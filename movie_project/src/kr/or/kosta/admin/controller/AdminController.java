package kr.or.kosta.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.kosta.admin.model.service.AdminService;
import kr.or.kosta.admin.vo.AdminVO;
import kr.or.kosta.common.vo.PagingBean;
import kr.or.kosta.common.vo.SearchVO;
import kr.or.kosta.commoncode.model.service.CommonCodeService;
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
	
	@Autowired
	private CommonCodeService commonService;
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
	
	//멤버 No 로 쿠폰리스트 출력
	@RequestMapping("getMemberByNo")
	public String getMemberByNo(ModelMap map,@RequestParam("memNo") int number){
		AdminVO member = service.selectMemberByNo(number);
		System.out.println("회원번호 : "+number);
		System.out.println("회원정보 : "+member);
		
		List<CouponVO> couponlist= service.selectCouponByMemberNo(number);
		map.addAttribute("member_info", member);
		map.addAttribute("coupon_list", couponlist);
		System.out.println("쿠폰리스트 : "+couponlist);
		return "admin/member_info.tiles";
	}
	
	@RequestMapping("issueCouponById")
	public String issueCouponById(@ModelAttribute  CouponVO vo,  @ModelAttribute  AdminVO aVo, ModelMap map){
		System.out.println("issueCouponById 쿠폰발행전"+vo);
		System.out.println("issueCouponById AdminVo"+aVo);
		String couponType = vo.getCoupType();
		int memNo = aVo.getMemNo();
		int memMil = aVo.getMemberMileage();
		
		AdminVO member = service.selectMemberByNo(memNo);
		System.out.println("issueCouponById 멤버정보 : "+member);
		int CurrentMileage = member.getMemberMileage() - memMil;
		
		System.out.println("Controller - issueCouponById : "+member);
		member.setMemberMileage(CurrentMileage);
		//업데이트멤버 추가
		System.out.println("member:" + member);
		service.updateMemberMileage(member);
		
		System.out.println("Controller - issueCouponById - modifyMember 호출 후 : "+member);
		
		CouponVO copVo = new CouponVO();
		copVo.setMemNo(memNo);
		copVo.setCoupType(couponType);
		copVo.setCoupUsed("103100");
		copVo.setCoupTypeName(null);
		copVo.setCoupUsedValue(null);
		copVo.setCoupUsedDate(null);
		System.out.println("넣을 쿠폰VO : "+copVo);
		service.insertCoupon(copVo);
		System.out.println("issueCouponById : "+member);
		System.out.println("넣은후 쿠폰 : "+service.selectCouponByMemberNo(memNo));
		return "redirect:/admin/getMemberByNo.do?memNo="+member.getMemNo();
	}
	
	//타일즈 안타는 쿠폰팝업창
	@RequestMapping("getCouponList")
	public String getCouponList(ModelMap map,@RequestParam("memNo") int memNo){
		List<CouponVO> clist = service.selectCouponByMemberNo(memNo);
		map.addAttribute("coupon_list", clist);
		return "/WEB-INF/view/admin/coupon_list.jsp";
	}
	
	//검색된 화면페이지 처리(페이징, 검색)
	@RequestMapping("getMemberByKeyword")
	public String getMemberByKeyword(ModelMap map, @RequestParam(defaultValue="1")int page, @RequestParam("searchType") String searchType, @RequestParam("searchKeyword") String searchKeyword){
		//SearchType : 검색조건 - ID, 이름, 등급, 전화번호 등등
		//SearchKeyword : 검색키워드 - id-1, 홍길동, vip, 010-1234-5678 등..
		
		SearchVO svo = new SearchVO();
		HashMap memberList = new HashMap();
		
		svo.setSearchType(searchType);
		
//		검색 키워드에서 CommonNo를 가져온다.
		String searchKeywordCommonNo = commonService.getCommonNo(searchKeyword.toUpperCase());
//		CommonNo가 있으면 해당 CommonNo를 SearchVO에 넣어서 멤버조회
		if(searchType != null && searchType.equals("MEM_MEMBERTYPE") && searchKeywordCommonNo != null){
			System.out.println("searchKeywordCommonNo"+searchKeywordCommonNo);
			svo.setSearchKeyword(searchKeywordCommonNo);
			memberList = service.selectMemberBySearchVOPaging(svo, page);

		}else{		//		CommonNo가 없으면 SearchVO를 이용하여 조회
			svo.setSearchKeyword(searchKeyword);
			memberList = service.selectMemberBySearchVOPaging(svo, page);
		}
		
		System.out.println("searchKeyword"+searchKeyword );
		map.addAttribute("searchedMemberMap", memberList);
		map.addAttribute("currentSearchType", searchType);
		map.addAttribute("currentSearchKeyword", searchKeyword);
		return "admin/searched_member_list.tiles";
	}
}
