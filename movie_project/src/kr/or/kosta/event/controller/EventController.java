package kr.or.kosta.event.controller;

import java.util.List;

import kr.or.kosta.event.model.service.EventService;
import kr.or.kosta.event.vo.EventVO;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/event/")
public class EventController {
	
	private EventService service;
	
	@RequestMapping(value="test1")
	public ModelAndView nowEvent(){
		List<EventVO> list= service.getEventList();
		System.out.println("nowEventTest.do");
		return new ModelAndView("event/now_event.tiles","event_list",list); 
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
