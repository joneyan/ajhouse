package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.po.AjHouseCat;
import com.aj.ajhouse.pojo.po.AjHouseCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AjHouseCatMapper {
    int countByExample(AjHouseCatExample example);

    int deleteByExample(AjHouseCatExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AjHouseCat record);

    int insertSelective(AjHouseCat record);

    List<AjHouseCat> selectByExample(AjHouseCatExample example);

    AjHouseCat selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AjHouseCat record, @Param("example") AjHouseCatExample example);

    int updateByExample(@Param("record") AjHouseCat record, @Param("example") AjHouseCatExample example);

    int updateByPrimaryKeySelective(AjHouseCat record);

    int updateByPrimaryKey(AjHouseCat record);
}