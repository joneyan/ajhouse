package com.aj.ajhouse.web;

import com.aj.ajhouse.pojo.po.AjHouseParam;
import com.aj.ajhouse.service.AjHouseParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HouseParamAction {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AjHouseParamService ajHouseParamService;
    @ResponseBody
    @RequestMapping("/house/param/save/{houseCatId}")
    public int addItemParams(@PathVariable("houseCatId") String houseCatId,String paramData){
        int i=0;
        Integer houseCatId_=Integer.parseInt(houseCatId);
        try{
            i=ajHouseParamService.saveHouseParam(houseCatId_,paramData);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }
    /**
     *
     */
    @ResponseBody
    @RequestMapping("/houseParam/query/{catid}")
    public AjHouseParam getHouseParamByCatId(@PathVariable("catid") Integer catId){
        AjHouseParam ajHouseParam=null;
        try{
            ajHouseParam=ajHouseParamService.getHouseParamByCatId(catId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return ajHouseParam;
    }
}
