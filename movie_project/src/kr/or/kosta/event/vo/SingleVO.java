package kr.or.kosta.event.vo;

import org.springframework.web.multipart.MultipartFile;

public class SingleVO {
	
	private int singleFileNo;
	private String singleTitle;
	private MultipartFile singleUpfile; //input type=file 과 매칭되는 변수 
	private String singleInfo;
	
	public SingleVO(){}

	public int getSingleFileNo() {
		return singleFileNo;
	}

	public void setSingleFileNo(int singleFileNo) {
		this.singleFileNo = singleFileNo;
	}

	public String getSingleTitle() {
		return singleTitle;
	}

	public void setSingleTitle(String singleTitle) {
		this.singleTitle = singleTitle;
	}

	public MultipartFile getUpfile() {
		return singleUpfile;
	}

	public void setUpfile(MultipartFile singleUpfile) {
		this.singleUpfile = singleUpfile;
	}

	public String getInfo() {
		return singleInfo;
	}

	public void setInfo(String singleInfo) {
		this.singleInfo = singleInfo;
	}

	
	
}
