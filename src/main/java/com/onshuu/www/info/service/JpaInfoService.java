package com.onshuu.www.info.service;

import java.util.List;

import com.onshuu.www.info.entity.InfoEntity;
import com.onshuu.www.info.entity.RecEntity;

public interface JpaInfoService {
	
	List<InfoEntity> selectNewsList() throws Exception;

	void saveNews(InfoEntity board) throws Exception;
	
	InfoEntity selectNewsDetail(int newsNum) throws Exception;

	void deleteNews(int newsNum);
	
	
	
	
	
	List<RecEntity> selectRecList() throws Exception;

	void saveRec(RecEntity board) throws Exception;
	
	RecEntity selectRecDetail(int recNum) throws Exception;

	void deleteRec(int recNum);
}
