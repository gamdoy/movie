package kr.or.kosta.theater.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.kosta.commoncode.model.service.CommonCodeService;
import kr.or.kosta.commoncode.vo.CommonCodeVO;
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
	private TheaterService theaterService;
	
	@Autowired
	private CommonCodeService commonCodeService;
	

	@RequestMapping(value="test")
	public String test(ModelMap map) {
		List<TheaterVO> list = theaterService.getTheaterList();
		map.addAttribute("name", list);
		return "/main.do";
	}
	
	@RequestMapping(value="ajaxTest")
	@ResponseBody
	public Map<String, Object> ajaxTest(@ModelAttribute TheaterVO vo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("theaNo", vo.getTheaNo());
		return map; 
	}
	
	@RequestMapping(value="theaterManagement")
	public String theaterManagement(ModelMap map) {
		List<TheaterVO> list = theaterService.getTheaterList();
		List<CommonCodeVO> statusList = commonCodeService.getCodeLIst("111");
		
		map.addAttribute("theaterList", list);
		map.addAttribute("statusList", statusList);
		
		return "theater/theaterManagement.tiles"; 
	}
	
	@RequestMapping(value="modifyTheater")
	@ResponseBody
	public int modifyTheater(@ModelAttribute TheaterVO vo, ModelMap map) {
		return theaterService.setTheater(vo);
	}
	
	@RequestMapping(value="addTheater")
	@ResponseBody
	public int addTheater(@ModelAttribute TheaterVO vo, ModelMap map) {
		return theaterService.registTheater(vo);
	}
	
	@RequestMapping(value="movieSchedule")
	public String movieSchedule(ModelMap map) {
		return "theater/movieSchedule.tiles";
	}
}