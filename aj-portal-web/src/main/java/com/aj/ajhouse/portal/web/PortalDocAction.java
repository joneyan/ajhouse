package com.aj.ajhouse.portal.web;

import com.aj.ajhouse.pojo.po.AjDocs;
import com.aj.ajhouse.service.PortalAjDocsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PortalDocAction {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PortalAjDocsService portalAjDocsService;

    @RequestMapping("/aboutDocFind/{docid}")
    public String listDocsById(@PathVariable("docid") Integer docid, Model model){
        List<AjDocs> docsList=null;
        try{
           docsList= portalAjDocsService.listDocById(docid);
           model.addAttribute("docsList",docsList);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return "doc-help-list";
    }

    @RequestMapping("/docContentFind/{docid}")
    public String getDocContent(@PathVariable("docid") Integer docid, Model model){
        AjDocs ajDocs=null;
        try{
            ajDocs= portalAjDocsService.getDocContent(docid);
            model.addAttribute("ajDocs",ajDocs);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return "doc-help-content";
    }
}
