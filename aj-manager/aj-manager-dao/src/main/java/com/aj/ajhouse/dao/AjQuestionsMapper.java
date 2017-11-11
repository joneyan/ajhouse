package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.po.AjQuestions;
import com.aj.ajhouse.pojo.po.AjQuestionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AjQuestionsMapper {
    int countByExample(AjQuestionsExample example);

    int deleteByExample(AjQuestionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AjQuestions record);

    int insertSelective(AjQuestions record);

    List<AjQuestions> selectByExample(AjQuestionsExample example);

    AjQuestions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AjQuestions record, @Param("example") AjQuestionsExample example);

    int updateByExample(@Param("record") AjQuestions record, @Param("example") AjQuestionsExample example);

    int updateByPrimaryKeySelective(AjQuestions record);

    int updateByPrimaryKey(AjQuestions record);
}