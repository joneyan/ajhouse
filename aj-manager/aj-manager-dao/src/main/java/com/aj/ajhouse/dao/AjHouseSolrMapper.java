package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.vo.AjHouseSearchCustom;

import java.util.List;

public interface AjHouseSolrMapper {
    List<AjHouseSearchCustom> listAllHouse();
}
