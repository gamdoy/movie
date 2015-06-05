package kr.or.kosta.theater.model.dao;

import java.util.List;

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

	public abstract List<String> selectReservedSeats(TicketVO tvo);

	public abstract TicketVO selectTicketByNo(int ticNo);
}