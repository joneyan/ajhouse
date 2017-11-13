package com.aj.ajhouse.web;

import com.aj.ajhouse.pojo.po.AjDocs;
import com.aj.ajhouse.service.AjDocsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
public class AjDocsAction {
    private Logger logger=LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AjDocsService ajDocsService;
    @RequestMapping("/docadd")
    public String docAdd(AjDocs ajdocs){
        ajDocsService.docAdd(ajdocs);
        return null;
    }
}
