package kr.or.kosta.theater.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.kosta.movieroom.vo.MovieroomVO;
import kr.or.kosta.schedule.vo.ScheduleVO;
import kr.or.kosta.theater.vo.TheaterVO;
import kr.or.kosta.ticket.vo.TicketVO;

public interface TheaterDAO {
	/**
	 * Theater 테이블의 전체 극장 조회 처리
	 * @return
	 */
	public abstract List<TheaterVO> selectAllTheater();

	/**
	 * Theater 테이블의 전체 극장 조회 처리
	 * @param theaNo 
	 * @return
	 */
	public abstract TheaterVO selectTheaterByTheaNo(int theaNo);

	public abstract int updateTheater(TheaterVO vo);

	public abstract int insertTheater(TheaterVO vo);

	public abstract List<ScheduleVO> selectScheduleListByNo(int theaNo);

	public abstract List<ScheduleVO> selectScheduleList(int theaNo);

	public abstract List<ScheduleVO> selectScreenTimeList(ScheduleVO vo);

	public abstract TicketVO selectMovieRoomByNo(int schNo);

	public abstract int insertTicket(TicketVO vo);

	public abstract List<TicketVO> selectTicket(int schNo);

	//상영관의 예매된 좌석을 조회
	public abstract List<String> selectReservedSeats(int schNO);

	public abstract TicketVO selectTicketByNo(int ticNo);

	public abstract List<TicketVO> selectTicketList();
	
	public abstract List<TicketVO> selectMovieListByDate(ScheduleVO vo);
	
	public abstract boolean isReservedSeats(TicketVO vo);

	public abstract List<TicketVO> selectTicketListPaging(HashMap map);

	public abstract int selectTotalTicketCount(HashMap map);

	public abstract int updateTicketByNo(TicketVO vo);

	public abstract List<MovieroomVO> selectMovieRoomListByNo(int theaNo);

	public abstract int insertMoovieroom(int theaNo, int count);

	public abstract int updateMovieroomByNo(MovieroomVO vo);

	public abstract int insertSchedule(ScheduleVO vo);

	public abstract int selectScheduleCount(MovieroomVO vo);

	public abstract List<ScheduleVO> selectScheduleListByDate(Map map);

	public abstract int selectTotalScheduleListByDateCount(HashMap map);

	public abstract int updateMemberMileage(TicketVO vo);
}