package com.aj.ajhouse.web;

import com.aj.ajhouse.common.dto.TreeNode;
import com.aj.ajhouse.service.AjHouseCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AjHouseCatAction {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AjHouseCatService ajHouseCatService;
    @ResponseBody
    @RequestMapping("/housecat")
    public List<TreeNode> listHouseCat(){
        List<TreeNode> list=null;
        try{
            list=ajHouseCatService.listHouseCat();
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return list;
    }
}
