package kr.or.kosta.commoncode.controller;

import java.util.List;

import kr.or.kosta.common.vo.ZipcodeVO;
import kr.or.kosta.commoncode.model.service.CommonCodeService;
import kr.or.kosta.commoncode.vo.CommonCodeVO;
import kr.or.kosta.theater.vo.TheaterVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/commonCode/")
public class CommonCodeController {
	@Autowired
	private CommonCodeService Service;
	
	@RequestMapping("phoneCode")
	@ResponseBody
	public List<CommonCodeVO> phoneCode() {
		return Service.getCodeList("101");
	}
	
	@RequestMapping("getCode")
	@ResponseBody
	public List<CommonCodeVO> getCode(@ModelAttribute CommonCodeVO vo) {
		return Service.getCodeList(vo.getKeyword());
	}
	
	@RequestMapping("getZipCodeForTheater")
	public String getZipCodeForTheater(@ModelAttribute TheaterVO vo, ModelMap map) {
		map.addAttribute("theaNo", vo.getTheaNo());
		return "/WEB-INF/view/common/zipcodeForTheater.jsp";
	}
	
	@RequestMapping("findZipcode")
	@ResponseBody
	public List<ZipcodeVO> findZipcode(@ModelAttribute ZipcodeVO vo) {
		System.out.println(Service.getZipcodeList(vo.getKeyword()));
		return Service.getZipcodeList(vo.getKeyword());
	}
}
