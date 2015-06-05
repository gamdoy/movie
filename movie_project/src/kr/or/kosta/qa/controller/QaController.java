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
	@RequestMapping(value="modify.do")
	public String  qa_modify(ModelMap map, @RequestParam("number")int fqNo){
		map.addAttribute("fqNo",fqNo);
		return "qa/qa_modify.tiles";
	}
	@RequestMapping(value="addQa.do")
	public String addQa(@ModelAttribute QaVO vo, ModelMap map){
		vo.setMemId("ID-01");
		vo.setQaStatus("stas");
		vo.setFqParentNumber(1);
		vo.setFileNo(30);
		vo.setMemNo(1);
		service.registerQaList(vo);
		return "/qa/qa.do";
	}
	@RequestMapping(value="selectQa.do")
	public String selectQa(ModelMap map, @RequestParam("number")int fqNo){
		QaVO vo = service.getQa(fqNo);
		System.out.println(vo.getQaCount());
		vo.setQaCount(vo.getQaCount()+1);
		service.modifyCount(vo);
		System.out.println(vo);
		map.addAttribute("qa_vo",vo);
		return "qa/qa_result.tiles";	
	}
	@RequestMapping(value="deleteQa.do")
	public String deleteQa(ModelMap map, @RequestParam("number")int fqNo){
		service.deleteQa(fqNo);
		return "/qa/qa.do";
	}
	@RequestMapping(value="modifyQa.do")
	public String modifyQa(ModelMap map, @ModelAttribute QaVO vo){
		service.modifyQa(vo);
		return "/qa/qa.do";
	}
}
