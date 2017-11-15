package com.aj.ajhouse.service.impl;

import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.dao.SysnewMapper;
import com.aj.ajhouse.pojo.po.AjSysnews;
import com.aj.ajhouse.service.SysnewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SysnewServiceImpl implements SysnewService{

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    SysnewMapper sysnewDao;


    @Override
    public Result<AjSysnews> listSysnewByPage(Page page) {
        Result<AjSysnews> result=null;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("page", page);

            result = new Result<AjSysnews>();

            int total = sysnewDao.countSysnew();
            result.setTotal(total);

            List<AjSysnews> list = sysnewDao.listSysnewByPage(map);
            result.setRows(list);

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();


        }
        return result;
    }
}

