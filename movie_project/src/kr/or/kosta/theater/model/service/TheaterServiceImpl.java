package kr.or.kosta.theater.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.kosta.common.vo.PagingBean;
import kr.or.kosta.common.vo.SearchVO;
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
		return dao.insertTheater(vo);
	}

	/**
	 * 극장별 상영 스케줄을 찾는 메소드
	 */
	@Override
	public List<ScheduleVO> getScheduleListByNo(int theaNo) {
		return dao.selectScheduleListByNo(theaNo);
	}

	/**
	 * 상영일을 스케줄에서 조회하는 메소드
	 */
	@Override
	public List<ScheduleVO> getScheduleList(int theaNo) {
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
	public int modibyTicketByNo(TicketVO vo) {
		return dao.updateTicketByNo(vo);
	}

	@Override
	public TicketVO getMovieRoomByNo(int schNo) {
		return dao.selectMovieRoomByNo(schNo);
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

	@Override
	public List<String> getReservedSeats(TicketVO tvo) {
		return dao.selectReservedSeats(tvo);
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
