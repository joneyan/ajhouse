package com.aj.ajhouse.dao;

import java.util.List;
import com.aj.ajhouse.pojo.po.AjAdmin;
import com.aj.ajhouse.pojo.po.AjAdminExample;
import org.apache.ibatis.annotations.Param;

public interface AjAdminMapper {
    int countByExample(AjAdminExample example);

    int deleteByExample(AjAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AjAdmin record);

    int insertSelective(AjAdmin record);

    List<AjAdmin> selectByExample(AjAdminExample example);

    AjAdmin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AjAdmin record, @Param("example") AjAdminExample example);

    int updateByExample(@Param("record") AjAdmin record, @Param("example") AjAdminExample example);

    int updateByPrimaryKeySelective(AjAdmin record);

    int updateByPrimaryKey(AjAdmin record);
}