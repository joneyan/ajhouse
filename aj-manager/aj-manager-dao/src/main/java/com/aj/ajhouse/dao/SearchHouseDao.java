package com.aj.ajhouse.dao;

import com.aj.ajhouse.common.dto.PageBean;
import com.aj.ajhouse.pojo.vo.AjHouseSearchCustom;
import com.aj.ajhouse.pojo.vo.AjHouseSearchCustom2;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SearchHouseDao {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SolrServer solrServer;

    public PageBean<AjHouseSearchCustom2> search(SolrQuery query) {
        PageBean<AjHouseSearchCustom2> result = null;
        try {
            //根据query查询索引库
            QueryResponse queryResponse = solrServer.query(query);
            //取查询结果。得到索引库中文档域对象
            SolrDocumentList solrDocumentList = queryResponse.getResults();
            //取查询结果总记录数。对应solr后台查询结果中numFound
            long numFound = solrDocumentList.getNumFound();
            result = new PageBean<AjHouseSearchCustom2>();
            result.setTotalCount((int) numFound);
            //取商品列表，需要取高亮显示
            Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
            List<AjHouseSearchCustom2> itemList = new ArrayList<>();


            //遍历文档域对象

            for (SolrDocument solrDocument : solrDocumentList) {
                AjHouseSearchCustom2 item = new AjHouseSearchCustom2();
                item.setId((String) solrDocument.get("id"));
                item.setCatName((String) solrDocument.get("house_catName"));
                item.setImage((String) solrDocument.get("house_image"));
                item.setPriceRange((String) solrDocument.get("house_pirceRange") );
                item.setSellPoint((String) solrDocument.get("house_sellPoit"));
                item.setAddress((String) solrDocument.get("house_address"));
                //取高亮显示
//                {
//                    "1039296": {
//                    "item_title": [
//                    "合约惠<em style=\"color:red\">机</em>测试<em style=\"color:red\">手机</em>（请勿下单）"
//                        ]
//                }}
                List<String> list = highlighting.get(solrDocument.get("id")).get("house_title");
                String title = "";
                if (list != null && list.size() > 0) {
                    //高亮部分
                    title = list.get(0);
                } else {
                    //无高亮部分
                    title = (String) solrDocument.get("house_title");
                }
                item.setTitle(title);
                //添加到商品列表
                itemList.add(item);
            }
            result.setList(itemList);
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        //返回结果
        return result;
    }
}
