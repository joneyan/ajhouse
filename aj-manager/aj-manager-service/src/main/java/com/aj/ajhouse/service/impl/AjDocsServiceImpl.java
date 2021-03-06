package com.aj.ajhouse.service.impl;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.dao.AjDocsCustomMapper;
import com.aj.ajhouse.dao.AjDocsMapper;
import com.aj.ajhouse.pojo.po.AjDocs;
import com.aj.ajhouse.pojo.po.AjDocsExample;
import com.aj.ajhouse.pojo.vo.AjDocsCustom;
import com.aj.ajhouse.service.AjDocsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class AjDocsServiceImpl implements AjDocsService{
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AjDocsMapper ajDocsMapper;
    @Autowired
    private AjDocsCustomMapper ajDocsCustomMapper;
    @Override
    public int docAdd(AjDocs ajdocs) {
        //少时诵诗书sssssss
        int insert=0;
        try{
            insert = ajDocsMapper.insert(ajdocs);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return insert;
    }

    @Override
    public Result<AjDocsCustom> listDocByPage(Page page, Order order) {
        Result<AjDocsCustom> result=null;
        try{
            HashMap<String, Object> map = new HashMap<String ,Object>();
            map.put("page",page);
            map.put("order",order);
            result=new Result<AjDocsCustom>();
            int total = ajDocsCustomMapper.countItems();
            result.setTotal(total);
            List<AjDocsCustom> list= ajDocsCustomMapper.listDocByPage(map);
            result.setRows(list);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public AjDocsCustom getEdit(int id) {
        AjDocsCustom ajDocsCustom=null;
        try{
            List<AjDocsCustom> ajDocs = ajDocsCustomMapper.selectByExampleWithBLOBs(id);
            if(ajDocs.size()>0){
                ajDocsCustom=ajDocs.get(0);
            }

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return ajDocsCustom;
    }
    @Transactional
    @Override
    public int modifyDoc(AjDocs ajDocs) {
        int i=0;
        try{
            ajDocs.setUpdateTime(new Date());
            AjDocsExample example = new AjDocsExample();
            AjDocsExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(ajDocs.getId());
            i = ajDocsMapper.updateByExampleSelective(ajDocs, example);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }
}
