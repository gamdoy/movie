package kr.or.kosta.movie.controller;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import kr.or.kosta.common.vo.SearchVO;
import kr.or.kosta.commoncode.model.service.CommonCodeService;
import kr.or.kosta.commoncode.vo.CommonCodeVO;
import kr.or.kosta.member.vo.MemberVO;
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
			String path = request.getServletContext().getRealPath("/images/movie");
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
	public String registerSuccsess(@RequestParam int movNo, ModelMap map) {
		MovieVO movie = service.getMovieByNo(movNo);
		map.addAttribute("movie", movie);
		return "movie/register_success.tiles";

	}

	// 영화 수정 페이지 이동
	@RequestMapping("modify_form.do")
	public String movieModify(@RequestParam int movNo, ModelMap map) {
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
	public String moditySuccess(@ModelAttribute MovieVO movie, ModelMap map, HttpServletRequest request, Errors errors) throws IllegalStateException, IOException{
		// 파일업로드 처리
				MultipartFile file = movie.getPoster();
				System.out.println(movie.getMovieNo());
				String newFileName=null;
				if (file != null && !file.isEmpty()) {
					newFileName = System.currentTimeMillis()+".jpg";
					System.out.println(newFileName+" : "+file.getOriginalFilename()+" : "+movie.getPosterName());
					String path = request.getServletContext().getRealPath("/images/movie");
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
				movie.setSuccess(success);
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
	
	//관리자 전체 영화 조회
	@RequestMapping("adminmovie_list.do")
	public String adminMovieList(@RequestParam(defaultValue="1")int pageNo, @ModelAttribute SearchVO vo,ModelMap map) {
		System.out.println("서치 " +vo);
		if(vo.getSearchType() != null && (vo.getSearchType().equals("mov_genre"))){
			vo.setSearchKeyword(service2.getCommonNo(vo.getSearchKeyword()));
		}
		Map movie = service.allMovieList(pageNo, vo);
		System.out.println(movie);
		map.addAttribute("moviePaging", movie);
		return "movie/adminMovieList_form.tiles";
	}
	
	//사용자 영화 리스트
	@RequestMapping("user_movie_list.do")
	public String userMovieList(ModelMap map){
		List movie= service.selectMovieList();
		map.put("movie", movie);
		System.out.println(movie);
		
		return "movie/userMovieList_form.tiles";
	}
	
	//사용자 영화조회
	@RequestMapping("user_movie_info.do")
	public String userMovieInfo(@RequestParam int movNo, ModelMap map, HttpSession session){
		
		MovieVO movie = service.getMovieByNo(movNo);
		MovieVO list = service.selFavorite(movNo);
		map.put("list",list);
		
		DecimalFormat format = new DecimalFormat(".#");
		double i= movie.getMovGrade() / movie.getMovCount();
		movie.setAvgGrade(format.format(i));
		
		map.put("movie", movie);
		return "movie/userMovieInfo.tiles";
		
	}
	//영화 평점
	@RequestMapping("/login/movieGrade.do")
	public String movieGrade(@RequestParam int star, @RequestParam int movNo, HttpSession session,ModelMap map){
		System.out.println("이건 나오나 "+star);
		System.out.println("건너온 영화번호 "+movNo);
		MovieVO movie = service.getMovieByNo(movNo);
		//평점 set
		movie.setMovGrade(movie.getMovGrade()+star);
		//세션로그인정보가 true 이면 평가 인원에 +1
		MemberVO member = (MemberVO) session.getAttribute("login_info");
		
		if(member!=null){
			movie.setMovCount(movie.getMovCount()+1);
		}
		// 평점/평가인원수 결과를 소수점1자리 까지만 표현
		DecimalFormat format = new DecimalFormat(".#");
		double i= movie.getMovGrade() / movie.getMovCount();
		movie.setAvgGrade(format.format(i));
		System.out.println(movie.getAvgGrade());
		service.updateMovie(movie);
		
		map.addAttribute("movie",movie);
		return "movie/userMovieInfo.tiles";
	}
	
	//관심영화 추가
	@RequestMapping("/login/addFavorite.do")
	public String addFavorate(@RequestParam int memNo, @RequestParam int movNo,   ModelMap map){
		//db 회원번호, 영화번호로 저장
		Map fav = new HashMap();
		fav.put("memNo",memNo);
		fav.put("movNo",movNo);
		service.addFavorite(fav);
		return "redirect:/movie/user_favorite2.do";
	}
	//redirect용
	@RequestMapping("user_favorite2.do")
	public String redirectFav(ModelMap map){
		List list = service.selFavoriteAll();
		System.out.println(list);
		map.put("movie", list);
		
		return "movie/user_favorite.tiles";
		
	}
	//관심영화 전체 조회
	@RequestMapping("user_favorate.do")
	public String favorList(ModelMap map){
		List list = service.selFavoriteAll();
		System.out.println(list);
		map.put("movie", list);
		return "movie/user_favorite.tiles";
	}
	
	//관심영화 삭제
	@RequestMapping("delFavor.do")
	public String delFavor(@RequestParam int movNo){
		System.out.println("넘어온번호 "+movNo);
		int i = service.delFavorite(movNo);
		System.out.println(i);
	return "/movie/user_favorate.do";
		
	}
	

}
