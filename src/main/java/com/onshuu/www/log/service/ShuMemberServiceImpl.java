package com.onshuu.www.log.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onshuu.www.log.dto.LoginDto;
import com.onshuu.www.log.mapper.ShuMemMapper;

@Service
public class ShuMemberServiceImpl implements ShuMemberService{
	
	@Autowired
	private ShuMemMapper shuMemMapper;
	
	@Override
	public LoginDto getShuMem(String memId) throws Exception {
		
		LoginDto findMember = shuMemMapper.getShuMem(memId);
		if(findMember != null) {
			return findMember;
		}
		else {
		return null;
		}
	}

}
