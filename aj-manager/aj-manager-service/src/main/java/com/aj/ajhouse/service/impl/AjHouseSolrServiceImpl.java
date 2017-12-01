package com.aj.ajhouse.service.impl;

import com.aj.ajhouse.dao.AjHouseSolrMapper;
import com.aj.ajhouse.pojo.vo.AjHouseSearchCustom;
import com.aj.ajhouse.service.AjHouseSolrService;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AjHouseSolrServiceImpl implements AjHouseSolrService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AjHouseSolrMapper ajHouseSolrDao;
    @Autowired
    private SolrServer solrServer;
    @Override
    public void addSolr() {
        List<AjHouseSearchCustom> list=ajHouseSolrDao.listAllHouse();
        try{
            for(AjHouseSearchCustom searchCustom:list){
                //拿到solr的文档域
                SolrInputDocument document = new SolrInputDocument();
                //想文档域中添加域:对应的schema.xml配置文件的域名
                document.addField("id",searchCustom.getId());
                document.addField("house_title",searchCustom.getTitle());
                document.addField("house_image",searchCustom.getImage());
                document.addField("house_address",searchCustom.getAddress());
                document.addField("house_sellPoit",searchCustom.getSellPoint());
                document.addField("house_catName",searchCustom.getCatName());
                Long price=searchCustom.getPrice();
                if(price<100){
                    searchCustom.setPriceRange(100+"万以下");
                }else if(price<150){
                    searchCustom.setPriceRange(100+"-150万");
                }else if(price<200){
                    searchCustom.setPriceRange(150+"-200万");
                }else if(price<300){
                    searchCustom.setPriceRange(200+"-300万");
                }else if(price<500){
                    searchCustom.setPriceRange(300+"-500万");
                }else{
                    searchCustom.setPriceRange("500万以上");
                }
                document.addField("house_pirceRange",searchCustom.getPriceRange());
                 solrServer.add(document);
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        try{
            solrServer.commit();
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

    }
}
