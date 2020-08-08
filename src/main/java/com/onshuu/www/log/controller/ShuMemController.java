package com.onshuu.www.log.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/*import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;*/
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.onshuu.www.log.dto.LoginDto;
//import com.onshuu.www.log.entity.ShuMem;
//import com.onshuu.www.info.entity.InfoEntity;
import com.onshuu.www.log.service.ShuMemberService;

@SessionAttributes("member")
@Controller
public class ShuMemController {
	
	@Autowired
	private ShuMemberService shuMemberService;
	
	@RequestMapping("/shulogin")
	public String openLoginForm() throws Exception{
		return "/log/shuLogin";
	}
	//@GetMapping("/signUp")
	//public String opensignUp() throws Exception{
		//return "/log/signUp";
	//}
	
	@RequestMapping("/shuloginPro")
	public String loginBatis(@RequestParam String memId, String memPassword, Model model) throws Exception {
		
		LoginDto findMember = shuMemberService.getShuMem(memId);

		if (findMember != null && memPassword.equals(findMember.getMemPassword())) {
			model.addAttribute("member", findMember);
			return "log/shuLogPage";
		} else {
			return "redirect:/shulogin";
		}
	}
	
	@RequestMapping("/logout")
	public String logoutBatis(SessionStatus status) {
		status.setComplete();
		return "/index";		
	}
	
	//@PostMapping("/signUp")
	//public String signUp(ShuMem board) throws Exception{
		//memberService.signUp(board);
		//return "redirect:/login";
	//}

}

