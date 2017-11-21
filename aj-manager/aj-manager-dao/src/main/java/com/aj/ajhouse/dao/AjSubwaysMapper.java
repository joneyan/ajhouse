package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.po.AjSubways;
import com.aj.ajhouse.pojo.po.AjSubwaysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AjSubwaysMapper {
    int countByExample(AjSubwaysExample example);

    int deleteByExample(AjSubwaysExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AjSubways record);

    int insertSelective(AjSubways record);

    List<AjSubways> selectByExample(AjSubwaysExample example);

    AjSubways selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AjSubways record, @Param("example") AjSubwaysExample example);

    int updateByExample(@Param("record") AjSubways record, @Param("example") AjSubwaysExample example);

    int updateByPrimaryKeySelective(AjSubways record);

    int updateByPrimaryKey(AjSubways record);
}