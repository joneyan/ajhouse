package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.po.AjStation;
import com.aj.ajhouse.pojo.po.AjStationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AjStationMapper {
    int countByExample(AjStationExample example);

    int deleteByExample(AjStationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AjStation record);

    int insertSelective(AjStation record);

    List<AjStation> selectByExample(AjStationExample example);

    AjStation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AjStation record, @Param("example") AjStationExample example);

    int updateByExample(@Param("record") AjStation record, @Param("example") AjStationExample example);

    int updateByPrimaryKeySelective(AjStation record);

    int updateByPrimaryKey(AjStation record);
}