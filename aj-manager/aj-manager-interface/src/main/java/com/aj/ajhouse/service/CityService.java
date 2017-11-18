package com.aj.ajhouse.service;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.common.dto.TreeNode;
import com.aj.ajhouse.pojo.po.AjCity;
import com.aj.ajhouse.pojo.vo.AjCityCustom;
import com.aj.ajhouse.pojo.vo.AjCityQuery;

import java.util.List;

public interface CityService {
    int saveCity(AjCity ajCity);
    Result<AjCityCustom> listCityByPage(Page page, Order order, AjCityQuery query);
    int deleteBatch(List ids);
    List<TreeNode> listCityCats();
    AjCity selectCityById(int id);
    int updateCity(AjCity ajCity);
    AjCity selectCityByName(String cityName);
}
