package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.po.AjQuestionAns;
import com.aj.ajhouse.pojo.po.AjQuestionAnsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AjQuestionAnsMapper {
    int countByExample(AjQuestionAnsExample example);

    int deleteByExample(AjQuestionAnsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AjQuestionAns record);

    int insertSelective(AjQuestionAns record);

    List<AjQuestionAns> selectByExample(AjQuestionAnsExample example);

    AjQuestionAns selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AjQuestionAns record, @Param("example") AjQuestionAnsExample example);

    int updateByExample(@Param("record") AjQuestionAns record, @Param("example") AjQuestionAnsExample example);

    int updateByPrimaryKeySelective(AjQuestionAns record);

    int updateByPrimaryKey(AjQuestionAns record);
}