package kr.or.kosta.movie.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.or.kosta.commoncode.model.service.CommonCodeService;
import kr.or.kosta.commoncode.model.service.CommonCodeServiceImpl;
import kr.or.kosta.commoncode.vo.CommonCodeVO;
import kr.or.kosta.movie.model.service.movieService;
import kr.or.kosta.movie.vo.ActorVO;
import kr.or.kosta.movie.vo.DirectorVO;
import kr.or.kosta.movie.vo.MovieVO;
import kr.or.kosta.movie.vo.ProductionVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	
	@Autowired
	private CommonCodeService service2;
	
	//영화등록 페이지
	@RequestMapping("register_form")
	public String registerForm(ModelMap map){
		
		//commonCode 사용 
		List<CommonCodeVO> screenGrade = service2.getCodeList("104");
		System.out.println(screenGrade);
		List<CommonCodeVO> genre = service2.getCodeList("110");
		
		
		List<DirectorVO> director = service.getDirector();
		List<ActorVO> actor = service.getActor();
		List<ProductionVO> production = service.getProduction();
		
		
		map.addAttribute("screenGrade",screenGrade);
		map.addAttribute("genre",genre);
		map.addAttribute("director",director);
		map.addAttribute("actor",actor);
		map.addAttribute("production",production);
		
		
		return "movie/register_form.tiles";
		 
	}
	
	@RequestMapping(value ="register.do", method=RequestMethod.POST)
	public String registerMovie(@ModelAttribute MovieVO movie, Errors errors, HttpServletRequest request) throws IllegalStateException, IOException{
	
		//파일업로드 처리
		MultipartFile file = movie.getPoster();
		
		
		if(file != null && !file.isEmpty()){
			String path = request.getServletContext().getRealPath("/images");
			String fileName = System.currentTimeMillis()+"";
			File image = new File(path, fileName);
			file.transferTo(image);
			movie.setPosterName(fileName);
		}
		
		
		System.out.println("영화등급 "+movie.getScreeningGrade());
		
		service.registerMovie(movie);
		return "movie/register_success.tiles";
	}
	
	
	
	
	
	
	
		
}
	
	


