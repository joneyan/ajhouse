package com.aj.ajhouse.service;

import com.aj.ajhouse.pojo.po.AjHouseParam;

public interface AjHouseParamService {
    int saveHouseParam(Integer houseCatId_, String paramData);

    AjHouseParam getHouseParamByCatId(Integer catId);
}
