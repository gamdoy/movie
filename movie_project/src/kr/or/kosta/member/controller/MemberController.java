package kr.or.kosta.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
		System.out.println(error);
		membervo.setMemMemberType("102100");
		System.out.println(membervo);
		service.joinMember(membervo);
		return "redirect:member/join_success.tiles";
	}
	@RequestMapping(value="joinForm.do")
	public String joinForm(@ModelAttribute MemberVO membervo, Errors error,ModelMap map )throws Exception{
		
		List<CommonCodeVO> telList = service2.getCodeList("101");
		map.addAttribute("telList",telList);
		
		return "member/join_form.tiles";	
	}
	
	@RequestMapping("idDuplicateCheck")
	@ResponseBody
	public Map<String,Boolean> idDuplicateCheck(@RequestParam String id){
		HashMap<String , Boolean> result = new HashMap<String , Boolean>();
		result.put("result", service.getMemberById(id)==null ? true:false);
		return result;
	}
	
}
