package kr.or.kosta.member.model.service;

import java.util.List;

import kr.or.kosta.member.exception.DuplicatedIdException;
import kr.or.kosta.member.model.dao.MemberDAO;
import kr.or.kosta.member.vo.MemberVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO dao;
	
	@Override
	public int joinMember(MemberVO membervo) throws DuplicatedIdException {
		if(dao.selectMemberById(membervo.getMemId())!=null){
			throw new DuplicatedIdException(membervo.getMemId()+"는 이미 등록된 아이디입니다.");
		}
		return dao.insertMember(membervo);
	}

	@Override
	public int modifyMember(MemberVO membervo) {
		return dao.updateMember(membervo);
	}

	@Override
	public int removeMember(String id) {
		return dao.deleteMemberById(id);
	}

	@Override
	public List<MemberVO> getMemberList() {
		List <MemberVO> list = dao.selectAllMember();
		return list;
	}

	@Override
	public MemberVO getMemberById(String id) {
		
		return dao.selectMemberById(id);
	}

	public MemberVO getMemberByNo(int memNo){
		return dao.selectMemberByNo(memNo);
	}

	@Override
	public MemberVO getMemberByname(MemberVO membervo) {
		return dao.selectMemberByname(membervo);
	}

	@Override
	public MemberVO getMemberPassword(MemberVO membervo) {
		return dao.selectMemberPassword(membervo);
	}

	@Override
	public int leaveMember(MemberVO membervo) {
		return dao.memberLeave(membervo);
	}
	
}
