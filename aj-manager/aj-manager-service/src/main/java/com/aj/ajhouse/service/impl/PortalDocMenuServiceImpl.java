package com.aj.ajhouse.service.impl;

import com.aj.ajhouse.dao.AjDocsMenuMapper;
import com.aj.ajhouse.pojo.po.AjDocsMenu;
import com.aj.ajhouse.pojo.po.AjDocsMenuExample;
import com.aj.ajhouse.service.PortalDocMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 帮助中心用于查询菜单的业务实现
 */
@Service
public class PortalDocMenuServiceImpl implements PortalDocMenuService{
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AjDocsMenuMapper ajDocsMenuDao;
    @Override
    public List<AjDocsMenu> listDocMenuByParentId(Integer parentid) {
        List<AjDocsMenu> menuList=null;
        try{
            AjDocsMenuExample example = new AjDocsMenuExample();
            AjDocsMenuExample.Criteria criteria = example.createCriteria();
            criteria.andParentidEqualTo(parentid);
            menuList = ajDocsMenuDao.selectByExample(example);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return menuList;
    }
}
