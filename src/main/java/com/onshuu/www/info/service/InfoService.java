package com.onshuu.www.info.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.onshuu.www.board.dto.BoardFileDto;
import com.onshuu.www.info.dto.InfoDto;
import com.onshuu.www.info.dto.InfoFileDto;

public interface InfoService {
	
	
	List<InfoDto> selectNewsList() throws Exception;
	
	void insertNews(InfoDto board, MultipartHttpServletRequest 
			multipartHttpServletRequest) throws Exception;
	
	InfoDto selectNewsDetail(int newsNum) throws Exception;
	
	List<String> selectInfoFileInformation(int newsNum) throws Exception;
	
	void updateNews(InfoDto board) throws Exception;
	
	void deleteNews(int newsNum) throws Exception;
	
	
	
	
	
	List<InfoDto> selectRecList() throws Exception;
	
	void insertRec(InfoDto board) throws Exception;
	
	InfoDto selectRecDetail(int recNum) throws Exception;
	
	void updateRec(InfoDto board) throws Exception;
	
	void deleteRec(int recNum) throws Exception;
	
	
	
	
	
	/*List<InfoDto> selectRecList() throws Exception;
	
	void insertRec(InfoDto board) throws Exception;
	
	InfoDto selectRecDetail(int recNum) throws Exception;
	
	void updateRec(InfoDto board) throws Exception;
	
	void deleteRec(int recNum) throws Exception;*/
}