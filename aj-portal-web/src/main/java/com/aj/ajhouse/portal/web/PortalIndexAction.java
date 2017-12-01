package com.aj.ajhouse.portal.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortalIndexAction {

    @RequestMapping("/")
    public String portalIndex(){
        return "index";
    }
    @RequestMapping("/{page}")
    public String toPage(@PathVariable("page") String page){
        return page;
    }

    @RequestMapping(value = "/ershoufang/xiangqing")
    public String ershoufangXiangqing(){

        return "ershoufang_xiangqing";
    }

}
