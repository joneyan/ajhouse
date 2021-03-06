package com.aj.ajhouse.web;

import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.pojo.po.AjSysnews;
import com.aj.ajhouse.pojo.vo.SysnewQuery;
import com.aj.ajhouse.service.SysnewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Scope("prototype")
public class SysnewAction {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    SysnewService sysnewService;


    @RequestMapping(value = "/sysnews")
    @ResponseBody
    public Result<AjSysnews> listItemsByPage(Page page, SysnewQuery sysnewQuery){
        Result<AjSysnews> list=null;
        try{
           list=sysnewService.listSysnewByPage(page, sysnewQuery);

        }catch(Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return list;
    }
    @ResponseBody
    @RequestMapping(value = "/sysnew")
    public int sysnewAdd(AjSysnews ajSysnews ){
        int i = 0;
        try {
            i = sysnewService.saveSysnew(ajSysnews);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;
    }

    @ResponseBody
    @RequestMapping(value = "pushSysnew" ,method = RequestMethod.POST)
    public Integer pushSysnew(@RequestParam("ids[]") List<Integer> ids){
        int i=0;
        try{
           i= sysnewService.pushSysnew(ids);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return  i;
    }

    @ResponseBody
    @RequestMapping(value = "pushNoSysnew" ,method = RequestMethod.POST)
    public Integer pushNoSysnew(@RequestParam("ids[]") List<Integer> ids){
        int i=0;
        try{
           i= sysnewService.pushNoSysnew(ids);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return  i;
    }

    @ResponseBody
    @RequestMapping(value = "delSysnew" )
    public Integer delSysnew(@RequestParam("ids[]") List<Integer> ids){
        int i=0;
        try{
           i= sysnewService.delSysnew(ids);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return  i;
    }

}

