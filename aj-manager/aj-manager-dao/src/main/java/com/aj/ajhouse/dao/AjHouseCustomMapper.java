package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.po.AjHouse;

import java.util.List;
import java.util.Map;

public interface AjHouseCustomMapper {
    List<AjHouse> listHouseByPage(Map<String, Object> map);

    int countHouses();
}
