package com.aj.ajhouse.service.impl;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.TreeNode;
import com.aj.ajhouse.dao.AjDocsMenuMapper;
import com.aj.ajhouse.pojo.po.AjDocsMenu;
import com.aj.ajhouse.pojo.po.AjDocsMenuExample;
import com.aj.ajhouse.pojo.vo.AjDocsMenuQuery;
import com.aj.ajhouse.service.DocsMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocsMenuServiceImpl implements DocsMenuService{
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AjDocsMenuMapper docsMenuDao;
    @Override
    public List<AjDocsMenu> listMenuByPage(Page page, Order order, AjDocsMenuQuery query) {

        return null;
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
