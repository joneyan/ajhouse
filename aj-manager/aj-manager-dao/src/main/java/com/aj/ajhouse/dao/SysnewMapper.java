package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.po.AjSysnews;

import java.util.List;
import java.util.Map;

public interface SysnewMapper {
    //后台功能模块

    int countSysnew();

    List<AjSysnews> listSysnewByPage(Map<String, Object> map);

    int saveSysnew(AjSysnews ajSysnews);

    int pushSysnew(Integer integer);

    int pushNoSysnew(Integer integer);

    int delSysnew(Integer integer);
// 前台 功能 模块

    int countSysnew(Map<String, Object> map);
}