package com.aj.ajhouse.service;


import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.pojo.po.AjSysnews;

public interface SysnewService {

    public Result<AjSysnews> listSysnewByPage(Page page) ;

}
