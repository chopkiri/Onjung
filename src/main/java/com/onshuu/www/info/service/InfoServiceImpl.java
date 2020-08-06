package com.onshuu.www.info.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onshuu.www.info.dto.InfoDto;
import com.onshuu.www.info.mapper.InfoMapper;

@Service
//비즈니스 로직을 처리하는 서비스 클래스를 나타내는 어노테이션
public class InfoServiceImpl implements InfoService {
	//비즈니스 로직
	
	@Autowired
	private InfoMapper infoMapper;
	
	@Override
	public List<InfoDto> selectNewsList() throws Exception {
		return infoMapper.selectNewsList();
		//사용자 요청을 처리하기 위한 비즈니스 로직을 구현
		//여기서는 데이터를 조회하도록 BoardMapper 클래스의 selectBoardList 메소드를 호출한다.
		//게시글 목록을 조회할 때는 별다른 비즈니스 로직이 없기 대문에 조회 메소드만 호출했지만,
		//일반적으로는 결과 조회 및 데이터 가공을 위해 보다 복잡한 로직을 처리하게 된다.
	}

	@Override
	public void insertNews(InfoDto board) throws Exception {
		infoMapper.insertNews(board);
	}
	
	@Override
	public InfoDto selectNewsDetail(int newsNum) throws Exception {
		infoMapper.updateHitCount(newsNum);
		
		InfoDto board = infoMapper.selectNewsDetail(newsNum);
		
		return board;
	}



	@Override
	public void updateNews(InfoDto board) throws Exception {
		infoMapper.updateNews(board);
	}

	@Override
	public void deleteNews(int newsNum) throws Exception {
		infoMapper.deleteNews(newsNum);
	}
	
	
	
	
	
	@Override
	public List<InfoDto> selectRecList() throws Exception {
		return infoMapper.selectRecList();
		//사용자 요청을 처리하기 위한 비즈니스 로직을 구현
		//여기서는 데이터를 조회하도록 BoardMapper 클래스의 selectBoardList 메소드를 호출한다.
		//게시글 목록을 조회할 때는 별다른 비즈니스 로직이 없기 대문에 조회 메소드만 호출했지만,
		//일반적으로는 결과 조회 및 데이터 가공을 위해 보다 복잡한 로직을 처리하게 된다.
	}

	@Override
	public void insertRec(InfoDto board) throws Exception {
		infoMapper.insertRec(board);
	}
	
	@Override
	public InfoDto selectRecDetail(int recNum) throws Exception {
		infoMapper.updateHitRec(recNum);
		
		InfoDto board = infoMapper.selectRecDetail(recNum);
		
		return board;
	}



	@Override
	public void updateRec(InfoDto board) throws Exception {
		infoMapper.updateRec(board);
	}

	@Override
	public void deleteRec(int recNum) throws Exception {
		infoMapper.deleteRec(recNum);
	}
	
}