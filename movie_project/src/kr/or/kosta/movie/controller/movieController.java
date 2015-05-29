package kr.or.kosta.movie.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import kr.or.kosta.movie.model.service.movieService;
import kr.or.kosta.movie.vo.MovieVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/movie/")
public class movieController {
	@Autowired
	private movieService service;
	
	//영화등록 페이지
	@RequestMapping("register_form")
	public String registerForm(){
		
		return "movie/register_form.tiles";
		
	}
	
	@RequestMapping(value ="register.do", method=RequestMethod.POST)
	public String registerMovie(@ModelAttribute MovieVO movie, Errors errors, HttpServletRequest request) throws IllegalStateException, IOException{
	
		//파일업로드 처리
		MultipartFile file = movie.getPoster();
		System.out.println(file.getSize());
		
		
		if(file != null && !file.isEmpty()){
			String path = request.getServletContext().getRealPath("/images");
			String fileName = System.currentTimeMillis()+"";
			File image = new File(path, fileName);
			file.transferTo(image);
			movie.setPosterName(fileName);
		}
		
		System.out.println("2번 "+movie.getPosterName());
		
		service.registerMovie(movie);
		return "movie/register_success.tiles";
	}
	
	
	
		
}
	
	


