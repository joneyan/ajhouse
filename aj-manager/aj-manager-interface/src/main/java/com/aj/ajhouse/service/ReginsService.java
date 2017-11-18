package com.aj.ajhouse.service;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.pojo.po.AjRegins;
import com.aj.ajhouse.pojo.vo.AjReginsCustom;
import com.aj.ajhouse.pojo.vo.AjReginsQuery;

import java.util.List;

public interface ReginsService {
    int saveRegins(AjRegins ajRegins);
    Result<AjReginsCustom> listReginsByPage(Page page,AjReginsQuery query,Order order);
    int deleteBatch(List ids);
    AjRegins selectReginsById(int id);
    int updateRegins(AjRegins ajRegins);
}
