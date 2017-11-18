package com.aj.ajhouse.service;


import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.pojo.po.AjSysnews;
import com.aj.ajhouse.pojo.vo.SysnewQuery;

import java.util.List;

public interface SysnewService {

    public Result<AjSysnews> listSysnewByPage(Page page, SysnewQuery sysnewQuery) ;

    int saveSysnew(AjSysnews ajSysnews);

    int pushNoSysnew(List<Integer> ids);
    int pushSysnew(List<Integer> ids);

    int delSysnew(List<Integer> ids);
}
