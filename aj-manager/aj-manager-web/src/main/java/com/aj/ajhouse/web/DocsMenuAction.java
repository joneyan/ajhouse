package com.aj.ajhouse.web;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.TreeNode;
import com.aj.ajhouse.pojo.po.AjDocsMenu;
import com.aj.ajhouse.pojo.vo.AjDocsMenuQuery;
import com.aj.ajhouse.service.DocsMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DocsMenuAction {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DocsMenuService docsMenuService;

    @ResponseBody
    @RequestMapping
    private List<AjDocsMenu> listMenuByPage(Page page, Order order, AjDocsMenuQuery query){
        List<AjDocsMenu> list = null;
        try{
            list=docsMenuService.listMenuByPage(page,order,query);
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }
    @ResponseBody
    @RequestMapping("/docsmenu")
    public List<TreeNode> listDocMenuByPid(@RequestParam("parentid") Integer parentid){
        List<TreeNode> treeNodeList=null;
        try{
            treeNodeList= docsMenuService.listDocMenuByPid(parentid);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return treeNodeList;
    }





}
