package kr.or.kosta.theater.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.or.kosta.movieroom.vo.MovieroomVO;
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
	public List<TicketVO> selectMovieListByDate(ScheduleVO vo) {
		return session.selectList(namespace + "selectMovieListByDate", vo);
	}

	@Override
	public List<ScheduleVO> selectScreenTimeList(ScheduleVO vo) {
		return session.selectList(namespace + "selectScreenTimeList", vo);
	}

	@Override
	public boolean isReservedSeats(TicketVO vo) {
		int count = session.selectOne(namespace + "isReservedSeats", vo);
		return count != 0;
	}

	@Override
	public List<TicketVO> selectTicketListPaging(HashMap map) {
		return session.selectList(namespace + "selectTicketListPaging", map);
	}
	
	@Override
	public int selectTotalTicketCount(HashMap map) {
		return session.selectOne(namespace + "selectTotalTicketCount", map);
	}
	
	@Override
	public int updateTicketByNo(TicketVO vo) {
		return session.update(namespace + "updateTicketByNo", vo);
	}

	@Override
	public int updateMovieroomByNo(MovieroomVO vo) {
		return session.update(namespace + "updateMovieroomByNo", vo);
	}

	@Override
	public int insertSchedule(ScheduleVO vo) {
		String schDate = vo.getSchDate();
		int count = 0;
		vo.setSchDate(schDate + " 09:00");
		count += session.insert(namespace + "insertSchedule", vo);
		vo.setSchDate(schDate + " 12:00");
		count += session.insert(namespace + "insertSchedule", vo);
		vo.setSchDate(schDate + " 15:00");
		count += session.insert(namespace + "insertSchedule", vo);
		vo.setSchDate(schDate + " 18:00");
		count += session.insert(namespace + "insertSchedule", vo);
		vo.setSchDate(schDate + " 21:00");
		count += session.insert(namespace + "insertSchedule", vo);
		return count;
	}

	@Override
	public List<ScheduleVO> selectScheduleListByDate(Map map) {
		return session.selectList(namespace + "selectScheduleListByDate", map);
	}

	@Override
	public int selectTotalScheduleListByDateCount(HashMap map) {
		return session.selectOne(namespace + "selectTotalScheduleListByDateCount", map);
	}

	@Override
	public int selectScheduleCount(MovieroomVO vo) {
		return session.selectOne(namespace + "selectScheduleCount", vo);
	}

	@Override
	public List<MovieroomVO> selectMovieRoomListByNo(int theaNo) {
		return session.selectList(namespace + "selectMovieRoomListByNo", theaNo);
	}

	@Override
	public int insertMoovieroom(int theaNo, int count) {
		int cnt = 0;
		MovieroomVO vo = new MovieroomVO();
		vo.setTheaNo(theaNo);
		vo.setMrScreentype("109100");
		vo.setMrLine(9);
		vo.setMrSeat(9);
		for (int i = 1; i <= count; i++) {
			vo.setMrName(i + "상영관");
			cnt += session.insert(namespace + "insertMovieroom", vo);
		}
		return cnt;
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
		return session.selectOne(namespace + "selectTicketByNo", ticNo);
	}

	@Override
	public List<TicketVO> selectTicketList() {
		return session.selectList(namespace + "selectTicketList");
	}

	//상영관의 예매된 좌석을 조회
	@Override
	public List<String> selectReservedSeats(int schNo) {
		return session.selectList(namespace + "selectReservedSeats", schNo);
	}

}
