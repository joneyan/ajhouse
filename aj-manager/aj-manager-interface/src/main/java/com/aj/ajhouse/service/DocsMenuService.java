package com.aj.ajhouse.service;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.pojo.po.AjDocsMenu;
import com.aj.ajhouse.pojo.vo.AjDocsMenuQuery;

import java.util.List;

public interface DocsMenuService {
    List<AjDocsMenu> listMenuByPage(Page page, Order order, AjDocsMenuQuery query);
}
