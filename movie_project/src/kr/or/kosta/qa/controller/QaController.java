package kr.or.kosta.qa.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

import kr.or.kosta.center.vo.QaVO;
import kr.or.kosta.event.model.service.EventService;
import kr.or.kosta.event.vo.EventVO;
import kr.or.kosta.qa.model.service.QaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/qa/")
public class QaController{
	@Autowired
	private QaService service;
	
	@RequestMapping(value="qa.do")
	public String qa_list(ModelMap map){
		List<QaVO> list= service.getQaList();
		map.addAttribute("qa_list",list);
		return "qa/qa_list.tiles";
	}
	@RequestMapping(value="write.do")
	public String qa_write(){
		return "qa/qa_write.tiles";
	}
	
	@RequestMapping(value="addQa.do")
	public String addQa(@ModelAttribute QaVO vo, ModelMap map){
		vo.setMemId("ID-01");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		vo.setFqRegdate(sdf.format(new Timestamp(System.currentTimeMillis())));
		vo.setFqLastdate("2015-01-01 11:11");
		vo.setQaStatus("stas");
		vo.setFqParentNumber(1);
		vo.setFileNo(30);
		vo.setMemNo(1);
		vo.setQaCount(1);
		service.registerQaList(vo);
		return "/qa/qa.do";
	}
	@RequestMapping(value="selectQa.do")
	public String selectQa(ModelMap map, @RequestParam("number")int fqNo){
		QaVO vo = service.getQa(fqNo);
		map.addAttribute("qa_vo",vo);
		return "qa/qa_result.tiles";
	}
}
