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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<AjDocsMenu> listParent() {

        return ajDocsMenuCustomMapper.listParent();
    }

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
                treeNode.setText(ajDocsMenu.getIsParent()? "closed":"open");
                treeNodeList.add(treeNode);
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return treeNodeList;
    }
}
