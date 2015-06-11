package kr.or.kosta.notice.model.service;

import kr.or.kosta.notice.model.dao.NoticeDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeDAO dao;
	
}
