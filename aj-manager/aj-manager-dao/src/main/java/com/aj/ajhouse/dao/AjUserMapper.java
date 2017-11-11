package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.po.AjUser;
import com.aj.ajhouse.pojo.po.AjUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AjUserMapper {
    int countByExample(AjUserExample example);

    int deleteByExample(AjUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AjUser record);

    int insertSelective(AjUser record);

    List<AjUser> selectByExample(AjUserExample example);

    AjUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AjUser record, @Param("example") AjUserExample example);

    int updateByExample(@Param("record") AjUser record, @Param("example") AjUserExample example);

    int updateByPrimaryKeySelective(AjUser record);

    int updateByPrimaryKey(AjUser record);
}