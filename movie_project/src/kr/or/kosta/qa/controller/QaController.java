package kr.or.kosta.qa.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.or.kosta.center.vo.QaVO;
import kr.or.kosta.event.model.service.EventService;
import kr.or.kosta.event.vo.EventVO;
import kr.or.kosta.files.vo.FilesVo;
import kr.or.kosta.qa.model.service.QaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/qa/")
public class QaController{
	private String images="C:\\JAVA\\apache-tomcat-7.0.59\\webapps\\spring_mvc_05_fileUpload\\upimage";
	@Autowired
	private QaService service;
	
	@RequestMapping(value="qa.do")
	public String qa_list(ModelMap map, @RequestParam(defaultValue="1")int page){
		Map pageMap = service.getQaListPaging(page);
		map.addAttribute("pageMap",pageMap);
		
		List<QaVO> list= service.getQaList();
		map.addAttribute("qa_list",list);
		
		return "qa/qa_list.tiles";
	}
	
	@RequestMapping(value="write.do")
	public String qa_write(){
		return "qa/qa_write.tiles";
	}
	
	@RequestMapping(value="modify.do")
	public String  qa_modify(ModelMap map, @RequestParam("number")int fqNo, @ModelAttribute FilesVo svo){
		
		QaVO vo = service.getQa(fqNo);
		System.out.println("야호 : " +vo);
		map.addAttribute("svo", svo);
		map.addAttribute("qaVO",vo);
	
		return "qa/qa_modify.tiles";
		
	}
	@RequestMapping(value="addQa.do")
	public String addQa(@ModelAttribute FilesVo svo, @ModelAttribute QaVO vo, ModelMap map, HttpServletRequest request) throws IllegalStateException, IOException{
		MultipartFile file = svo.getUpfile();
		if (file != null && !file.isEmpty()) {
			String path = request.getServletContext().getRealPath("/images");
			String fileName = file.getOriginalFilename();
			File upfile = new File(path, fileName);
			file.transferTo(upfile);
			svo.setFileOrinName(fileName);
			svo.setFileName(fileName);		
		}else{
			System.out.println("파일이없어");
		}
		vo.setMemId("ID-01");
		vo.setQaStatus("stas");
		vo.setMemNo(1);
		vo.setQaSecret("111");
		service.registerQaList(vo);
		svo.setFileParentNo(vo.getFqNo());
		service.insertFiles(svo);
		FilesVo fvo = service.selectFiles(vo.getFqNo());
		vo.setFileNo(fvo.getFileNo());
		service.modifyQaFileNumber(vo);
		System.out.println("작성 후 VO : "+vo);
		return "/qa/qa.do";
	}
	
	@RequestMapping(value="selectQa.do")
	public String selectQa(@RequestParam("number")int fqNo, ModelMap map){
		QaVO vo = service.getQa(fqNo);
		System.out.println("111:" +vo);
		FilesVo temp =service.selectFiles(fqNo);
		map.addAttribute("fileName", temp.getFileName());
		vo.setQaCount(vo.getQaCount()+1);
		
		service.modifyCount(vo);
		System.out.println("select 후 : "+vo);
		map.addAttribute("qa_vo",vo);
		return "qa/qa_result.tiles";	
	}
	@RequestMapping(value="deleteQa.do")
	public String deleteQa(ModelMap map, @RequestParam("number")int fqNo){
		service.deleteQa(fqNo);
		return "/qa/qa.do";
	}
	@RequestMapping(value="modifyQa.do")
	public String modifyQa(@RequestParam("fqNo")int fqNo, ModelMap map, @ModelAttribute QaVO vo , @ModelAttribute FilesVo svo, HttpServletRequest request) throws IllegalStateException, IOException{
		MultipartFile file = svo.getUpfile();
		svo.setFileNo(service.selectFiles(fqNo).getFileNo());
		svo.setFileParentNo(service.selectFiles(fqNo).getFileNo());
		String path = "C:\\JAVA\\apache-tomcat-7.0.59\\webapps\\movie_project\\images";
		String name=file.getOriginalFilename();
		File upfile = new File(path, name);
		file.transferTo(upfile);
		svo.setFileName(name);	
		service.modifyFile(svo);
		vo.setFqParentNumber(svo.getFileNo());
		vo.setFileNo(svo.getFileNo());
		service.modifyQa(vo);
		return "/qa/qa.do";
	}
	
	@RequestMapping("download.do")
	public String download(@RequestParam String filename, ModelMap map){
		map.addAttribute("downFile", filename); //다운로드 할 파일명을 넣어 view로 이동
		return "downloadView";
	}
	

	
	
}
