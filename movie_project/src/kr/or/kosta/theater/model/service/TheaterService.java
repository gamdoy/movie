package kr.or.kosta.theater.model.service;

import java.util.List;

import kr.or.kosta.schedule.vo.ScheduleVO;
import kr.or.kosta.theater.vo.TheaterVO;
import kr.or.kosta.ticket.vo.TicketVO;

public interface TheaterService {
	public List<TheaterVO> getTheaterList();

	public TheaterVO getTheater(int theaNo);

	public int setTheater(TheaterVO vo);

	public int registTheater(TheaterVO vo);

	public List<ScheduleVO> getScheduleListByNo(int theaNo);

	public List<ScheduleVO> getScheduleList(int theaNo);

	public List<ScheduleVO> getScreenTimeList(ScheduleVO vo);

	public TicketVO getMovieRoomByNo(int schNo);

	public int registTicket(TicketVO vo);

	public List<TicketVO> getReservedSeat(int schNo);

	public List<String> getReservedSeats(TicketVO tvo);

	public TicketVO getTicketByNo(int ticNo);
}