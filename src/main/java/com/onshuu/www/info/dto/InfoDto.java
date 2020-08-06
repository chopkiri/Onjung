package com.onshuu.www.info.dto;

import lombok.Data;

@Data
public class InfoDto {
	
	private int newsNum;
	private String newsTitle;
	private String newsInput;
	private String newsDate;
	private int newsView;
	private String creatorId;
	
    private int recNum;
    private String recCompany;
    private String recPosit;
    private String recQual;
    private String recSal;
    private String recDeadline;
    private String recInput;
    private int recView;
    
   /* private int rvwNum;
    private String rvwCateg;
    private String rvwTitle;
    private String rvwInput;
    private String rvwDate;
    private int rvwView;*/
	
	/*private int boardIdx;
	private String title;
	private String contents;
	private int hitCnt;
	private String creatorId;
	private String createdDatetime;
	private String updaterId;
	private String updatedDatetime;*/
}