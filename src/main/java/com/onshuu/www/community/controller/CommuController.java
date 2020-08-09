package com.onshuu.www.community.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.onshuu.www.community.dto.CommuDto;
import com.onshuu.www.community.service.CommuService;

@Controller
public class CommuController {

    @Autowired
    private CommuService commuService;

    @RequestMapping("/community/openCommuList.do")
    public ModelAndView openCommuList() throws Exception {
        ModelAndView mv = new ModelAndView("/community/CommuList");

        List<CommuDto> list = commuService.selectCommuList();
        mv.addObject("list", list);

        return mv;
    }

    @RequestMapping("/community/openCommuWrite.do")
    public String openCommuWrite() throws Exception {
        return "/community/CommuWrite";
    }

    @RequestMapping("/community/insertCommu.do")
    public String insertCommu(CommuDto community)
            throws Exception {
        commuService.insertCommu(community);
        return "redirect:/community/openCommuList.do";
    }

    @RequestMapping("/community/openCommuDetail.do")
    public ModelAndView openCommuDetail(@RequestParam int qna_int) throws Exception {
        ModelAndView mv = new ModelAndView("/community/CommuDetail");

        CommuDto community = commuService.selectCommuDetail(qna_int);
        mv.addObject("community", community);

        return mv;
    }

    @RequestMapping("/community/updateCommu.do")
    public String updateCommu(CommuDto community) throws Exception {
        commuService.updateCommu(community);
        return "redirect:/community/openCommuList.do";
    }

    @RequestMapping("/community/deleteCommu.do")
    public String deleteCommu(int qna_int) throws Exception {
        commuService.deleteCommu(qna_int);
        return "redirect:/community/openCommuList.do";
    }

}