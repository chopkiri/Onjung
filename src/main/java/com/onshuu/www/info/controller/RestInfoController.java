package com.onshuu.www.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.onshuu.www.info.dto.InfoDto;
import com.onshuu.www.info.service.InfoService;

import java.util.List;

@Controller
public class RestInfoController {
	
	
	@Autowired
	private InfoService infoService;
	
	@RequestMapping(value="/news/list", method=RequestMethod.GET)
	public ModelAndView openNewsList() throws Exception{
		ModelAndView mv = new ModelAndView("/info/restNewsList");
		
		List<InfoDto> list = infoService.selectNewsList();
		mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping(value="/news/write", method=RequestMethod.GET)
	public String openNewsWrite() throws Exception{
		return "/info/restNewsWrite";
	}
	
	@RequestMapping(value="/news/write", method=RequestMethod.POST)
	public String insertNews(InfoDto board, MultipartHttpServletRequest 
			multipartHttpServletRequest) throws Exception{
		infoService.insertNews(board, multipartHttpServletRequest);
		return "redirect:/news/list";
	}
	
	@RequestMapping(value="/news/{newsNum}", method=RequestMethod.GET)
	public ModelAndView openNewsDetail(@PathVariable("newsNum") int newsNum, ModelMap model) throws Exception{
		ModelAndView mv = new ModelAndView("/info/restNewsDetail");
		
		InfoDto board = infoService.selectNewsDetail(newsNum);
		mv.addObject("board", board);
		
		return mv;
	}
	
	@RequestMapping(value="/news/{newsNum}", method=RequestMethod.PUT)
	public String updateNews(InfoDto board) throws Exception{
		infoService.updateNews(board);
		return "redirect:/news/list";
	}
	
	@RequestMapping(value="/news/{newsNum}", method=RequestMethod.DELETE)
	public String deleteNews(@PathVariable("newsNum") int newsNum) throws Exception{
		infoService.deleteNews(newsNum);
				
		return "redirect:/news/list";
	}
	
	
	
	
	
	@RequestMapping(value="/rec/list", method=RequestMethod.GET)
	public ModelAndView openRecList() throws Exception{
		ModelAndView mv = new ModelAndView("/info/restRecruitList");
		
		List<InfoDto> list = infoService.selectRecList();
		mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping(value="/rec/write", method=RequestMethod.GET)
	public String openRecWrite() throws Exception{
		return "/info/restRecruitWrite";
	}
	
	@RequestMapping(value="/rec/write", method=RequestMethod.POST)
	public String insertRec(InfoDto board) throws Exception{
		infoService.insertRec(board);
		return "redirect:/rec/list";
	}
	
	@RequestMapping(value="/rec/{recNum}", method=RequestMethod.GET)
	public ModelAndView openRecDetail(@PathVariable("recNum") int recNum, ModelMap model) throws Exception{
		ModelAndView mv = new ModelAndView("/info/restRecruitDetail");
		
		InfoDto board = infoService.selectRecDetail(recNum);
		mv.addObject("board", board);
		
		return mv;
	}
	
	@RequestMapping(value="/rec/{recNum}", method=RequestMethod.PUT)
	public String updateRec(InfoDto board) throws Exception{
		infoService.updateRec(board);
		return "redirect:/rec/list";
	}
	
	@RequestMapping(value="/rec/{recNum}", method=RequestMethod.DELETE)
	public String deleteRec(@PathVariable("recNum") int recNum) throws Exception{
		infoService.deleteRec(recNum);
				
		return "redirect:/rec/list";
	}
}
