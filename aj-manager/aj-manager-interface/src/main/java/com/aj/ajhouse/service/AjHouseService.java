package com.aj.ajhouse.service;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.pojo.po.AjHouse;
import com.aj.ajhouse.pojo.vo.AjHouseQuery;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AjHouseService {
    int addHouse(AjHouse ajHouse,String paramData ,List<MultipartFile> images);

    Result<AjHouse> listHouseByPage(Page page, Order order, AjHouseQuery query);

    int stopHouse(List<Integer> ids);
}
