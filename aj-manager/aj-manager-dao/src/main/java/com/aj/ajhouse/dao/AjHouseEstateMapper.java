package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.po.AjHouseEstate;
import com.aj.ajhouse.pojo.po.AjHouseEstateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AjHouseEstateMapper {
    int countByExample(AjHouseEstateExample example);

    int deleteByExample(AjHouseEstateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AjHouseEstate record);

    int insertSelective(AjHouseEstate record);

    List<AjHouseEstate> selectByExample(AjHouseEstateExample example);

    AjHouseEstate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AjHouseEstate record, @Param("example") AjHouseEstateExample example);

    int updateByExample(@Param("record") AjHouseEstate record, @Param("example") AjHouseEstateExample example);

    int updateByPrimaryKeySelective(AjHouseEstate record);

    int updateByPrimaryKey(AjHouseEstate record);
}