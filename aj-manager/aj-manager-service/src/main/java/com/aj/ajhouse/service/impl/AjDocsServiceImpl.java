package com.aj.ajhouse.service.impl;

import com.aj.ajhouse.dao.AjDocsMapper;
import com.aj.ajhouse.pojo.po.AjDocs;
import com.aj.ajhouse.service.AjDocsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AjDocsServiceImpl implements AjDocsService{
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AjDocsMapper ajDocsMapper;
    @Override
    public int docAdd(AjDocs ajdocs) {
        int insert=0;
        try{
            insert = ajDocsMapper.insert(ajdocs);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return insert;
    }
}
