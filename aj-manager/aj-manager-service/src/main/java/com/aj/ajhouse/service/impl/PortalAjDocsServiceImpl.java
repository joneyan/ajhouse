package com.aj.ajhouse.service.impl;

import com.aj.ajhouse.common.jedis.JedisClient;
import com.aj.ajhouse.common.util.JsonUtils;
import com.aj.ajhouse.dao.AjDocsMapper;
import com.aj.ajhouse.pojo.po.AjDocs;
import com.aj.ajhouse.pojo.po.AjDocsExample;
import com.aj.ajhouse.service.PortalAjDocsService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortalAjDocsServiceImpl implements PortalAjDocsService{
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AjDocsMapper ajDocsDao;
    @Autowired
    private JedisClient jdisClient;
    @Override
    public List<AjDocs> listDocById(Integer docid) {
        List<AjDocs> docsList=null;
        try{
            AjDocsExample example = new AjDocsExample();
            AjDocsExample.Criteria criteria = example.createCriteria();
            criteria.andMenuLeafidEqualTo(docid);
            docsList = ajDocsDao.selectByExampleWithBLOBs(example);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return docsList;
    }

    @Override
    public AjDocs getDocContent(Integer docid) {
        AjDocs ajDocs=null;

            try{
                String json = jdisClient.hget("CONTENT_AJDOC", docid + "");
                if(StringUtils.isNotBlank(json)){
                    return JsonUtils.jsonToPojo(json,AjDocs.class);
                }
            }catch (Exception e){

            }
            ajDocs = ajDocsDao.selectByPrimaryKey(docid);
        try{
            jdisClient.hset("CONTENT_AJDOC",docid+"", JsonUtils.objectToJson(ajDocs));
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return ajDocs;
    }
}
