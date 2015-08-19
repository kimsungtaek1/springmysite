package com.bit2015.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.mysite.dao.BoardDao;
import com.bit2015.mysite.vo.BoardVo;
import com.bit2015.mysite.vo.GuestBookVo;

@Service
public class BoardService {
	@Autowired
	BoardDao boardDao;
	
	public List<BoardVo> list(){
		List<BoardVo> list = boardDao.getList();
		return list;
		
	}
	public void write(BoardVo vo) {
		boardDao.write(vo);

	}
	
}
