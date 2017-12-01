package com.aj.ajhouse.service.impl;

import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.dao.SysnewMapper;
import com.aj.ajhouse.pojo.po.AjSysnews;
import com.aj.ajhouse.pojo.vo.SysnewQuery;
import com.aj.ajhouse.service.SysnewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;


@Service
public class SysnewServiceImpl implements SysnewService{

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    SysnewMapper sysnewDao;

    @Override
    public Result<AjSysnews> listSysnewByPage(Page page, SysnewQuery sysnewQuery) {
        Result<AjSysnews> result=null;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("page", page);
            map.put("sysnewQuery", sysnewQuery);

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

    @Override
    public int saveSysnew(AjSysnews ajSysnews) {
        int i = 0;
        try {
            sysnewDao.saveSysnew(ajSysnews);
            i+=1;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int pushSysnew(List<Integer> ids) {
        int i=0;
        try{
            for (int j=0;j<ids.size();j++){
                i=sysnewDao.pushSysnew(ids.get(j));
            }

        }catch(Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

        return i;
    }

    @Override
    public int pushNoSysnew(List<Integer> ids) {
        int i=0;
        try{
            for (int j=0;j<ids.size();j++){
                i=sysnewDao.pushNoSysnew(ids.get(j));
            }

        }catch(Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

        return i;
    }
    @Override
    public int delSysnew(List<Integer> ids) {
        int i=0;
        try{
            for (int j=0;j<ids.size();j++){
                i=sysnewDao.delSysnew(ids.get(j));
            }

        }catch(Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

        return i;
    }

}

