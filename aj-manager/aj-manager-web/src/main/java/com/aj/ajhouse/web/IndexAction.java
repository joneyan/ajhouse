package com.aj.ajhouse.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
public class IndexAction {
    @RequestMapping("/")
    public String toIndex(){
        return "index";
    }
    @RequestMapping("/{page}")
    public String toPage(@PathVariable("page") String page){
        return page;
    }
}
