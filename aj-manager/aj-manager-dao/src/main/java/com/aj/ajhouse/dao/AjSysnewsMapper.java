package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.po.AjSysnews;
import com.aj.ajhouse.pojo.po.AjSysnewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AjSysnewsMapper {
    int countByExample(AjSysnewsExample example);

    int deleteByExample(AjSysnewsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AjSysnews record);

    int insertSelective(AjSysnews record);

    List<AjSysnews> selectByExampleWithBLOBs(AjSysnewsExample example);

    List<AjSysnews> selectByExample(AjSysnewsExample example);

    AjSysnews selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AjSysnews record, @Param("example") AjSysnewsExample example);

    int updateByExampleWithBLOBs(@Param("record") AjSysnews record, @Param("example") AjSysnewsExample example);

    int updateByExample(@Param("record") AjSysnews record, @Param("example") AjSysnewsExample example);

    int updateByPrimaryKeySelective(AjSysnews record);

    int updateByPrimaryKeyWithBLOBs(AjSysnews record);

    int updateByPrimaryKey(AjSysnews record);
}