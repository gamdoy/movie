package kr.or.kosta.stats.model.dao;

import java.util.List;

import kr.or.kosta.stats.vo.StatsVO;

public interface StatsDAO {

	public abstract List<StatsVO> selectSeatCount();
	
	public abstract List<StatsVO> selectMovieViewers();
	
}
