package kr.or.kosta.files.view;


import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

/*
 * 
 */
public class DownloadView extends AbstractView{
	
	private String uploadDir = "C:\\JAVA\\apache-tomcat-7.0.59\\webapps\\movie_project\\upload";
	//응답할 내용의 타입(content-type)을 리턴
	public String getContentType(){
		return "application/octet-stream";//형식이 지정되지 않는 어플의 타입지정
	}
	public void renderMergedOutputModel(Map model, HttpServletRequest request, HttpServletResponse response) throws Exception{
		//model정보(ModelAndView)로 다운로드할 파일의 이름을 받아온다.
		String fileName=(String)model.get("downFile");
		
		//응답내용의 타입(응답 content-type)을 설정
		response.setContentType(getContentType());
		
		//파일명의 한글처리.
		String newfileName= new String(fileName.getBytes("euc-kr"), "8859_1");
		
		//응답 헤더에 다운로드 파일명을 지정
		response.setHeader("Content-Disposition", "attachment;filename="+newfileName);
		
		//IO를 통해 파일 => 클라이언트에 전송
		File file = new File(uploadDir, fileName);
		FileInputStream fi = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		FileCopyUtils.copy(fi, os);//fi에서 읽은 것은 os로 copy , while()을 대신 
		
	}
	
}
