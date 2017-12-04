package com.aj.ajhouse.service;

import com.aj.ajhouse.common.dto.PageBean;
import com.aj.ajhouse.pojo.vo.AjHouseSearchCustom2;

public interface AjHouseSolrService {
    void addSolr();
    PageBean<AjHouseSearchCustom2> listHouseByPage(String keyword, Integer page, int rows);
}
