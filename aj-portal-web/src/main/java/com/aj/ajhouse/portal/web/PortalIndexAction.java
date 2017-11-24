package com.aj.ajhouse.portal.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortalIndexAction {

    @RequestMapping("/")
    public String portalIndex(){
        return "index";
    }
}
