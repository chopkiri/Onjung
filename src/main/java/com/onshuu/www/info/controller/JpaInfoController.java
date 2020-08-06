package com.onshuu.www.info.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.onshuu.www.info.entity.InfoEntity;
import com.onshuu.www.info.entity.RecEntity;
import com.onshuu.www.info.service.JpaInfoService;

import java.util.List;

@Controller
public class JpaInfoController {
	
	@Autowired
	private JpaInfoService jpaInfoService;
	
	@RequestMapping(value="/jpa/news/list", method=RequestMethod.GET)
	public ModelAndView openNewsList() throws Exception{
		ModelAndView mv = new ModelAndView("/info/jpaNewsList");
		
		List<InfoEntity> list = jpaInfoService.selectNewsList();
		mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping(value="/jpa/news/write", method=RequestMethod.GET)
	public String openNewsWrite() throws Exception{
		return "/info/jpaNewsWrite";
	}
	
	@RequestMapping(value="/jpa/news/write", method=RequestMethod.POST)
	public String insertNews(InfoEntity board) throws Exception{
		jpaInfoService.saveNews(board);
		return "redirect:/jpa/news/list";
	}
	
	@RequestMapping(value="/jpa/news/{newsNum}", method=RequestMethod.GET)
	public ModelAndView openNewsDetail(@PathVariable("newsNum") int newsNum, ModelMap model) throws Exception{
		ModelAndView mv = new ModelAndView("/info/jpaNewsDetail");
		
		InfoEntity board = jpaInfoService.selectNewsDetail(newsNum);
		mv.addObject("board", board);
		
		return mv;
	}
	
	@RequestMapping(value="/jpa/news/{newsNum}", method=RequestMethod.PUT)
	public String updateNews(InfoEntity board) throws Exception{
		jpaInfoService.saveNews(board);
		return "redirect:/jpa/news/list";
	}
	
	@RequestMapping(value="/jpa/news/{newsNum}", method=RequestMethod.DELETE)
	public String deleteNews(@PathVariable("newsNum") int newsNum) throws Exception{
		jpaInfoService.deleteNews(newsNum);
				
		return "redirect:/jpa/news/list";
	}
	
	
	
	
	
	@RequestMapping(value="/jpa/rec/list", method=RequestMethod.GET)
	public ModelAndView openRecList() throws Exception{
		ModelAndView mv = new ModelAndView("/info/jpaRecruitList");
		
		List<RecEntity> list = jpaInfoService.selectRecList();
		mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping(value="/jpa/rec/write", method=RequestMethod.GET)
	public String openRecWrite() throws Exception{
		return "/info/jpaRecruitWrite";
	}
	
	@RequestMapping(value="/jpa/rec/write", method=RequestMethod.POST)
	public String insertRec(RecEntity board) throws Exception{
		jpaInfoService.saveRec(board);
		return "redirect:/jpa/rec/list";
	}
	
	@RequestMapping(value="/jpa/rec/{recNum}", method=RequestMethod.GET)
	public ModelAndView openRecDetail(@PathVariable("recNum") int recNum, ModelMap model) throws Exception{
		ModelAndView mv = new ModelAndView("/info/jpaRecruitDetail");
		
		RecEntity board = jpaInfoService.selectRecDetail(recNum);
		mv.addObject("board", board);
		
		return mv;
	}
	
	@RequestMapping(value="/jpa/rec/{recNum}", method=RequestMethod.PUT)
	public String updateRec(RecEntity board) throws Exception{
		jpaInfoService.saveRec(board);
		return "redirect:/jpa/rec/list";
	}
	
	@RequestMapping(value="/jpa/rec/{recNum}", method=RequestMethod.DELETE)
	public String deleteRec(@PathVariable("recNum") int recNum) throws Exception{
		jpaInfoService.deleteRec(recNum);
				
		return "redirect:/jpa/rec/list";
	}
}
