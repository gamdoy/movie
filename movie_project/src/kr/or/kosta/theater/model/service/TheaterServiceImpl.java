package kr.or.kosta.theater.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.kosta.common.vo.PagingBean;
import kr.or.kosta.common.vo.SearchVO;
import kr.or.kosta.movieroom.vo.MovieroomVO;
import kr.or.kosta.schedule.vo.ScheduleVO;
import kr.or.kosta.theater.model.dao.TheaterDAO;
import kr.or.kosta.theater.vo.TheaterVO;
import kr.or.kosta.ticket.vo.TicketVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterServiceImpl implements TheaterService {
	
	@Autowired
	private TheaterDAO dao;
	
	/**
	 * 전체 극장리스트를 받는 메소드
	 */
	@Override
	public List<TheaterVO> getTheaterList(){
		return dao.selectAllTheater();
	}

	/**
	 * 극장을 찾는 메소드
	 */
	@Override
	public TheaterVO getTheater(int theaNo) {
		return dao.selectTheaterByTheaNo(theaNo);
	}

	/**
	 * 상영일을 기준으로 스케줄을 조회 
	 */
	@Override
	public List getScheduleListByDate(ScheduleVO vo, SearchVO searchVo, int page) {
		HashMap map = new HashMap();
		map.put("searchKeyword", searchVo.getSearchKeyword());
		map.put("searchType", searchVo.getSearchType());
		map.put("mrNo", vo.getMrNo());
		
		int totalContent = dao.selectTotalScheduleListByDateCount(map);
		
		PagingBean pagingBean = new PagingBean(totalContent, page);
		
		map.put("contentsPerPage", pagingBean.CONTENTS_PER_PAGE);
		map.put("page", page);
		List<ScheduleVO> scheduleList = dao.selectScheduleListByDate(map);
		
		//두개의 값(List, PagingBean)을 Map에 넣어 return
		List list = new ArrayList();
		list.add(pagingBean);
		list.add(scheduleList);
		
		return list;
	}

	/**
	 * 극장을 수정하는 메소드
	 */
	@Override
	public int setTheater(TheaterVO vo) {
		return dao.updateTheater(vo);
	}

	/**
	 * 극장을 생성하는 메소드
	 */
	@Override
	public int registTheater(TheaterVO vo) {
		int cnt = dao.insertTheater(vo);
		/*임시적으로 극장 생성시 3개의 상영관을 생성한다.*/
		dao.insertMoovieroom(vo.getTheaNo(),3);
		return cnt;
	}

	/**
	 * 예매시 영화가격의 10%를 마일리지로 적립
	 */
	@Override
	public int modifyMemberMileage(TicketVO vo) {
		return dao.updateMemberMileage(vo);
	}

	/**
	 * 상영일을 스케줄에서 조회하는 메소드
	 */
	@Override
	public List<ScheduleVO> getScheduleListBytheaNo(int theaNo) {
		return dao.selectScheduleList(theaNo);
	}

	@Override
	public List<ScheduleVO> getScreenTimeList(ScheduleVO vo) {
		return dao.selectScreenTimeList(vo);
	}

	@Override
	public boolean isReservedSeats(TicketVO vo) {
		return dao.isReservedSeats(vo);
	}

	@Override
	public List getTicketListPaging(int page, SearchVO vo) {
		//목록에 뿌려줄 List<Member> 조회
		//PagingBean 생성
		HashMap map = new HashMap();
		map.put("searchKeyword", vo.getSearchKeyword());
		map.put("searchType", vo.getSearchType());
		
		int totalContent = dao.selectTotalTicketCount(map);
		PagingBean pagingBean = new PagingBean(totalContent, page);
		
		map.put("contentsPerPage", pagingBean.CONTENTS_PER_PAGE);
		map.put("pageNo", page);
		List<TicketVO> ticketList = dao.selectTicketListPaging(map);
		
		//두개의 값(List, PagingBean)을 Map에 넣어 return
		List list = new ArrayList();
		list.add(pagingBean);
		list.add(ticketList);
		
		return list;
	}

	@Override
	public int modifyTicketByNo(TicketVO vo) {
		return dao.updateTicketByNo(vo);
	}

	@Override
	public int modifyMovieroomByNo(MovieroomVO vo) {
		return dao.updateMovieroomByNo(vo);
	}

	@Override
	public int addSchedule(ScheduleVO vo) {
		return dao.insertSchedule(vo);
	}

	@Override
	public int getScheduleCount(MovieroomVO vo) {
		return dao.selectScheduleCount(vo);
	}

	@Override
	public TicketVO getMovieRoomByNo(int schNo) {
		return dao.selectMovieRoomByNo(schNo);
	}

	@Override
	public List<MovieroomVO> getMovieRoomListByNo(int theaNo) {
		return dao.selectMovieRoomListByNo(theaNo);
	}

	@Override
	public List<TicketVO> getTicketList() {
		return dao.selectTicketList();
	}

	@Override
	public int registTicket(TicketVO vo) {
		return dao.insertTicket(vo);
	}

	@Override
	public List<TicketVO> getReservedSeat(int schNo) {
		return dao.selectTicket(schNo);
	}

	//상영관의 예매된 좌석을 조회
	@Override
	public List<String> getReservedSeats(int schNo) {
		return dao.selectReservedSeats(schNo);
	}

	@Override
	public TicketVO getTicketByNo(int ticNo) {
		return dao.selectTicketByNo(ticNo);
	}
	
	@Override
	public List<TicketVO> getMovieListByDate(ScheduleVO vo){
		return dao.selectMovieListByDate(vo);
	}
}
