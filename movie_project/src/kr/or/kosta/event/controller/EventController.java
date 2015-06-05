package kr.or.kosta.event.controller;

import java.util.List;
import java.util.Map;

import kr.or.kosta.event.model.service.EventService;
import kr.or.kosta.event.vo.EventVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/event/")
public class EventController {
	
	@Autowired
	private EventService service;
	
	@RequestMapping(value="nowEvent")
	public String nowEvent(ModelMap map){
		List<EventVO> list= service.getEventList();
		System.out.println(list.size());
		
		map.addAttribute("event_list",list);
		
		return "event/now_event.tiles";
	}
	
	@RequestMapping(value="specEvent")
	public String specEvent(@ModelAttribute EventVO vo,ModelMap map){
		
		int evtNo=vo.getEvtNo();
		
		EventVO evtVO=service.getEventByEvtNo(evtNo);
		System.out.println(evtNo);
		map.addAttribute("evtVO",evtVO);
		
		return "event/spec_event.tiles";
	}
	
	@RequestMapping(value="endEvent")
	public String endEvent(){
		System.out.println("eventTest.do");
		return "event/end_event.tiles";
	}
	
	@RequestMapping(value="eventBoard")
	public String prizeWinner(){
		System.out.println("eventTest.do");
		return "event/event_board.tiles";
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
	public String modifyEvent(@ModelAttribute EventVO vo,ModelMap map){
		System.out.println("이벤트 수정");
		service.setEvent(vo);
		return "event/now_event.tiles";
	}
	
	@RequestMapping(value="modifyEventNumber")
	public String modifyEventNumber(@ModelAttribute EventVO vo,ModelMap map){
		int evtNo=vo.getEvtNo();
		EventVO evtVO=service.getEventByEvtNo(evtNo);
		map.addAttribute("evtVO",evtVO);
		
		return "event/modify_form.tiles";
	}
	
	@RequestMapping(value="deleteEventByEventNumber")
	public String deleteEvent (@ModelAttribute EventVO vo){
		int evtNo=vo.getEvtNo();
		service.removeEventByEventNumber(evtNo);
		return "event/now_event.tiles";
	}
	
	@RequestMapping(value="eventListPaging")
	public String eventListPaing(@RequestParam(defaultValue="1")int page,ModelMap map){
		Map pageMap = service.getEventListPaging(page);
		map.addAttribute("pageMap",pageMap);
		return "event/event_list_paging.tiles";
		
	}
	
	@RequestMapping(value="searchEventText")
	public String searchEventText(@RequestParam String searchText, @ModelAttribute EventVO vo ,ModelMap map){
		
		List<EventVO> searchEventList = service.searchEventByText(searchText);
		System.out.println(searchEventList);
		
		map.addAttribute("search_event_list",searchEventList);
		
		return "event/search_event.tiles";
	}
}
