package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.po.AjHouse;
import com.aj.ajhouse.pojo.po.AjHouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AjHouseMapper {
    int countByExample(AjHouseExample example);

    int deleteByExample(AjHouseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AjHouse record);

    int insertSelective(AjHouse record);

    List<AjHouse> selectByExample(AjHouseExample example);

    AjHouse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AjHouse record, @Param("example") AjHouseExample example);

    int updateByExample(@Param("record") AjHouse record, @Param("example") AjHouseExample example);

    int updateByPrimaryKeySelective(AjHouse record);

    int updateByPrimaryKey(AjHouse record);
}