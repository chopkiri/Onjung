package com.onshuu.www.info.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.onshuu.www.info.dto.InfoDto;
import com.onshuu.www.info.service.InfoService;


@RestController
public class RestInfoApiController {
	
	@Autowired
	private InfoService infoService;
	
	@RequestMapping(value="/api/news/list", method=RequestMethod.GET)
	public List<InfoDto> openNewsList() throws Exception{
		return infoService.selectNewsList();
	}
	
	@RequestMapping(value="/api/news/write", method=RequestMethod.POST)
	public void insertNews(@RequestBody InfoDto board) throws Exception{
		infoService.insertNews(board);
	}
	
	@RequestMapping(value="/api/news/{newsNum}", method=RequestMethod.GET)
	public InfoDto openNewsDetail(@PathVariable("newsNum") int newsNum) throws Exception{
		
		return infoService.selectNewsDetail(newsNum);
	}
	
	@RequestMapping(value="/api/news/{newsNum}", method=RequestMethod.PUT)
	public String updateNews(@RequestBody InfoDto board) throws Exception{
		infoService.updateNews(board);
		return "redirect:/api/news/list";
	}
	
	@RequestMapping(value="/api/news/{newsNum}", method=RequestMethod.DELETE)
	public String deleteNews(@PathVariable("newsNum") int newsNum) throws Exception{
		infoService.deleteNews(newsNum);
		return "redirect:/api/news/list";
	}
}