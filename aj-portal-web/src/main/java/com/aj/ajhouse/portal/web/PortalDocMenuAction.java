package com.aj.ajhouse.portal.web;

import com.aj.ajhouse.pojo.po.AjDocsMenu;
import com.aj.ajhouse.service.PortalDocMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PortalDocMenuAction {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PortalDocMenuService portalDocMenuService;

    @ResponseBody
    @RequestMapping("/getkindmenu/{parentid}")
    public List<AjDocsMenu> listDocMenu(@PathVariable("parentid") Integer parentid){
        List<AjDocsMenu> menuList=null;
        try{
            menuList=portalDocMenuService.listDocMenuByParentId(parentid);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return menuList;
    }
}
