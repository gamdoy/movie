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
	public void joinMember(MemberVO membervo) throws DuplicatedIdException {
		if(dao.selectMemberById(membervo.getMemId())!=null){
			throw new DuplicatedIdException(membervo.getMemId()+"는 이미 등록된 아이디입니다.");
		}
		dao.insertMember(membervo);
	}

	@Override
	public void modifyMember(MemberVO membervo) {
		dao.updateMember(membervo);
	}

	@Override
	public void removeMember(String id) {
		dao.deleteMemberById(id);
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

	
}
