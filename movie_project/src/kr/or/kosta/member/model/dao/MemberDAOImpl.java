package kr.or.kosta.member.model.dao;

import java.util.List;

import kr.or.kosta.member.vo.MemberVO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{
	private String namespace = "member.dao.memberMapper.";
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public MemberVO selectMemberById(String id) {
		return session.selectOne(namespace+"selectMemberById",id);
	}

	@Override
	public int insertMember(MemberVO membervo) {
		return session.insert(namespace+"insertMember",membervo);
	}

	@Override
	public int updateMember(MemberVO membervo) {
		return session.update(namespace+"updateMember",membervo);
	}

	@Override
	public int deleteMemberById(String id) {
		return session.delete(namespace+"deleteMemberById",id);
	}

	@Override
	public List<MemberVO> selectAllMember() {
		return session.selectList(namespace+"selectAllMember");
	}

}
