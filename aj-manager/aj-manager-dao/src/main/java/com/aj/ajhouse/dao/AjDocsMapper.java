package com.aj.ajhouse.dao;

import java.util.List;

import com.aj.ajhouse.pojo.po.AjDocs;
import com.aj.ajhouse.pojo.po.AjDocsExample;
import org.apache.ibatis.annotations.Param;

public interface AjDocsMapper {
    int countByExample(AjDocsExample example);

    int deleteByExample(AjDocsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AjDocs record);

    int insertSelective(AjDocs record);

    List<AjDocs> selectByExampleWithBLOBs(AjDocsExample example);

    List<AjDocs> selectByExample(AjDocsExample example);

    AjDocs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AjDocs record, @Param("example") AjDocsExample example);

    int updateByExampleWithBLOBs(@Param("record") AjDocs record, @Param("example") AjDocsExample example);

    int updateByExample(@Param("record") AjDocs record, @Param("example") AjDocsExample example);

    int updateByPrimaryKeySelective(AjDocs record);

    int updateByPrimaryKeyWithBLOBs(AjDocs record);

    int updateByPrimaryKey(AjDocs record);
}