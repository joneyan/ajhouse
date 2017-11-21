package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.po.AjHouseImages;
import com.aj.ajhouse.pojo.po.AjHouseImagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AjHouseImagesMapper {
    int countByExample(AjHouseImagesExample example);

    int deleteByExample(AjHouseImagesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AjHouseImages record);

    int insertSelective(AjHouseImages record);

    List<AjHouseImages> selectByExample(AjHouseImagesExample example);

    AjHouseImages selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AjHouseImages record, @Param("example") AjHouseImagesExample example);

    int updateByExample(@Param("record") AjHouseImages record, @Param("example") AjHouseImagesExample example);

    int updateByPrimaryKeySelective(AjHouseImages record);

    int updateByPrimaryKey(AjHouseImages record);
}