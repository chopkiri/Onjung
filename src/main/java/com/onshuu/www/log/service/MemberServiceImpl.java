package com.onshuu.www.log.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onshuu.www.log.entity.ShuMem;
import com.onshuu.www.log.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRepository memberRepo;
	
	public ShuMem getMember(ShuMem member) {
		Optional<ShuMem> findMember = memberRepo.findById(member.getId());
		if(findMember.isPresent())
			return findMember.get();
		else return null;
	}
	
}
