package com.onshuu.www.community.dto;

import lombok.Data;

@Data
public class CommuDto {


    private int qna_num;

    private String qna_title;

    private String qna_input;

    private int qna_hitCnt;

    private String qna_creator_nick;

    private String qna_created_datetime;

    private String qna_updater_nick;

    private String qna_updated_datetime;

    private String qna_deleted_yn;
}

