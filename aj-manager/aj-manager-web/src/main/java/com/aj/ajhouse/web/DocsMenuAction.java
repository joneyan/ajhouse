package com.aj.ajhouse.web;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.pojo.po.AjDocsMenu;
import com.aj.ajhouse.pojo.vo.AjDocsMenuQuery;
import com.aj.ajhouse.service.DocsMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DocsMenuAction {

    @Autowired
    private DocsMenuService docsMenuService;

    @ResponseBody
    @RequestMapping
    private List<AjDocsMenu> listMenuByPage(Page page, Order order, AjDocsMenuQuery query){
        List<AjDocsMenu> list = null;
        try{
            list=docsMenuService.listMenuByPage(page,order,query);
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }




}
