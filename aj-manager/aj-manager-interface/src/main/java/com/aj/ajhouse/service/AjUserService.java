package com.aj.ajhouse.service;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.pojo.po.AjUser;
import com.aj.ajhouse.pojo.vo.UserQuery;

public interface AjUserService {

    Result<AjUser> listUserByPage(Page page, Order order, UserQuery query);
    AjUser findById(int id);
    int updateUser(AjUser ajUser);

}
