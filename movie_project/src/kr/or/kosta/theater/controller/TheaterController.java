package kr.or.kosta.theater.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.kosta.theater.model.service.TheaterService;
import kr.or.kosta.theater.vo.TheaterVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/theater/")
public class TheaterController {
	@Autowired
	private TheaterService service;
	
	@RequestMapping(value="test")
	public String test(ModelMap map) {
		System.out.println("test.do");
		List<TheaterVO> list = service.test();
		System.out.println("list size : " + list.size());
		map.addAttribute("name", list);
		return "/main.do";
	}
	
	@RequestMapping(value="ajaxTest")
	@ResponseBody
	public Map<String, Object> ajaxTest(@ModelAttribute TheaterVO vo) {
		System.out.println("ajaxTest.do");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("theaNo", vo.getTheaNo());
		return map; 
	}
}