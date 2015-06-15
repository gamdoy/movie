package kr.or.kosta.theater.model.service;

import java.util.List;
import java.util.Map;

import kr.or.kosta.common.vo.SearchVO;
import kr.or.kosta.movieroom.vo.MovieroomVO;
import kr.or.kosta.schedule.vo.ScheduleVO;
import kr.or.kosta.theater.vo.TheaterVO;
import kr.or.kosta.ticket.vo.TicketVO;

public interface TheaterService {
	public List<TheaterVO> getTheaterList();

	public TheaterVO getTheater(int theaNo);

	public int setTheater(TheaterVO vo);

	public int registTheater(TheaterVO vo);

	public List<ScheduleVO> getScheduleListByNo(int theaNo);

	public List<ScheduleVO> getScheduleListBytheaNo(int theaNo);

	public List<ScheduleVO> getScreenTimeList(ScheduleVO vo);

	public TicketVO getMovieRoomByNo(int schNo);

	public int registTicket(TicketVO vo);

	public List<TicketVO> getReservedSeat(int schNo);

	//상영관의 예매된 좌석을 조회
	public List<String> getReservedSeats(int schNo);

	public TicketVO getTicketByNo(int ticNo);

	public List<TicketVO> getTicketList();

	public List<TicketVO> getMovieListByDate(ScheduleVO vo);

	public boolean isReservedSeats(TicketVO vo);

	public List getTicketListPaging(int page, SearchVO vo);

	public int modifyTicketByNo(TicketVO vo);

	public List<MovieroomVO> getMovieRoomListByNo(int theaNo);

	public int modifyMovieroomByNo(MovieroomVO vo);

	public int addSchedule(ScheduleVO vo);

	public int getScheduleCount(MovieroomVO vo);

	public List getScheduleListByDate(ScheduleVO vo, SearchVO searchVo, int page);
}