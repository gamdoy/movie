package kr.or.kosta.event.controller;

import java.util.List;

import kr.or.kosta.event.model.service.EventService;
import kr.or.kosta.event.vo.EventVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/event/")
public class EventController {
	
	@Autowired
	private EventService service;
	
	@RequestMapping(value="test1")
	public String nowEvent(ModelMap map){
		List<EventVO> list= service.getEventList();
		System.out.println(list.size());
		
		map.addAttribute("event_list",list);
		
		return "event/now_event.tiles";
	}
	
	@RequestMapping(value="test11")
	public String specEvent(@ModelAttribute EventVO vo,ModelMap map){
		
		int evtNo=vo.getEvtNo();
		
		EventVO evtVO=service.getEventByEvtNo(evtNo);
		System.out.println(evtNo);
		map.addAttribute("evtVO",evtVO);
		
		return "event/spec_event.tiles";
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
	
	@RequestMapping(value="addEvent")
	@ResponseBody
	public int addEvent(@ModelAttribute EventVO vo, ModelMap map){
		int i=service.registEvent(vo);
		System.out.println(i);
		return i;
	}
	
	@RequestMapping(value="modifyEvent")
	@ResponseBody
	public int modifyEvent(@ModelAttribute EventVO vo,ModelMap map){
		return service.setEvent(vo);
	}
}
