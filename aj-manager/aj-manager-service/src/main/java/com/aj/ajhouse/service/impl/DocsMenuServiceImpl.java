package com.aj.ajhouse.service.impl;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.dao.AjDocsMenuCustomMapper;
import com.aj.ajhouse.common.dto.TreeNode;
import com.aj.ajhouse.dao.AjDocsMenuMapper;
import com.aj.ajhouse.pojo.po.AjDocsMenu;
import com.aj.ajhouse.pojo.po.AjDocsMenuExample;
import com.aj.ajhouse.pojo.vo.AjDocsMenuQuery;
import com.aj.ajhouse.pojo.vo.AjDocsMenuView;
import com.aj.ajhouse.service.DocsMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 帮助菜单service层
 */

@Service
public class DocsMenuServiceImpl implements DocsMenuService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AjDocsMenuCustomMapper ajDocsMenuCustomMapper;

    @Autowired
    private AjDocsMenuMapper docsMenuDao;

    //分页查询菜单功能
    @Override
    public Result<AjDocsMenuView> listMenuByPage(Page page, Order order, AjDocsMenuQuery query) {
        Result<AjDocsMenuView> result = null;
        try{
            //创建一个map用于封装传参
            Map<String, Object> map = new HashMap<>();
            map.put("page",page);
            map.put("order",order);
            map.put("query",query);
            //创建实体类
            result = new Result<>();
            //获取符合条件的总记录数
            int total=ajDocsMenuCustomMapper.getTotal(map);
            result.setTotal(total);
            //获取符合条件的集合
            List<AjDocsMenuView> rows = ajDocsMenuCustomMapper.listMenuByPage(map);
            result.setRows(rows);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

        return result;
    }

    //刘浩: 查询父标题
    @Override
    public List<TreeNode> listParent() {
        List<TreeNode> treeNodeList=null;
        try{
            List<AjDocsMenu> list = ajDocsMenuCustomMapper.listParent();
            treeNodeList=new ArrayList<>();
            for(int i=0;i<list.size();i++){
                AjDocsMenu ajDocsMenu = list.get(i);
                TreeNode treeNode = new TreeNode();
                treeNode.setId((long)ajDocsMenu.getId());
                treeNode.setText(ajDocsMenu.getName());
                treeNodeList.add(treeNode);
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return treeNodeList;
    }

    //严静: 帮助菜单树形下拉框
    @Override
    public List<TreeNode> listDocMenuByPid(Integer parentid) {
        List<TreeNode> treeNodeList=null;
        try{
            AjDocsMenuExample example=new AjDocsMenuExample();
            AjDocsMenuExample.Criteria criteria = example.createCriteria();
            criteria.andParentidEqualTo(parentid);
            List<AjDocsMenu> ajDocsMenus = docsMenuDao.selectByExample(example);
            treeNodeList=new ArrayList<TreeNode>();
            for(int i=0;i<ajDocsMenus.size();i++){
                AjDocsMenu ajDocsMenu = ajDocsMenus.get(i);
                TreeNode treeNode = new TreeNode();
                treeNode.setId((long)ajDocsMenu.getId());
                treeNode.setText(ajDocsMenu.getName());
                treeNode.setState(ajDocsMenu.getIsParent()? "closed":"open");
                treeNodeList.add(treeNode);
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return treeNodeList;
    }

    /**
     * 添加菜单功能
     * @param ajDocsMenu
     * @return
     */
    @Override
    public int saveMenu(AjDocsMenu ajDocsMenu) {
        int i = 0;
        try{
            Date date = new Date();
            ajDocsMenu.setCreatetime(date);
            ajDocsMenu.setUpdatetime(date);
            ajDocsMenu.setStatus(0);
            ajDocsMenu.setIsParent(false);

            i = docsMenuDao.insert(ajDocsMenu);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    //刘浩:删除菜单
    @Override
    public int removeMenu(List<Integer> ids) {
        int i = 0;
        try {
            //准备商品对象，这个对象包含了状态为3的字段
            AjDocsMenu ajDocsMenu = new AjDocsMenu();
            ajDocsMenu.setStatus(1);
            //创建查询模板
            AjDocsMenuExample example = new AjDocsMenuExample();
            AjDocsMenuExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(ids);
            //执行更新
            i = docsMenuDao.updateByExampleSelective(ajDocsMenu, example);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;
    }

    //根据id查找菜单,用户修改
    @Override
    public AjDocsMenu getMenuById(Integer id) {
        AjDocsMenu ajDocsMenu = null;
        try {
            ajDocsMenu = docsMenuDao.selectByPrimaryKey(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return ajDocsMenu;
    }

    @Override
    public int updateMenuById(AjDocsMenu ajDocsMenu) {
        int i = 0;
        try{
            Date date = new Date();
            ajDocsMenu.setCreatetime(date);
            ajDocsMenu.setUpdatetime(date);
            ajDocsMenu.setStatus(0);
            ajDocsMenu.setIsParent(false);
            i = docsMenuDao.updateByPrimaryKeySelective(ajDocsMenu);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }
}
