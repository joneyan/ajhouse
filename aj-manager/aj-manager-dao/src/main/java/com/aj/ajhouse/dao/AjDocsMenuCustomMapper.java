package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.po.AjDocsMenu;
import com.aj.ajhouse.pojo.vo.AjDocsMenuView;

import java.util.List;
import java.util.Map;


public interface AjDocsMenuCustomMapper {

    //查询符合条件的集合
    List<AjDocsMenuView> listMenuByPage(Map<String, Object> map);

    //查询符合条件的总记录数
    int getTotal(Map<String, Object> map);

    //查询父标题
    List<AjDocsMenu> listParent();
}
