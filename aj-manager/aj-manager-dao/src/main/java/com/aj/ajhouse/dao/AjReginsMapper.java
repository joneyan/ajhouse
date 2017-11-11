package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.po.AjRegins;
import com.aj.ajhouse.pojo.po.AjReginsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AjReginsMapper {
    int countByExample(AjReginsExample example);

    int deleteByExample(AjReginsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AjRegins record);

    int insertSelective(AjRegins record);

    List<AjRegins> selectByExample(AjReginsExample example);

    AjRegins selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AjRegins record, @Param("example") AjReginsExample example);

    int updateByExample(@Param("record") AjRegins record, @Param("example") AjReginsExample example);

    int updateByPrimaryKeySelective(AjRegins record);

    int updateByPrimaryKey(AjRegins record);
}