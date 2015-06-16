package kr.or.kosta.qa.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.kosta.admin.vo.AdminVO;
import kr.or.kosta.center.vo.CommentVO;
import kr.or.kosta.center.vo.QaVO;
import kr.or.kosta.common.vo.SearchVO;
import kr.or.kosta.event.model.service.EventService;
import kr.or.kosta.event.vo.EventVO;
import kr.or.kosta.files.vo.FilesVo;
import kr.or.kosta.member.vo.MemberVO;
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
	private String images="C:\\JAVA\\apache-tomcat-7.0.59\\webapps\\movie_project\\upload";
	@Autowired
	private QaService service;
	
	@RequestMapping(value="reply.do")
	public String reply_write(@RequestParam("fqNo")int fqNo, ModelMap map, @RequestParam("fqParentNumber")int fqParentNumber){
		
		map.addAttribute("fqNo",fqNo);
		map.addAttribute("fqParentNumber",fqParentNumber);
		return "qa/reply_write.tiles";
	}
	
	@RequestMapping(value="register_reply.do")
	public String addReply(@ModelAttribute FilesVo svo, @ModelAttribute QaVO vo, ModelMap map, HttpServletRequest request) throws IllegalStateException, IOException{
		MultipartFile file = svo.getUpfile();
		if (file != null && !file.isEmpty()) {
			
			String path = request.getServletContext().getRealPath("/upload");
			String fileName = file.getOriginalFilename();
			File upfile = new File(path, fileName);
			file.transferTo(upfile);
			svo.setFileOrinName(fileName);
			svo.setFileName(fileName);		
			service.insertFiles(svo);
		}else{
			System.out.println("선택된 파일이 없습니다.");
		}
		vo.setMemId("ID-01");
		vo.setQaStatus("stas");
		vo.setMemNo(1);
		QaVO reVo = service.getQa(vo.getFqNo());
		System.out.println("reVO의 Level");
		vo.setReplyStep(reVo.getReplyStep());
		vo.setReplyLevel(reVo.getReplyLevel());
		vo.setFileNo(svo.getFileNo());
		
		service.updateReply(vo);
		System.out.println("변경후 : "+vo.getFqNo());
		vo.setReplyStep(reVo.getReplyStep());
		vo.setReplyLevel(reVo.getReplyLevel()+1);
		
		service.register_reply(vo);
		System.out.println("rvo : "+vo);
		
		
		return "redirect:/qa/qa.do";
	}
	
	@RequestMapping(value="comment.do")
	public String addComment(@ModelAttribute QaVO vo, @RequestParam("fqNo")int fqNo, @ModelAttribute CommentVO cvo, ModelMap map, HttpServletRequest request) {
		cvo.setComParentNumber(fqNo);
		service.registerComment(cvo);
		List list =service.getComment(fqNo);
		map.addAttribute("comment_list", list);
		return "redirect:/qa/selectQa.do?number="+fqNo;	
	}
	
	@RequestMapping(value="deleteComment.do")
	public String deleteQa(@RequestParam("comNo")int comNo, @RequestParam("fqNo")int fqNo){
		service.deleteComment(comNo);
		return "/qa/selectQa.do?number="+fqNo;	
	}
	
	@RequestMapping(value="selectComment_toModify.do")
	public String  selectComment_toModify(ModelMap map, @RequestParam("comNo")int comNo, @RequestParam("fqNo")int fqNo){
		return "redirect:/qa/selectQaToModifyComment.do?number="+fqNo+"&comNo="+comNo;		
	}
	
	@RequestMapping(value="comment_modify.do")
	public String  comment_modify(@RequestParam("fqNo")int fqNo, @ModelAttribute CommentVO cvo){
		
		service.modifyComment(cvo);
		return "/qa/selectQa.do?number="+fqNo;	
	}
	
	
	public String qa_list(ModelMap map, @RequestParam(defaultValue="1")int page){
		
		Map pageMap = service.getQaListPaging(page);
		map.addAttribute("pageMap",pageMap);
		
		List<QaVO> list= service.getQaList();
		map.addAttribute("qa_list",list);
		
		return "/qa/qa_list.tiles";
	}
	
	@RequestMapping(value="write.do")
	public String qa_write(){
		return "qa/qa_write.tiles";
	}
	
	@RequestMapping(value="modify.do")
	public String  qa_modify(ModelMap map, @RequestParam("number")int fqNo, @ModelAttribute FilesVo svo){
		QaVO vo = service.getQa(fqNo);
		map.addAttribute("svo", svo);
		map.addAttribute("qaVO",vo);
		return "qa/qa_modify.tiles";	
	}
	@RequestMapping(value="addQa.do")
	public String addQa(@ModelAttribute FilesVo svo, @ModelAttribute QaVO vo, ModelMap map, HttpServletRequest request) throws IllegalStateException, IOException{
		MultipartFile file = svo.getUpfile();
		if (file != null && !file.isEmpty()) {
			String path = request.getServletContext().getRealPath("/upload");
			String fileName = file.getOriginalFilename();
			File upfile = new File(path, fileName);
			file.transferTo(upfile);
			svo.setFileOrinName(fileName);
			svo.setFileName(fileName);		
			service.insertFiles(svo);
		
		}else{
			System.out.println("선택된 파일이 없습니다.");
		}
		vo.setMemId("ID-01");
		vo.setQaStatus("stas");
		vo.setMemNo(1);
		vo.setReplyStep(0);
		vo.setReplyLevel(0);
		
		vo.setFileNo(svo.getFileNo());
		
		service.registerQaList(vo);
		
		
		return "redirect:/qa/qa.do";
	}
	
	@RequestMapping(value="selectQa.do")
	public String selectQa(@RequestParam("number")int fqNo, ModelMap map){
		int countComment = service.getCountComment(fqNo);
		map.addAttribute("countComment",  countComment);
		QaVO vo = service.getQa(fqNo);
		if(vo.getFileNo() != 0){
			FilesVo temp =service.selectFiles(vo.getFileNo());
			System.out.println(temp);
			map.addAttribute("fileName", temp.getFileName());	
		}
		vo.setQaCount(vo.getQaCount()+1);
		service.modifyCount(vo);
		vo.setQaText(vo.getQaText().replace("\r\n", "<br>"));
		map.addAttribute("qa_vo",vo);
		List list =service.getComment(fqNo);
		map.addAttribute("comment_list", list);
		System.out.println("select : "+vo);
		return "qa/qa_result.tiles";	
		
	}
	
	@RequestMapping(value="selectQaToModifyComment.do")
	public String selectQaToModifyComment(@RequestParam("number")int fqNo, ModelMap map, @RequestParam("comNo")int comNo){
		CommentVO cvo = service.getCommentByComNo(comNo);
		QaVO  vo = service.getQa(fqNo);
		FilesVo temp =service.selectFiles(vo.getFileNo());
		map.addAttribute("fileName", temp.getFileName());
		vo.setQaCount(vo.getQaCount()+1);
		service.modifyCount(vo);
		vo.setQaText(vo.getQaText().replace("\r\n", "<br>"));
		map.addAttribute("qa_vo",vo);
		List list =service.getComment(fqNo);
		map.addAttribute("comment_list", list);
		map.addAttribute("cvo",cvo);
		return "qa/qa_comment_modify.tiles";	
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
		String path = "C:\\JAVA\\apache-tomcat-7.0.59\\webapps\\movie_project\\upload";
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
	
	@RequestMapping(value="qa.do")
	public String getQaByKeyword(HttpSession session, ModelMap map, @RequestParam(defaultValue="1")int page, @ModelAttribute SearchVO svo){
		//MemberVO member = (MemberVO) session.getAttribute("login_info");
		//String memberType = member.getMemMemberType();
		
		Map qaList = new HashMap();
		QaVO qaVo;
	
		//Map pageMap = service.getQaListPaging(page);
		//map.addAttribute("pageMap",pageMap);
		
		//selectQaBySearchVOPaging -> svo 의 searchType, searchKeyword, 현재 page 를 이용하여 페이징된 list 리턴
		qaList = service.selectQaBySearchVOPaging(svo, page);
		System.out.println("ㅇㅇㅇgetQaByKeyword : "+qaList);
		map.addAttribute("pageMap", qaList);
		map.addAttribute("currentSearchType", svo.getSearchType());
		map.addAttribute("currentSearchKeyword", svo.getSearchKeyword());
		
		return "qa/qa_list.tiles";
	}
	
	
	
}
