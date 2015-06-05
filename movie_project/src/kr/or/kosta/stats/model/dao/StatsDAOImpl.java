package kr.or.kosta.stats.model.dao;

import java.util.List;

import kr.or.kosta.stats.vo.StatsVO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StatsDAOImpl implements StatsDAO{
	private String namespace="stats.dao.statsMapper.";
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public List<StatsVO> selectMovieViewers() {
		return session.selectList(namespace+"selectMovieViewers");
	}
	
	@Override
		public List<StatsVO> selectSeatCount() {
			return session.selectList(namespace+"selectSeatCount");
		}
}
