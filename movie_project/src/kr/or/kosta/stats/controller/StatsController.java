package kr.or.kosta.stats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stats/")
public class StatsController {
		@RequestMapping(value="cal")
		public String testCal(){
			return "stats/statistics_form.tiles";
		}
}
