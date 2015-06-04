package kr.or.kosta.theater.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.or.kosta.schedule.vo.ScheduleVO;
import kr.or.kosta.theater.vo.TheaterVO;
import kr.or.kosta.ticket.vo.TicketVO;

@Component
public class TheaterDAOImpl implements TheaterDAO {
	private String namespace="theater.dao.theaterMapper.";
	
	/**
	 * SqlSession을 받기 위한 SqlSessionTemplate 
	 */
	@Autowired
	private SqlSessionTemplate session;
	
	/**
	 * 전체 극장리스트를 받는 메소드
	 */
	@Override
	public List<TheaterVO> selectAllTheater() {
		return session.selectList(namespace + "selectAllTheater");
	}

	/**
	 * 극장을 찾는 메소드
	 */
	@Override
	public TheaterVO selectTheaterByTheaNo(int theaNo) {
		return session.selectOne(namespace + "selectTheaterByTheaNo", theaNo);
	}

	/**
	 * 극장을 수정하는 메소드
	 */
	@Override
	public int updateTheater(TheaterVO vo) {
		return session.update(namespace + "updateTheater", vo);
	}

	/**
	 * 극장을 추가하는 메소드
	 */
	@Override
	public int insertTheater(TheaterVO vo) {
		return session.insert(namespace + "insertTheater", vo);
	}

	/**
	 * 상영스케줄을 찾는 메소드
	 */
	@Override
	public List<ScheduleVO> selectScheduleListByNo(int theaNo) {
		return session.selectList(namespace + "selectSechduleListByTheater", theaNo);
	}

	/**
	 * 상영일을 스케줄에서 조회하는 메소드
	 */
	@Override
	public List<ScheduleVO> selectScheduleList(int theaNo) {
		return session.selectList(namespace + "selectSechduleList", theaNo);
	}

	@Override
	public List<ScheduleVO> selectScreenTimeList(ScheduleVO vo) {
		return session.selectList(namespace + "selectScreenTimeList", vo);
	}

	@Override
	public TicketVO selectMovieRoomByNo(int schNo) {
		return session.selectOne(namespace + "selectMovieRoomByNo", schNo);
	}

	@Override
	public int insertTicket(TicketVO vo) {
		return session.insert(namespace + "insertTicket", vo);
	}

	@Override
	public List<TicketVO> selectTicket(int schNo) {
		return session.selectOne(namespace + "selectTicket", schNo);
	}

	@Override
	public TicketVO selectTicketByNo(int ticNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> selectReservedSeats(TicketVO tvo) {
		return session.selectList(namespace + "selectReservedSeats", tvo);
	}

}
