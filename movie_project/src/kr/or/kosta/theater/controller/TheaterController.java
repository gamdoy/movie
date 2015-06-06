package kr.or.kosta.theater.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.kosta.commoncode.model.service.CommonCodeService;
import kr.or.kosta.commoncode.vo.CommonCodeVO;
import kr.or.kosta.schedule.vo.ScheduleVO;
import kr.or.kosta.theater.model.service.TheaterService;
import kr.or.kosta.theater.vo.TheaterVO;
import kr.or.kosta.ticket.vo.TicketVO;

import org.json.JSONArray;
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
	

	@RequestMapping("test")
	public String test(ModelMap map) {
		List<TheaterVO> list = theaterService.getTheaterList();
		map.addAttribute("name", list);
		return "/main.do";
	}
	
	@RequestMapping("ajaxTest")
	@ResponseBody
	public Map<String, Object> ajaxTest(@ModelAttribute TheaterVO vo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("theaNo", vo.getTheaNo());
		return map; 
	}
	
	@RequestMapping("theaterManagement")
	public String theaterManagement(ModelMap map) {
		List<TheaterVO> list = theaterService.getTheaterList();
		List<CommonCodeVO> statusList = commonCodeService.getCodeList("111");
		
		map.addAttribute("theaterList", list);
		map.addAttribute("statusList", statusList);
		
		return "theater/theaterManagement.tiles"; 
	}
	
	@RequestMapping("modifyTheater")
	@ResponseBody
	public int modifyTheater(@ModelAttribute TheaterVO vo) {
		return theaterService.setTheater(vo);
	}
	
	@RequestMapping("addTheater")
	@ResponseBody
	public int addTheater(@ModelAttribute TheaterVO vo) {
		return theaterService.registTheater(vo);
	}
	
	@RequestMapping("movieSchedule")
	public String movieSchedule(ModelMap map) {
		List<TheaterVO> theaList = theaterService.getTheaterList();
		map.addAttribute("theaList", theaList);
		
		return "theater/movieSchedule.tiles";
	}
	
	@RequestMapping("getScheduleList")
	@ResponseBody
	public List<ScheduleVO> getScheduleList(@ModelAttribute TheaterVO vo) {
		return theaterService.getScheduleList(vo.getTheaNo());
	}
	
	@RequestMapping("getScreenTimeList")
	@ResponseBody
	public List<ScheduleVO> getScreenTimeList(@ModelAttribute ScheduleVO vo) {
		return theaterService.getScreenTimeList(vo);
	}
	
	@RequestMapping("reserveForm")
	public String reserveForm(@ModelAttribute ScheduleVO vo, ModelMap map) {
		TicketVO tvo = new TicketVO();
		tvo.setMemNo(2);
		tvo.setSchNo(vo.getSchNo());
		map.addAttribute("movieRoom", theaterService.getMovieRoomByNo(vo.getSchNo()));
		map.addAttribute("payTypeList", commonCodeService.getCodeList("108"));
		map.addAttribute("memInfo", tvo);
		JSONArray list = new JSONArray((Collection)theaterService.getReservedSeats(tvo));
		map.addAttribute("reservedSeatList", list);
		return "ticket/reserveForm.tiles";
	}
	
	@RequestMapping("reserve")
	@ResponseBody
	public Map<String, String> reserve(@ModelAttribute TicketVO vo) {
		String seats = "";
		for (int seat = 0; seat < vo.getTicTotalcustomer(); seat++) {
			seats += "|" + vo.getMrLine() + "-" + (vo.getMrSeat() + seat);
		}
		
		seats += "|";
		vo.setMemNo(2);
		vo.setTicPaytype("100000");
		vo.setTicPrice(8000);
		vo.setTicSeatno(seats);
		theaterService.registTicket(vo);
		Map<String, String> map = new HashMap<String, String>();
		map.put("url", "/theater/reserveSuccess.do");
		map.put("ticNo", vo.getTicNo()+"");
		return map;
	}
	
	@RequestMapping("reserveSuccess")
	public String reserveSuccess(@ModelAttribute TicketVO vo, ModelMap map) {
		map.addAttribute("ticket", theaterService.getTicketByNo(vo.getTicNo()));
		return "ticket/reserveSuccess.tiles";
	}
	
	@RequestMapping("ticketList")
	public String ticketList(ModelMap map) {
		map.addAttribute("ticketList", theaterService.getTicketList());
		return "ticket/ticketList.tiles";
	}
}