package kr.or.kosta.stats.controller;

import java.util.List;

import kr.or.kosta.stats.model.service.StatsService;
import kr.or.kosta.stats.vo.StatsVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stats/")
public class StatsController {
	
	@Autowired
	private StatsService statsService;
	
		@RequestMapping("statistics_form")
		public String goStatisticsForm(){
			return "stats/statistics_form.tiles";
		}
		
		@RequestMapping("booking_status_form")
		public String getBookingStatus(){
			return "stats/booking_status_form.tiles";
		}
		
		@RequestMapping("seat_occupancy_form")
		public String getSeatOccupancy(){
			return "stats/seat_occupancy_form.tiles";
		}
		
		@RequestMapping("statistics_list")
		public String getStatisticsList(ModelMap map){
			List<StatsVO> list= statsService.getStatistics();
			map.addAttribute("statsList", list);
			return  "stats/statistics_form.tiles";
		}
}
