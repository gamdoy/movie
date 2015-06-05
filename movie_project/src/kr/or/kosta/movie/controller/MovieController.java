package kr.or.kosta.movie.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.or.kosta.commoncode.model.service.CommonCodeService;
import kr.or.kosta.commoncode.model.service.CommonCodeServiceImpl;
import kr.or.kosta.commoncode.vo.CommonCodeVO;
import kr.or.kosta.movie.model.service.MovieService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/movie/")
public class MovieController {
	@Autowired
	private MovieService service;

	@Autowired
	private CommonCodeService service2;

	// 영화등록 페이지
	@RequestMapping("register_form.do")
	public String registerForm(ModelMap map) {

		// commonCode 사용
		List<CommonCodeVO> screenGrade = service2.getCodeList("104");
		List<CommonCodeVO> genre = service2.getCodeList("110");
		// 감독,배우,제작사
		List<DirectorVO> director = service.getDirector();
		List<ActorVO> actor = service.getActor();
		List<ProductionVO> production = service.getProduction();

		map.addAttribute("screenGrade", screenGrade);
		map.addAttribute("genre", genre);
		map.addAttribute("dirNo", director);
		map.addAttribute("actNo", actor);
		map.addAttribute("proNo", production);

		return "movie/register_form.tiles";
	}

	// 영화등록 로직
	@RequestMapping(value = "register.do")
	public String registerMovie(@ModelAttribute MovieVO movie, Errors errors,
			HttpServletRequest request) throws IllegalStateException,
			IOException {

		// 파일업로드 처리
		MultipartFile file = movie.getPoster();
		if (file != null && !file.isEmpty()) {
			String path = request.getServletContext().getRealPath("/images");
			String fileName = System.currentTimeMillis()+".jpg";
			File image = new File(path, fileName);
			file.transferTo(image);
			movie.setPosterName(fileName);
		}
		
		service.registerMovie(movie);

		System.out.println("db작업후 " + movie);

		return "redirect:/movie/register_success.do?movNo="
				+ movie.getMovieNo();
	}

	// 등록 성공
	@RequestMapping("register_success.do")
	public String registerSuccsess(@RequestParam String movNo, ModelMap map) {
		MovieVO movie = service.getMovieByNo(movNo);
		map.addAttribute("movie", movie);
		return "movie/register_success.tiles";

	}

	// 영화 수정 페이지 이동
	@RequestMapping("modify_form.do")
	public String movieModify(@RequestParam String movNo, ModelMap map) {
		
		MovieVO movie = service.getMovieByNo(movNo);
		System.out.println(movie);
		map.addAttribute("movie", movie);

		// commonCode 사용
		List<CommonCodeVO> screenGrade = service2.getCodeList("104");
		List<CommonCodeVO> genre = service2.getCodeList("110");
		// 감독,배우,제작사
		List<DirectorVO> director = service.getDirector();
		List<ActorVO> actor = service.getActor();
		List<ProductionVO> production = service.getProduction();

		map.addAttribute("screenGrade", screenGrade);
		map.addAttribute("genre", genre);
		map.addAttribute("dirNo", director);
		map.addAttribute("actNo", actor);
		map.addAttribute("proNo", production);

		return "movie/modify_form.tiles";
	}
	
	//수정페이지
	@RequestMapping("modify_success.do")
	public String moditySuccess(@ModelAttribute MovieVO movie, ModelMap map, HttpServletRequest request) throws IllegalStateException, IOException{
	
		// 파일업로드 처리
				MultipartFile file = movie.getPoster();
				
				System.out.println(movie.getMovieNo());
				
				String newFileName=null;
				if (file != null && !file.isEmpty()) {
					newFileName = System.currentTimeMillis()+".jpg";
					System.out.println(newFileName+" : "+file.getOriginalFilename()+" : "+movie.getPosterName());
					String path = request.getServletContext().getRealPath("/images");
					File image = new File(path, newFileName);
					file.transferTo(image);
					//기존사진 있는 경우 삭제
					if(movie.getPosterName()!=null){
						File oldImage = new File(path,movie.getPosterName());
						oldImage.delete();
					}
					movie.setPosterName(newFileName);
				}
				
				int success = service.updateMovie(movie);
				movie.setsuccess(success);
				
				System.out.println(success);
				map.addAttribute("movie", movie);
				
				// commonCode 사용
				List<CommonCodeVO> screenGrade = service2.getCodeList("104");
				List<CommonCodeVO> genre = service2.getCodeList("110");
				// 감독,배우,제작사
				List<DirectorVO> director = service.getDirector();
				List<ActorVO> actor = service.getActor();
				List<ProductionVO> production = service.getProduction();

				map.addAttribute("screenGrade", screenGrade);
				map.addAttribute("genre", genre);
				map.addAttribute("dirNo", director);
				map.addAttribute("actNo", actor);
				map.addAttribute("proNo", production);
				
				return "movie/modify_form.tiles";
	}

	
	
	// 전체 영화 조회
	@RequestMapping("adminmovie_list.do")
	public String adminMovieList(ModelMap map) {
		List<MovieVO> movie = service.allMovieList();
		
		map.addAttribute("movie", movie);
		return "movie/adminMovieList_form.tiles";

	}
	

}