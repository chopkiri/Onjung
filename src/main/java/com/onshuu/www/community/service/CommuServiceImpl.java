package com.onshuu.www.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.onshuu.www.community.dto.CommuDto;
import com.onshuu.www.community.mapper.CommuMapper;



@Service
public class CommuServiceImpl implements CommuService {

    @Autowired
    private CommuMapper commuMapper;

    @Override
    public List<CommuDto> selectCommuList() throws Exception {
        return commuMapper.selectCommuList();
    }
    @Override
    public void insertCommu(CommuDto community) throws Exception {
        commuMapper.insertCommu(community);
    }

    @Override
    public CommuDto selectCommuDetail(int qna_num) throws Exception {
        CommuDto board = commuMapper.selectCommuDetail(qna_num);
        commuMapper.updateHitCount(qna_num);

        return board;
    }

    @Override
    public void updateCommu(CommuDto board) throws Exception {
        commuMapper.updateCommu(board);
    }

    @Override
    public void deleteCommu(int qna_num) throws Exception {
        commuMapper.deleteCommu(qna_num);
    }


}
