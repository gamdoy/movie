package kr.or.kosta.admin.controller;

import java.util.List;

import kr.or.kosta.admin.model.service.AdminService;
import kr.or.kosta.admin.vo.AdminVO;
import kr.or.kosta.coupon.vo.CouponVO;
import kr.or.kosta.event.model.service.EventService;

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
	
	@RequestMapping("member_list")
	public String memberList(ModelMap map){
		List<AdminVO> list = service.getMemberList();
		map.addAttribute("member_list", list);
		return "admin/member_list.tiles";
	}
	
	@RequestMapping("getMemberById")
	public String getMemberById(ModelMap map,@RequestParam("memberId") String id){
		AdminVO member = service.selectMemberById(id);
		map.addAttribute("member_info", member);
		return "admin/member_info.tiles";
	}
	@RequestMapping("issueCouponById")
	public String issueCouponById(@ModelAttribute  CouponVO vo,  @ModelAttribute  AdminVO aVo, ModelMap map){
		String couponType = vo.getCoupType();
		int memNo = aVo.getMemNo();
		int memMil = aVo.getMemberMileage();
		System.out.println("AdminController : "+couponType+":"+memNo+":"+memMil);
		System.out.println("쿠폰발행 컨트롤러 : "+memNo+" : "+couponType);
		int i = service.issueCouponByMemberNo(memNo, memMil, couponType);
		return "admin/member_info.tiles";
	}
}
