package kr.or.kosta.stats.model.service;

import java.util.List;

import kr.or.kosta.stats.vo.StatsVO;

public interface StatsService {

	public abstract List<StatsVO> getStatistics();
}
