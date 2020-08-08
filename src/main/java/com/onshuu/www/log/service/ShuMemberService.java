package com.onshuu.www.log.service;

import com.onshuu.www.log.dto.LoginDto;

public interface ShuMemberService {
	
	LoginDto getShuMem(String memId) throws Exception;
	
}
