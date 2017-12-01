package com.aj.ajhouse.web;

import com.aj.ajhouse.common.dto.MessageResult;
import com.aj.ajhouse.service.AjHouseSolrService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SolrAction {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AjHouseSolrService ajHouseSolrService;
    @ResponseBody
    @RequestMapping("solradd")
    public MessageResult addsolr(){
        int i=0;
        MessageResult messageResult = new MessageResult();
        try{
            ajHouseSolrService.addSolr();
            messageResult.setSuccess(true);
            messageResult.setMessage("索引导入成功");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return messageResult;
    }

}
