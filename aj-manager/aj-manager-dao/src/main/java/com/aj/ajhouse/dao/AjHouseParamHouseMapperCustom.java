package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.po.AjHouseParamHouse;
import com.aj.ajhouse.pojo.po.AjHouseParamHouseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AjHouseParamHouseMapperCustom {

    AjHouseParamHouse getByHouseId(int itemId);
}