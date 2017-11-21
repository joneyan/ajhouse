package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.po.AjHouseParam;
import com.aj.ajhouse.pojo.po.AjHouseParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AjHouseParamMapper {
    int countByExample(AjHouseParamExample example);

    int deleteByExample(AjHouseParamExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AjHouseParam record);

    int insertSelective(AjHouseParam record);

    List<AjHouseParam> selectByExample(AjHouseParamExample example);

    AjHouseParam selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AjHouseParam record, @Param("example") AjHouseParamExample example);

    int updateByExample(@Param("record") AjHouseParam record, @Param("example") AjHouseParamExample example);

    int updateByPrimaryKeySelective(AjHouseParam record);

    int updateByPrimaryKey(AjHouseParam record);
}