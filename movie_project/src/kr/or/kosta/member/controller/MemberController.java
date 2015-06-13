package kr.or.kosta.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosta.commoncode.model.service.CommonCodeService;
import kr.or.kosta.commoncode.vo.CommonCodeVO;
import kr.or.kosta.member.model.service.MemberService;
import kr.or.kosta.member.vo.MemberVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/member/")
public class MemberController {

	
	@Autowired
	private MemberService service;
	
	@Autowired
	private CommonCodeService service2;
	
	@RequestMapping(value="join.do",method=RequestMethod.POST)
	public String joinMember(@ModelAttribute MemberVO membervo, Errors error)throws Exception{
		membervo.setMemMemberType("102100");
		service.joinMember(membervo);
		return "redirect:/member/join_success.do?memId="+membervo.getMemId();
	}
	@RequestMapping(value="joinForm.do")
	public String joinForm(@ModelAttribute MemberVO membervo, Errors error,ModelMap map )throws Exception{
		
		List<CommonCodeVO> telList = service2.getCodeList("101");
		map.addAttribute("telList",telList);
		
		return "member/join_form.tiles";	
	}
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String login(String id,String password, HttpSession session, HttpServletResponse response, ModelMap map){
		MemberVO m = service.getMemberById(id);
		String url = null;
		
		if(m!=null){
			if(password.equals(m.getMemPassword())){
				session.setAttribute("login_info", m);
				url = "main.tiles";
			}else{
				url = "member/login_form.tiles";
				map.addAttribute("error_message", "Password를 확인하세요");
			}
		}else{
			url = "member/login_form.tiles";
			map.addAttribute("error_message","ID를 확인하세요");
		}
		return url;
	}
	@RequestMapping("idSearch")
	public String idSearch(@ModelAttribute MemberVO vo,HttpSession session,ModelMap map)throws Exception{
		MemberVO m = service.getMemberByname(vo);
		System.out.println("vo : " + vo);
		System.out.println("m" + m);
		map.addAttribute("member_info",m);
		List<CommonCodeVO> telList = service2.getCodeList("101");
		map.addAttribute("telList",telList);
		return "/WEB-INF/view/member/idSearch.jsp";
		
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session,HttpServletResponse response){
		session.invalidate();
		return "redirect:/main.do";
	}
	@RequestMapping("modifyMemberInfo")
	public String modifyMemberInfo(@ModelAttribute MemberVO membervo, HttpSession session, HttpServletRequest request,ModelMap map)throws Exception{
		MemberVO loginInfo = (MemberVO)session.getAttribute("login_info");
		List<CommonCodeVO> telList = service2.getCodeList("101");
		map.addAttribute("telList",telList);
		membervo.setMemMemberType("102100");
		int count = service.modifyMember(membervo);
		if(count==1){
			map.addAttribute("message","true");
		}else{
			map.addAttribute("message","false");

		}
		loginInfo.setMemName(membervo.getMemName());
		loginInfo.setMemPassword(membervo.getMemPassword());
		loginInfo.setMemAddressDetail(membervo.getMemAddressDetail());
		loginInfo.setMemBirthDate(membervo.getMemBirthDate());
		loginInfo.setMemEmail(membervo.getMemEmail());
		loginInfo.setMemPhoneNo(membervo.getMemPhoneNo());
		
		return "member/modify_form.tiles";	
	}
	@RequestMapping("modify_form")
	public String modifyMember(@ModelAttribute MemberVO membervo, HttpSession session,ModelMap map)throws Exception{
		MemberVO loginInfo = (MemberVO)session.getAttribute("login_info");
		List<CommonCodeVO> telList = service2.getCodeList("101");
		map.addAttribute("telList",telList);
		return "member/modify_form.tiles";
	}
	@RequestMapping("search_form")
	public String searchMember(HttpSession session,ModelMap map)throws Exception{
		List<CommonCodeVO> telList = service2.getCodeList("101");
		map.addAttribute("telList",telList);
		return "/WEB-INF/view/member/idSearch.jsp";
	}
	@RequestMapping("idDuplicateCheck")
	@ResponseBody
	public Map<String,Boolean> idDuplicateCheck(@RequestParam String id){
		HashMap<String , Boolean> result = new HashMap<String , Boolean>();
		result.put("result", service.getMemberById(id)==null ? true:false);
		return result;
	}
}
