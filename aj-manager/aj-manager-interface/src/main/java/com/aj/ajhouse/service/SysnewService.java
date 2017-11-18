package com.aj.ajhouse.service;


import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.pojo.po.AjSysnews;

import java.util.List;

public interface SysnewService {

    public Result<AjSysnews> listSysnewByPage(Page page) ;

    int saveSysnew(AjSysnews ajSysnews);

    int pushSysnew(List<Integer> ids);
}
