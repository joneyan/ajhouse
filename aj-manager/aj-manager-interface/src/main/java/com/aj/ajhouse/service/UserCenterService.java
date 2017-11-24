package com.aj.ajhouse.service;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.pojo.po.AjSysnews;

import java.util.List;

/**
 * @Author: yiyun
 * @Company:
 * @Package: com.aj.ajhouse.service
 * @Date: 2017-11-23
 * @Time: 22:15
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public interface UserCenterService {

    List<AjSysnews> getMessages(Page page, Order order);
}
