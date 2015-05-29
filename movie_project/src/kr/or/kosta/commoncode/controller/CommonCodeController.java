package kr.or.kosta.commoncode.controller;

import java.util.List;

import kr.or.kosta.common.vo.ZipcodeVO;
import kr.or.kosta.commoncode.model.service.CommonCodeService;
import kr.or.kosta.commoncode.vo.CommonCodeVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/commonCode/")
public class CommonCodeController {
	@Autowired
	private CommonCodeService Service;
	
	@RequestMapping(value="phoneCode")
	@ResponseBody
	public List<CommonCodeVO> phoneCode() {
		return Service.getCodeLIst("101");
	}
	
	@RequestMapping(value="findZipcode")
	@ResponseBody
	public List<ZipcodeVO> findZipcode(@ModelAttribute ZipcodeVO vo) {
		System.out.println(vo.getKeyword());
		return null;
	}
}
