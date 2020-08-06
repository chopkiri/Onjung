package com.onshuu.www.info.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onshuu.www.info.entity.InfoEntity;
import com.onshuu.www.info.entity.RecEntity;
import com.onshuu.www.info.repository.JpaInfoRepository;
import com.onshuu.www.info.repository.JpaRecRepository;

@Service
public class JpaInfoServiceImpl implements JpaInfoService {
	
	@Autowired
	JpaInfoRepository jpaInfoRepository;
	
	@Override
	public List<InfoEntity> selectNewsList() throws Exception {
		return jpaInfoRepository.findAllByOrderByNewsNumDesc();
	}

	@Override
	public void saveNews(InfoEntity board) throws Exception {
		board.setCreatorId("admin");
		jpaInfoRepository.save(board);
	}
	
	@Override
	public InfoEntity selectNewsDetail(int newsNum) throws Exception{
		Optional<InfoEntity> optional = jpaInfoRepository.findById(newsNum);
		if(optional.isPresent()){
			InfoEntity board = optional.get();
			board.setNewsView(board.getNewsView() + 1);
			jpaInfoRepository.save(board);
			
			return board;
		}
		else {
			throw new NullPointerException();
		}
	}

	@Override
	public void deleteNews(int newsNum) {
		jpaInfoRepository.deleteById(newsNum);
	}
	
	
	
	

	@Autowired
	JpaRecRepository jpaRecRepository;
	
	@Override
	public List<RecEntity> selectRecList() throws Exception {
		return jpaRecRepository.findAllByOrderByRecNumDesc();
	}

	@Override
	public void saveRec(RecEntity board) throws Exception {
		board.setCreatorId("admin");
		jpaRecRepository.save(board);
	}

	@Override
	public RecEntity selectRecDetail(int recNum) throws Exception {
		Optional<RecEntity> optional = jpaRecRepository.findById(recNum);
		if(optional.isPresent()){
			RecEntity board = optional.get();
			jpaRecRepository.save(board);
			
			return board;
		}
		else {
			throw new NullPointerException();
		}
	}

	@Override
	public void deleteRec(int recNum) {
		jpaRecRepository.deleteById(recNum);	
	}
}
