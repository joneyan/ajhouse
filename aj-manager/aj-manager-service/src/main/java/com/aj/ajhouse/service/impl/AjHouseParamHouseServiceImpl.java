package com.aj.ajhouse.service.impl;

import com.aj.ajhouse.dao.AjHouseParamHouseMapperCustom;
import com.aj.ajhouse.pojo.po.AjHouseParamHouse;
import com.aj.ajhouse.service.AjHouseParamHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AjHouseParamHouseServiceImpl implements AjHouseParamHouseService {


    @Autowired
    private AjHouseParamHouseMapperCustom ajHouseParamHouseDaoCustom;

    @Override
    public AjHouseParamHouse getByItemId(int itemId) {

        AjHouseParamHouse ajHouseParamHouse = null;
        try {
            ajHouseParamHouse=ajHouseParamHouseDaoCustom.getByHouseId(itemId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ajHouseParamHouse;
    }
}
