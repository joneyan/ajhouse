package com.aj.ajhouse.service.impl;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.pojo.po.AjDocsMenu;
import com.aj.ajhouse.pojo.vo.AjDocsMenuQuery;
import com.aj.ajhouse.service.DocsMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocsMenuServiceImpl implements DocsMenuService{
    @Override
    public List<AjDocsMenu> listMenuByPage(Page page, Order order, AjDocsMenuQuery query) {

        return null;
    }
}
