package com.aj.ajhouse.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class AjDocsAction {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

}
