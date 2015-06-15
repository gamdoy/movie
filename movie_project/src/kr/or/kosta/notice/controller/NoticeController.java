package kr.or.kosta.notice.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.or.kosta.center.vo.QaVO;
import kr.or.kosta.common.vo.SearchVO;
import kr.or.kosta.files.vo.FilesVo;
import kr.or.kosta.notice.model.service.NoticeService;
import kr.or.kosta.notice.vo.NoticeVO;
import kr.or.kosta.qa.model.service.QaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/notice/")
public class NoticeController{
	
	private String images="C:\\JAVA\\apache-tomcat-7.0.59\\webapps\\movie_project\\upload";
	@Autowired
	private NoticeService service;
	
	@RequestMapping(value="notice.do")
	public String notice_list(ModelMap map, @RequestParam(defaultValue="1")int page){
		
		Map pageMap = service.getNoticeListPaging(page);
		map.addAttribute("pageMap",pageMap);
		
		List<NoticeVO> list= service.getNoticeList();
		map.addAttribute("notice_list",list);
		
		return "notice/notice_list.tiles";
	}
	
	@RequestMapping(value="write.do")
	public String notice_write(){
		return "notice/notice_write.tiles";
	}
	
	@RequestMapping(value="modify.do")
	public String  notice_modify(ModelMap map, @RequestParam("number")int notiNo, @ModelAttribute FilesVo svo){
		
		NoticeVO vo = service.getNotice(notiNo);
		map.addAttribute("svo", svo);
		map.addAttribute("NoticeVO",vo);
	
		return "notice/notice_modify.tiles";
		
	}
	
	@RequestMapping(value="addNotice.do")
	public String addNotice(@ModelAttribute FilesVo svo, @ModelAttribute NoticeVO vo, ModelMap map, HttpServletRequest request) throws IllegalStateException, IOException{
		MultipartFile file = svo.getUpfile();
		if (file != null && !file.isEmpty()) {
			String path = request.getServletContext().getRealPath("/upload");
			String fileName = file.getOriginalFilename();
			File upfile = new File(path, fileName);
			file.transferTo(upfile);
			svo.setFileOrinName(fileName);
			svo.setFileName(fileName);		
		}else{
			System.out.println("파일이없어");
		}
			
		service.registerNoticeList(vo);
		svo.setFileParentNo(vo.getNotiNo());
		service.insertFiles(svo);
		FilesVo fvo = service.selectFiles(vo.getNotiNo());
		vo.setFileNo(fvo.getFileNo());
		service.modifyNoticeFileNumber(vo);
		System.out.println("작성 후 VO : "+vo);
		return "/notice/notice.do";
	}
	
	
	@RequestMapping(value="selectNotice.do")
	public String selectQa(@RequestParam("number")int notiNo, ModelMap map){
		NoticeVO vo = service.getNotice(notiNo);
		FilesVo temp =service.selectFiles(notiNo);
		map.addAttribute("fileName", temp.getFileName());
		vo.setNotiCount(vo.getNotiCount()+1);
		
		service.modifyCount(vo);
		map.addAttribute("NoticeVO",vo);
		return "notice/notice_result.tiles";	
	}
	
	@RequestMapping(value="deleteNotice.do")
	public String deleteNotice(ModelMap map, @RequestParam("number")int notiNo){
		service.deleteNotice(notiNo);
		return "/notice/notice.do";
	}
	
	@RequestMapping(value="modifyN.do")
	public String modifyQa(@RequestParam("notiNo")int notiNo, ModelMap map, @ModelAttribute NoticeVO vo , @ModelAttribute FilesVo svo, HttpServletRequest request) throws IllegalStateException, IOException{
		MultipartFile file = svo.getUpfile();
		svo.setFileNo(service.selectFiles(notiNo).getFileNo());
		svo.setFileParentNo(service.selectFiles(notiNo).getFileNo());
		String path = "C:\\JAVA\\apache-tomcat-7.0.59\\webapps\\movie_project\\upload";
		String name=file.getOriginalFilename();
		File upfile = new File(path, name);
		file.transferTo(upfile);
		svo.setFileName(name);	
		service.modifyFile(svo);
		vo.setNoticeParentNumber(svo.getFileNo());
		vo.setFileNo(svo.getFileNo());
		service.modifyNotice(vo);
		return "/notice/notice.do";
	}
	
	@RequestMapping("download.do")
	public String download(@RequestParam String filename, ModelMap map){
		map.addAttribute("downFile", filename); //다운로드 할 파일명을 넣어 view로 이동
		return "downloadView";
	}
	
	@RequestMapping("getNoticeByKeyword.do")
	public String getQaByKeyword(ModelMap map, @RequestParam("searchType") String searchType, @RequestParam("searchKeyword") String searchKeyword){
		
		SearchVO svo = new SearchVO();
		Map noticeList = new HashMap();
		svo.setSearchType(searchType);
		
		svo.setSearchKeyword(searchKeyword);
		List<NoticeVO> list = service.selectNoticeBySearchVO(svo);
		noticeList.put("noticeList", list);
		map.addAttribute("noticeMap", noticeList);
		return "notice/searched_noticeList.tiles";
		
	}
}
