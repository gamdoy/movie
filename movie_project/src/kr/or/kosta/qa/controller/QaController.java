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

import kr.or.kosta.admin.model.service.AdminService;
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
@RequestMapping("/qa/login/")
public class QaController{
	private String images="C:\\JAVA\\apache-tomcat-7.0.59\\webapps\\movie_project\\upload";
	@Autowired
	private QaService service;
	private AdminService adminService;
	@RequestMapping(value="reply.do")
	public String reply_write(@RequestParam("fqNo")int fqNo, ModelMap map, @RequestParam("fqParentNumber")int fqParentNumber){
		
		map.addAttribute("fqNo",fqNo);
		map.addAttribute("fqParentNumber",fqParentNumber);
		return "qa/reply_write.tiles";
	}
	

	
	@RequestMapping(value="register_reply.do")
	public String addReply(HttpSession session, @ModelAttribute FilesVo svo, @ModelAttribute QaVO vo, ModelMap map, HttpServletRequest request) throws IllegalStateException, IOException{
		MemberVO mvo = (MemberVO) session.getAttribute("login_info");
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
		vo.setMemNo(mvo.getMemNo());
		QaVO reVo = service.getQa(vo.getFqNo());
		service.plusReplyStep();
		vo.setReplyStep(reVo.getReplyStep());
		vo.setReplyLevel(reVo.getReplyLevel()+1);
		vo.setFileNo(svo.getFileNo());
		service.updateReply(vo);
		service.register_reply(vo);
		System.out.println("rvo : "+vo);
		return "redirect:/qa/login/qa.do";
	}
	
	@RequestMapping(value="comment.do")
	public String addComment(@RequestParam("fqNo")int fqNo, @ModelAttribute CommentVO cvo, ModelMap map, HttpServletRequest request) {
		cvo.setComParentNumber(fqNo);
		service.registerComment(cvo);
		List list =service.getComment(fqNo);
		map.addAttribute("comment_list", list);
		return "redirect:/qa/login/selectQa.do?number="+fqNo;	
	}
	
	@RequestMapping(value="deleteComment.do")
	public String deleteQa(@RequestParam("comNo")int comNo, @RequestParam("fqNo")int fqNo){
		service.deleteComment(comNo);
		return "/qa/login/selectQa.do?number="+fqNo;	
	}
	
	@RequestMapping(value="selectComment_toModify.do")
	public String  selectComment_toModify(ModelMap map, @RequestParam("comNo")int comNo, @RequestParam("fqNo")int fqNo){
		return "redirect:/qa/login/selectQaToModifyComment.do?number="+fqNo+"&comNo="+comNo;		
	}
	
	@RequestMapping(value="comment_modify.do")
	public String  comment_modify(@RequestParam("fqNo")int fqNo, @ModelAttribute CommentVO cvo){
		
		service.modifyComment(cvo);
		return "/qa/login/selectQa.do?number="+fqNo;	
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
	
	//QA 수정페이지 이동 
	@RequestMapping(value="modify.do")
	public String  qa_modify(ModelMap map, @RequestParam("number")int fqNo, @ModelAttribute FilesVo svo,@RequestParam("fileName")String fileName){
		QaVO vo = service.getQa(fqNo);
		map.addAttribute("svo", svo);
		System.out.println("svo : "+svo);
		map.addAttribute("qaVO",vo);
		return "qa/qa_modify.tiles";	
	}
	
	
	//게시판 목록 선택
	@RequestMapping(value="selectQa.do")
	public String selectQa(@RequestParam("number")int fqNo, ModelMap map){
		int countComment = service.getCountComment(fqNo);
		map.addAttribute("countComment",  countComment);
		QaVO vo = service.getQa(fqNo);
		if(vo.getFileNo() != 0){
			FilesVo temp =service.selectFiles(vo.getFileNo());
			
			map.addAttribute("fileName", temp.getFileName());	
		}
		vo.setQaCount(vo.getQaCount()+1);
		service.modifyCount(vo);
		vo.setQaText(vo.getQaText().replace("\r\n", "<br>"));
		map.addAttribute("qa_vo",vo);
		List list =service.getComment(fqNo);
		map.addAttribute("comment_list", list);
		return "qa/qa_result.tiles";	
		
	}
	
	//코맨트 수정
	@RequestMapping(value="selectQaToModifyComment.do")
	public String selectQaToModifyComment(@RequestParam("number")int fqNo, ModelMap map, @RequestParam("comNo")int comNo){
		CommentVO cvo = service.getCommentByComNo(comNo);
		QaVO  vo = service.getQa(fqNo);
		
		FilesVo temp =service.selectFiles(vo.getFileNo());
		if(temp!=null){
			map.addAttribute("fileName", temp.getFileName());
		}
		vo.setQaCount(vo.getQaCount()+1);
		service.modifyCount(vo);
		vo.setQaText(vo.getQaText().replace("\r\n", "<br>"));
		map.addAttribute("qa_vo",vo);
		
		List list =service.getComment(fqNo);
		System.out.println("list : "+list);
		map.addAttribute("comment_list", list);
		map.addAttribute("cvo",cvo);
		return "qa/qa_comment_modify.tiles";	
	}
	
	//QA 삭제
	@RequestMapping(value="deleteQa.do")
	public String deleteQa(ModelMap map, @RequestParam("number")int fqNo){
		service.deleteQa(fqNo);
		return "/qa/login/qa.do";
	}
	
	//QAVO 등록
		@RequestMapping(value="addQa.do")
		public String addQa(HttpSession session, @ModelAttribute FilesVo svo, @ModelAttribute QaVO vo, ModelMap map, HttpServletRequest request) throws IllegalStateException, IOException{
			MemberVO mvo = (MemberVO) session.getAttribute("login_info");
			
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
			
			vo.setMemNo(mvo.getMemNo());
			vo.setMemId(mvo.getMemId());
			
			vo.setReplyLevel(0);
			vo.setFileNo(svo.getFileNo());
			service.registerQaList(vo);
			
			return "redirect:/qa/login/qa.do";
		}
		
	//QA수정
	@RequestMapping(value="modifyQa.do")
	public String modifyQa(@RequestParam("fqNo")int fqNo, ModelMap map, @ModelAttribute QaVO vo , @ModelAttribute FilesVo svo, HttpServletRequest request) throws IllegalStateException, IOException{
		MultipartFile file = svo.getUpfile();
		
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != ""){
			String path = request.getServletContext().getRealPath("/upload");
			String name=file.getOriginalFilename();
			File upfile = new File(path, name);
			file.transferTo(upfile);
			svo.setFileName(name);	
			service.modifyFile(svo);
			svo.setFileOrinName(name);
			vo.setFileNo(svo.getFileNo());
			service.insertFiles(svo);	
			vo.setFileNo(svo.getFileNo());
		}else {
			service.deleteFile(vo.getFileNo());
			vo.setFileNo(0);
		}
		System.out.println(vo);
		service.modifyQa(vo);
		return "/qa/login/qa.do";
	}
	
	//다운로드 뷰 
	@RequestMapping("download.do")
	public String download(@RequestParam String filename, ModelMap map){	
		map.addAttribute("downFile", filename); 
		return "downloadView";
	}
	//QA리스트
	@RequestMapping(value="qa.do")
	public String getQaByKeyword(HttpSession session, ModelMap map, @RequestParam(defaultValue="1")int page, @ModelAttribute SearchVO svo){
		MemberVO mvo = (MemberVO) session.getAttribute("login_info");
		Map qaList = new HashMap();
		QaVO qaVo;
		qaList = service.selectQaBySearchVOPaging(svo, page);
		map.addAttribute("pageMap", qaList);
		map.addAttribute("currentSearchType", svo.getSearchType());
		map.addAttribute("currentSearchKeyword", svo.getSearchKeyword());
		
		if(mvo==null){
			//비회원
			return "main.tiles";
		}else if(mvo.getMemMemberType().equals("102300")){
		//관리자모드
			return "qa/qa_list_admin.tiles";
		}else{
			return "qa/qa_list.tiles";	
		}
	}
}
