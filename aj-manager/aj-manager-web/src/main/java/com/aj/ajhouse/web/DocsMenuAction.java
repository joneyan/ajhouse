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
import org.springframework.web.bind.annotation.*;

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

    //刘浩:分页查询的下拉框
    @ResponseBody
    @RequestMapping("menus/parent")
    public List<TreeNode>  listParent(){
        List<TreeNode> list = null;
        try{
            list = docsMenuService.listParent();
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return list;
    }

    //严静:帮助文档菜单的下拉框
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

    //刘浩: 保存新增菜单
    @ResponseBody
    @RequestMapping(value = "/menus/addmenu",method = RequestMethod.POST)
    public int saveMenu(AjDocsMenu ajDocsMenu){
        int i = 0;
        try{
           i = docsMenuService.saveMenu(ajDocsMenu);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    //刘浩: 删除菜单
    @ResponseBody
    @RequestMapping("/menus/batch")
    public int removeMenu(@RequestParam("ids[]") List<Integer> ids){
        int i = 0;
        try {
            i = docsMenuService.removeMenu(ids);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;
    }

    //刘浩: 修改菜单-获取被修改对象
    @RequestMapping("/menusUpdate/{id}")
    public String getMenuById(@PathVariable("id") Integer id, Model model){
        AjDocsMenu ajDocsMenu = null;
        try {
            ajDocsMenu = docsMenuService.getMenuById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        model.addAttribute("ajDocsMenu",ajDocsMenu);
        return "menu-update";
    }

    //刘浩: 修改菜单-修改
    @ResponseBody
    @RequestMapping("/menus/updateMenu")
    public int updateMenuById(AjDocsMenu ajDocsMenu){
        int i = 0;
        try{
            i = docsMenuService.updateMenuById(ajDocsMenu);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

}
