package com.aj.ajhouse.web;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.common.dto.TreeNode;
import com.aj.ajhouse.pojo.po.AjDocsMenu;
import com.aj.ajhouse.pojo.vo.AjDocsMenuQuery;
import com.aj.ajhouse.pojo.vo.AjDocsMenuView;
import com.aj.ajhouse.service.DocsMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 帮助菜单control层
 */

@Controller
public class DocsMenuAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DocsMenuService docsMenuService;


    //分页查询菜单功能
    @ResponseBody
    @RequestMapping("/menus")
    public Result<AjDocsMenuView> listMenuByPage(Page page, Order order, AjDocsMenuQuery query){
        Result<AjDocsMenuView> result = null;
        try{
            result=docsMenuService.listMenuByPage(page,order,query);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

        return result;
    }

    @ResponseBody
    @RequestMapping("menus/parent")
    public List<AjDocsMenu>  listParent(Model model){
        List<AjDocsMenu> list = null;
        list = docsMenuService.listParent();
        AjDocsMenu ajDocsMenu = new AjDocsMenu();
        ajDocsMenu.setId(0);
        ajDocsMenu.setName("全部");
        list.add(ajDocsMenu);
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
