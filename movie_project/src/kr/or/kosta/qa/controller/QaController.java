package kr.or.kosta.qa.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/qa/")
public class QaController{
	@RequestMapping(value="qa.do")
	public String qa_list(){
		return "qa/qa_list.tiles";
	}
	@RequestMapping(value="write.do")
	public String qa_write(){
		return "qa/qa_write.tiles";
	}
}
