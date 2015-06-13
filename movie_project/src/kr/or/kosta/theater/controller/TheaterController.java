package kr.or.kosta.theater.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.or.kosta.common.vo.SearchVO;
import kr.or.kosta.commoncode.model.service.CommonCodeService;
import kr.or.kosta.commoncode.vo.CommonCodeVO;
import kr.or.kosta.movie.model.service.MovieService;
import kr.or.kosta.movie.model.service.MovieServiceImpl;
import kr.or.kosta.movieroom.vo.MovieroomVO;
import kr.or.kosta.schedule.vo.ScheduleVO;
import kr.or.kosta.theater.model.service.TheaterService;
import kr.or.kosta.theater.vo.TheaterVO;
import kr.or.kosta.ticket.vo.TicketVO;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/theater/")
public class TheaterController {
	@Autowired
	private TheaterService theaterService;
	
	@Autowired
	private CommonCodeService commonCodeService;
	
	@Autowired
	private MovieService movieService;
	

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
	
	@RequestMapping("getMovieList")
	@ResponseBody
	public List<TicketVO> getMovieListByDate(@ModelAttribute ScheduleVO vo, Errors errors) {
		return theaterService.getMovieListByDate(vo);
	}
	
	@RequestMapping("getScheduleList")
	@ResponseBody
	public List<ScheduleVO> getScheduleList(@ModelAttribute TheaterVO vo) {
		return theaterService.getScheduleListBytheaNo(vo.getTheaNo());
	}
	
	@RequestMapping("getScreenTimeList")
	@ResponseBody
	public List<ScheduleVO> getScreenTimeList(@ModelAttribute ScheduleVO vo) {
		List<ScheduleVO> list = theaterService.getScreenTimeList(vo);
		for (ScheduleVO sVO : list) {
			sVO.setMovPoster("/images/movie/" +sVO.getMovPoster());
		}
		return list;
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
	public Map<String, String> reserve(@ModelAttribute TicketVO vo) throws Exception {
		String seats = "";
		Map<String, String> map = new HashMap<String, String>();
		for (int seat = 0; seat < vo.getTicTotalcustomer(); seat++) {
			String seatNo = "|" + vo.getMrLine() + "-" + (vo.getMrSeat() + seat);
			vo.setTicSeatno(seatNo);
			boolean flag = theaterService.isReservedSeats(vo);
			if(flag){
				map.put("reserved", "true");
				return map;
			}
			seats += seatNo;
		}
		
		seats += "|";
		vo.setMemNo(2);//회원 정보 고정
		vo.setTicStatus("112100");//결제완료 고정
		vo.setTicPrice(8000);
		vo.setTicSeatno(seats);
		
		theaterService.registTicket(vo);
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
	public String ticketList(@RequestParam(defaultValue="1")int page, @ModelAttribute SearchVO vo, ModelMap map) {
		String tempSearchKeyword = vo.getSearchKeyword();
		if(vo.getSearchType() != null && (vo.getSearchType().equals("tic_paytype") || vo.getSearchType().equals("tic_status"))){
			vo.setSearchKeyword(commonCodeService.getCommonNo(vo.getSearchKeyword()));
		}
		List list = theaterService.getTicketListPaging(page, vo);
		List ticStatusList = commonCodeService.getCodeList("112");
		
		vo.setSearchKeyword(tempSearchKeyword);
		map.addAttribute("pagingBean", list.get(0));
		map.addAttribute("ticketList", list.get(1));
		map.addAttribute("searchVO", vo);
		map.addAttribute("ticStatusList", ticStatusList);
		
		return "ticket/ticketList.tiles";
	}
	
	@RequestMapping("modifyTicketByNo")
	@ResponseBody
	public Boolean modifyTicketByNo(@ModelAttribute TicketVO vo) {
		int count = theaterService.modifyTicketByNo(vo);
		return count == 1;
	}
	
	@RequestMapping("modifyMovieroomForm")
	public String modifyMovieroomForm(@RequestParam int theaNo, ModelMap map) {
		List<MovieroomVO> list = theaterService.getMovieRoomListByNo(theaNo);
		List<CommonCodeVO> codeList = commonCodeService.getCodeList("109");
		map.addAttribute("movieroomList", list);
		map.addAttribute("codeList", codeList);
		map.addAttribute("theaNo", theaNo);
		return "theater/modifyMovieroom.tiles";
	}
	
	@RequestMapping("setScheduleForm")
	public String setScheduleForm(@ModelAttribute ScheduleVO vo, SearchVO searchVO, @RequestParam(defaultValue="1")int page, ModelMap map) {
		map.addAttribute("searchVO", searchVO);
		map.addAttribute("mrNo", vo.getMrNo());
		map.addAttribute("theaNo", vo.getTheaNo());
		map.addAttribute("movNo", vo.getMovNo());
		map.addAttribute("movieList", movieService.selectMovieList());
		List list = theaterService.getScheduleListByDate(vo, searchVO, page);
		System.out.println(searchVO);
		System.out.println(list);
		map.addAttribute("pagingBean", list.get(0));
		map.addAttribute("scheduleList", list.get(1));
		return "schedule/schduleList.tiles";
	}
	
	@RequestMapping("setSchedule")
	@ResponseBody
	public String setSchedule(@ModelAttribute ScheduleVO vo, ModelMap map) {
		int count = theaterService.addSchedule(vo);
		map.addAttribute("mrNo", vo.getMrNo());
		return count == 5 ? "1" : "0";
	}
	
	@RequestMapping("modifyMovieroom")
	@ResponseBody
	public int modifyMovieroom(@ModelAttribute MovieroomVO vo) {
		return theaterService.modifyMovieroomByNo(vo);
	}
	
	@RequestMapping("getScheduleCount")
	@ResponseBody
	public int getScheduleCount(@ModelAttribute MovieroomVO vo) {
		return theaterService.getScheduleCount(vo);
	}
}