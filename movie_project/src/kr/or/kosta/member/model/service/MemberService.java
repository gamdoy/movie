package kr.or.kosta.member.model.service;

import java.util.List;

import kr.or.kosta.member.exception.DuplicatedIdException;
import kr.or.kosta.member.vo.MemberVO;

public interface MemberService {

	//회원 가입 메소드
	public abstract void joinMember(MemberVO membervo) throws DuplicatedIdException;
	
	//회원정보수정 메소드
	public abstract void modifyMember(MemberVO membervo);
	
	//회원 탈퇴 메소드
	public abstract void removeMember(String id);
	
	//회원id로 조회
	public abstract MemberVO getMemberById(String id); 
	
	//전체회원 목록 조회 메소드
	public abstract List<MemberVO> getMemberList();
}