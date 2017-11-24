package com.aj.ajhouse.service.impl;

import com.aj.ajhouse.common.dto.TreeNode;
import com.aj.ajhouse.dao.AjHouseCatMapper;
import com.aj.ajhouse.pojo.po.AjDocsMenu;
import com.aj.ajhouse.pojo.po.AjHouseCat;
import com.aj.ajhouse.pojo.po.AjHouseCatExample;
import com.aj.ajhouse.service.AjHouseCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AjHouseCatServiceImpl implements AjHouseCatService{
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AjHouseCatMapper ajHouseCatDao;
    @Override
    public List<TreeNode> listHouseCat() {
        List<TreeNode> list=null;
        try{
            AjHouseCatExample example = new AjHouseCatExample();
            AjHouseCatExample.Criteria criteria = example.createCriteria();
            List<AjHouseCat> ajHouseCats = ajHouseCatDao.selectByExample(example);
            list=new ArrayList<TreeNode>();
            for(int i=0;i<ajHouseCats.size();i++){
                AjHouseCat ajHouseCat = ajHouseCats.get(i);
                TreeNode treeNode = new TreeNode();
                treeNode.setId((long)ajHouseCat.getId());
                treeNode.setText(ajHouseCat.getCatName());
                treeNode.setState("open");
                list.add(treeNode);
            }

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return list;
    }
}
