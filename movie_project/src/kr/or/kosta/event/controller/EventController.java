package kr.or.kosta.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/event/")
public class EventController {
	
	@RequestMapping(value="test1")
	public String nowEvent(){
		System.out.println("eventTest.do");
		return "event/now_event.tiles";
	}
	
	@RequestMapping(value="test2")
	public String endEvent(){
		System.out.println("eventTest.do");
		return "event/end_event.tiles";
	}
	
	@RequestMapping(value="test3")
	public String prizeWinner(){
		System.out.println("eventTest.do");
		return "event/prizeWinner.tiles";
	}
}
