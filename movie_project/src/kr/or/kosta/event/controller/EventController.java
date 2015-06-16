package kr.or.kosta.event.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.kosta.center.vo.QaVO;
import kr.or.kosta.event.model.service.EventService;
import kr.or.kosta.event.vo.EventVO;
import kr.or.kosta.event.vo.WinnerVO;
import kr.or.kosta.files.vo.FilesVo;
import kr.or.kosta.member.vo.MemberVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/event/")
public class EventController {
	
	
	
	@Autowired
	private EventService service;
	
	@RequestMapping(value="nowEvent.do")
	public String nowEvent(ModelMap map){
		List<EventVO> list= service.getEventList();
		System.out.println(list.size());
		
		map.addAttribute("event_list",list);
		
		return "event/now_event.tiles";
	}
	
	@RequestMapping(value="endEvent.do")
	public String endEvent(ModelMap map){
		List<EventVO> list= service.getEventList();
		System.out.println(list.size());
		
		map.addAttribute("event_list",list);
		
		return "event/end_event.tiles";
	}
	
	@RequestMapping(value="specEvent")
	public String specEvent(@RequestParam int evtNo,ModelMap map){
		
		EventVO evtVO=service.getEventByEvtNo(evtNo);
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
	
	/*
	@RequestMapping(value="addEvent")
	@ResponseBody
	public int addEvent(@ModelAttribute EventVO vo, ModelMap map){
		int i=service.registEvent(vo);
		System.out.println(i);
		return i;
	}
	*/
	
	@RequestMapping(value="regisForm")
	public String regisForm(@ModelAttribute MemberVO membervo, HttpSession session, HttpServletRequest request,ModelMap map){
		MemberVO loginInfo = (MemberVO)session.getAttribute("login_info");
		String url=null;
		
		if(loginInfo.getMemMemberType().equals("102300")){
			map.addAttribute("login_info",loginInfo);
			url="event/regis_form.tiles";
		}else{
			url="event/nowEvent.do";
			map.addAttribute("error_message", "관리자만 사용가능한 메뉴입니다.");
		}
		return url;
	}
	
	@RequestMapping(value="modifyEvent")
	public String modifyEvent(@ModelAttribute EventVO vo,ModelMap map,HttpServletRequest request)throws IllegalStateException, IOException{
		
		System.out.println(vo);
		MultipartFile file = vo.getEvtImageFile();
		if(file!=null && !file.isEmpty()){
			String path=request.getServletContext().getRealPath("/images/event");
			String fileName=System.currentTimeMillis()+".jpg";
			File evtImage=new File(path,fileName);
			file.transferTo(evtImage);
			vo.setEvtFile(fileName);

		}
		
		service.setEvent(vo);
		
		return "/event/nowEvent.do";
		
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
		return "/event/nowEvent.do";
	}
	
	@RequestMapping(value="eventListPaging")
	public String eventListPaing(@RequestParam(defaultValue="1")int page,ModelMap map){
		System.out.println(page);
		Map pageMap = service.getWinnerListPaging(page);
		System.out.println(page);
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
	
	/*파일 싱글 업로드
	@RequestMapping(value="singleup")
	public String singleUpload(SingleUpload svo,ModelMap map)throws IllegalStateException, IOException{
		MultipartFile upfile = svo.getUpfile();
		if(upfile!=null && !upfile.isEmpty()){
			String fileName=upfile.getOriginalFilename();
			long size=upfile.getSize();
			File file=new File(imageDir,fileName);
			upfile.transferTo(file);
			map.addAttribute("filename",fileName);
			map.addAttribute("filesize",size);
			map.addAttribute("title",svo.getTitle());
			map.addAttribute("info",svo.getInfo());
		}else{
			map.addAttribute("title","업로드된 파일이 없습니다.");
		}
		return "event/now_event.tiles";
	}
	*/
	
	@RequestMapping(value="addEvent")
	public String addEvent(@ModelAttribute EventVO vo, ModelMap map,HttpServletRequest request)throws IllegalStateException, IOException{
		
		
		
		MultipartFile file = vo.getEvtImageFile();
		if(file!=null && !file.isEmpty()){
			String path=request.getServletContext().getRealPath("/images/event");
			String fileName=System.currentTimeMillis()+".jpg";
			File evtImage=new File(path,fileName);
			file.transferTo(evtImage);
			vo.setEvtFile(fileName);

		}
		
		service.registEvent(vo);
		
		return "/event/nowEvent.do";
	}
	
	/*********************************************************
	 * 
	 * 				    당첨자 게시판 컨트롤러
	 * 
	 *********************************************************/
	
	@RequestMapping(value="specWinner")
	public String specWinner(@ModelAttribute WinnerVO vo,ModelMap map){
		
		int winNo=vo.getWinNo();
		
		WinnerVO winVO=service.getWinnerByWinNo(winNo);
		System.out.println(winVO);
		map.addAttribute("winVO",winVO);
		
		return "event/spec_winner.tiles";
	}
	
	@RequestMapping(value="deleteWinner")
	public String deleteWinner(ModelMap map, @RequestParam("winNo")int winNo){
		service.deleteWinner(winNo);
		return "/event/eventListPaging.do";
	}
	
	@RequestMapping(value="modifyForm")
	public String  modifyForm(ModelMap map, @RequestParam("winNo")int winNo){
		WinnerVO winVO=service.getWinnerByWinNo(winNo);
		map.addAttribute("winVO",winVO);
	
		return "event/modify_winner.tiles";
	}
	
	@RequestMapping(value="modifyWinner")
	public String modifyWinner(@ModelAttribute WinnerVO vo, ModelMap map){
		
		service.modifyWinner(vo);
		return "/event/eventListPaging.do";
	}

}
