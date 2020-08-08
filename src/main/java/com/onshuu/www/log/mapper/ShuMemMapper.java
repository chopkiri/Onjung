package com.onshuu.www.log.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.onshuu.www.log.dto.LoginDto;

@Mapper
public interface ShuMemMapper {
	
	LoginDto getShuMem(String memId) throws Exception;
}
