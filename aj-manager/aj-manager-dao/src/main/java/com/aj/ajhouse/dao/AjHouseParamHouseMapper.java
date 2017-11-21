package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.po.AjHouseParamHouse;
import com.aj.ajhouse.pojo.po.AjHouseParamHouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AjHouseParamHouseMapper {
    int countByExample(AjHouseParamHouseExample example);

    int deleteByExample(AjHouseParamHouseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AjHouseParamHouse record);

    int insertSelective(AjHouseParamHouse record);

    List<AjHouseParamHouse> selectByExample(AjHouseParamHouseExample example);

    AjHouseParamHouse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AjHouseParamHouse record, @Param("example") AjHouseParamHouseExample example);

    int updateByExample(@Param("record") AjHouseParamHouse record, @Param("example") AjHouseParamHouseExample example);

    int updateByPrimaryKeySelective(AjHouseParamHouse record);

    int updateByPrimaryKey(AjHouseParamHouse record);
}