package com.aj.ajhouse.dao;

import java.util.List;

import com.aj.ajhouse.pojo.po.AjCity;
import com.aj.ajhouse.pojo.po.AjCityExample;
import org.apache.ibatis.annotations.Param;


public interface AjCityMapper {
    int countByExample(AjCityExample example);

    int deleteByExample(AjCityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AjCity record);

    int insertSelective(AjCity record);

    List<AjCity> selectByExample(AjCityExample example);

    AjCity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AjCity record, @Param("example") AjCityExample example);

    int updateByExample(@Param("record") AjCity record, @Param("example") AjCityExample example);

    int updateByPrimaryKeySelective(AjCity record);

    int updateByPrimaryKey(AjCity record);
}