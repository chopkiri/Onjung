package com.onshuu.www.community.service;

import java.util.List;
import com.onshuu.www.community.dto.CommuDto;

public interface CommuService {

    List<CommuDto> selectCommuList() throws Exception;

    void insertCommu(CommuDto community) throws Exception ;

    CommuDto selectCommuDetail(int qna_num) throws Exception;

    void updateCommu(CommuDto community) throws Exception;

    void deleteCommu(int qna_num) throws Exception;


}
