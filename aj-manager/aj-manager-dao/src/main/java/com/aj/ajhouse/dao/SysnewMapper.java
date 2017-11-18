package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.po.AjSysnews;

import java.util.List;
import java.util.Map;

public interface SysnewMapper {
    int countSysnew();


    List<AjSysnews> listSysnewByPage(Map<String, Object> map);

    int saveSysnew(AjSysnews ajSysnews);

    int pushSysnew(Integer integer);
}
