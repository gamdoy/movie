package kr.or.kosta.movie.controller;

import kr.or.kosta.movie.model.service.movieService;
import kr.or.kosta.movie.vo.MovieVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie/")
public class movieController {
	@Autowired
	private movieService service;
	
	@RequestMapping("register_form")
	public String registerForm(){
			
		
		return "/WEB-INF/view/movie/register_form.jsp";
		
	}
	
	@RequestMapping("register.do")
	public String registerMovie(@ModelAttribute MovieVO movie){
		System.out.println(movie.getClass());
		service.registerMovie(movie);
		return "/index.jsp";
	}
	
		
}
	
	


