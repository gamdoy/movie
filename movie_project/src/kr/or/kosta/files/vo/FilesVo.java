package kr.or.kosta.files.vo;

import org.springframework.web.multipart.MultipartFile;

public class FilesVo {
	private int fileNo;
	private int fileParentNo;
	private String fileName;
	private String fileOrinName;
	
	private MultipartFile upfile;
	
	public FilesVo() {}

	public FilesVo(int fileNo, int fileParentNo, String fileName,
			String fileOrinName, MultipartFile upfile) {
		super();
		this.fileNo = fileNo;
		this.fileParentNo = fileParentNo;
		this.fileName = fileName;
		this.fileOrinName = fileOrinName;
		this.upfile = upfile;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public int getFileParentNo() {
		return fileParentNo;
	}

	public void setFileParentNo(int fileParentNo) {
		this.fileParentNo = fileParentNo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileOrinName() {
		return fileOrinName;
	}

	public void setFileOrinName(String fileOrinName) {
		this.fileOrinName = fileOrinName;
	}

	public MultipartFile getUpfile() {
		return upfile;
	}

	public void setUpfile(MultipartFile upfile) {
		this.upfile = upfile;
	}

	@Override
	public String toString() {
		return "FilesVo [fileNo=" + fileNo + ", fileParentNo=" + fileParentNo
				+ ", fileName=" + fileName + ", fileOrinName=" + fileOrinName
				+ ", upfile=" + upfile + "]";
	}

	
	
}
