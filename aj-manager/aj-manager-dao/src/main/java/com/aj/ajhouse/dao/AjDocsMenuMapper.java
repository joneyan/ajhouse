package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.po.AjDocsMenu;
import com.aj.ajhouse.pojo.po.AjDocsMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AjDocsMenuMapper {
    int countByExample(AjDocsMenuExample example);

    int deleteByExample(AjDocsMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AjDocsMenu record);

    int insertSelective(AjDocsMenu record);

    List<AjDocsMenu> selectByExample(AjDocsMenuExample example);

    AjDocsMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AjDocsMenu record, @Param("example") AjDocsMenuExample example);

    int updateByExample(@Param("record") AjDocsMenu record, @Param("example") AjDocsMenuExample example);

    int updateByPrimaryKeySelective(AjDocsMenu record);

    int updateByPrimaryKey(AjDocsMenu record);
}