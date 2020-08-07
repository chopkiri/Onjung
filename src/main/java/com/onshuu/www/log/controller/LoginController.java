package com.onshuu.www.log.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
/*import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;*/
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

//import com.onshuu.www.info.entity.InfoEntity;
import com.onshuu.www.log.entity.ShuMem;
import com.onshuu.www.log.service.MemberService;

@SessionAttributes("member")
@Controller
public class LoginController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String openLoginWrite() throws Exception{
		return "/log/login";
	}
	//@GetMapping("/signUp")
	//public String opensignUp() throws Exception{
		//return "/log/signUp";
	//}
	
	@PostMapping("/login")
	public String login(ShuMem member, Model model) {
		ShuMem findMember = memberService.getMember(member);

		if (findMember != null && findMember.getPassword().equals(member.getPassword())) {
			model.addAttribute("member", findMember);
			return "log/getLogPage";
		} else {
			return "redirect:/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "/index";		
	}
	
	//@PostMapping("/signUp")
	//public String signUp(ShuMem board) throws Exception{
		//memberService.signUp(board);
		//return "redirect:/login";
	//}

}

