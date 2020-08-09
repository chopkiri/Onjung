package com.onshuu.www.community.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.onshuu.www.community.dto.CommuDto;

@Mapper
public interface CommuMapper {
    List<CommuDto> selectCommuList() throws Exception;

    void insertCommu(CommuDto community) throws Exception;

    CommuDto selectCommuDetail(int qna_num) throws Exception;

    void updateHitCount(int qna_num) throws Exception;

    void updateCommu(CommuDto board) throws Exception;

    void deleteCommu(int qna_num) throws Exception;

}