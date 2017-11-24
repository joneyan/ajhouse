package com.aj.ajhouse.web;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.pojo.po.AjHouse;
import com.aj.ajhouse.pojo.vo.AjHouseQuery;
import com.aj.ajhouse.service.AjHouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class AjHouseAction {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AjHouseService ajHouseService;
    @ResponseBody
    @RequestMapping("/house")
    public int addHouse(AjHouse ajHouse, String paramData,@RequestParam("images[]")List<MultipartFile> images){
        int i=0;
        try{
            i = ajHouseService.addHouse(ajHouse, paramData,images);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @ResponseBody
    @RequestMapping("/houses")
    public Result<AjHouse> listHouseByPage(Page page, Order order,AjHouseQuery query){
        Result<AjHouse> list=null;
        try{
            list=ajHouseService.listHouseByPage(page,order,query);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return list;
    }

    @ResponseBody
    @RequestMapping("/house/batchstop")
    public int stopHouse(@RequestParam("ids[]") List<Integer> ids){
        int i=0;
        try{
           i= ajHouseService.stopHouse(ids);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }
}
