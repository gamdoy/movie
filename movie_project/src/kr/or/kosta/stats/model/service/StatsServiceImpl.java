package kr.or.kosta.stats.model.service;

import java.util.List;

import kr.or.kosta.stats.model.dao.StatsDAO;
import kr.or.kosta.stats.vo.StatsVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsServiceImpl implements StatsService{
	
	@Autowired
	private StatsDAO dao;
	
	@Override
	public List<StatsVO> getStatistics() {
		List<StatsVO> list1 = dao.selectMovieViewers();
		System.out.println(list1);
		List<StatsVO> list2 = dao.selectSeatCount();
		System.out.println(list2);
		return list1;
	}
}
