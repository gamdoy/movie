package kr.or.kosta.member.model.dao;

import java.util.List;

import kr.or.kosta.member.vo.MemberVO;

public interface MemberDAO {

	//id로 회원정보 조회하여 return
	public abstract MemberVO selectMemberById(String id);
	
	//이름으로 회원정보 조회하여 return
	public abstract MemberVO selectMemberByname(MemberVO membervo);
	
	//회원탈퇴 확인시 멤버타입교체하여 return
	public abstract int memberLeave(MemberVO membervo);
	
	//회원정보 db에 insert
	public abstract int insertMember(MemberVO membervo);
	
	//회원아이디로 비밀번호조회
	public abstract MemberVO selectMemberPassword(MemberVO membervo);
	
	//회원정보 수정 
	public abstract int updateMember(MemberVO membervo);
	
	//매개변수로받은 id의 회원을 삭제
	public abstract int deleteMemberById(String id);
	
	//전체회원정보 조회
	public abstract List<MemberVO>selectAllMember();

	public abstract MemberVO selectMemberByNo(int memNo);
}
