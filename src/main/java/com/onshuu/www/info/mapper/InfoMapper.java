package com.onshuu.www.info.mapper;

import java.util.List;



import org.apache.ibatis.annotations.Mapper;

import com.onshuu.www.info.dto.InfoDto;
import com.onshuu.www.info.dto.InfoFileDto;

@Mapper
//마이바티스 매퍼 인터페이스 선언
public interface InfoMapper {
	List<InfoDto> selectNewsList() throws Exception;
	//인터페이스이기 때문에 메소드 이름과 반환 형식만 지정
	//여기서 지정한 메소드의 이름은 잠시 후 나올 sql의 이름과 동일해야 한다.
	
	void insertNews(InfoDto board) throws Exception;
	
	void insertNewsFileList(List<InfoFileDto> list) throws Exception;
	
	void updateHitCount(int newsNum) throws Exception;
	
	InfoDto selectNewsDetail(int newsNum) throws Exception;
	
	void updateNews(InfoDto board) throws Exception;
	
	void deleteNews(int newsNum) throws Exception;
	
	
	
	
	
	List<InfoDto> selectRecList() throws Exception;
	//인터페이스이기 때문에 메소드 이름과 반환 형식만 지정
	//여기서 지정한 메소드의 이름은 잠시 후 나올 sql의 이름과 동일해야 한다.
	
	void insertRec(InfoDto board) throws Exception;
	
	void updateHitRec(int recNum) throws Exception;
	
	InfoDto selectRecDetail(int recNum) throws Exception;
	
	void updateRec(InfoDto board) throws Exception;
	
	void deleteRec(int recNum) throws Exception;
	
	

}